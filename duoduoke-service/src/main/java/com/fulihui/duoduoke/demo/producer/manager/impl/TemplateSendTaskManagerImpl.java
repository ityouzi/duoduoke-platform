package com.fulihui.duoduoke.demo.producer.manager.impl;


import com.fulihui.duoduoke.demo.api.api.TemplateSendTaskService;
import com.fulihui.duoduoke.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.duoduoke.demo.api.dto.WxTemplateDTO;
import com.fulihui.duoduoke.demo.api.dto.WxTemplateSendDTO;
import com.fulihui.duoduoke.demo.api.enums.TemplateSendTaskStateEnum;
import com.fulihui.duoduoke.demo.api.request.SendTaskRequest;
import com.fulihui.duoduoke.demo.producer.manager.BaseSendDataDefinition;
import com.fulihui.duoduoke.demo.producer.manager.TemplateSendTaskManager;
import com.fulihui.duoduoke.demo.producer.manager.enums.SendDataDefinitionEnum;
import com.fulihui.duoduoke.demo.producer.model.SendUserModel;
import com.fulihui.duoduoke.demo.common.util.RedisUtils;
import com.google.common.collect.Maps;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.*;

/**
 * @author: JY
 * @date: 2018/8/16 9:41
 */
@Component
public class TemplateSendTaskManagerImpl implements TemplateSendTaskManager {

    private static final Logger logger = LoggerFactory.getLogger(TemplateSendTaskManagerImpl.class);
    private static String DUODUOKE_TASK_KEY = "DUODUOKE_TASK_KEY_";
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    TemplateSendTaskService sendTaskService;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void checkData() {
        //获取活动任务列表
        List<TemplateSendTaskDTO> activityTask = getActivityTask();

        if (activityTask != null && activityTask.size() > 0) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.SECOND, 0);

