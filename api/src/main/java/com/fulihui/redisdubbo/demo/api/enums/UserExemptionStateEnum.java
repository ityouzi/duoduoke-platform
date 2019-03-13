package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/15 0015 10:01
 */
@Getter
public enum UserExemptionStateEnum implements BaseEnum {
                                                        /**
                                                         * 未使用
                                                         */

                                                        NOUSED("1", "未使用"),

                                                        /**
                                                         * 使用
                                                         */
                                                        USED("2", "使用"),

                                                        /**
                                                         * 过期失效
                                                         */
                                                        INVALID("3", "过期失效"),

                                                        /**
                                                         * 已结算
                                                         */
                                                        SETTLE("4", "已结算"),

    ;

    String code;
    String desc;

    UserExemptionStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
