package com.fulihui.redisdubbo.demo.integration;


import com.fulihui.redisdubbo.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.redisdubbo.demo.api.request.OrderFansDetailRequest;
import org.near.servicesupport.result.TPageResult;

/**
 * @author lizhi
 * @date 2018-8-21
 */
public interface OrderFansDetailServiceClient {

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    TPageResult<OrderFansDetailDTO> queryPage(OrderFansDetailRequest request);

}