            for (TemplateSendTaskDTO sendTaskDTO : activityTask) {
                BaseSendDataDefinition definition = null;
                try {
                    if (sendTaskDTO.getType() == 1) {
                        //被动任务
                        definition = SendDataDefinitionEnum.DefaultPassiveTaskDefinition.getSendDataDefinition();
                    } else {
                        //region主动任务
                        //判断是否到固定时间
                        List<Time> triggerTime = getTriggerTimes(sendTaskDTO.getTriggerTimes());
                        if (triggerTime == null || triggerTime.size() == 0) {
                            logger.error("任务" + sendTaskDTO.getTitle() + "未设置定时时间");
                            continue;
                        }
                        for (Time time : triggerTime) {
                            //触发事件
                            if (calendar.get(Calendar.HOUR_OF_DAY) == time.getHours() && calendar.get(Calendar.MINUTE) == time.getMinutes()) {
                                definition = SendDataDefinitionEnum.get(sendTaskDTO.getId()).getSendDataDefinition();
                                //同一时间 只做一次操作
                                break;
                            }
                        }
                        //endregion
                    }
                    logger.info("开始执行任务{}", sendTaskDTO.getTitle());
                    if (definition != null) {
                        //读取待发送的数据
                        List<SendUserModel> userModels = definition.list(sendTaskDTO);
                        //发送的批次Id
                        String batchId = calendar.getTime().getTime() / 1000 + "";
                        if (userModels != null && userModels.size() > 0) {
                            logger.info("开始执行任务条数{}", userModels.size());
                            for (SendUserModel sendUserModel : userModels) {
                                putSendData(sendTaskDTO, sendUserModel, batchId);
                            }
                        }
                    }
                } catch (Exception ex) {
                    logger.error("执行发送【" + sendTaskDTO.getTitle() + "】任务失败{}", ex);
                }
            }
        }
    }

    /**
     * 添加发送的用户
     *
     * @param userModel
     */
    @Override
    public void putSend(SendDataDefinitionEnum sendDataDefinitionEnum, SendUserModel userModel) {

        TemplateSendTaskDTO model = getActivityTask().stream().filter((f) -> {
            return f.getId().equals(sendDataDefinitionEnum.getTaskId());
        }).findFirst().get();
        if (model != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.SECOND, 0);
            String batchId = calendar.getTime().getTime() / 1000 + "";
            putSendData(model, userModel, batchId);
        }
    }

    /**
     * 清空队列
     *
     * @param id
     * @return
     */
    @Override
    public void clearTaskQueue(Integer id) {

        String taskHashKey = DUODUOKE_TASK_KEY + id;

        //清空任务
        redisUtils.del(taskHashKey);
    }


    /**
     * 添加发送数据
     *
     * @param sendTaskDTO
     * @param userModel
     * @param batchId
     * @return
     */
    private boolean putSendData(TemplateSendTaskDTO sendTaskDTO, SendUserModel userModel, String batchId) {
        try {
            WxTemplateSendDTO templateSendDTO = new WxTemplateSendDTO();
            templateSendDTO.setTouser(userModel.getOpenId());
            templateSendDTO.setPage(sendTaskDTO.getTemplatePage());
            templateSendDTO.setTemplateId(sendTaskDTO.getTemplateId());
            templateSendDTO.setFormId(userModel.getFormId());
            templateSendDTO.setTaskId(sendTaskDTO.getId());
            templateSendDTO.setUserId(userModel.getUserId());
            templateSendDTO.setEmphasisKeyword(sendTaskDTO.getEmphasisKeyword());

            //替换固定参数
            String templateData = sendTaskDTO.getTemplateDate();
            Map<String, String> params = userModel.getTemplateParams();
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if (sendTaskDTO.getTemplateDate().contains(entry.getKey())) {
                        templateData = templateData.replaceAll(entry.getKey(), entry.getValue());
                    }
                }
            }

            //连接参数
            Map<String, Object> urlParams = userModel.getLinkParams();
            if (urlParams == null) {
                urlParams = Maps.newHashMap();
            }
            urlParams.put("taskId", sendTaskDTO.getId());
            urlParams.put("batchId", batchId);

            //解析Map
            WxTemplateDTO templateDTO = new WxTemplateDTO();
            templateDTO.setExample(templateData);
            templateSendDTO.setKeywords((LinkedHashMap) templateDTO.getKeywords());
            templateSendDTO.setParams(urlParams);

            logger.info("推送模板消息-放入消息队列 用户：{},模板Id:{}", userModel.getUserId(), sendTaskDTO.getId());

            //放入kafka

            return true;
        } catch (Exception ex) {
            logger.error("推送模板消息失败-放入消息队列出错：{}", ex);
        }

        return false;
    }


    /**
     * 获取有效的任务
     *
     * @return
     */
    private List<TemplateSendTaskDTO> getActivityTask() {

        SendTaskRequest taskRequest = new SendTaskRequest();

        List<Integer> states = new ArrayList<>();
        states.add(Integer.parseInt(TemplateSendTaskStateEnum.ENABLE.getCode()));
        states.add(Integer.parseInt(TemplateSendTaskStateEnum.HAS_SEND.getCode()));

        //设置状态
        taskRequest.setState(states);
        //分页条件
        taskRequest.setPage(1);
        taskRequest.setRows(100);

        TPageResult<TemplateSendTaskDTO> list = sendTaskService.list(taskRequest);

        return list.getValues() == null ? new ArrayList<>() : list.getValues();
    }

    /**
     * 获取任务触发的时间
     *
     * @param triggerTime
     * @return
     */
    private List<Time> getTriggerTimes(String triggerTime) {

        if (StringUtil.isEmpty(triggerTime)) {
            return null;
        }

        String[] strTimes = triggerTime.split(";");

        List<Time> result = new ArrayList<>(strTimes.length);

        for (String time : strTimes) {
            String[] triggerVal = time.split("@");
            result.add(Time.valueOf(triggerVal[1]));
        }

        return result;
    }

}
