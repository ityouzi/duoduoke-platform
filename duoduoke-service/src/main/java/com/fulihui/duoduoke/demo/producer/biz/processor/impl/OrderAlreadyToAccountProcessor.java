package com.fulihui.duoduoke.demo.producer.biz.processor.impl;

import com.fulihui.duoduoke.demo.api.api.AppConfigService;
import com.fulihui.duoduoke.demo.api.api.UserAccountService;
import com.fulihui.duoduoke.demo.api.api.UserRewardRecordService;
import com.fulihui.duoduoke.demo.api.dto.OrderFansDetailDTO;
import com.fulihui.duoduoke.demo.api.dto.UserFormRecordDTO;
import com.fulihui.duoduoke.demo.api.enums.*;
import com.fulihui.duoduoke.demo.api.request.UserAccountOperatorRequest;
import com.fulihui.duoduoke.demo.api.request.UserRewardRecordRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccountDetail;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccountDetailExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.duoduoke.demo.producer.manager.AppSendMessageManager;
import com.fulihui.duoduoke.demo.producer.manager.TakeAccountAmountManager;
import com.fulihui.duoduoke.demo.producer.repository.PromotionChannelsRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserFormRepository;
import com.fulihui.duoduoke.demo.producer.util.Consts;
import com.fulihui.duoduoke.demo.producer.biz.processor.AbstractOrderStatusProcessor;
import com.fulihui.duoduoke.demo.producer.config.AppServiceConfig;
import com.fulihui.duoduoke.demo.producer.config.H5ServiceConfig;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserAccountDetailMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;
import com.google.common.collect.Maps;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.toJSONString;
import static com.fulihui.duoduoke.demo.api.enums.SwitchEnum.DISABLE;
import static com.fulihui.duoduoke.demo.api.enums.UserAccountBizCode.*;

/**
 * 订单已到账处理
 *
 * @author lizhi
 * @date 2018 -7-12
 */
