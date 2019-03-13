package com.fulihui.duoduoke.demo.api.enums;

import org.near.toolkit.model.BaseEnum;

/**
 * @author Administrator
 */

public enum WithdrawalsErrorCodeEnum implements BaseEnum {

                                                          /**
                                                           * 非实名用户账号不可发放
                                                           */
                                                          V2_ACCOUNT_SIMPLE_BAN("V2_ACCOUNT_SIMPLE_BAN",
                                                                                "非实名用户账号不可发放"),
                                                          /**
                                                           * 付款金额超出限制
                                                           */
                                                          AMOUNT_LIMIT("AMOUNT_LIMIT", "付款金额超出限制"),
                                                          /**
                                                           * 微信转账失败
                                                           */
                                                          FAILED("FAILED", "微信转账失败"),
                                                          /**
                                                           * 该用户今日付款次数超过限制,如有需要请登录微信支付商户平台更改API安全配置
                                                           */
                                                          SENDNUM_LIMIT("SENDNUM_LIMIT",
                                                                        "该用户今日付款次数超过限制,如有需要请登录微信支付商户平台更改API安全配置"),
                                                          /**
                                                            * 微信转账处理中
                                                            */
                                                          PROCESSING("PROCESSING", "微信转账处理中"),
                                                          /**
                                                           * 微信查找无此单号
                                                           */
                                                          NOT_FOUND("NOT_FOUND", "微信查找无此单号"),;

    private String code;
    private String desc;

    WithdrawalsErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
