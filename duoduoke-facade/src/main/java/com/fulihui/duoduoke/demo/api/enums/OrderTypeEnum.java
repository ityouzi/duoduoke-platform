package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 */

@Getter
public enum OrderTypeEnum implements BaseEnum {

                                               /**
                                                * 常规
                                                */
                                               C("0", "常规"),
                                               /**
                                                * 翻倍订单
                                                */
                                               T("1", "翻倍订单"),
                                               /**
                                                * 加倍订单
                                                */
                                               D("2", "加倍订单"),

                                               /**
                                                * 免单返现
                                                */
                                               Y("3", "免单返现");

    String code;
    String desc;

    OrderTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
