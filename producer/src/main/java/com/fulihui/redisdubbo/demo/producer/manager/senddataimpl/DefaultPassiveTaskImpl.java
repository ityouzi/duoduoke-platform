package com.fulihui.redisdubbo.demo.producer.manager.senddataimpl;

import com.fulihui.redisdubbo.demo.api.api.TemplateSendTaskService;
import com.fulihui.redisdubbo.demo.api.api.UserFormService;
import com.fulihui.redisdubbo.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserFormIdDTO;
import com.fulihui.redisdubbo.demo.api.enums.TemplateSendTaskStateEnum;
import com.fulihui.redisdubbo.demo.api.enums.TemplateSendTaskTimeEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import com.fulihui.redisdubbo.demo.api.request.SendTaskRequest;
import com.fulihui.redisdubbo.demo.producer.manager.PassiveTaskDefinition;
import com.fulihui.redisdubbo.demo.producer.model.SendUserModel;
import com.fulihui.redisdubbo.demo.producer.model.UserModel;
import com.fulihui.redisdubbo.demo.weixin.common.util.RedisUtils;
import com.google.common.collect.Maps;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: JY
 * @date: 2018/10/18 17:35
 */
@Service("defaultPassiveTaskImpl")
public class DefaultPassiveTaskImpl implements PassiveTaskDefinition {

    private static final Logger logger = LoggerFactory
            .getLogger(DefaultPassiveTaskImpl.class);
    /**
     * 过期时间
     */
    private static final Long USER_COUNT_EXPIRE_TIME = 24 * 6 * 60L;
    private static String DUODUOKE_TASK_KEY = "DUODUOKE_TASK_KEY_";
    private static String DUODUOKE_USER_COUNT_KEY = "DUODUOKE_USER_COUNT_KEY_";
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserFormService userFormService;
    @Autowired
    TemplateSendTaskService sendTaskService;

    @Override
    public List<SendUserModel> list(TemplateSendTaskDTO sendTaskDTO) {

        Calendar dateNow = Calendar.getInstance();
        dateNow.set(Calendar.SECOND, 0);
        //当前时间下所有待发消息的key
        String paramKey = dateNow.getTime().getTime() / 1000 + "";

        String todayUserCountKey = getTodayUserCountKey();

        String taskTimeKey = DUODUOKE_TASK_KEY + sendTaskDTO.getId();

        List<String> userIds = (List<String>) redisUtils.hget(taskTimeKey, paramKey);

        List<SendUserModel> result = null;

        if (userIds != null) {
            //当日没有标记发送 无需判断发送次数/无限制发送次数
            if (redisUtils.hasKey(todayUserCountKey) && sendTaskDTO.getSendCount() != -1) {
                userIds = userIds.stream().filter((item) -> {
                    Integer todaySendCount = (Integer) redisUtils.hget(todayUserCountKey,
                            sendTaskDTO.getId() + "_" + item);
                    //每日发送次数
                    if (todaySendCount != null
                            && todaySendCount >= sendTaskDTO.getDateSendCount()) {
                        logger.info("推送模板消息：用户{}当日发送次数超限{}次 跳过 ", item, todaySendCount);
                        return false;
                    }
                    return true;
                }).collect(Collectors.toList());
            }

            if (userIds != null && userIds.size() > 0) {
                //查询用户信息&formId
                List<UserFormIdDTO> userFormIdDTOS = userFormService.queryFormIdByUserIds(userIds);

                result = new ArrayList<>(userFormIdDTOS.size());

                for (UserFormIdDTO formIdDTO : userFormIdDTOS) {
                    SendUserModel userModel = new SendUserModel();
                    userModel.setFormId(formIdDTO.getFormId());
                    userModel.setOpenId(formIdDTO.getOpenId());
                    userModel.setUserId(formIdDTO.getUserId());
                    Map<String, String> templateParams = Maps.newHashMap();
                    templateParams.put("@Nick", formIdDTO.getDecodeName());
                    userModel.setTemplateParams(templateParams);
                    result.add(userModel);
                }
            }
        }

        //删除缓存数据
        redisUtils.hdel(taskTimeKey, paramKey);

        return result;
    }

    /**
     * 设置当天发送次数
     *
     * @param userIds
     * @param taskId
     */
    @Override
    public void markerToadyCount(List<String> userIds, Integer taskId) {

        String todayUserCountKey = getTodayUserCountKey();

        //是否添加
        boolean hasAdd = redisUtils.hasKey(todayUserCountKey);

        for (String userId : userIds) {
            //当日发送模板数+1
            redisUtils.hincr(todayUserCountKey, taskId + "_" + userId, 1);
        }

        //初次添加 设置过期时间为1天
        if (!hasAdd) {
            redisUtils.expire(todayUserCountKey, USER_COUNT_EXPIRE_TIME);
        }
    }