@Component
public class OrderAlreadyToAccountProcessor extends AbstractOrderStatusProcessor {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrderAlreadyToAccountProcessor.class);

    private static final Logger ORDER_FANS_BIZ_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);
    /**
     * The User account service.
     */
    @Autowired
    UserAccountService userAccountService;

    /**
     * The App config service.
     */
    @Autowired
    AppConfigService appConfigService;

    /**
     * The Take account amount manager.
     */
    @Autowired
    TakeAccountAmountManager takeAccountAmountManager;

    /**
     * The User account detail mapper.
     */
    @Autowired
    UserAccountDetailMapper userAccountDetailMapper;

    /**
     * The User reward record service.
     */
    @Autowired
    UserRewardRecordService userRewardRecordService;
    /**
     * The App send message manager.
     */
    @Autowired
    AppSendMessageManager appSendMessageManager;

    /**
     * The User form repository.
     */
    @Autowired
    UserFormRepository userFormRepository;

    /**
     * The App service config.
     */
    @Autowired
    AppServiceConfig appServiceConfig;
    @Autowired
    H5ServiceConfig h5ServiceConfig;

    /**
     * The Promotion channels repository.
     */
    @Autowired
    PromotionChannelsRepository promotionChannelsRepository;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Double value = 0.3;
        Integer promotionAmount = 297;
        double v = (value * promotionAmount);
        System.out.println(v);
        Money money = new Money();
        BigDecimal divide = new BigDecimal(v).divide(new BigDecimal(100));
        money.setAmount(divide);
        System.out.println(money.toString());

    }

    @Override
    protected void confuseTarget(OrderInfo target) {

    }

    @Override
    protected void stealTheItem(OrderInfo target) {

    }

    private void update(UserFormRecordDTO formRecord) {
        UserFormRecord newRecord = new UserFormRecord();
        newRecord.setId(formRecord.getId());
        newRecord.setFormStatus(DISABLE.getCode());
        newRecord.setFormDesc("消息推送成功过期");
        userFormRepository.update(newRecord);
        ORDER_FANS_BIZ_LOGGER.info("订单奖励发放到账,发送模板消息成功,该用户userId:{}", formRecord.getUserId());
    }

    /**
     * Send.
     *
     * @param userId the user id
     * @param amount the amount
     */
    void send(String userId, long amount) {
        try {
            List<UserFormRecordDTO> formList = userFormRepository.query(userId,
                    SwitchEnum.ENABLE.getCode());
            if (CollectionUtils.isEmpty(formList)) {
                return;
            }

            Map<String, String> propertyMap = Maps.newHashMap();
            Money money = new Money();
            money.setCent(amount);
            propertyMap.put("keyword1", "订单奖励到账:" + money.toString() + "元");
            propertyMap.put("keyword2", "现在");
            propertyMap.put("keyword3", "可随时提现到微信钱包哦~");
            String content = toJSONString(propertyMap);
            UserFormRecordDTO recordDTO = formList.get(0);
            boolean b = appSendMessageManager.sendMessage(
                    MessageChannelEnum.ORDER_REWARD_TO_ACCOUNT.getCode(), userId, content,
                    recordDTO.getFormId(), null);
            if (b) {
                update(recordDTO);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    protected void orderFans(List<OrderFansDetailDTO> target) {
        if (!CollectionUtils.isEmpty(target)) {
            long totalAmount = 0;
            for (OrderFansDetailDTO dto : target) {
                ORDER_FANS_BIZ_LOGGER.info("订单推荐给上级加余额:{}", dto);
                String fansType = dto.getFansType();
                OrderFansTypeEnum typeEnum = EnumUtil.queryByCode(fansType,
                        OrderFansTypeEnum.class);
                if (typeEnum != null) {
                    UserAccountBizCode bizCode = typeEnum.getBizCode();
                    Long aLong = Long.valueOf(dto.getFansAmount());
                    addMoneyToBalance(dto.getOrderSn(), aLong, dto.getPUserId(), bizCode.getDesc(),
                            bizCode.getCode(), UserAccountType.MINI_USER.getCode());
                    totalAmount += aLong;
                }
            }
            ORDER_FANS_BIZ_LOGGER.info("订单推荐给上级加余额,totalAmount:{}", totalAmount);
        }
    }

    /**
     * 用户订单查询审核成功之后,转换业务订单状态已到账
     *
     * @param orderSn
     * @param amount
     * @param userId
     * @param remark
     * @param bizCode
     * @param userAccountType
     * @return
     */
    private long addMoneyToBalance(String orderSn, Long amount, String userId, String remark,
                                   String bizCode, String userAccountType) {

        UserAccountOperatorRequest accOptReq = new UserAccountOperatorRequest();
        accOptReq.setAmount(amount);
        accOptReq.setUserId(userId);
        // 账户资产来源关联业务流水号 订单号
        accOptReq.setSourceCode(orderSn);
        //订单返利
        accOptReq.setRemark(remark);
        accOptReq.setOptType(UserAccountOptTypeEnum.INCOME.getCode());
        accOptReq.setBizCode(bizCode);
        accOptReq.setUserAccountType(userAccountType);
        if (xxx(orderSn, userId, bizCode)) {
            return amount;

        }
        takeAccountAmountManager.addBalance(accOptReq);
        return amount;
    }

    private boolean xxx(String orderSn, String userId, String bizCode) {
        //用户余额收入
        UserAccountDetailExample example = new UserAccountDetailExample();
        UserAccountDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andBizCodeEqualTo(bizCode);
        criteria.andSourceCodeEqualTo(orderSn);
        criteria.andOptTypeEqualTo(UserAccountOptTypeEnum.INCOME.getCode());
        List<UserAccountDetail> list = userAccountDetailMapper.selectByExample(example);
        return !CollectionUtils.isEmpty(list);
    }

    @Override
    public Long execute(OrderInfo orderInfo) {
        //拼多多订单返利金额 自购金额
        Long rebateAmount = get(orderInfo);
        //订单返利 ,如果是免单返现逻辑 不返利
        if (StringUtil.equals(orderInfo.getPId(), appServiceConfig.getFreePid())
                || StringUtil.equals(orderInfo.getPId(), h5ServiceConfig.getFreePid())) {
            LOGGER.info("订单返利,如果是免单返现逻辑,不返利,订单号:{}", orderInfo.getOrderSn());
            return rebateAmount;
        }

        if (StringUtil.equals(orderInfo.getOrderPromotionSource(),
                OrderPromotionSourceEnum.H5.getCode())) {
            return rebateAmount;
        }

        String customParameters = orderInfo.getCustomParameters();

        //订单自购基本返利
        addMoneyToBalance(orderInfo.getOrderSn(), rebateAmount, customParameters, "订单返利",
                ORDER_REBATE.getCode(), UserAccountType.MINI_USER.getCode());
        long sendAmount = 0;
        //订单如果有助力翻倍返利
        if (StringUtil.isNotBlank(orderInfo.getHelpStatus()) && StringUtil
                .equals(orderInfo.getHelpStatus(), RedPackageConfigStatusEnum.ON.getCode())) {
            sendAmount = orderTheTurn(orderInfo.getOrderSn(), rebateAmount, customParameters);
        }

        //订单中包含的商品如果有加倍返利 佣金金额  直接乘以商品加倍比例
        if (StringUtil.isNotBlank(orderInfo.getOrderType())
                && StringUtil.equals(orderInfo.getOrderType(), OrderTypeEnum.D.getCode())) {
            sendAmount = orderTheDouble(orderInfo.getOrderSn(),
                    Long.valueOf(orderInfo.getPromotionAmount()), customParameters,
                    orderInfo.getDoublePercent());
        }

        //发送模板消息
        send(customParameters, rebateAmount + sendAmount);

        return rebateAmount;
    }

    @Override
    public Long onEvent(OrderInfo orderInfo) {
        //返利佣金配置
        Double promotionCommission = orderInfo.getOrderPromotionCommission();
        //返利金额
        Integer promotionAmount = orderInfo.getPromotionAmount();

        String channelsCode = orderInfo.getChannelsCode();

        Assert.notNull(channelsCode, "channelsCode  is not null");

        LOGGER.info("推广渠道信息:{},配置返利百分比:{},拼多多订单返利金额:{}", channelsCode, promotionCommission,
                promotionAmount);

        double v = (promotionCommission * promotionAmount) / 100;
        Money money = new Money();
        money.setAmount(new BigDecimal(v).divide(new BigDecimal(100)));
        LOGGER.info("预计返利金额:{}", money.getCent());
        addMoneyToBalance(orderInfo.getOrderSn(), money.getCent(), channelsCode, "渠道推广返利",
                CHANNEL_PROMOTION_REBATE.getCode(), UserAccountType.PROMOTION_MERCHANT.getCode());
        //渠道收入
        promotionChannelsRepository.modifyIncomeBalance(channelsCode, money.getCent(),
                money.getCent());
        return money.getCent();
    }

    /**
     * 商品订单加倍
     *
     * @param orderSn
     * @param rebateAmount
     * @param customParameters
     * @param doublePercent
     */
    private long orderTheDouble(String orderSn, Long rebateAmount, String customParameters,
                                Double doublePercent) {
        double v = rebateAmount * doublePercent / 100;
        long d = (long) v;
        addMoneyToBalance(orderSn, d, customParameters, "订单商品加倍返利", ORDER_PRODUCT_DOUBLE.getCode(),
                UserAccountType.MINI_USER.getCode());
        return d;
    }

    /**
     * 订单翻倍
     *
     * @param orderSn
     * @param rebateAmount
     * @param customParameters
     */
    private long orderTheTurn(String orderSn, Long rebateAmount, String customParameters) {
        UserRewardRecordRequest request = new UserRewardRecordRequest();
        request.setOrderSn(orderSn);
        request.setUserId(customParameters);
        TSingleResult<Double> result = userRewardRecordService.sumPercent(request);
        ServiceResultUtil.checkResult(result);
        Double value = result.getValue();
        if (value != null) {
            double v = rebateAmount * value / 100;
            long d = (long) v;
            addMoneyToBalance(orderSn, d, customParameters, "订单助力返利", ORDER_DOUBLE.getCode(),
                    UserAccountType.MINI_USER.getCode());
            return d;
        }
        return 0;
    }

    /**
     * 已到账
     *
     * @return
     */
    @Override
    public UserOrderStatusEnum getType() {
        return UserOrderStatusEnum.ALREADY_TO_ACCOUNT;
    }

}
