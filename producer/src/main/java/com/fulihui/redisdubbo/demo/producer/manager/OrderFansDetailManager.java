package com.fulihui.redisdubbo.demo.producer.manager;


import com.fulihui.redisdubbo.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfo;

import java.util.List;


/**
 * @author lizhi
 * @date 2018-8-2
 */
public interface OrderFansDetailManager {


    /**
     * Task order fans list.
     *
     * @param info   the info
     * @param amount the amount
     * @return the list
     */
    List<OrderFansDetailDTO> taskOrderFans(OrderInfo info, Long amount);
}
