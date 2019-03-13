package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 *
 * @author lizhi
 * @date 2018-12-06
 */
@Getter
public enum TelevisionTypeEnum implements BaseEnum {
                                                    /**
                                                     * 生成红包推广链接
                                                     */
                                                    RED_ENVELOPE("RED_ENVELOPE", "生成红包推广链接",
                                                                 "pdd.ddk.rp.prom.url.generate"),

                                                    /**
                                                     * 转盘抽免单
                                                     */
                                                    TURNTABLE("TURNTABLE", "转盘抽免单链接",
                                                              "pdd.ddk.lottery.url.gen"),

                                                    /**
                                                     * 商城栏目
                                                     */
                                                    MALL("MALL", "商城栏目链接",
                                                         "pdd.ddk.cms.prom.url.generate"),

                                                    /**
                                                     * 主题链接
                                                     */
                                                    TOPIC_LINK("TOPIC_LINK", "主题链接",
                                                               "pdd.ddk.theme.prom.url.generate"),

    ;

    String code;
    String desc;

    String api;

    TelevisionTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    TelevisionTypeEnum(String code, String desc, String api) {
        this.code = code;
        this.desc = desc;
        this.api = api;

    }
}
