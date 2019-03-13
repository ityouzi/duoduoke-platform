package com.fulihui.redisdubbo.demo.manager.impl;

import com.alibaba.fastjson.JSON;
import com.fulihui.redisdubbo.demo.api.enums.OrderPromotionSourceEnum;
import com.fulihui.redisdubbo.demo.api.request.GoodsPromotionGenerateRequest;
import com.fulihui.redisdubbo.demo.api.response.GoodsPromotionUrlResponse;
import com.fulihui.redisdubbo.demo.config.AesKeyConfig;
import com.fulihui.redisdubbo.demo.integration.GoodsPromotionServiceClient;
import com.fulihui.redisdubbo.demo.manager.GoodsPromotionManager;
import com.fulihui.redisdubbo.demo.model.CustomParameters;
import com.fulihui.redisdubbo.demo.vo.GoodsPromotionUrlVO;
import com.fulihui.redisdubbo.demo.weixin.common.crypto.AESCoder;
import org.near.servicesupport.result.TMultiResult;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;

/**
 *
 * @author lizhi
 * @date 2018-7-14
 */
@Component
public class GoodsPromotionManagerImpl implements GoodsPromotionManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsPromotionManagerImpl.class);
    @Autowired
    GoodsPromotionServiceClient goodsPromotionServiceClient;

    @Autowired
    AesKeyConfig aesKeyConfig;

    @Override
    public GoodsPromotionUrlVO goodsGenerate(String userId, String goodsId, String pid,
                                             String shareId, Boolean generateWeApp) {
        LOGGER.info("GoodsPromotionManager.userId:{},goodsId:{},pid:{},shareId:{}", userId, goodsId,
            pid, shareId);
        //自定义参数
        CustomParameters parameters = new CustomParameters();
        parameters.setUserId(userId);
        if (StringUtil.isNotEmpty(shareId)) {
            parameters.setOrderUserReferee(shareId);
        }
        parameters.setOrderSource(OrderPromotionSourceEnum.MINI_APP.getCode());
        //加密
        AESCoder aesCoder = AESCoder.getInstance();
        String json = aesCoder.encryptBase64(JSON.toJSONString(parameters), aesKeyConfig.getAesKey());

        GoodsPromotionGenerateRequest request = new GoodsPromotionGenerateRequest();
        request.setCustom_parameters(json);
        request.setGoods_id_list(goodsId);
        request.setP_id(pid);
        request.setMulti_group(Boolean.FALSE);
        request.setGenerate_short_url(Boolean.TRUE);
        request.setGenerate_we_app(generateWeApp);
        request.setGenerate_weapp_webview(Boolean.FALSE);
        TMultiResult<GoodsPromotionUrlResponse> result = goodsPromotionServiceClient
            .goodsPromotionGenerate(request);
        checkResult(result);
        LOGGER.info("result:{}", result);
        List<GoodsPromotionUrlResponse> values = result.getValues();
        GoodsPromotionUrlVO vo = null;
        if (!CollectionUtils.isEmpty(values)) {
            vo = new GoodsPromotionUrlVO();
            GoodsPromotionUrlResponse goodsPromotionUrlResponse = values.get(0);
            vo.setAppId(goodsPromotionUrlResponse.getApp_id());
            vo.setPagePath(goodsPromotionUrlResponse.getPage_path());
        }

        return vo;
    }
}
