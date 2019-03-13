package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:01
 */
@Getter
public enum AdvertStateEnum implements BaseEnum {

    /**
     * 开启
     */
    OPEN("0", "开启"),
    /**
     * 关闭
     */
    STOP("1", "关闭"),
    ;

    String code;
    String desc;

    AdvertStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
