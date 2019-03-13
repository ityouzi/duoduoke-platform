package com.fulihui.redisdubbo.demo.producer.manager.senddataimpl;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.api.api.sign.SignUserConfigService;
import com.fulihui.redisdubbo.demo.api.api.sign.SignUserRecordService;
import com.fulihui.redisdubbo.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserFormRecordDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserConfigDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserCountDTO;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.redisdubbo.demo.api.enums.SignStatusEnum;
import com.fulihui.redisdubbo.demo.api.enums.SwitchEnum;
import com.fulihui.redisdubbo.demo.api.request.sign.SignUserRecordRequest;
import com.fulihui.redisdubbo.demo.producer.manager.BaseSendDataDefinition;
import com.fulihui.redisdubbo.demo.producer.model.SendUserModel;
import com.fulihui.redisdubbo.demo.producer.repository.SignUserCountRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserFormRepository;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author: ssm 签到提醒-初期
 * @date: 2018/10/18 17:04
 */
@Service("beforeSignRemindImpl")
public class BeforeSignRemindImpl implements BaseSendDataDefinition {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(BeforeSignRemindImpl.class);
    @Autowired
    SignUserConfigService signUserConfigService;
    @Autowired
    private SignUserCountRepository signUserCountRepository;
    @Autowired
    private UserFormRepository userFormRepository;
    @Autowired
    private SignUserRecordService signUserRecordService;
    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("BeforeSignRemindImpl-schedule-pool-%d")
                    .daemon(true).build());

    public static void main(String[] args) {
        SignUserRecordDTO data1 = new SignUserRecordDTO("1", "aaaa");
        SignUserRecordDTO data2 = new SignUserRecordDTO("2", "dddd");
        SignUserRecordDTO data3 = new SignUserRecordDTO("1", "vvvv");
        SignUserRecordDTO data4 = new SignUserRecordDTO("4", "rrrr");
        SignUserRecordDTO data5 = new SignUserRecordDTO("1", "ssss");
        List<SignUserRecordDTO> list = Arrays.asList(data1, data2, data3, data4, data5);
        List<SignUserRecordDTO> l = removal(list);
        System.out.println(JSONObject.toJSONString(l));

    }

    private static List<SignUserRecordDTO> removal(List<SignUserRecordDTO> list) {
        return list.stream()
                .collect(collectingAndThen(
                        toCollection(
                                () -> new TreeSet<>(Comparator.comparing(SignUserRecordDTO::getUserId))),
                        ArrayList::new));
    }

    @Override
    public List<SendUserModel> list(TemplateSendTaskDTO sendTaskDTO) {

        LOGGER.info("签到提醒,消息发送");
        List<SendUserModel> successList = new ArrayList<>();
        SignUserRecordRequest recordRequest = new SignUserRecordRequest();
        recordRequest.setSignTimeExt(new Date());

        TMultiResult<SignUserRecordDTO> result = signUserRecordService
                .queryBeforeSignUser(recordRequest);
        ServiceResultUtil.checkResult(result);

        if (!CollectionUtils.isEmpty(result.getValues())) {
            List<SignUserRecordDTO> collect = result.getValues();
            for (SignUserRecordDTO item : collect) {

                SignUserRecordRequest check = new SignUserRecordRequest();
                check.setSignTimeExt(new Date());
                check.setUserId(item.getUserId());
                TPageResult<SignUserRecordDTO> pageResult = signUserRecordService.queryPage(check);
                ServiceResultUtil.checkResult(pageResult);
                if (!CollectionUtils.isEmpty(pageResult.getValues()) && pageResult.getValues()
                        .get(0).getSignStatus().equals(SignStatusEnum.Y.getCode())) {
                    LOGGER.info("签到提醒,用户今天已经签到过,忽略,userId:{}", item.getUserId());
                    continue;
                }

                String userId = item.getUserId();
                TSingleResult<SignUserConfigDTO> singleResult = signUserConfigService
                        .takeUserConfig(userId);
                SignUserConfigDTO signUserConfigDTO = singleResult.getValue();
                if (signUserConfigDTO.getState().equals(SwitchEnum.ENABLE.getCode())) {
                    List<UserFormRecordDTO> list = userFormRepository.query(userId,
                            SwitchEnum.ENABLE.getCode());
                    if (!CollectionUtils.isEmpty(list)) {
                        UserFormRecordDTO formRecord = list.get(0);
                        SendUserModel userModel = new SendUserModel();
                        Map<String, String> tempParams = new HashMap<>();
                        Date cycleTime = item.getCycleTime();
                        SignUserCountDTO dto = signUserCountRepository.query(userId, cycleTime);
                        int count = 0;
                        if (dto != null) {
                            count = dto.getTotalCount();
                        }
                        tempParams.put("@SignDays", count + "");
                        userModel.setTemplateParams(tempParams);
                        userModel.setUserId(item.getUserId());
                        userModel.setOpenId(formRecord.getOpenId());
                        userModel.setFormId(formRecord.getFormId());
                        successList.add(userModel);
                    } else {
                        LOGGER.info("签到提醒,发送模板消息未查询到可使用的formId,该用户userId:{}", userId);
                    }
                } else {
                    LOGGER.info("签到提醒,用户发送模板消息状态禁用,该用户userId:{}", userId);
                }

            }
        }
        LOGGER.info("签到提醒,消息发送:{}", successList.size());
        return successList;
    }

    abstract class AbstractCall implements Callable<List<SignUserRecordDTO>> {

        SignUserRecordRequest recordRequest;
        SignUserRecordService signUserRecordService;

        AbstractCall(SignUserRecordRequest recordRequest,
                     SignUserRecordService signUserRecordService) {
            this.recordRequest = recordRequest;
            this.signUserRecordService = signUserRecordService;
        }

        public AbstractCall() {

        }
    }

}
