package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/8/16 13:50
 */
@Getter
public enum  TemplateSendTaskBehaviorsEnum implements BaseEnum {

    /**
     * 当日访问
     */
    VISIT_TODAY("1", "当日访问"),

    /**
     * 当日新用户
     */
    NEW_TOADY("2", "当日新用户");


    String code;
    String desc;

    TemplateSendTaskBehaviorsEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
