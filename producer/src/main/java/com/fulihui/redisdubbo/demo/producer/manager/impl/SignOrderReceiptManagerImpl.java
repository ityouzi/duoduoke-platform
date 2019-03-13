package com.fulihui.redisdubbo.demo.producer.manager.impl;


import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserAccountOptTypeEnum;
import com.fulihui.redisdubbo.demo.api.request.UserAccountOperatorRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dao.UserAccountDetailMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetail;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetailExample;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.redisdubbo.demo.producer.manager.AppSendMessageManager;
import com.fulihui.redisdubbo.demo.producer.manager.SignOrderReceiptManager;
import com.fulihui.redisdubbo.demo.producer.manager.TakeAccountAmountManager;
import com.fulihui.redisdubbo.demo.producer.repository.UserFormRepository;
import com.fulihui.redisdubbo.demo.producer.util.Consts;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fulihui.redisdubbo.demo.api.enums.MessageChannelEnum.SIGN_ACCOUNT_BALANCE;
import static com.fulihui.redisdubbo.demo.api.enums.SwitchEnum.DISABLE;
import static com.fulihui.redisdubbo.demo.api.enums.SwitchEnum.ENABLE;
import static org.near.toolkit.common.DateUtils.formatWebFormat;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-11-13
 */
@Component
public class SignOrderReceiptManagerImpl implements SignOrderReceiptManager {

    private static final Logger ORDER_FANS_BIZ_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);

    @Autowired
    UserFormRepository userFormRepository;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    AppSendMessageManager appSendMessageManager;
    @Autowired
    UserAccountDetailMapper userAccountDetailMapper;
    @Autowired
    TakeAccountAmountManager takeAccountAmountManager;

    @Override
    public long addMoneyToBalance(String orderSn, Long amount, String userId, String remark,
                                  String bizCode) {

        UserAccountOperatorRequest accOptReq = new UserAccountOperatorRequest();
        accOptReq.setAmount(amount);
        accOptReq.setUserId(userId);
        // 账户资产来源关联业务流水号 订单号
        accOptReq.setSourceCode(orderSn);
        //订单返利
        accOptReq.setRemark(remark);
        accOptReq.setOptType(UserAccountOptTypeEnum.INCOME.getCode());
        accOptReq.setBizCode(bizCode);
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
    public void send(String userId) {
        threadPoolTaskExecutor.execute(() -> {
            ORDER_FANS_BIZ_LOGGER.info("签到奖金触发发放到账户余额开始,userId:{}", userId);
            Map<String, String> propertyMap = Maps.newHashMap();
            propertyMap.put("keyword1", "签到奖金已发放到账");
            propertyMap.put("keyword2", formatWebFormat(new Date()));
            propertyMap.put("keyword3", "立即领取，提现到微信");
            String content = JSONObject.toJSONString(propertyMap);
            //查询有效的formId
            List<UserFormRecordDTO> recordList = userFormRepository.query(userId, ENABLE.getCode());
            if (!isEmpty(recordList)) {
                UserFormRecordDTO formRecord = recordList.get(0);
                boolean b = appSendMessageManager.sendMessage(SIGN_ACCOUNT_BALANCE.getCode(),
                        userId, content, formRecord.getFormId(), null);
                if (b) {
                    UserFormRecord newRecord = new UserFormRecord();
                    newRecord.setId(formRecord.getId());
                    newRecord.setFormStatus(DISABLE.getCode());
                    newRecord.setFormDesc("分享赚消息推送成功过期");
                    userFormRepository.update(newRecord);
                } else {
                    ORDER_FANS_BIZ_LOGGER.info("签到奖金触发发放到账户余额,发送模板消息失败,该用户userId:{}", userId);
                }
            } else {
                ORDER_FANS_BIZ_LOGGER.info("签到奖金触发发放到账户余额,发送模板消息未查询到可使用的formId,该用户userId:{}",
                        userId);
            }
        });

    }

}
