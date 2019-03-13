package com.fulihui.duoduoke.demo.api.api.promotion;


import com.fulihui.duoduoke.demo.api.request.promition.PromotionTelevisionLinkRequest;
import com.fulihui.duoduoke.demo.api.dto.PromotionTelevisionLinkDTO;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 *
 * @author lizhi
 * @date 2018-12-06
 */
public interface PromotionTelevisionLinkService {

    TSingleResult<Long> insert(PromotionTelevisionLinkRequest request);

    /**
     * 分页查询订单信息
     *
     * @param request the request
     * @return t page result
     */
    TPageResult<PromotionTelevisionLinkDTO> queryPage(PromotionTelevisionLinkRequest request);

}
