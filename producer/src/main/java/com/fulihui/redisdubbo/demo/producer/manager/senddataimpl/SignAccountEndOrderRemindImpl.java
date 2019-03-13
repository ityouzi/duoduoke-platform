package com.fulihui.redisdubbo.demo.producer.manager.senddataimpl;

import com.fulihui.redisdubbo.demo.api.api.sign.SignAwardService;
import com.fulihui.redisdubbo.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.redisdubbo.demo.api.enums.SwitchEnum;
import com.fulihui.redisdubbo.demo.api.request.sign.SignAwardRequest;
import com.fulihui.redisdubbo.demo.producer.manager.BaseSendDataDefinition;
import com.fulihui.redisdubbo.demo.producer.model.SendUserModel;
import com.fulihui.redisdubbo.demo.producer.repository.UserFormRepository;
import org.near.servicesupport.result.TMultiResult;
import org.near.toolkit.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author: ssm 有效期最后一天的签到奖金，在最后一天21点还是未绑定，则触发即将失效提醒（多个符合签到奖金情况，也只发一次）
 * @date: 2018/10/18 17:04
 */
@Service("signAccountEndOrderRemindImpl")
public class SignAccountEndOrderRemindImpl implements BaseSendDataDefinition {


    private static final Logger logger = LoggerFactory.getLogger(SignAccountEndOrderRemindImpl.class);
    @Autowired
    SignAwardService signAwardService;
    @Autowired
    private UserFormRepository userFormRepository;

    @Override
    public List<SendUserModel> list(TemplateSendTaskDTO sendTaskDTO) {

        logger.info("有效期最后一天的签到奖金，但是今天截至21点尚未绑定订单的提醒通知,发送模板消息");
        List<SendUserModel> result = new ArrayList<>();
        SignAwardRequest request = new SignAwardRequest();
        request.setGmtCreate(new Date());
        TMultiResult<SignAwardDTO> signAwardDTOTMultiResult = signAwardService.queryLastValidity(request);
        List<SignAwardDTO> list = signAwardDTOTMultiResult.getValues();
        if (!CollectionUtils.isEmpty(list)) {
            logger.info("有效期最后一天的签到奖金，但是今天截至21点尚未绑定订单条数:{}", list.size());
            for (SignAwardDTO dto : list) {
                String userId = dto.getUserId();
                List<UserFormRecordDTO> formRecordDTOS = userFormRepository.query(userId, SwitchEnum.ENABLE.getCode());
                if (!CollectionUtils.isEmpty(formRecordDTOS)) {
                    UserFormRecordDTO formRecord = formRecordDTOS.get(0);
                    SendUserModel userModel = new SendUserModel();
                    Map<String, String> tempParams = new HashMap<>();
                    Integer prizeMoney = dto.getPrizeMoney();
                    Money money = new Money();
                    money.setCent(prizeMoney);
                    tempParams.put("@amount", money.getAmount().toString());
                    userModel.setTemplateParams(tempParams);
                    userModel.setUserId(userId);
                    userModel.setOpenId(formRecord.getOpenId());
                    userModel.setFormId(formRecord.getFormId());
                    result.add(userModel);
                } else {
                    logger.info("有效期最后一天的签到奖金，但是今天截至21点尚未绑定订单的提醒通知,发送模板消息未查询到可使用的formId,该用户userId:{}",
                            userId);
                }
            }
        }

        logger.info("有效期最后一天的签到奖金,消息发送:{}", result.size());


        return result;
    }
}
