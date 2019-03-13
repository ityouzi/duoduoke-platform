package com.fulihui.duoduoke.demo.web.integration.impl;


import com.fulihui.duoduoke.demo.api.api.GoodsPromotionService;
import com.fulihui.duoduoke.demo.api.request.GoodsPromotionGenerateRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsPromotionUrlResponse;
import com.fulihui.duoduoke.demo.web.integration.GoodsPromotionServiceClient;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizhi
 * @date 2018-9-17
 */
@Component
public class GoodsPromotionServiceClientImpl implements GoodsPromotionServiceClient {
    @org.apache.dubbo.config.annotation.Reference
    GoodsPromotionService goodsPromotionService;
    @Override
    public TMultiResult<GoodsPromotionUrlResponse> goodsPromotionGenerate(GoodsPromotionGenerateRequest request) {
        TMultiResult<GoodsPromotionUrlResponse> result = goodsPromotionService.goodsPromotionGenerate(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }


    @Override
    public TMultiResult<GoodsPromotionUrlResponse> convertResponse(String contentJson) {
        TMultiResult<GoodsPromotionUrlResponse> result = goodsPromotionService
                .convertResponse(contentJson);
        ServiceResultUtil.checkResult(result);
        return result;
    }


}
