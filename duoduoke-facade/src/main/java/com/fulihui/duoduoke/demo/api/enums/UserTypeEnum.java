/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * 用户类型枚举
 *
 * @author lizhi
 */
@Getter
public enum UserTypeEnum implements BaseEnum {
    /**
     * 小程序用户
     */
    MINI_USER("1", "小程序用户"),

    /**
     * 微信公众号h5用户
     */
    WX_PN_USER("2", "微信公众号h5用户"),
    ;

    String code;
    String desc;

    UserTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
