/*
 * Copyright (c) 2017. Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.enums;


import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * 付款方式
 *
 * @author lizhi
 */
@Getter
public enum TradePayTypeEnum implements BaseEnum {
    /**
     * 微信支付
     */

    WECHAT_PAY("WECHAT_PAY", "微信支付"),;

    String code;
    String desc;

    TradePayTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
