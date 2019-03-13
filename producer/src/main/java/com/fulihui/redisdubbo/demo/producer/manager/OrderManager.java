package com.fulihui.redisdubbo.demo.producer.manager;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfo;

/**
 * @author lizhi
 * @date 2018-8-17
 */
public interface OrderManager {

    /**
     * Send.
     *
     * @param info        the info
     * @param promoAmount the promo amount
     */
    void send(OrderInfo info, Long promoAmount);

    void sendOrderDouble(OrderInfo info, Long promoAmount);
}
