package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 *
 * @author lizhi
 * @date 2018-11-30
 */
@Getter
public enum OrderPromotionSourceEnum implements BaseEnum {

                                                          /**
                                                           * 小程序推广
                                                           */
                                                          MINI_APP("MINI_APP", "小程序推广"),
                                                          /**
                                                           * H5推广
                                                           */
                                                          H5("H5", "H5推广"),;

    String code;
    String desc;

    OrderPromotionSourceEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
