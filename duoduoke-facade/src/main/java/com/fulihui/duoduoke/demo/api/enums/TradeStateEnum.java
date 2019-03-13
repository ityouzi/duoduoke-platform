/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.enums;


import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * 交易状态
 * @author lizhi
 */
@Getter
public enum TradeStateEnum implements BaseEnum {
    /**
     * 待支付
     */
    UNPAID("UNPAID", "待支付"),
    /**
     * 处理中
     */
    PROCESS("PROCESS", "处理中"),
    /**
     * 支付成功
     */
    FINISH("FINISH", "支付成功"),
    /**
     * 支付失败
     */
    FAILED("FAILED", "支付失败"),
    /**
     * 交易关闭
     */
    CLOSED("CLOSED", "交易关闭"),
    /**
     * 支付中
     */
    INPAY("INPAY", "支付中"),;

    String code;
    String desc;

    TradeStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
