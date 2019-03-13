package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 * @date 2018-7-10
 */
@Getter
public enum DuoDuoOrderStatusEnum implements BaseEnum {

//    订单状态：
// -1 未支付;
// 0-已支付；
// 1-已成团；
// 2-确认收货；
// 3-审核成功；
// 4-审核失败（不可提现）；
// 5-已经结算；
// 8-非多多进宝商品（无佣金订单）;
// 10-已处罚

    /**
     * 未支付 ,待确认
     */
    N_PAY("-1", "未支付", UserOrderStatusEnum.TO_BE_CONFIRMED.getCode()),

    /**
     * 已支付 ,待确认
     */
    Y_PAY("0", "已支付", UserOrderStatusEnum.TO_BE_CONFIRMED.getCode()),

    /**
     * 已成团,待确认
     */
    Y_GROUP("1", "已成团", UserOrderStatusEnum.TO_BE_CONFIRMED.getCode()),
    /**
     * 确认收货 ,待结算
     */

    C_RECEIPT("2", "确认收货", UserOrderStatusEnum.TO_BE_SETTLEMENT.getCode()),

    /**
     * 审核成功 ,已到账
     */
    AUDIT_SUCCESS("3", "审核成功", UserOrderStatusEnum.ALREADY_TO_ACCOUNT.getCode()),

    /**
     * 审核失败（不可提现） ,无效
     */
    AUDIT_FAILURE("4", "审核失败（不可提现）", UserOrderStatusEnum.INVALID.getCode()),

    /**
     * 已经结算 ,不更改用户状态
     */

    A_SETTLED("5", "已经结算",UserOrderStatusEnum.DO_NOTHING.getCode()),

    /**
     * 非多多进宝商品（无佣金订单） ,无效
     */
    NOT_MUCH("8", "非多多进宝商品（无佣金订单）", UserOrderStatusEnum.INVALID.getCode()),

    /**
     * 已处罚,无效
     */
    PUNISHED("10", "已处罚", UserOrderStatusEnum.INVALID.getCode()),;

    String code;
    String desc;
    String userOrderStatus;

    DuoDuoOrderStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    DuoDuoOrderStatusEnum(String code, String desc, String userOrderStatus) {
        this.code = code;
        this.desc = desc;
        this.userOrderStatus = userOrderStatus;
    }


}
