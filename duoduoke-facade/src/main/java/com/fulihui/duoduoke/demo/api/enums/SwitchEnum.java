/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.enums;


import lombok.Getter;
import org.near.toolkit.model.BaseEnum;


/**
 * @author lizhi
 */

@Getter
public enum SwitchEnum implements BaseEnum {

    /**
     * 启用
     */
    ENABLE("1", "启用"),

    /**
     * 禁用
     */
    DISABLE("0", "禁用");

    String code;
    String desc;

    SwitchEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
