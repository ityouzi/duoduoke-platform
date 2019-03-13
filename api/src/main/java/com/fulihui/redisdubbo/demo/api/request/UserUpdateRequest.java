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
public class UserUpdateRequest extends ToString {


    private static final long serialVersionUID = 4617961562020088483L;

    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String gender;

    /**
     * 是否关注
     */
    private Integer subscribe;
    /**
     *
     */
    private String userId;

    private String avatarUrl;

}
