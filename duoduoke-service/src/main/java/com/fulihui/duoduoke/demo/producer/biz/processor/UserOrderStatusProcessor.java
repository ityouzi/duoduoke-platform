package com.fulihui.duoduoke.demo.producer.biz.processor;


import com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;


/**
 * The interface User order status processor.
 *
 * @author lizhi
 */
public interface UserOrderStatusProcessor {

    /**
     * 查询订单状态枚举信息
     *
     * @return the type
     */
    UserOrderStatusEnum getType();

    /**
     * 执行
     *
     * @param orderInfo the order info
     * @return the long
     */
    Long execute(OrderInfo orderInfo);

    /**
     * 执行
     *
     * @param orderInfo the order info
     * @return the long
     */
    Long onEvent(OrderInfo orderInfo);

}
