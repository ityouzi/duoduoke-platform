package com.fulihui.duoduoke.demo.web.integration.impl;


import com.fulihui.duoduoke.demo.api.api.ActivityConfigService;
import com.fulihui.duoduoke.demo.api.api.ExemptionService;
import com.fulihui.duoduoke.demo.api.api.GoodsInfoService;
import com.fulihui.duoduoke.demo.api.api.UserExemptionService;
import com.fulihui.duoduoke.demo.api.dto.ActivityConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.GoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.ExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.dto.UserExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.enums.ActivityStateEnum;
import com.fulihui.duoduoke.demo.api.enums.ActivityTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.AppConfigEnum;
import com.fulihui.duoduoke.demo.api.enums.ExemptionGoodsStateEnum;
import com.fulihui.duoduoke.demo.api.request.*;
import com.fulihui.duoduoke.demo.web.integration.ExemptionServiceClient;
import com.fulihui.duoduoke.demo.web.manager.AppConfigManager;
import com.fulihui.duoduoke.demo.web.param.ExemptionGoodsParam;
import com.fulihui.duoduoke.demo.web.vo.AppConfigVO;
import com.fulihui.duoduoke.demo.web.vo.ExemptionActivityVO;
import com.fulihui.duoduoke.demo.web.vo.ExemptionGoodsVO;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.webmvcsupport.view.PageView;
import org.near.webmvcsupport.view.PageViewBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/14 0014 9:49
 */
@Component
public class ExemptionServiceClientImpl implements ExemptionServiceClient {
    @org.apache.dubbo.config.annotation.Reference

    ExemptionService exemptionService;

    @org.apache.dubbo.config.annotation.Reference
    UserExemptionService userExemptionService;

    @org.apache.dubbo.config.annotation.Reference
    ActivityConfigService activityConfigService;

    @Autowired
    AppConfigManager appConfigManager;

    @org.apache.dubbo.config.annotation.Reference
    GoodsInfoService goodsInfoService;

