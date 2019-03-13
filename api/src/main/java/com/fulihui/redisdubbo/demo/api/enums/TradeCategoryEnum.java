/*
 * Copyright (c) 2017. Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.enums;


import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * 交易类型
 *
 * @author lizhi
 */
@Getter

public enum TradeCategoryEnum implements BaseEnum {
    /**
     * 提现
     */
    WITH_DRAW("WITH_DRAW", "提现"),;

    String code;
    String desc;

    TradeCategoryEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
