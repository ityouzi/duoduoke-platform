package org.near.toolkit.common;

import org.near.toolkit.model.BaseEnum;

/**
 *
 * Created by Willard.Hu on 2015/8/3.
 */
public enum TestEnum implements BaseEnum {
    A("A", "code is 'A'"),

    B("A", "code is 'A'"), ;

    private String code;

    private String desc;

    TestEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
