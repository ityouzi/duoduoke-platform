package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/8/15 14:21
 */
@Getter
public enum TemplateSendTaskStateEnum implements BaseEnum {

    /**
     * 启用
     */
    ENABLE("1", "启用"),

    /**
     * 已发送
     */
    HAS_SEND("2", "已发送"),

    /**
     * 停用使用
     */
    DISABLE("3","停用");


    String code;
    String desc;

    TemplateSendTaskStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
