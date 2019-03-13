package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/14 0014 16:55
 */
@Getter
public enum ActivityStateEnum {

                               /**
                                * 有效
                                */
                               ON(1, "有效"),
                               /**
                                * 无效
                                */
                               OFF(2, "无效"),

    ;

    int    code;
    String desc;

    ActivityStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
