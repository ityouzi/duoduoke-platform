package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.TemplateSendTaskService;
import com.fulihui.redisdubbo.demo.api.api.UserService;
import com.fulihui.redisdubbo.demo.api.api.WechatAuthService;
import com.fulihui.redisdubbo.demo.api.dto.UserDTO;
import com.fulihui.redisdubbo.demo.api.enums.TemplateSendTaskBehaviorsEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import com.fulihui.redisdubbo.demo.manager.UserManager;
import com.fulihui.redisdubbo.demo.weixin.common.util.RedisUtils;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: JY
 * @date: 2018/8/17 15:38
 */
@Component
public class UserManagerImpl implements UserManager {

    @org.apache.dubbo.config.annotation.Reference
    UserService userService;

    @org.apache.dubbo.config.annotation.Reference
    WechatAuthService wechatAuthService;

    @org.apache.dubbo.config.annotation.Reference
    TemplateSendTaskService templateSendTaskService;

    @Autowired
    RedisUtils redisUtils;

    private static final String DUODUO_USER_OPEN_TEMPLATE        = "DUODUOKE_USER_OPEN_TEMPLATE_";

    /**
     * 过期时间
     */
    private static final Long   DUODUO_USER_OPEN_TEMPLATE_EXPIRE = 7 * 24 * 60 * 60L;

    /**
     * 当日访问
     * @param userId
     */
    @Override
    public void visitToday(String userId) {

        UserDTO userDTO = userService.queryByUserId(userId).getValue();
        userService.recordUserBehaviors(userDTO, TemplateSendTaskBehaviorsEnum.VISIT_TODAY,
            UserTypeEnum.MINI_USER);
    }

    /**
     * 打开模板消息
     * @param userId 用户id
     * @param taskId 任务id
     */
    @Override
    public void userOpenTemplate(String userId, Integer taskId, String batchId) {

        if (taskId == null || StringUtil.isEmpty(batchId)) {
            return;
        }

        //任务Id为HashKey
        String hasKey = DUODUO_USER_OPEN_TEMPLATE + taskId;

        String paramKey = userId + "_" + batchId;

        //已经记录
        if (redisUtils.hHasKey(hasKey, paramKey)) {
            return;
        }

        //记录用户访问-7天自动过期
        if (redisUtils.hset(hasKey, paramKey, true, DUODUO_USER_OPEN_TEMPLATE_EXPIRE)) {
            //添加访问记录
            templateSendTaskService.setCountRecord(taskId, 1,
                TemplateSendTaskService.TEMPLATE_USER_OPEN);
        }
    }
}
