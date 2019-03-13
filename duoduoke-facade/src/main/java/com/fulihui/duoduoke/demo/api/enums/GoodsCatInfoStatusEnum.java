package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/7/13 18:02
 */
@Getter
public enum GoodsCatInfoStatusEnum implements BaseEnum {

    /**
     * 是
     */
    IS("1", "是"),

    /**
     * 否
     */
    NO("0", "否");

    String code;
    String desc;

    GoodsCatInfoStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}