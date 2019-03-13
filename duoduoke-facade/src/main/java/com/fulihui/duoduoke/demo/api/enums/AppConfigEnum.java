package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/7/26 13:46
 */
@Getter
public enum AppConfigEnum implements BaseEnum {

    /**
     * 前端首页客服按钮
     */
    UI_CUSTOMER_HOME_PAGE("1", "前端首页客服按钮"),
    /**
     * 前端超级搜客服按钮
     */
    UI_CUSTOMER_SEARCH_PAGE("2", "前端超级搜客服按钮"),
    /**
     * 前端详情客服按钮
     */
    UI_CUSTOMER_DETAIL_PAGE("3", "前端详情客服按钮"),
    /**
     * 佣金比率
     */
    COMMISSION_PERCENTAGE("4", "佣金比率"),

    /**
     * 分享比率
     */
    SHARE_PERCENTAGE("5", "分享比例"),

    /**
     * 一级上级配置比例
     */
    ONE_PERCENTAGE("6", "一级上级配置比例"),

    /**
     * 二级上级配置比例
     */
    TWO_PERCENTAGE("7", "二级上级配置比例"),

    /**
     * 提现金额配置余额限制
     */
    AMOUNT_CHECK("8", "提现金额配置余额限制"),

    /**
     * 小编微信号配置
     */
    WECHAT_NO("9", "小编微信号配置1"),

    WECHAT_NO_TWO("10", "小编微信号配置2"),

    /**
     * 前端订单客服按钮
     */
    UI_CUSTOMER_ORDER_PAGE("11", "前端订单客服按钮"),
    /**
     * 翻牌活动总开关
     */
    FLOP_ACTIVITY_USING("12", "翻牌活动总开关"),
    /**
     * 分享得翻牌机会-配置
     */
    FLOP_WITH_SHARE("13", "分享得翻牌机会", 2),
    /**
     * 补签助力分享-配置
     */
    SIGN_WITH_SHARE("14", "补签助力分享", 2),
    /**
     * 签到规则文案配置
     */
    SIGN_DESCRIBE_CONFIG("15", "签到规则文案配置"),

    /**
     * 免单活动Banner设置
     */
    EXEMPTION_ACTIVITY_BANNER("16","免单活动Banner设置",2),
    /**
     * 免单分享设置
     */
    EXEMPTION_ACTIVITY_SHARE("17","免单分享设置",2),
    /**
     * 前端详情客服按钮
     */
    UI_EXEMPTION_PAGE("18", "免单客服按钮"),

    WITHDRAWAL_CONFIG("19", "提现引导配置"),

    /**
     * H5免单活动Banner设置
     */
    H5_EXEMPTION_ACTIVITY_BANNER("20","H5免单活动Banner设置",2),
    /**
     * H5免单分享设置
     */
    H5_EXEMPTION_ACTIVITY_SHARE("21","H5免单分享设置",2),
    H5_EXEMPTION_ACTIVITY_SHARE_SUBTITLE("22","H5免单分享副标题")
    ;

    String code;
    String desc;
    /**
     * 1:普通配置  2:图片文配置
     */
    Integer type;

    AppConfigEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
        this.type = 1;
    }

    AppConfigEnum(String code, String desc, Integer type) {
        this.code = code;
        this.desc = desc;
        this.type = type;
    }
}
