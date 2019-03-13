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
public enum GoodsChooseEnum implements BaseEnum {

    /**
     * 是
     */
    IS("1", "是"),
    /**
     * 否
     */

    NO("0", "否");

    String code;
    String desc;

    GoodsChooseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
