package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:01
 */
@Getter
public enum RewardHelpStateEnum implements BaseEnum {

    /**
     * 进行中
     */
    ONGOING("ONGOING", "进行中"),
    /**
     * 已过期
     */
    EXPIRED("EXPIRED", "已过期"),
    /**
     * 已完成
     */
    SUCCEED("SUCCEED", "已完成"),
    ;

    String code;
    String desc;

    RewardHelpStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
