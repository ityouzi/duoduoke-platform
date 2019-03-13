package com.fulihui.redisdubbo.demo.api.api.promotion;


import com.fulihui.redisdubbo.demo.api.dto.PromotionTelevisionLinkDTO;
import com.fulihui.redisdubbo.demo.api.request.promition.PromotionTelevisionLinkRequest;
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
