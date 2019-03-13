package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/7/31 14:24
 */
@Getter
public enum DuoDuoOrderTypeEnum implements BaseEnum {

    /**
     * 已处罚,无效
     */
    Single("0", "单品推广"),
    /**
     * 红包活动推广
     */
    RedPackage("1","红包活动推广"),
    /**
     * 领券页底部推荐
     */
    CouponBottom("2","领券页底部推荐")
    ;

    String code;
    String desc;

    DuoDuoOrderTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
