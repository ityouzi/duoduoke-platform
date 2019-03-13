package com.fulihui.duoduoke.demo.producer.biz.processor.sign.impl;

import com.fulihui.duoduoke.demo.api.api.sign.SignAwardService;
import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.SignPrizeStatusEnum;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import com.fulihui.duoduoke.demo.producer.biz.processor.sign.AbstractDuoDuoOrderStatusProcessor;
import com.fulihui.duoduoke.demo.producer.manager.SignOrderReceiptManager;
import com.fulihui.duoduoke.demo.producer.util.Consts;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;


/**
 * 订单确认收货
 *
 * @author lizhi
 * @date 2018-7-12
 */
@Component
public class DuoDuoOrderReceiptProcessor extends AbstractDuoDuoOrderStatusProcessor {

    private static final Logger ORDER_FANS_BIZ_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);
    @Autowired
    SignOrderReceiptManager signOrderReceiptManager;
    @Autowired
    SignAwardService signAwardService;

    @Override
    public DuoDuoOrderStatusEnum getType() {
        return DuoDuoOrderStatusEnum.C_RECEIPT;
    }

    @Override
    public void takeOrderSign(String orderSn, String userId, Integer orderAmount, String orderStatus) {
        boolean check = check(orderSn, userId);
        if (check) {
            SignAwardRequest request = new SignAwardRequest();
            request.setOrderSn(orderSn);
            request.setUserId(userId);
            TSingleResult<SignAwardDTO> result = signAwardService.queryUserIdOrderSn(request);
            checkResult(result);
            SignAwardDTO value = result.getValue();
            //如果不等于空
            if (value != null) {
                //奖金已发放
                if (StringUtil.equals(SignPrizeStatusEnum.ISSUED.getCode(),
                        value.getPrizeStatus())) {
                    return;
                }
                //如果已经绑定了
                if (StringUtil.equals(SignPrizeStatusEnum.BIND.getCode(), value.getPrizeStatus())) {
                    //状态
                    if (StringUtil.equals(DuoDuoOrderStatusEnum.C_RECEIPT.getCode(), orderStatus)) {
                        SignAwardRequest update = new SignAwardRequest();
                        update.setId(value.getId());
                        update.setBindOrderStatus(orderStatus);
                        signAwardService.update(update);
                    }
                }
            }
        }
    }

}
