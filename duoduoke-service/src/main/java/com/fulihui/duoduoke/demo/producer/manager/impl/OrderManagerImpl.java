package com.fulihui.duoduoke.demo.producer.manager.impl;

import com.fulihui.duoduoke.demo.api.dto.UserFormRecordDTO;
import com.fulihui.duoduoke.demo.api.enums.OrderTypeEnum;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.duoduoke.demo.producer.manager.AppSendMessageManager;
import com.fulihui.duoduoke.demo.producer.manager.OrderManager;
import com.fulihui.duoduoke.demo.producer.config.AppServiceConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.duoduoke.demo.producer.repository.UserFormRepository;
import com.fulihui.duoduoke.demo.producer.util.Consts;
import com.google.common.collect.Maps;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSONObject.toJSONString;
import static com.fulihui.duoduoke.demo.api.enums.MessageChannelEnum.DOUBLE_ORDER;
import static com.fulihui.duoduoke.demo.api.enums.MessageChannelEnum.ORDER;
import static com.fulihui.duoduoke.demo.api.enums.SwitchEnum.DISABLE;
import static com.fulihui.duoduoke.demo.api.enums.SwitchEnum.ENABLE;
import static org.near.toolkit.common.DateUtils.formatWebFormat;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-8-17
 */
@Component
public class OrderManagerImpl implements OrderManager {

    private static final Logger ORDER_FANS_BIZ_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);
    @Autowired
    UserFormRepository userFormRepository;
    @Autowired
    AppSendMessageManager appSendMessageManager;

    @Autowired
    AppServiceConfig appServiceConfig;

    @Override
    public void send(OrderInfo info, Long promoAmount) {
        if (info == null || promoAmount == null) {
            return;
        }
        String userId = info.getCustomParameters();
        ORDER_FANS_BIZ_LOGGER.info("推送模板消息开始,userId:{}", userId);
        Map<String, String> propertyMap = getStringStringMap(info, promoAmount);
        String content = toJSONString(propertyMap);
        //查询有效的formId
        List<UserFormRecordDTO> recordList = userFormRepository.query(info.getCustomParameters(),
                ENABLE.getCode());
        if (!isEmpty(recordList)) {
            UserFormRecordDTO formRecord = recordList.get(0);
            boolean b = appSendMessageManager.sendMessage(ORDER.getCode(), userId, content,
                    formRecord.getFormId(), null);
            if (b) {
                xxx(formRecord);
            } else {
                ORDER_FANS_BIZ_LOGGER.info("首次跟单信息抓取,发送模板消息失败,该用户userId:{}",
                        info.getCustomParameters());
            }
        } else {
            ORDER_FANS_BIZ_LOGGER.info("首次跟单信息抓取,发送模板消息未查询到可使用的formId,该用户userId:{}",
                    info.getCustomParameters());
        }
    }

    @Override
    public void sendOrderDouble(OrderInfo info, Long promoAmount) {
        if (info == null || promoAmount == null) {
            return;
        }
        String userId = info.getCustomParameters();
        ORDER_FANS_BIZ_LOGGER.info("获得奖励翻倍机会,userId:{}", userId);
        Map<String, String> propertyMap = Maps.newHashMap();
        Money money = new Money();
        money.setCent(promoAmount * 2);
        propertyMap.put("keyword1", "恭喜获得一次奖励翻倍特权，可拿奖励:" + money.toString() + "元");
        propertyMap.put("keyword2", "请在30分钟内确认领取");
        propertyMap.put("keyword3", "也是厉害了，你的手气不错，请尽快确认领取~");
        String content = toJSONString(propertyMap);
        //查询有效的formId
        List<UserFormRecordDTO> recordList = userFormRepository.query(info.getCustomParameters(),
                ENABLE.getCode());
        if (!isEmpty(recordList)) {
            UserFormRecordDTO record = recordList.get(0);
            String page = "pages/orderList/orderList?status=0" + "&orderSn=" + info.getOrderSn()
                    + "&template=1";
            boolean b = appSendMessageManager.sendMessage(DOUBLE_ORDER.getCode(), userId, content,
                    record.getFormId(), page);
            if (b) {
                xxx(record);
            } else {
                ORDER_FANS_BIZ_LOGGER.info("获得奖励翻倍机会,发送模板消息失败,该用户userId:{}",
                        info.getCustomParameters());
            }
        } else {
            ORDER_FANS_BIZ_LOGGER.info("获得奖励翻倍机会,发送模板消息未查询到可使用的formId,该用户userId:{}",
                    info.getCustomParameters());
        }
    }

    private void xxx(UserFormRecordDTO formRecord) {
        UserFormRecord newRecord = new UserFormRecord();
        newRecord.setId(formRecord.getId());
        newRecord.setFormStatus(DISABLE.getCode());
        newRecord.setFormDesc("消息推送成功过期");
        userFormRepository.update(newRecord);
        ORDER_FANS_BIZ_LOGGER.info("获得奖励翻倍机会,发送模板消息成功,该用户userId:{}", formRecord.getUserId());
    }

    private Map<String, String> getStringStringMap(OrderInfo info, Long promoAmount) {

        Map<String, String> propertyMap = Maps.newHashMap();
        propertyMap.put("keyword1", info.getOrderSn());
        propertyMap.put("keyword2", info.getGoodsName());
        propertyMap.put("keyword3", formatWebFormat(info.getOrderCreateTime()));
        propertyMap.put("keyword4", "已记录到您的账户");
        Money money = new Money();
        //预估奖励
        money.setCent(promoAmount);

        //预估奖励${总奖励金额}元（含加倍奖励${加倍奖励金额}元），奖励将在结算后发放
        if (StringUtil.isNotBlank(info.getOrderType())
                && StringUtil.equals(info.getOrderType(), OrderTypeEnum.D.getCode())) {
            Double doublePercent = info.getDoublePercent();
            double v = promoAmount * doublePercent / 100;
            Money doubleMoney = new Money();
            long d = (long) v;
            doubleMoney.setCent(d);
            Money total = money.add(doubleMoney);
            boolean b = StringUtil.equals(appServiceConfig.getFreePid(), info.getPId());

            if (b) {
                Integer exemptionAmount = info.getExemptionAmount();
                Money amount = new Money();
                amount.setCent(exemptionAmount);
                propertyMap.put("keyword5", "恭喜，抢到免单！免单金额：" + amount.toString() + "元");
            } else {
                propertyMap.put("keyword5", "预计奖励" + total.getAmount().toString() + "元（含加倍奖励"
                        + doubleMoney.getAmount().toString() + "元），奖励将在结算后发放)");
            }
            ORDER_FANS_BIZ_LOGGER.info("返利金额:{},加倍金额:{},总金额:{},加倍比率:{}",
                    money.getAmount().toString(), doubleMoney.getAmount().toString(),
                    total.getAmount().toString(), v);

        } else {
            propertyMap.put("keyword5", "预计奖励" + money.getAmount().toString() + "元");
        }
        return propertyMap;
    }
}
