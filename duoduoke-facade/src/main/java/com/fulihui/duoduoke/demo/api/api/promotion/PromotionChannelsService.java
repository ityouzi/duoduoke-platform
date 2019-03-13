package com.fulihui.duoduoke.demo.api.api.promotion;


import com.fulihui.duoduoke.demo.api.dto.promotion.PromotionChannelsDTO;
import com.fulihui.duoduoke.demo.api.request.promition.PromotionChannelsRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * The interface Promotion channels service.
 * @author lizhi
 * @date 2018 -11-29
 */
public interface PromotionChannelsService {

    /**
     * Query page t page result.
     *
     * @param request the request 
     * @return the t page result
     */
    TPageResult<PromotionChannelsDTO> queryPage(PromotionChannelsRequest request);

    /**
     * Insert t single result.
     *
     * @param request the request 
     * @return the t single result
     */
    TSingleResult<Long> insert(PromotionChannelsRequest request);

    /**
     * Update t single result.
     *
     * @param request the request 
     * @return the t single result
     */
    TSingleResult<Long> update(PromotionChannelsRequest request);

    /**
     * Query by pk t single result.
     *
     * @param request the request 
     * @return the t single result
     */
    TSingleResult<PromotionChannelsDTO> queryByPk(PromotionChannelsRequest request);

    /**
     * Query by pid t single result.
     *
     * @param pid the pid 
     * @return the t single result
     */
    TSingleResult<PromotionChannelsDTO> queryByPid(String pid);

}
