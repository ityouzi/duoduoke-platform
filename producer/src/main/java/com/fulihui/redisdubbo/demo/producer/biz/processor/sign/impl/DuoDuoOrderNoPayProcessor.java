package com.fulihui.redisdubbo.demo.producer.biz.processor.sign.impl;

import com.fulihui.redisdubbo.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.redisdubbo.demo.producer.biz.processor.sign.AbstractDuoDuoOrderStatusProcessor;
import org.springframework.stereotype.Component;


/**
 * Created by lizhi on 2018-10-22.
 */
@Component
public class DuoDuoOrderNoPayProcessor extends AbstractDuoDuoOrderStatusProcessor {

    @Override
    public DuoDuoOrderStatusEnum getType() {
        return DuoDuoOrderStatusEnum.N_PAY;
    }

    @Override
    public void takeOrderSign(String orderSn, String userId, Integer orderAmount, String orderStatus) {

    }

}
