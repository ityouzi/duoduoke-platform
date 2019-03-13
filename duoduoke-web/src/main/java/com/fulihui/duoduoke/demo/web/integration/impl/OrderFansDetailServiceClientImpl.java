package com.fulihui.duoduoke.demo.web.integration.impl;


import com.fulihui.duoduoke.demo.api.api.OrderFansDetailService;
import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.api.request.OrderFansDetailRequest;
import com.fulihui.duoduoke.demo.web.integration.OrderFansDetailServiceClient;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizhi
 * @date 2018-9-7
 */
@Component
public class OrderFansDetailServiceClientImpl implements OrderFansDetailServiceClient {
    @org.apache.dubbo.config.annotation.Reference
    OrderFansDetailService orderFansDetailService;

    @Override
    public TPageResult<OrderFansDetailDTO> queryPage(OrderFansDetailRequest request) {
        TPageResult<OrderFansDetailDTO> result = orderFansDetailService.queryPage(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }
}
