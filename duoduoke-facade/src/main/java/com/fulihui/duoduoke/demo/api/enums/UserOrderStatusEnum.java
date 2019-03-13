package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Getter
public enum UserOrderStatusEnum implements BaseEnum {
                                                     /**
                                                      * 待确认
                                                      */
                                                     TO_BE_CONFIRMED("1", "待确认", "确认收货后%s天到账"),

                                                     /**
                                                      * 待结算
                                                      */
                                                     TO_BE_SETTLEMENT("2", "待结算", "预计%s结算"),

                                                     /**
                                                      * 已到账
                                                      */
                                                     ALREADY_TO_ACCOUNT("3", "已到账", "%s 已到账"),

                                                     /**
                                                      * 无效
                                                      */
                                                     INVALID("4", "无效", "订单交易失败，无法获得佣金"),

                                                     /**
                                                      * 不处理
                                                      */
                                                     DO_NOTHING("5", "终态不处理", ""),

    ;

    String code;
    String desc;
    String orderDesc;

    UserOrderStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    UserOrderStatusEnum(String code, String desc, String orderDesc) {
        this.code = code;
        this.desc = desc;
        this.orderDesc = orderDesc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public String getOrderDesc() {
        return orderDesc;
    }
}
