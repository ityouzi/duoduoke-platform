package com.fulihui.redisdubbo.demo.api.api.promotion;


import com.fulihui.redisdubbo.demo.api.dto.OrderInfoDTO;
import com.fulihui.redisdubbo.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.redisdubbo.demo.api.request.OrderInfoRequest;
import com.fulihui.redisdubbo.demo.api.request.OrderQueryInfoRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 * @date 2018-11-29
 */
public interface PromotionChannelsOrderService {

    TPageResult<OrderInfoDTO> queryPage(OrderQueryInfoRequest request);

    TSingleResult<OrderInfoDTO> queryByPk(OrderInfoRequest request);

    TPageResult<GroupChannelsOrderDTO> queryGroupPage(OrderQueryInfoRequest request);

      TPageResult<GroupChannelsOrderDTO> queryGroupPageModify(OrderQueryInfoRequest request);

}
