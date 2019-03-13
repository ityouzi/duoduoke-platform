package com.fulihui.redisdubbo.demo.producer.biz.processor.sign;


import com.fulihui.redisdubbo.demo.api.enums.DuoDuoOrderStatusEnum;

/**
 * The interface User order status processor.
 *
 * @author lizhi
 */
public interface DuoDuoOrderStatusProcessor {

    /**
     * 查询订单状态枚举信息
     *
     * @return the type
     */
    DuoDuoOrderStatusEnum getType();

    /**
     * 签到奖金订单关联
     *
     * @param orderSn     the order sn
     * @param userId      the user id
     * @param orderAmount the order amount
     * @param orderStatus the order status
     */
    void takeOrderSign(String orderSn, String userId, Integer orderAmount, String orderStatus);

}
