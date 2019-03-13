/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.enums;


import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * 交易人类型枚举
 *
 * @author lizhi

 */
@Getter
public enum TraderTypeEnum implements BaseEnum {
    /**
     * 平台
     */
    PLATFORM("PLATFORM", "平台"),
    /**
     * 用户
     */
    USER("USER", "用户"),;

    String code;
    String desc;

    TraderTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
