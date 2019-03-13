package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 *
 * @author lizhi
 * @date 2018-10-17
 */
@Getter
public enum SignPrizeStatusEnum implements BaseEnum {

                                                     /**
                                                      * 未使用
                                                      */
                                                     UNUSED("0", "未使用", " gmt_create desc"),
                                                     /**
                                                      * 已绑定
                                                      */
                                                     BIND("1", "已绑定", " gmt_modified desc"),

                                                     /**
                                                      * 奖金已发放
                                                      */
                                                     ISSUED("2", "奖金已发放", "  gmt_modified desc"),
                                                     /**
                                                      * 已过期
                                                      */
                                                     EXPIRED("3", "已过期", "   gmt_modified desc "),

    ;

    String         code;
    String         desc;
    private String sortInfo;

    SignPrizeStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    SignPrizeStatusEnum(String code, String desc, String sortInfo) {
        this.code = code;
        this.desc = desc;
        this.sortInfo = sortInfo;
    }

}