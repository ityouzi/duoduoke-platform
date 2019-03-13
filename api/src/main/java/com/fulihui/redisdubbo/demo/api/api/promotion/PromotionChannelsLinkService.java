package com.fulihui.redisdubbo.demo.api.api.promotion;


import com.fulihui.redisdubbo.demo.api.dto.promotion.PromotionChannelsLinkDTO;
import com.fulihui.redisdubbo.demo.api.request.promition.PromotionChannelsLinkRequest;
import org.near.servicesupport.result.TSingleResult;

/**
 *
 * @author lizhi
 * @date 2018-11-29
 */
public interface PromotionChannelsLinkService {

    TSingleResult<PromotionChannelsLinkDTO> queryByCode(PromotionChannelsLinkRequest request);

    TSingleResult<Boolean> saveUpdate(PromotionChannelsLinkRequest request);

}
