package com.fulihui.redisdubbo.demo.producer.biz.processor.sign.impl;

import com.fulihui.redisdubbo.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.redisdubbo.demo.producer.biz.processor.sign.AbstractDuoDuoOrderStatusProcessor;
import org.springframework.stereotype.Component;


/**
 * 已处罚
 * Created by lizhi on 2018-10-19.
 */
@Component
public class DuoDuoOrderPunishedProcessor extends AbstractDuoDuoOrderStatusProcessor {
    @Override
    public DuoDuoOrderStatusEnum getType() {
        return DuoDuoOrderStatusEnum.PUNISHED;
    }

    @Override
    public void takeOrderSign(String orderSn, String userId, Integer orderAmount, String orderStatus) {

    }
}
