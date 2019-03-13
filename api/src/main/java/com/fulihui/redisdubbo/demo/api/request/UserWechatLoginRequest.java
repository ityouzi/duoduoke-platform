/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 */
@Getter
@Setter
public class UserWechatLoginRequest extends ToString {

    private static final long serialVersionUID = 4617961562020088483L;
    /**
     * 微信用户唯一标识
     */
    private String            openId;
    /**
     * 微信 appid
     */
    private String            appid;
    /**
     * 昵称
     */
    private String            nickName;
    /**
     * 性别
     */
    private String            gender;
    /**
     * 开发者平台多微信下用户统一标识
     */
    private String            unionid;
    /**
     * 是否关注
     */
    private Integer           subscribe;

    /**
     * user_detail.user_source
     * 用户来源
     *
     *
     */
    private String            userSource;

    /**
     * user_detail.user_referee
     * 用户推荐人
     *
     *
     */
    private String            userReferee;

    /**
     *
     *
     * user_detail.reg_url
     * 注册页面路径
     *
     * @mbg.generated 2018-09-18 10:55:29
     */
    private String            regUrl;
    /**
     * 用户注册类型
     * @see com.fulihui.redisdubbo.demo.producer.facade.enums.UserTypeEnum
     */
    private String            userType;
}
