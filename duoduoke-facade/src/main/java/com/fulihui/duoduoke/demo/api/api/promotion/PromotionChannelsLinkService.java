package com.fulihui.duoduoke.demo.api.api.promotion;


import com.fulihui.duoduoke.demo.api.dto.promotion.PromotionChannelsLinkDTO;
import com.fulihui.duoduoke.demo.api.request.promition.PromotionChannelsLinkRequest;
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
