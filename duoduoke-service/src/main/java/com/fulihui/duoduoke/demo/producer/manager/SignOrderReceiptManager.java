package com.fulihui.duoduoke.demo.producer.manager;

/**
 * @author lizhi
 * @date 2018-11-13
 */
public interface SignOrderReceiptManager {

    long addMoneyToBalance(String orderSn, Long amount, String userId, String remark,
                           String bizCode);

    void send(String userId);

}
