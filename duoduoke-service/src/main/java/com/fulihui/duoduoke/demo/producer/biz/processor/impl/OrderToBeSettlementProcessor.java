package com.fulihui.duoduoke.demo.producer.biz.processor.impl;

import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.duoduoke.demo.producer.biz.processor.AbstractOrderStatusProcessor;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.duoduoke.demo.producer.repository.UserExemptionGoodsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 订单待结算处理
 *
 * @author lizhi
 * @date 2018-7-12
 */
@Component
public class OrderToBeSettlementProcessor extends AbstractOrderStatusProcessor {


    @Autowired
    UserExemptionGoodsRepository userExemptionGoodsRepository;


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
    public UserOrderStatusEnum getType() {
        return UserOrderStatusEnum.TO_BE_SETTLEMENT;
    }

    @Override
    public Long execute(OrderInfo orderInfo) {

        return get(orderInfo);
    }

    @Override
    public Long onEvent(OrderInfo orderInfo) {
        return null;
    }
}
