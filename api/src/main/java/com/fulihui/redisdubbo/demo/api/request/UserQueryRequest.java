/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 */
@Getter
@Setter
public class UserQueryRequest extends PageRequest {
    private static final long serialVersionUID = 1680198827869990027L;

    /**
     * user_detail.id
     */
    private Integer id;

    /**
     * user_detail.user_id
     * 用户唯一标识
     */
    private String userId;

    /**
     * user_detail.nickname
     * 昵称
     */
    private String nickname;

    /**
     * user_detail.name
     * 用户姓名
     */
    private String name;

    /**
     * user_detail.gender
     * 用户性别
     */
    private String gender;

    /**
     * user_detail.id_card
     * 身份证号
     */
    private String idCard;

    /**
     * user_detail.mobile_no
     * 手机号
     */
    private String mobileNo;

    /**
     * user_detail.birthday
     * 生日yyyyMMdd
     */
    private String birthday;

    /**
     * user_detail.gmt_create
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * user_detail.create_by
     */
    private String createBy;

    /**
     * user_detail.gmt_modified
     * 修改时间
     */
    private Date gmtModified;

    /**
     * user_detail.modified_by
     */
    private String modifiedBy;

    /**
     * user_detail.user_source
     * 用户来源
     */
    private String userSource;

    /**
     * user_detail.user_referee
     * 用户推荐人
     */
    private List<String> userReferee;
    /**
     * user_detail.user_referee
     * 标志位
     */
    private String marker;
    /**
     * 排序字段
     */
    private String sortInfo;

}
