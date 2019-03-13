package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:01
 */
@Getter
public enum RedPackageConfigStatusEnum implements BaseEnum {

    /**
     * 开启
     */
    ON("on", "开启"),
    /**
     * 关闭
     */
    OFF("off", "关闭"),
    ;

    String code;
    String desc;

    RedPackageConfigStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
