package com.fulihui.redisdubbo.demo.producer.biz.processor.impl;

import com.fulihui.redisdubbo.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.redisdubbo.demo.producer.biz.processor.AbstractOrderStatusProcessor;
import com.fulihui.redisdubbo.demo.producer.config.AppServiceConfig;
import com.fulihui.redisdubbo.demo.producer.config.H5ServiceConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.repository.UserExemptionGoodsRepository;
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
    AppServiceConfig appServiceConfig;
    @Autowired
    UserExemptionGoodsRepository userExemptionGoodsRepository;
    @Autowired
    H5ServiceConfig h5ServiceConfig;

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
        Long aLong = get(orderInfo);

        if (StringUtils.equals(orderInfo.getPId(), appServiceConfig.getFreePid())
                || StringUtils.equals(orderInfo.getPId(), h5ServiceConfig.getFreePid())) {

            String userId = orderInfo.getCustomParameters();
            UserExemptionGoods record = new UserExemptionGoods();
            record.setUserId(userId);
            record.setGoodsId(Long.valueOf(orderInfo.getGoodsId()));
            record.setOrderSn(orderInfo.getOrderSn());
            List<UserExemptionGoods> list = userExemptionGoodsRepository.selectByExample(record);
            if (!CollectionUtils.isEmpty(list)) {
                UserExemptionGoods goods = list.get(0);
                if (!StringUtils.equals(orderInfo.getOrderStatus(), goods.getBindOrderStatus())) {
                    UserExemptionGoods item = new UserExemptionGoods();
                    item.setId(goods.getId());
                    //把订单状态修改
                    item.setBindOrderStatus(orderInfo.getOrderStatus());
                    userExemptionGoodsRepository.updateById(item);
                }
            }
        }
        return aLong;
    }

    @Override
    public Long onEvent(OrderInfo orderInfo) {
        return null;
    }
}
