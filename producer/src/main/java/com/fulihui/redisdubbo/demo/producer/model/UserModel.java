package com.fulihui.redisdubbo.demo.producer.model;


import com.fulihui.redisdubbo.demo.api.enums.TemplateSendTaskBehaviorsEnum;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/8/16 13:42
 */
@Setter
@Getter
public class UserModel {

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户行为
     */
    private TemplateSendTaskBehaviorsEnum userBehaviors;

    /**
     * 行为时间
     */
    private Date behaviorTime;
    /**
     * 用户类型
     */
    private UserTypeEnum userType;

}
