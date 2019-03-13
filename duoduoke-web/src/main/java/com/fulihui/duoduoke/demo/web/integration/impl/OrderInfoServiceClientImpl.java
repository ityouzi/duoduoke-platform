package com.fulihui.duoduoke.demo.web.integration.impl;


import com.fulihui.duoduoke.demo.api.api.OrderInfoService;
import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.duoduoke.demo.web.integration.OrderInfoServiceClient;
import org.apache.dubbo.config.annotation.Reference;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 * @author lizhi
 * @date 2018-9-7
 */
@Component
public class OrderInfoServiceClientImpl implements OrderInfoServiceClient {
    @Reference(version = "1.0.0")
    OrderInfoService orderInfoService;

    @Override
    public TPageResult<OrderInfoDTO> queryPage(OrderQueryInfoRequest request) {
        TPageResult<OrderInfoDTO> result = orderInfoService.queryPage(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<OrderInfoDTO> queryByOrderSn(OrderQueryInfoRequest request) {
        TSingleResult<OrderInfoDTO> result = orderInfoService.queryByOrderSn(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

}
