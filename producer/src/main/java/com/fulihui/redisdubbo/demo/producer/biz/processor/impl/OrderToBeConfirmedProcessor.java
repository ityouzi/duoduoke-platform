package com.fulihui.redisdubbo.demo.producer.biz.processor.impl;

import com.fulihui.redisdubbo.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.redisdubbo.demo.api.enums.OrderTypeEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserExemptionStateEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.redisdubbo.demo.producer.biz.processor.AbstractOrderStatusProcessor;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.repository.ExemptionGoodsRepository;
import com.fulihui.redisdubbo.demo.producer.repository.OrderInfoRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserExemptionGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 订单待确认处理
 *
 * @author lizhi
 * @date 2018-7-12
 */
@Component
public class OrderToBeConfirmedProcessor extends AbstractOrderStatusProcessor {
    @Autowired
    OrderInfoRepository orderInfoRepository;

    @Autowired
    UserExemptionGoodsRepository userExemptionGoodsRepository;

    @Autowired
    ExemptionGoodsRepository exemptionGoodsRepository;

    @Override
    protected void confuseTarget(OrderInfo target) {

    }

    @Override
    protected void stealTheItem(OrderInfo target) {

    }

    @Override
    protected void orderFans(List<OrderFansDetailDTO> target) {

    }

    /**
     * 待确认
     *
     * @return
     */
    @Override
    public UserOrderStatusEnum getType() {
        return UserOrderStatusEnum.TO_BE_CONFIRMED;
    }

    @Override
    public Long execute(OrderInfo orderInfo) {
        Long aLong = get(orderInfo);
        //关联订单
        List<UserExemptionGoods> list = freeOrder(orderInfo);
        if (!CollectionUtils.isEmpty(list)) { //
            UserExemptionGoods goods = list.get(0);
            if (UserExemptionStateEnum.NOUSED.getCode().equals(goods.getState())) {
                Integer backAmount = goods.getBackAmount();
                orderInfo.setOrderType(OrderTypeEnum.Y.getCode());
                orderInfo.setExemptionAmount(backAmount);
                OrderInfo newInfo = new OrderInfo();
                newInfo.setOrderType(OrderTypeEnum.Y.getCode());
                newInfo.setExemptionAmount(backAmount);
                newInfo.setCustomParameters(orderInfo.getCustomParameters());
                newInfo.setOrderSn(orderInfo.getOrderSn());
                orderInfoRepository.update(newInfo);
                UserExemptionGoods item = new UserExemptionGoods();
                item.setId(goods.getId());
                item.setOrderSn(orderInfo.getOrderSn());
                item.setState(UserExemptionStateEnum.USED.getCode());
                userExemptionGoodsRepository.updateById(item);
                Long goodsId = goods.getGoodsId();
                ExemptionGoods exemptionGoods = new ExemptionGoods();
                exemptionGoods.setGoodsId(goodsId);
                exemptionGoods.setActivityId(goods.getActivityId());
                exemptionGoods.setOrderQuantityNum(1);
                exemptionGoodsRepository.modifyNum(exemptionGoods);
            }
        }
        return aLong;
    }

    @Override
    public Long onEvent(OrderInfo orderInfo) {
        return null;
    }
}
