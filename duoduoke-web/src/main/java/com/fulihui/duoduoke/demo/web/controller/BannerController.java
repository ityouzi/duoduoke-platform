package com.fulihui.duoduoke.demo.web.controller;


import com.fulihui.duoduoke.demo.api.dto.BannerDto;
import com.fulihui.duoduoke.demo.api.enums.AdvertTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.GoodsCatInfoStatusEnum;
import com.fulihui.duoduoke.demo.api.request.BannerSelectRequest;
import com.fulihui.duoduoke.demo.web.integration.AdvertServiceClient;
import com.fulihui.duoduoke.demo.web.vo.AdvertInfoVO;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TSingleResult;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:03
 */
@RestController
@RequestMapping("/banner")
@Api(description = "banner信息")
public class BannerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    AdvertServiceClient advertServiceClient;


    private Map<String, List<AdvertInfoVO>> advertInfoVOList;

    @PostMapping("bannerList")
    @ApiOperation("banner列表")
    public JsonResult<Map<String, List<AdvertInfoVO>>> bannerList() {
        return JsonResultBuilder.succ(advertInfoVOList);
    }

    public AdvertInfoVO toVo(BannerDto dto) {

        AdvertInfoVO vo = new AdvertInfoVO();
        vo.setId(dto.getPositionBannerId());
        vo.setAdvertImg(dto.getImageUrl());
        vo.setImgUrl(dto.getActionUrl());
        vo.setType(dto.getPositionCode());
        vo.setTitle(dto.getParamJson());
        return vo;
    }


    @PostConstruct
    @Scheduled(cron = "0 0/2 * * * *")
    Map<String, List<AdvertInfoVO>> getVOList() {

        advertInfoVOList = Maps.newHashMap();
        BannerSelectRequest request = new BannerSelectRequest();
        request.setStatus(GoodsCatInfoStatusEnum.IS.getCode());
        request.setModuleCode("duoduoke");
        request.setHasTimeCondition("true");

        TSingleResult<List<BannerDto>> result;
        try {
            result = advertServiceClient.selectBanner(request);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return Maps.newHashMap();
        }
        List<AdvertInfoVO> bannerList = new ArrayList<>();
        List<AdvertInfoVO> columnList = new ArrayList<>();
        List<AdvertInfoVO> activityList = new ArrayList<>();
        List<AdvertInfoVO> miniList = new ArrayList<>();
        List<AdvertInfoVO> floatList = new ArrayList<>();

        List<BannerDto> list = result.getValue();
        if (!CollectionUtils.isEmpty(list)) {
            for (BannerDto bannerDto : list) {
                AdvertInfoVO advertInfoVO = toVo(bannerDto);
                String type = advertInfoVO.getType();
                if (type.equals(AdvertTypeEnum.DUODUOKE_BANNER.getCode())) {
                    bannerList.add(advertInfoVO);
                } else if (type.equals(AdvertTypeEnum.DUODUOKE_COLUMN.getCode())) {
                    columnList.add(advertInfoVO);
                } else if (type.equals(AdvertTypeEnum.MINI.getCode())) {
                    miniList.add(advertInfoVO);
                } else if (type.equals(AdvertTypeEnum.SIGN_ACTIVITY.getCode())) {
                    activityList.add(advertInfoVO);
                } else if (type.equals(AdvertTypeEnum.FLOAT.getCode())) {
                    floatList.add(advertInfoVO);
                }
            }
            advertInfoVOList.put(AdvertTypeEnum.DUODUOKE_BANNER.getCode(), bannerList);
            advertInfoVOList.put(AdvertTypeEnum.DUODUOKE_COLUMN.getCode(), columnList);
            advertInfoVOList.put(AdvertTypeEnum.MINI.getCode(), miniList);
            advertInfoVOList.put(AdvertTypeEnum.SIGN_ACTIVITY.getCode(), activityList);
            advertInfoVOList.put(AdvertTypeEnum.FLOAT.getCode(), floatList);

        }

        return advertInfoVOList;
    }

    /**
     * Getter method for property <tt>advertInfoVOList</tt>
     *
     * @return property value of advertInfoVOList
     */
    public Map<String, List<AdvertInfoVO>> getAdvertInfoVOList() {
        return advertInfoVOList;
    }

    /**
     * Setter method for property <tt>advertInfoVOList</tt>.
     *
     * @param advertInfoVOList value to be assigned to property advertInfoVOList
     */
    public void setAdvertInfoVOList(Map<String, List<AdvertInfoVO>> advertInfoVOList) {
        this.advertInfoVOList = advertInfoVOList;
    }
}
