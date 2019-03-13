/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.enums;


import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 */

@Getter
public enum GoodsStateEnum implements BaseEnum {

    /**
     * 上架
     */
    ON("0", "上架"),

    /**
     *初始化
     */
    INIT("2", "初始化"),

    /**
     *下架
     */
    OFF("1", "下架"),

    /**
     *过期
     */
    OVER("3", "过期")
    ;

    String code;
    String desc;

    GoodsStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
