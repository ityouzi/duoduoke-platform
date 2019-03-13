package com.fulihui.duoduoke.demo.web.controller;


import com.fulihui.duoduoke.demo.api.api.GoodsInfoService;
import com.fulihui.duoduoke.demo.api.dto.DuoduoGoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.ExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.enums.GoodsStateEnum;
import com.fulihui.duoduoke.demo.api.request.DuoduoGoodsInfoRequest;
import com.fulihui.duoduoke.demo.api.request.IdRequest;
import com.fulihui.duoduoke.demo.web.factory.AppConfigFactory;
import com.fulihui.duoduoke.demo.web.integration.ExemptionServiceClient;
import com.fulihui.duoduoke.demo.web.manager.ExemptionGoodsManager;
import com.fulihui.duoduoke.demo.web.manager.GoodsInfoManager;
import com.fulihui.duoduoke.demo.web.param.ExemptionGoodInfoParam;
import com.fulihui.duoduoke.demo.web.param.ExemptionGoodsParam;
import com.fulihui.duoduoke.demo.web.vo.ExemptionActivityVO;
import com.fulihui.duoduoke.demo.web.vo.ExemptionGoodsVO;
import com.fulihui.duoduoke.demo.web.vo.UserExemptionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.StringUtil;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.near.webmvcsupport.view.PageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;

/**
 * @Description:免单商品
 * @Author: xiaoming
 * @version: v 0.1 2018/11/13 0013 18:37
 */
@RestController
@RequestMapping("/exemption")
@Api(description = "免单商品")
public class ExemptionGoodsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExemptionGoodsController.class);

    @Autowired
    ExemptionServiceClient exemptionServiceClient;

    @org.apache.dubbo.config.annotation.Reference
    GoodsInfoService goodsInfoService;

    @Autowired
    AppConfigFactory appConfigFactory;

    @Autowired
    GoodsInfoManager goodsInfoManager;

    @Autowired
    ExemptionGoodsManager exemptionGoodsManager;

    @PostMapping("exemptionGoodsDetail")
    @ApiOperation("免单商品详情")
    public JsonResult<ExemptionGoodsVO> exemptionGoodsDetail(HttpServletRequest servletRequest,
                                                             @RequestBody ExemptionGoodInfoParam param) {
        if (param.getGoodsId() == null || param.getId() == null) {
            return JsonResultBuilder.fail("102", "商品参数错误");
        }
        ExemptionGoodsVO vo = new ExemptionGoodsVO();
        IdRequest idRequest = new IdRequest();
        idRequest.setId(param.getId());
        ExemptionGoodsDTO exemptionGoodsDTO = exemptionServiceClient.select(idRequest);
        if (exemptionGoodsDTO != null) {
            BeanUtils.copyProperties(exemptionGoodsDTO, vo);
            vo.setNowTime(System.currentTimeMillis());
            vo.setPayAmount(exemptionGoodsDTO.getPayAmount().toString());
            vo.setBackAmount(exemptionGoodsDTO.getBackAmount().toString());
            DuoduoGoodsInfoRequest infoRequest = new DuoduoGoodsInfoRequest();
            infoRequest.setGoodsId(param.getGoodsId());
            infoRequest.setState(GoodsStateEnum.ON.getCode());
            TSingleResult<DuoduoGoodsInfoDTO> goodsDetailNOResult = goodsInfoService
                .queryGoodsDetailNO(infoRequest);
            checkResult(goodsDetailNOResult);
            DuoduoGoodsInfoDTO dto = goodsDetailNOResult.getValue();
            if (dto != null) {
                vo.setGoodsThumbnailUrl(dto.getGoodsThumbnailUrl());
                String goodsGalleryUrls = dto.getGoodsGalleryUrls();

                if (StringUtil.isNotEmpty(goodsGalleryUrls)) {
                    String substring = goodsGalleryUrls.substring(1, goodsGalleryUrls.length() - 1)
                        .replace("\"", "");
                    vo.setGoodsGalleryUrls(substring.split(","));
                }
                return JsonResultBuilder.succ(vo);
            } else {
                return JsonResultBuilder.fail("101", "商品已下架");
            }
        } else {
            return JsonResultBuilder.fail("101", "商品已下架");
        }

    }

    @PostMapping("robbingOrder")
    @ApiOperation("抢单")
    public JsonResult<UserExemptionVO> robbingOrder(@RequestBody ExemptionGoodInfoParam param) {
        if (param.getGoodsId() == null || param.getId() == null || param.getActivityId() == null) {
            return JsonResultBuilder.fail("102", "商品参数错误");
        }

        return exemptionGoodsManager.robbingOrder(param);

    }

    @PostMapping("exemptionGoodsList")
    @ApiOperation("免单商品列表")
    public JsonResult<PageView<ExemptionGoodsVO>> exemptionGoodsList(@RequestBody ExemptionGoodsParam param) {
        PageView<ExemptionGoodsVO> list = exemptionServiceClient.list(param);
        return JsonResultBuilder.succ(list);
    }

    @PostMapping("exemptionActivity")
    @ApiOperation("免单活动信息")
    public JsonResult<ExemptionActivityVO> exemptionActivity() {

        ExemptionActivityVO exemption = exemptionServiceClient.getExemption();

        return JsonResultBuilder.succ(exemption);
    }
}
