package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 * @date 2018-12-06
 */
@Getter
public enum UserAccountType implements BaseEnum {
                                                 /**
                                                  * 收入
                                                  */
                                                 MINI_USER("MINI_USER", "小程序授权用户"),
                                                 /**
                                                  * 推广商户
                                                  */
                                                 PROMOTION_MERCHANT("PROMOTION_MERCHANT", "推广商户"),

                                                 /**
                                                  * 微信公众号h5授权用户
                                                  */
                                                 WX_PN_USER("WX_PN_USER", "微信公众号h5授权用户"),;

    String code;
    String desc;

    UserAccountType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}