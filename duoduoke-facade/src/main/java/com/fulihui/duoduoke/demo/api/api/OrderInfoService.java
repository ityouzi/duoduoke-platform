package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.duoduoke.demo.api.request.OrderInfoTakeAmountRequest;
import com.fulihui.duoduoke.demo.api.request.OrderInfoUpdateRequest;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * The interface Order info service.
 *
 * @author lizhi
 * @date 2018 -7-10
 */
public interface OrderInfoService {
    TPageResult<OrderInfoDTO> queryOrderExceedDay(OrderQueryInfoRequest request);

    TPageResult<GroupChannelsOrderDTO> queryGroupPage(OrderQueryInfoRequest request);

    /**
     * 分页查询订单信息
     *
     * @param request the request
     * @return t page result
     */
    TPageResult<OrderInfoDTO> queryPage(OrderQueryInfoRequest request);

    /**
     * 根据订单号查询
     *
     * @param request the request
     * @return the t single result
     */
    TSingleResult<OrderInfoDTO> queryByOrderSn(OrderQueryInfoRequest request);

    void confirmReceiptAddBalance(OrderQueryInfoRequest request);

    /**
     * 根据订单状态查询
     *
     * @param request the request
     * @return the t multi result
     */
    TMultiResult<OrderInfoDTO> queryTMultiResult(OrderQueryInfoRequest request);

    /**
     * 根据条件查询数量
     *
     * @param request the request
     * @return t single result
     */
    TSingleResult<Long> queryCount(OrderQueryInfoRequest request);

    /**
     * 订单关联
     *
     * @param request the request
     */
    BaseResult takeOrderInfoAmount(OrderInfoTakeAmountRequest request);

    /**
     * Update base result.
     *
     * @param request the request
     * @return the base result
     */
    BaseResult update(OrderInfoUpdateRequest request);

}