    @Override
    public void putUser(UserModel userModel) {
        if (userModel == null) {
            return;
        }
        if (userModel.getUserType() == UserTypeEnum.MINI_USER) {

            List<TemplateSendTaskDTO> activitTask = getPassiveTask();

            if (activitTask != null && activitTask.size() > 0) {

                for (TemplateSendTaskDTO sendTaskDTO : activitTask) {

                    //判断行为条件是否符合
                    if (!StringUtil.isEmpty(sendTaskDTO.getUserBehaviors())) {
                        //不包含
                        if (!sendTaskDTO.getUserBehaviors()
                                .contains(userModel.getUserBehaviors().getCode())) {
                            continue;
                        }
                    }

                    //判断性别
                    if (!StringUtil.isEmpty(sendTaskDTO.getUserSex())) {
                        //未知性别判断
                        if (null == userModel.getUserSex()
                                && !"3".equals(sendTaskDTO.getUserSex())) {
                            continue;
                            //男、女性别判断
                        } else if (!sendTaskDTO.getUserSex().equals(userModel.getUserSex())) {
                            continue;
                        }
                    }

                    //条件符合
                    addCache(sendTaskDTO, userModel);
                }
            }
        }

    }

    /**
     * 获取当日记录用户发送的Key
     *
     * @return
     */
    private String getTodayUserCountKey() {
        return DUODUOKE_USER_COUNT_KEY + Calendar.getInstance().get(Calendar.DATE);
    }

    /**
     * 获取有效的任务
     *
     * @return
     */
    private List<TemplateSendTaskDTO> getPassiveTask() {

        SendTaskRequest taskRequest = new SendTaskRequest();

        List<Integer> states = new ArrayList<>();
        states.add(Integer.parseInt(TemplateSendTaskStateEnum.ENABLE.getCode()));
        states.add(Integer.parseInt(TemplateSendTaskStateEnum.HAS_SEND.getCode()));

        //设置状态
        taskRequest.setState(states);
        //分页条件
        taskRequest.setPage(1);
        taskRequest.setRows(100);
        //查询被动任务
        taskRequest.setType(1);

        TPageResult<TemplateSendTaskDTO> list = sendTaskService.list(taskRequest);

        return list.getValues();
    }

    /**
     * 将需要发送的用户添加至缓存
     *
     * @param taskDTO
     * @param userModel
     */
    private void addCache(TemplateSendTaskDTO taskDTO, UserModel userModel) {

        String taskHashKey = DUODUOKE_TASK_KEY + taskDTO.getId();

        if (StringUtil.isEmpty(taskDTO.getTriggerTimes())) {
            return;
        }

        //param Key
        List<String> timeKeys = getTimeKey(taskDTO, userModel);
        for (String timeKey : timeKeys) {
            List<String> userIds = (List<String>) redisUtils.hget(taskHashKey, timeKey);
            if (userIds == null) {
                userIds = new ArrayList<>();
            }

            //判断重复添加
            if (userIds.contains(userModel.getUserId())) {
                return;
            }

            userIds.add(userModel.getUserId());
            //数据添加至redis
            if (!redisUtils.hset(taskHashKey, timeKey, userIds)) {
                try {
                    Thread.sleep(200);
                    redisUtils.hset(taskHashKey, timeKey, userIds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取params Key 已分为单为的时间戳+UserId
     *
     * @param taskDTO
     * @param userModel
     * @return
     */
    private List<String> getTimeKey(TemplateSendTaskDTO taskDTO, UserModel userModel) {
        //解析发送时间 格式 1@2:30;2@12:30
        String[] trigerTime = taskDTO.getTriggerTimes().split(";");

        List<String> result = new ArrayList<>(trigerTime.length);

        for (String time : trigerTime) {

            String[] triggerVal = time.split("@");

            TemplateSendTaskTimeEnum taskTimeEnum = EnumUtil.queryByCode(triggerVal[0],
                    TemplateSendTaskTimeEnum.class);

            if (taskTimeEnum != null) {
                Time afterTime = Time.valueOf(triggerVal[1]);
                //推送的时间点
                result.add(getPushTime(taskTimeEnum, afterTime, userModel.getBehaviorTime()) + "");
            }
        }

        return result;
    }

    /**
     * 获取推送时间点单为s
     */
    private long getPushTime(TemplateSendTaskTimeEnum taskTimeEnum, Time afterTime,
                             Date userVisitTiem) {

        //当前时间
        Calendar visitDate = Calendar.getInstance();
        visitDate.setTime(userVisitTiem);
        switch (taskTimeEnum) {
            //当天
            case TOADY:
                //增加时、分
                visitDate.add(Calendar.HOUR_OF_DAY, afterTime.getHours());
                visitDate.add(Calendar.MINUTE, afterTime.getMinutes());
                visitDate.set(Calendar.SECOND, 0);
                break;
            //明天
            case TOMORROW:
            case TWO_AFTER:
            case THREE_AFTER:
                //增加天、设置时、分
                visitDate.add(Calendar.DATE, taskTimeEnum.getAfterDay());
                visitDate.set(Calendar.HOUR_OF_DAY, afterTime.getHours());
                visitDate.set(Calendar.MINUTE, afterTime.getMinutes());
                visitDate.set(Calendar.SECOND, 0);
                break;
            default:
        }
        return visitDate.getTime().getTime() / 1000;
    }

}
