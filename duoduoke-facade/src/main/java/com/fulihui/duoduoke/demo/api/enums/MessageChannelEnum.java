/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/12 0012 14:56
 */
@Getter
public enum MessageChannelEnum implements BaseEnum {

                                                    /**
                                                     * 订单
                                                     */
                                                    ORDER("ORDER", "订单"),
                                                    /**
                                                     * 分享赚
                                                     */
                                                    SHARE("SHARE", "分享赚"),
                                                    /**
                                                     * 订单奖励翻倍
                                                     */
                                                    DOUBLE_ORDER("DOUBLE_ORDER", "订单奖励翻倍"),
                                                    /**
                                                     * 禁用
                                                     */
                                                    WITHDRAW("WITHDRAW", "提现"),
                                                    /**
                                                     * 助力进行中未达到100
                                                     */
                                                    HELPIN("HELPIN", "助力进行中未达到100%"),
                                                    /**
                                                     * 助力进行中即将到期
                                                     */
                                                    HELPINEXPIRE("HELPINEXPIRE", "助力进行中即将到期"),
                                                    /**
                                                     * 助力已过期
                                                     */
                                                    HELPEXPIRED("HELPEXPIRED", "助力已过期"),
                                                    /**
                                                     * 助力已完成
                                                     */
                                                    HELPSUCCESS("HELPSUCCESS", "助力已完成"),
                                                    /**
                                                     * 红包过期提醒
                                                     */
                                                    RED_EXPIRED("RED_EXPIRED", "红包过期提醒"),

                                                    /**
                                                     * 签到奖金成功绑定订单
                                                     */
                                                    SIGN_THE_ORDER("SIGN_THE_ORDER", "签到奖金成功绑定订单"),

                                                    /**
                                                     * 签到奖金触发发放到账户余额
                                                     */
                                                    SIGN_ACCOUNT_BALANCE("SIGN_ACCOUNT_BALANCE",
                                                                         "签到奖金触发发放到账户余额"),

                                                    /**
                                                     * 每天20点定时对前2天有签到的用户，但是今日未签到的用户发送
                                                     */
                                                    SIGN_REMIND_START("SIGN_REMIND_START",
                                                                      "签到提醒初期"),

                                                    /**
                                                     * 每天20点定时对前6-7天有签到的用户，但是今日未签到的用户发送
                                                     */
                                                    SIGN_REMIND_STOP("SIGN_REMIND_START",
                                                                     "签到提醒临近结束"),

                                                    /**
                                                     * 签到周期结束后隔天11点发放通知
                                                     */
                                                    SIGN_ACCOUNT_BALANCE_REMIND("SIGN_REMIND_START",
                                                                                "签到周期结束后隔天11点发放通知"),

                                                    /**
                                                     * 昨天获得的签到奖金，但是今天截至21点尚未绑定订单的提醒通知
                                                     */
                                                    SIGN_ACCOUNT_ORDER_REMIND("SIGN_REMIND_START",
                                                                              "昨天获得的签到奖金，但是今天截至21点尚未绑定订单的提醒通知"),

                                                    /**
                                                     * 有效期最后一天的签到奖金，在最后一天21点还是未绑定，则触发即将失效提醒
                                                     */
                                                    SIGN_ACCOUNT_INVALID_REMIND("SIGN_REMIND_START",
                                                                                "有效期最后一天的签到奖金，在最后一天21点还是未绑定，则触发即将失效提醒"),

                                                    /**
                                                     * 订单奖励发放到账
                                                     */
                                                    ORDER_REWARD_TO_ACCOUNT("ORDER_REWARD_TO_ACCOUNT",
                                                                            "订单奖励发放到账"),

                                                    /**
                                                     * 获得免单资格
                                                     */
                                                    FREE_QUALIFICATION("FREE_QUALIFICATION",
                                                                       "获得免单资格"),

    ;

    String code;
    String desc;

    MessageChannelEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
