package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/10/16 15:52
 */
@Getter
public enum ActivityTypeEnum implements BaseEnum {

    /**
     * 签到活动
     */
    Sign("1", "签到活动"),
    /**
     * 翻牌活动
     */
    Flop("2", "翻牌活动"),
    /**
     * 免单活动
     */
    Exemption("3", "免单活动"),
    /**
     * H5免单活动
     */
    H5Exemption("4", "H5免单活动");

    String code;
    String desc;

    ActivityTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
