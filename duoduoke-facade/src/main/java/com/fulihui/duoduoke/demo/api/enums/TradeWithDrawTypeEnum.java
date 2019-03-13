/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.enums;


import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * 提现方式
 * <p>
 * . * 提现方式
 *
 * @author LIZHI
 */
@Getter
public enum TradeWithDrawTypeEnum implements BaseEnum {

    /**
     * 提现到微信余额
     */
    WX_BALANCE("WX_BALANCE", "提现到微信余额"),;

    String code;
    String desc;

    TradeWithDrawTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
