/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 */
package com.fulihui.duoduoke.demo.producer.biz.processor;

import com.fulihui.duoduoke.demo.api.api.ActivityConfigService;
import com.fulihui.duoduoke.demo.api.dto.ActivityConfigPrizeDTO;
import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.api.enums.ActivityTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.OrderPromotionSourceEnum;
import com.fulihui.duoduoke.demo.producer.biz.processor.sign.DuoDuoOrderStatusProcessor;
import com.fulihui.duoduoke.demo.producer.biz.processor.sign.DuoDuoOrderStatusProcessorBizRegister;
import com.fulihui.duoduoke.demo.producer.config.H5ServiceConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.duoduoke.demo.producer.manager.OrderFansDetailManager;
import com.fulihui.duoduoke.demo.producer.repository.UserExemptionGoodsRepository;
import org.apache.commons.lang3.StringUtils;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;


/**
 * 公共业务抽象处理器
 *
 * @author lizhi
 */
public abstract class AbstractOrderStatusProcessor implements UserOrderStatusProcessor {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractOrderStatusProcessor.class);

    @Autowired
    OrderFansDetailManager orderFansDetailManager;

    @Autowired
    DuoDuoOrderStatusProcessorBizRegister duoDuoOrderStatusProcessorBizRegister;


    @Autowired
    UserExemptionGoodsRepository userExemptionGoodsRepository;

    @Autowired
    ActivityConfigService activityConfigService;

    @Autowired
    H5ServiceConfig h5ServiceConfig;

    /**
     * Get long.
     *
     * @param orderInfo the order info
     * @return 获取返利金额 long
     */
    public Long get(OrderInfo orderInfo) {
        //返利佣金配置
        Integer snapshot = orderInfo.getOrderCommissionSnapshot();
        //返利金额
        Integer promotionAmount = orderInfo.getPromotionAmount();
        LOGGER.info("配置用户百分比:{},拼多多订单返利金额:{}", snapshot, promotionAmount);
        Long amount = (long) ((promotionAmount * snapshot) / 100);
        LOGGER.info("预计返利金额:{}", amount);
        List<OrderFansDetailDTO> list = orderFansDetailManager.taskOrderFans(orderInfo, amount);
        //关联用户订单粉丝
        orderFans(list);
        //关联用户签到
        sign(orderInfo);

        return amount;
    }

    protected List<UserExemptionGoods> freeOrder(OrderInfo orderInfo) {

        String pId = orderInfo.getPId();
        //如果为空 忽略
        if (StringUtils.isBlank(pId)) {
            return null;
        }

        //如果拉取 订单的 pid 不是  免单pid
        if (!StringUtils.equals(pId, h5ServiceConfig.getFreePid())) {
            return null;
        }
        //活动
        String userId = orderInfo.getCustomParameters();
        UserExemptionGoods record = new UserExemptionGoods();
        record.setUserId(userId);
        record.setGoodsId(Long.valueOf(orderInfo.getGoodsId()));
        List<UserExemptionGoods> list = userExemptionGoodsRepository.selectByExample(record);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        TSingleResult<ActivityConfigPrizeDTO> result = activityConfigService
                .getUsingActivity(ActivityTypeEnum.Exemption);
        if (result == null || result.getValue() == null) {
            return null;
        }
        ActivityConfigPrizeDTO value = result.getValue();
        //订单创建时间
        Date orderCreateTime = orderInfo.getOrderCreateTime();
        if (!(orderCreateTime.getTime() >= value.getStartTime().getTime()
                && orderCreateTime.getTime() <= value.getEndTime().getTime())) {
            return null;
        }

        UserExemptionGoods goods = list.get(0);

        Integer payAmount = goods.getPayAmount();

        LOGGER.info("getOrderAmount:{},payAmount:{}", orderInfo.getOrderAmount(), payAmount);

        if (!orderInfo.getOrderAmount().equals(payAmount)) {
            return null;
        }
        return list;
    }

    private void sign(OrderInfo orderInfo) {
        //如果订单是h5 直接返回
        if (StringUtil.equals(orderInfo.getOrderPromotionSource(),
                OrderPromotionSourceEnum.H5.getCode())) {
            return;
        }

        DuoDuoOrderStatusEnum statusEnum = EnumUtil.queryByCode(orderInfo.getOrderStatus(),
                DuoDuoOrderStatusEnum.class);
        if (statusEnum != null) {
            DuoDuoOrderStatusProcessor processor = duoDuoOrderStatusProcessorBizRegister
                    .get(statusEnum);
            processor.takeOrderSign(orderInfo.getOrderSn(), orderInfo.getCustomParameters(),
                    orderInfo.getOrderAmount(), orderInfo.getOrderStatus());
        }
    }

    protected abstract void confuseTarget(OrderInfo target);

    protected abstract void stealTheItem(OrderInfo target);

    protected abstract void orderFans(List<OrderFansDetailDTO> target);

}
