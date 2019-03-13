package com.fulihui.duoduoke.demo.producer.biz.processor.sign.impl;

import com.fulihui.duoduoke.demo.api.api.sign.SignAwardService;
import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import com.fulihui.duoduoke.demo.producer.biz.processor.sign.AbstractDuoDuoOrderStatusProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 非多多进宝商品（无佣金订单）
 *
 * @author lizhi
 * @date 2018-10-19
 */
@Component
public class DuoDuoOrderNotMuchProcessor extends AbstractDuoDuoOrderStatusProcessor {
    @Autowired
    SignAwardService signAwardService;

    @Override
    public DuoDuoOrderStatusEnum getType() {
        return DuoDuoOrderStatusEnum.NOT_MUCH;
    }

    @Override
    public void takeOrderSign(String orderSn, String userId, Integer orderAmount, String orderStatus) {

        boolean check = check(orderSn, userId);
        if (check) {
            SignAwardRequest request = new SignAwardRequest();
            request.setUserId(userId);
            request.setOrderSn(orderSn);
            signAwardService.failure(request);
        }

    }
}
