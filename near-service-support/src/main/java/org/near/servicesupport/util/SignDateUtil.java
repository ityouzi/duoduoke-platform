package org.near.servicesupport.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.List;
import java.util.TreeMap;

import org.near.servicesupport.request.BaseRequest;
import org.near.toolkit.common.ClassFieldUtil;

/**
 *
 * Created by Willard.Hu on 2016/5/5.
 */
public class SignDateUtil {

    public static TreeMap<String, String> genDefaultSignData(Object instance, Class<?> clz) {
        List<Field> fieldList = ClassFieldUtil.getClassFields(clz, BaseRequest.class);
        TreeMap<String, String> map = new TreeMap<>();
        if (fieldList == null || fieldList.isEmpty()) {
            return map;
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        AccessibleObject.setAccessible(fields, true);

        for (Field f : fields) {
            try {
                Object o = f.get(instance);
                if (o != null) {
                    map.put(f.getName(), o.toString());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return map;
    }
}
