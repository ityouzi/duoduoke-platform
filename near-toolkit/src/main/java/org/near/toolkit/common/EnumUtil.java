package org.near.toolkit.common;

import org.near.toolkit.model.BaseEnum;

/**
 * 枚举工具类
 * Created by Willard.Hu on 2015/8/3.
 */
public class EnumUtil {

    /**
     * 通过枚举code查询枚举类
     */
    public static <T extends BaseEnum> T queryByCode(String code, Class<T> enumClz) {
        if (enumClz == null || !enumClz.isEnum() || StringUtil.isBlank(code)) {
            return null;
        }
        for (T t : enumClz.getEnumConstants()) {
            if (StringUtil.equals(t.getCode(), code)) {
                return t;
            }
        }
        return null;
    }

    /**
     * 判断code是否在指定枚举值中
     */
    public static <T extends BaseEnum> boolean inEnum(String code, Class<T> enumClz) {
        if (enumClz == null || !enumClz.isEnum() || StringUtil.isBlank(code)) {
            return false;
        }
        for (T t : enumClz.getEnumConstants()) {
            if (StringUtil.equals(t.getCode(), code)) {
                return true;
            }
        }
        return false;

    }

}
