package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author wahaha
 */
@Getter
public enum OrderPromoTypeEnum implements BaseEnum {

                                                    /**
                                                     * 染色
                                                     */
                                                    DYEING("dyeing", "染色"),

                                                    /**
                                                     * 普通
                                                     */
                                                    ORDINARY("ordinary", "普通");

    String code;
    String desc;

    OrderPromoTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}