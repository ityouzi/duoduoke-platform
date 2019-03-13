package com.fulihui.duoduoke.demo.producer.manager;

/**
 * Created by lizhi on 2018-11-22.
 */
public interface ExemptionOrderManager {

    void invalid(String userId, String orderSn, String goodsId, String orderStatus);
}
