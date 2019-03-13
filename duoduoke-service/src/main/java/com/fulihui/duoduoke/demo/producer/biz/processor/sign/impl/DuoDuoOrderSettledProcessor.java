package com.fulihui.duoduoke.demo.producer.biz.processor.sign.impl;

import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.duoduoke.demo.producer.biz.processor.sign.AbstractDuoDuoOrderStatusProcessor;
import org.springframework.stereotype.Component;

/**
 * 已经结算
 * Created by lizhi on 2018-10-19.
 */
@Component
public class DuoDuoOrderSettledProcessor extends AbstractDuoDuoOrderStatusProcessor {
    @Override
    public DuoDuoOrderStatusEnum getType() {
        return DuoDuoOrderStatusEnum.A_SETTLED;
    }

    @Override
    public void takeOrderSign(String orderSn, String userId, Integer orderAmount, String orderStatus) {

    }
}
