package com.fulihui.duoduoke.demo.producer.biz.processor.impl;

import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.duoduoke.demo.producer.biz.processor.AbstractOrderStatusProcessor;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.duoduoke.demo.producer.manager.ExemptionOrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 订单无效处理
 *
 * @author lizhi
 * @date 2018-7-12
 */
@Component
public class OrderInvalidProcessor extends AbstractOrderStatusProcessor {


    @Autowired
    ExemptionOrderManager exemptionOrderManager;


    @Override
    protected void confuseTarget(OrderInfo target) {

    }

    @Override
    protected void stealTheItem(OrderInfo target) {

    }

    @Override
    protected void orderFans(List<OrderFansDetailDTO> target) {

    }

    @Override
    public Long execute(OrderInfo orderInfo) {

        return get(orderInfo);
    }

    @Override
    public Long onEvent(OrderInfo orderInfo) {
        return null;
    }

    @Override
    public UserOrderStatusEnum getType() {
        return UserOrderStatusEnum.INVALID;
    }
}
