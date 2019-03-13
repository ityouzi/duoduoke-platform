package com.fulihui.duoduoke.demo.web.integration;


import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 * @date 2018-9-7
 */
public interface OrderInfoServiceClient {

    TPageResult<OrderInfoDTO> queryPage(OrderQueryInfoRequest request);

    TSingleResult<OrderInfoDTO> queryByOrderSn(OrderQueryInfoRequest request);
}
