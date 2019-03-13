/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;

/**
 * @author Administrator
 */

@Getter
public enum ExemptionGoodsStateEnum {

    /**
     * 开启
     */
    ON(1, "开启"),


    /**
     *下架
     */
    OFF(2, "关闭"),

    OVER(3, "下架");

    int code;
    String desc;

    ExemptionGoodsStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
