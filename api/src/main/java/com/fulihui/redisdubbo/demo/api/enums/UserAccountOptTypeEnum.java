package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 *
 * @author lizhi
 * @date 2018-7-12
 */
@Getter
public enum UserAccountOptTypeEnum implements BaseEnum {
    /**
     * 收入
     */
    INCOME("0", "收入"),
    /**
     * 支出
     */
    OUTLAY("1", "支出"),;

    String code;
    String desc;

    UserAccountOptTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}