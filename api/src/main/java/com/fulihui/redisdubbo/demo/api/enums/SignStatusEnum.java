package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 *
 * @author lizhi
 * @date 2018-10-12
 */

@Getter
public enum SignStatusEnum implements BaseEnum {

                                                /**
                                                 * 已签到
                                                 */
                                                Y("1", "已签到"),
                                                /**
                                                 * 未签到
                                                 */
                                                N("0", "未签到"),

                                                /**
                                                 * 已补签
                                                 */
                                                S("3", "已补签"),

    ;

    String code;
    String desc;

    SignStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}