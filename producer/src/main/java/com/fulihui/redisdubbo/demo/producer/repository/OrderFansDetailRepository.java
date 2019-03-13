package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderFansDetail;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderFansDetailExample;

import java.util.List;


/**
 * @author lizhi
 * @date 2018-7-31
 */
public interface OrderFansDetailRepository {


    int insert(OrderFansDetail info);

    int update(OrderFansDetail info);

    List<OrderFansDetailDTO> queryOrderSn(String orderSn);

    List<OrderFansDetailDTO> queryOrderSn(String orderSn, String userId, String pUserId);

    long count(OrderFansDetailExample example);

    List<OrderFansDetailDTO> query(OrderFansDetailExample example);
}
