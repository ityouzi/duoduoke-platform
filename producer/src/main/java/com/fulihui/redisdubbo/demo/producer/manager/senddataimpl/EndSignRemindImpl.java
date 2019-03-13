package com.fulihui.redisdubbo.demo.producer.manager.senddataimpl;


import com.fulihui.redisdubbo.demo.api.api.sign.SignUserConfigService;
import com.fulihui.redisdubbo.demo.api.api.sign.SignUserRecordService;
import com.fulihui.redisdubbo.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserConfigDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserCountDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.redisdubbo.demo.api.enums.SwitchEnum;
import com.fulihui.redisdubbo.demo.api.request.sign.SignUserRecordRequest;
import com.fulihui.redisdubbo.demo.producer.manager.BaseSendDataDefinition;
import com.fulihui.redisdubbo.demo.producer.model.SendUserModel;
import com.fulihui.redisdubbo.demo.producer.repository.SignUserCountRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserFormRepository;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author: ssm 签到提醒临近结束
 * @date: 2018/10/18 17:04
 */
@Service("endSignRemindImpl")
public class EndSignRemindImpl implements BaseSendDataDefinition {

    private static final Logger logger = LoggerFactory.getLogger(EndSignRemindImpl.class);
    @Autowired
    SignUserConfigService signUserConfigService;
    @Autowired
    SignUserRecordService signUserRecordService;
    @Autowired
    private SignUserCountRepository signUserCountRepository;
    @Autowired
    private UserFormRepository userFormRepository;

    @Override
    public List<SendUserModel> list(TemplateSendTaskDTO sendTaskDTO) {

        logger.info("签到提醒临近结束,消息发送");
        List<SendUserModel> result = new ArrayList<>();
        SignUserRecordRequest recordRequest = new SignUserRecordRequest();
        recordRequest.setSignTimeExt(new Date());
        TMultiResult<SignUserRecordDTO> multiResult = signUserRecordService.queryNearingEnd(recordRequest);
        List<SignUserRecordDTO> list = multiResult.getValues();
        if (!CollectionUtils.isEmpty(list)) {
            logger.info("签到提醒临近结束条数:{}", list.size());
            for (SignUserRecordDTO dto : list) {
                String userId = dto.getUserId();
                TSingleResult<SignUserConfigDTO> signUserConfigDTOTSingleResult = signUserConfigService.takeUserConfig(userId);
                SignUserConfigDTO signUserConfigDTO = signUserConfigDTOTSingleResult.getValue();
                if (signUserConfigDTO.getState().equals(SwitchEnum.ENABLE.getCode())) {
                    List<UserFormRecordDTO> formRecordDTOS = userFormRepository.query(userId, SwitchEnum.ENABLE.getCode());
                    if (!CollectionUtils.isEmpty(formRecordDTOS)) {
                        UserFormRecordDTO formRecord = formRecordDTOS.get(0);
                        SendUserModel userModel = new SendUserModel();
                        Map<String, String> tempParams = new HashMap<>();
                        Date cycleTime = dto.getCycleTime();

                        SignUserCountDTO userCountDTO = signUserCountRepository.query(userId, cycleTime);
                        int count = 0;
                        if (userCountDTO != null) {
                            count = userCountDTO.getTotalCount();
                        }
                        tempParams.put("@SignDays", count + "");
                        userModel.setTemplateParams(tempParams);
                        userModel.setUserId(userId);
                        userModel.setOpenId(formRecord.getOpenId());
                        userModel.setFormId(formRecord.getFormId());
                        result.add(userModel);
                    } else {
                        logger.info("签到提醒临近结束,发送模板消息未查询到可使用的formId,该用户userId:{}",
                                userId);
                    }
                } else {
                    logger.info("签到提醒临近结束,用户发送模板消息状态禁用,该用户userId:{}",
                            userId);
                }
            }

        }

        logger.info("签到提醒临近结束,消息发送:{}", result.size());


        return result;
    }
}
