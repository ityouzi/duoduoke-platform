package com.fulihui.duoduoke.demo.producer.manager.senddataimpl;


import com.fulihui.duoduoke.demo.api.api.sign.SignAwardService;
import com.fulihui.duoduoke.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.duoduoke.demo.api.dto.UserFormRecordDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.enums.SwitchEnum;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import com.fulihui.duoduoke.demo.producer.manager.BaseSendDataDefinition;
import com.fulihui.duoduoke.demo.producer.model.SendUserModel;
import com.fulihui.duoduoke.demo.producer.repository.UserFormRepository;
import org.near.servicesupport.result.TMultiResult;
import org.near.toolkit.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author: ssm 昨天获得的签到奖金，但是今天截至21点尚未绑定订单的提醒通知
 * @date: 2018/10/18 17:04
 */
@Service("signAccountOrderRemindImpl")
public class SignAccountOrderRemindImpl implements BaseSendDataDefinition {


    private static final Logger logger = LoggerFactory.getLogger(SignAccountOrderRemindImpl.class);
    @Autowired
    private UserFormRepository userFormRepository;
    @Autowired
    private SignAwardService signAwardService;

    @Override
    public List<SendUserModel> list(TemplateSendTaskDTO sendTaskDTO) {
        logger.info("昨天获得的签到奖金，但是今天截至21点尚未绑定订单的提醒通知,发送模板消息");

        List<SendUserModel> result = new ArrayList<>();

        SignAwardRequest request = new SignAwardRequest();
        request.setGmtCreate(new Date());
        TMultiResult<SignAwardDTO> signAwardDTOTMultiResult = signAwardService.queryAsOfGmtCreate(request);
        List<SignAwardDTO> list = signAwardDTOTMultiResult.getValues();
        if (!CollectionUtils.isEmpty(list)) {
            for (SignAwardDTO dto : list) {
                logger.info("昨天获得的签到奖金，但是今天截至21点尚未绑定订单条数:{}", list.size());
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
                    logger.info("昨天获得的签到奖金，但是今天截至21点尚未绑定订单的提醒通知,发送模板消息未查询到可使用的formId,该用户userId:{}",
                            userId);
                }
            }

        }

        logger.info("昨天获得的签到奖金,消息发送:{}", result.size());


        return result;
    }
}
