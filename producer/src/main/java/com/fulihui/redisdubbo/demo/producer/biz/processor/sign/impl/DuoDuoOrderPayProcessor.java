package com.fulihui.redisdubbo.demo.producer.biz.processor.sign.impl;

import com.fulihui.redisdubbo.demo.api.api.sign.SignAwardService;
import com.fulihui.redisdubbo.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.redisdubbo.demo.api.request.sign.SignAwardRequest;
import com.fulihui.redisdubbo.demo.producer.biz.processor.sign.AbstractDuoDuoOrderStatusProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 订单已支付处理
 *
 * @author lizhi
 * @date 2018-7-12
 */
@Component
public class DuoDuoOrderPayProcessor extends AbstractDuoDuoOrderStatusProcessor {

    @Autowired
    SignAwardService signAwardService;

    @Override
    public DuoDuoOrderStatusEnum getType() {
        return DuoDuoOrderStatusEnum.Y_PAY;
    }

    @Override
    public void takeOrderSign(String orderSn, String userId, Integer orderAmount, String orderStatus) {
        boolean check = check(orderSn, userId);
        if (check) {
            SignAwardRequest request = new SignAwardRequest();
            request.setUserId(userId);
            request.setOrderSn(orderSn);
            request.setOverOrderMoney(orderAmount);
            request.setBindOrderStatus(orderStatus);
            signAwardService.bindOrder(request);
        }
    }
}
