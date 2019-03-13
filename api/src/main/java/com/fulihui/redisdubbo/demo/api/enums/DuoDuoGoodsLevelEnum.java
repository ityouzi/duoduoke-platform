package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/19 0019 15:37
 */
@Getter
public enum DuoDuoGoodsLevelEnum {
    /**
     * 一级目录
     */

    ONE(1, "一级目录"),
    /**
     * 二级目录
     */
    TWO(2, "二级目录");

    int code;
    String desc;

    DuoDuoGoodsLevelEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
