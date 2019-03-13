package com.fulihui.duoduoke.demo.api.api.promotion;


import com.fulihui.duoduoke.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.duoduoke.demo.api.request.OrderInfoRequest;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
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
