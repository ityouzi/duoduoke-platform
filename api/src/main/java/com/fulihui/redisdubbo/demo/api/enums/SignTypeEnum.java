package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 *
 * @author lizhi
 * @date 2018-10-11
 */
@Getter
public enum SignTypeEnum implements BaseEnum {
                                              /**
                                               * 自签
                                               */
                                              SELF("SELF", "自签"),

                                              /**
                                               * 补签
                                               */
                                              SUPPLEMENT("SUPPLEMENT", "补签");

    String code;
    String desc;

    SignTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