    @Override
    public TMultiResult<ExemptionGoodsDTO> query(ExemptionRequest request) {
        TMultiResult<ExemptionGoodsDTO> result = exemptionService.query(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public ExemptionGoodsDTO select(IdRequest idRequest) {
        TSingleResult<ExemptionGoodsDTO> result = exemptionService.selectByPrimaryKey(idRequest);
        ServiceResultUtil.checkResult(result);
        return result.getValue();
    }

    @Override
    public List<UserExemptionGoodsDTO> queryUserExemptionGoods(UserExemptionGoodsDTO userExemptionGoodsDTO) {
        TMultiResult<UserExemptionGoodsDTO> result = userExemptionService
            .query(userExemptionGoodsDTO);
        ServiceResultUtil.checkResult(result);
        return result.getValues();
    }

    /**
     * 插入数据
     * @param
     * @return
     */
    @Override
    public Boolean insertUserExemption(UserExemptionGoodsDTO userExemptionGoodsDTO) {
        TSingleResult<Boolean> result = userExemptionService.insert(userExemptionGoodsDTO);
        ServiceResultUtil.checkResult(result);
        return result.getValue();
    }

    @Override
    public ActivityConfigDTO queryActivity(Integer id) {
        ActivityConfigRequest request = new ActivityConfigRequest();
        request.setId(id);
        request.setType(Integer.parseInt(ActivityTypeEnum.EXEMPTION.getCode()));
        request.setState(ActivityStateEnum.ON.getCode());
        request.setStartTime(new Date());
        TPageResult<ActivityConfigDTO> result = activityConfigService.list(request);
        ServiceResultUtil.checkResult(result);
        List<ActivityConfigDTO> list = result.getValues();
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 获取免单活动信息
     *
     * @return
     */
    @Override
    public ExemptionActivityVO getExemption() {

        ExemptionActivityVO activityVO = new ExemptionActivityVO();

        //banner信息
        AppConfigVO bannerModel = appConfigManager
            .getModel(AppConfigEnum.EXEMPTION_ACTIVITY_BANNER);
        activityVO.setBannerImgPath(bannerModel.getConfigExtendVal());
        activityVO.setRuleRemark(bannerModel.getConfigVal());

        //分享信息
        AppConfigVO shareModel = appConfigManager.getModel(AppConfigEnum.EXEMPTION_ACTIVITY_SHARE);
        activityVO.setShareImgPath(shareModel.getConfigExtendVal());
        activityVO.setShareTitle(shareModel.getConfigVal());

        ActivityConfigDTO activityModel = activityConfigService
            .getByEnumType(ActivityTypeEnum.EXEMPTION).getValue();

        if (activityModel != null) {
            activityVO.setActivityState(activityModel.getState());
            //剩余毫秒数
            activityVO.setEndTimestamp(
                (activityModel.getEndTime().getTime() - System.currentTimeMillis()));
            ExemptionGoodsParam request = new ExemptionGoodsParam();
            request.setActivityId(activityModel.getId());
            request.setPage(1);
            request.setRows(100);
            activityVO.setCommoditys(list(request).getValues());
        } else {
            activityVO.setActivityState(ActivityStateEnum.OFF.getCode());
            activityVO.setEndTimestamp(0L);
        }

        return activityVO;
    }

    @Override
    public boolean modifyNum(ExemptionGoodsDTO exemptionGoodsDTO) {
        return exemptionService.modifyNum(exemptionGoodsDTO);
    }

    @Override
    public BaseResult robbingOrder(ExemptionGoodsDTO exemptionGoodsDTO, UserExemptionGoodsDTO userExemptionGoodsDTO) {
        UserExemptionRequest userExemptionRequest = new UserExemptionRequest();
        userExemptionRequest.setExemptionGoodsDTO(exemptionGoodsDTO);
        userExemptionRequest.setUserExemptionGoodsDTO(userExemptionGoodsDTO);
        BaseResult result = userExemptionService.robbingOrder(userExemptionRequest);

        return result;
    }

    @Override
    public boolean subNum(ExemptionGoodsDTO exemptionGoodsDTO) {
        return exemptionService.subReceiveNum(exemptionGoodsDTO);
    }

    @Override
    public PageView<ExemptionGoodsVO> list(ExemptionGoodsParam request) {

        List<Integer> activityIds;

        //设置活动Id
        if (request.getActivityId() != null) {
            activityIds = new ArrayList<>();
            activityIds.add(request.getActivityId());
        } else {
            //往期活动Id
            activityIds = activityConfigService.getStopActivityIds(ActivityTypeEnum.EXEMPTION)
                .getValue();
        }

        //无数据
        if (activityIds != null && activityIds.size() > 0) {
            //查询免单活动商品
            ExemptionRequest exemptionRequest = new ExemptionRequest();
            exemptionRequest.setActivityIds(activityIds);
            exemptionRequest.setPage(request.getPage());
            exemptionRequest.setRows(request.getRows());

            //查询所有活动的商品
            TPageResult<ExemptionGoodsDTO> result = exemptionService.queryPage(exemptionRequest);

            if (result.getValues() != null && result.getValues().size() > 0) {
                List<ExemptionGoodsVO> listResult = new ArrayList<>(result.getValues().size());
                //转换Model并设置商品主图
                result.getValues().forEach(item -> {
                    ExemptionGoodsVO tempModel = BeanConvUtil.copy(item, ExemptionGoodsVO.class);
                    //设置价格
                    if (item.getBackAmount() != null) {
                        tempModel.setBackAmount(item.getBackAmount() + "");
                    }
                    if (item.getPayAmount() != null) {
                        tempModel.setPayAmount(item.getPayAmount() + "");
                    }
                    Date gmtReceive = item.getGmtReceive();
                    if (gmtReceive != null) {
                        String format = DateUtils.format(gmtReceive, "MM.dd");
                        tempModel.setGmtReceive(format);
                    }

                    //需求：如果商品状态为关闭，或者免单份数<=已分配份数，则显示为已抢光，份数显示为仅剩0
                    if(ExemptionGoodsStateEnum.OFF.equals(item.getState())){
                        tempModel.setSurplusNum(0);
                    }

                    //查询商品图片地址
                    GoodsInfoRequest goodsInfoRequest = new GoodsInfoRequest();
                    goodsInfoRequest.setGoodsId(tempModel.getGoodsId());
                    TSingleResult<GoodsInfoDTO> goodsResult = goodsInfoService
                        .queryGoodsDetailNO(goodsInfoRequest);
                    if (goodsResult.getValue() != null) {
                        tempModel.setGoodsThumbnailUrl(goodsResult.getValue().getGoodsThumbnailUrl());
                    }

                    listResult.add(tempModel);
                });
                return PageViewBuilder.build(listResult, result.getPage(), result.getRows(),
                    result.getTotalRows());
            }
        }

        return PageViewBuilder.build(new ArrayList<>(), request.getPage(), request.getRows(), 0);
    }
}
