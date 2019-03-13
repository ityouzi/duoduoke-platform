/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 */

@Getter
public enum WechatTokenTypeEnum implements BaseEnum {

                                                     /**
                                                      * 小程序接口票据
                                                      */
                                                     ACCESS_TOKEN("ACCESS_TOKEN", "小程序接口票据"),

                                                     /**
                                                      * 微信公众号JS-SDK票据
                                                      */
                                                     WX_PN_JSAPI_TICKET("WX_PN_JSAPI_TICKET",
                                                                        "JS-SDK票据"),

                                                     /**
                                                      * 微信公众号ACCESS_TOKEN 票据
                                                      */
                                                     WX_PN_ACCESS_TOKEN("WX_PN_ACCESS_TOKEN",
                                                                        "微信公众号ACCESS_TOKEN票据"),

                                                     /**
                                                      * 多多客授权ACCESS_TOKEN 票据
                                                      */
                                                     DUO_ACCESS_TOKEN("DUO_ACCESS_TOKEN",
                                                                      "多多客授权ACCESS_TOKEN票据"),

                                                     /**
                                                      * 多多客授权刷新 DUO_REFRESH_ACCESS_TOKEN 票据
                                                      */
                                                     DUO_REFRESH_ACCESS_TOKEN("DUO_REFRESH_ACCESS_TOKEN",
                                                                              "多多客授权刷新 DUO_REFRESH_ACCESS_TOKEN 票据"),

    ;

    String code;
    String desc;

    WechatTokenTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
