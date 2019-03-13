package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/8/16 14:36
 */
@Getter
public enum TemplateSendTaskTimeEnum implements BaseEnum {

    /**
     * 当日n小时后
     */
    TOADY("1", "当日访问后",0),

    /**
     * 明天固定几点
     */
    TOMORROW("2", "次日",1),

    /**
     * 第二天固定几点
     */
    TWO_AFTER("3","第二天",2),

    /**
     * 第三天固定几点
     */
    THREE_AFTER("4","第三天",3);

    String code;
    String desc;
    Integer afterDay;

    TemplateSendTaskTimeEnum(String code, String desc,Integer afterDay) {
        this.code = code;
        this.desc = desc;
        this.afterDay = afterDay;
    }
}
