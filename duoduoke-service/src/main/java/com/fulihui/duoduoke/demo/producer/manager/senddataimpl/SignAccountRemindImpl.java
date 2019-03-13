package com.fulihui.duoduoke.demo.producer.manager.senddataimpl;


import com.fulihui.duoduoke.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.duoduoke.demo.api.dto.UserFormRecordDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.enums.ActivitySignPrizeTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.ActivityTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.SwitchEnum;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignAwardExample;
import com.fulihui.duoduoke.demo.producer.manager.BaseSendDataDefinition;
import com.fulihui.duoduoke.demo.producer.model.SendUserModel;
import com.fulihui.duoduoke.demo.producer.repository.SignAwardRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserFormRepository;
import org.near.toolkit.common.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;

/**
 * @author: ssm 签到周期结束后隔天11点发放通知
 * @date: 2018/10/18 17:04
 */
@Service("signAccountRemindImpl")
public class SignAccountRemindImpl implements BaseSendDataDefinition {

    private static final Logger logger = LoggerFactory.getLogger(SignAccountRemindImpl.class);
    @Autowired
    private SignAwardRepository signAwardRepository;
    @Autowired
    private UserFormRepository userFormRepository;

    @Override
    public List<SendUserModel> list(TemplateSendTaskDTO sendTaskDTO) {
        logger.info("签到周期结束后隔天11点发放通知,发送模板消息");

        Date date = new Date();
        String s = DateUtils.formatWebFormat(date);
        List<SendUserModel> result = new ArrayList<>();
        try {
            Date formatDate = DateUtils.parseNewFormat(s + " 00:00:00");
            SignAwardExample example = new SignAwardExample();
            SignAwardExample.Criteria criteria = example.createCriteria();
            criteria.andActivityTypeEqualTo(ActivityTypeEnum.Sign.getCode());
            criteria.andPrizeTypeEqualTo(ActivitySignPrizeTypeEnum.BONUS.getCode());
            criteria.andGmtCreateGreaterThanOrEqualTo(formatDate);
            List<SignAwardDTO> list = signAwardRepository.selectByExample(example);
            if (!CollectionUtils.isEmpty(list)) {
                logger.info("签到周期结束后隔天11点发放通知条数:{}", list.size());
                for (SignAwardDTO dto : list) {
                    String userId = dto.getUserId();
                    List<UserFormRecordDTO> formRecordDTOS = userFormRepository.query(userId, SwitchEnum.ENABLE.getCode());
                    if (!CollectionUtils.isEmpty(formRecordDTOS)) {
                        UserFormRecordDTO formRecord = formRecordDTOS.get(0);
                        SendUserModel userModel = new SendUserModel();
                        Map<String, String> tempParams = new HashMap<>();
                        tempParams.put("@date", DateUtils.formatWebFormat(dto.getGmtCreate()));
                        userModel.setTemplateParams(tempParams);
                        userModel.setUserId(userId);
                        userModel.setOpenId(formRecord.getOpenId());
                        userModel.setFormId(formRecord.getFormId());
                        result.add(userModel);
                    } else {
                        logger.info("签到周期结束后隔天11点发放通知,发送模板消息未查询到可使用的formId,该用户userId:{}",
                                userId);
                    }
                }
            }

        } catch (ParseException e) {
            logger.error("签到周期结束后隔天11点发放通知", e);
        }
        logger.info("签到周期结束后隔天11点发放通知,消息发送:{}", result.size());


        return result;
    }
}
