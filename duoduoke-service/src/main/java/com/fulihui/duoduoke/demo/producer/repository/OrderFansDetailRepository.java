package com.fulihui.duoduoke.demo.producer.repository;


import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderFansDetail;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderFansDetailExample;

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
