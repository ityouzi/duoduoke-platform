package com.fulihui.redisdubbo.demo.producer.service;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.api.api.AppSendMessageService;
import com.fulihui.redisdubbo.demo.api.api.UserFormService;
import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.enums.MessageChannelEnum;
import com.fulihui.redisdubbo.demo.api.enums.SwitchEnum;
import com.fulihui.redisdubbo.demo.api.request.AppSendMessageRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.redisdubbo.demo.producer.manager.AppSendMessageManager;
import com.fulihui.redisdubbo.demo.producer.repository.UserFormRepository;
import com.google.common.collect.Maps;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lizhi
 * @date 2018-8-28
 */
@Service(version = "${demo.service.version}")

public class AppSendMessageServiceImpl implements AppSendMessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppSendMessageServiceImpl.class);
    @Autowired
    AppSendMessageManager appSendMessageManager;
    @Autowired
    UserFormRepository userFormRepository;

    @Autowired
    UserFormService userFormService;


    @Override
    public TSingleResult<Boolean> sendMessage(AppSendMessageRequest request) {

        boolean b = appSendMessageManager.sendMessage(request.getType(), request.getUserId(),
                request.getContent(), request.getFormId(), request.getPage());
        if (b) {
            LOGGER.info("消息发送结果通知,userId:{}", request.getUserId());
            UserFormRecord record = new UserFormRecord();
            record.setId(request.getId());
            record.setFormStatus(SwitchEnum.DISABLE.getCode());
            record.setFormDesc("消息推送成功过期");
            userFormRepository.update(record);
        }
        return ResultBuilder.succTSingle(b);
    }

    @Override
    public BaseResult userWithdrawSend(String userId, int balance, String text) {
        try {
            /** 申请时间 {{keyword1.DATA}} 提现金额 {{keyword2.DATA}} 审核结果 {{keyword3.DATA}} */
            Money money = new Money();
            money.setCent(balance);
            Map<String, String> propertyMap = Maps.newHashMap();
            propertyMap.put("keyword1", DateUtils.formatNewFormat(new Date()));
            propertyMap.put("keyword2", money.toString());
            propertyMap.put("keyword3", text);
            String content = JSONObject.toJSONString(propertyMap);

            TMultiResult<UserFormRecordDTO> query = userFormService.query(userId,
                    SwitchEnum.ENABLE.getCode());
            ServiceResultUtil.checkResult(query);
            List<UserFormRecordDTO> list = query.getValues();
            if (!CollectionUtils.isEmpty(list)) {
                String formId = list.get(0).getFormId();
                AppSendMessageRequest request = new AppSendMessageRequest();
                request.setType(MessageChannelEnum.WITHDRAW.getCode());
                request.setUserId(userId);
                request.setContent(content);
                request.setFormId(formId);
                request.setId(list.get(0).getId());
                TSingleResult<Boolean> result = this.sendMessage(request);
                // 如果发送成功
                if (result.getValue()) {
                    //            XXX
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return ResultBuilder.succ();
    }

    @Override
    public BaseResult sendMiniMessage(AppSendMessageRequest request) {
        return ResultBuilder.succ();

    }
}
