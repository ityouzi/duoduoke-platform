package com.fulihui.duoduoke.demo.api.api;



import com.fulihui.duoduoke.demo.api.request.GoodsPromotionGenerateRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsPromotionUrlResponse;
import org.near.servicesupport.result.TMultiResult;

/**
 * 生成多多进宝商品推广链接 接口服务
 *
 * @author lizhi
 * @date 2018 -7-8
 */
public interface GoodsPromotionService {

    /**
     * 生成推广链接服务
     *
     * @param request the request
     * @return the t multi result
     */
    TMultiResult<GoodsPromotionUrlResponse> goodsPromotionGenerate(GoodsPromotionGenerateRequest request);

    TMultiResult<GoodsPromotionUrlResponse> convertResponse(String contentJson);

}
