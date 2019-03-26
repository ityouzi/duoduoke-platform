package com.fulihui.duoduoke.demo.api.enums;

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
    SIGN("1", "签到活动"),
    /**
     * 翻牌活动
     */
    FLOP("2", "翻牌活动"),
    /**
     * 免单活动
     */
    EXEMPTION("3", "免单活动"),
    /**
     * H5免单活动
     */
    H5EXEMPTION("4", "H5免单活动");

    String code;
    String desc;

    ActivityTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
