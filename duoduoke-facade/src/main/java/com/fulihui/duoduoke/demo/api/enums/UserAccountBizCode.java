package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 * @date 2018-7-21
 */
@Getter
public enum UserAccountBizCode implements BaseEnum {

                                                    /**
                                                     * 订单返利
                                                     */
                                                    ORDER_REBATE("ORDER_REBATE", "订单返利"),

                                                    /**
                                                     * 用户提现
                                                     */
                                                    WITHDRAW("WITHDRAW", "用户提现"),
                                                    /**
                                                     * REFUND
                                                     */

                                                    REFUND("REFUND", "提现退款"),

                                                    /**
                                                     * 分享商品订单
                                                     */
                                                    SHARE_ORDER("SHARE_ORDER", "分享商品订单"),

                                                    /**
                                                     * 粉丝订单
                                                     */
                                                    FANS_ORDER("FANS_ORDER", "粉丝订单"),

                                                    /**
                                                     * 订单翻倍
                                                     */
                                                    ORDER_DOUBLE("ORDER_DOUBLE", "订单翻倍"),
                                                    /**
                                                     * 订单商品加倍
                                                     */
                                                    ORDER_PRODUCT_DOUBLE("ORDER_PRODUCT_DOUBLE",
                                                                         "订单商品加倍"),

                                                    /**
                                                     * 签到零钱-翻牌
                                                     */
                                                    SIGN_USER_FLOP("SIGN_USER_FLOP", "签到零钱-翻牌"),

                                                    /**
                                                     * 订单签到奖励
                                                     */
                                                    ORDER_SIGN_REWARD("ORDER_SIGN_REWARD",
                                                                      "订单签到奖励"),

                                                    /**
                                                     * 商品免单返现奖励
                                                     */
                                                    ORDER_FREE_REWARD("ORDER_FREE_REWARD",
                                                                      "商品免单返现奖励"),

                                                    /**
                                                     * 渠道推广返利
                                                     */
                                                    CHANNEL_PROMOTION_REBATE("CHANNEL_PROMOTION_REBATE",
                                                                             "渠道推广返利"),;

    String code;
    String desc;

    UserAccountBizCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}