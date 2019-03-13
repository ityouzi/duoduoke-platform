package com.fulihui.duoduoke.demo.producer.manager;


import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;

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
