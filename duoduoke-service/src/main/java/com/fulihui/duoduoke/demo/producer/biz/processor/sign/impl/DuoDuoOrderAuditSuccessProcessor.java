package com.fulihui.duoduoke.demo.producer.biz.processor.sign.impl;

import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.duoduoke.demo.producer.biz.processor.sign.AbstractDuoDuoOrderStatusProcessor;
import com.fulihui.duoduoke.demo.producer.util.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 审核成功
 *
 * @author lizhi
 * @date 2018-10-18
 */
@Component
public class DuoDuoOrderAuditSuccessProcessor extends AbstractDuoDuoOrderStatusProcessor {
    private static final Logger ORDER_FANS_BIZ_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);

    @Override
    public DuoDuoOrderStatusEnum getType() {
        return DuoDuoOrderStatusEnum.AUDIT_SUCCESS;
    }

    @Override
    public void takeOrderSign(String orderSn, String userId, Integer orderAmount,
                              String orderStatus) {

    }

}
