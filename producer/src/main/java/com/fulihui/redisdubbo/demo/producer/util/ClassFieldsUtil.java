package com.fulihui.redisdubbo.demo.producer.util;


import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by willa on 2015/10/14.
 */
public class ClassFieldsUtil {

    /**
     * map对象拼装类对象，对象由方法生成
     */
    public static <T> T map2Obj(Map<String, Object> map, Class<T> clz) {
        try {
            T obj = clz.newInstance();
            map2Obj(map, obj);
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * map对象拼装类对象，对象
     */
    public static <T> void map2Obj(Map<String, Object> map, T obj) {
        if (map == null || obj == null) {
            return;
        }
        List<Field> fields = loopFileds(obj.getClass());
        try {
            if (fields != null) {
                for (Field field : fields) {
                    Object value = map.get(field.getName());
                    if (value != null) {
                        field.set(obj, value);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转换map
     */
    public static Map<String, Object> obj2StrValMap(Object o) {
        List<Field> fields = loopFileds(o.getClass());
        Map<String, Object> map = new HashMap<>();
        try {
            for (Field field : fields) {
                Object val = field.get(o);
                if (val != null) {
                    map.put(field.getName(), val.toString());
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return map;
    }


    public static List<String> obj2StrVal(Object o) {
        List<Field> fields = loopFileds(o.getClass());
        List<String> list = new ArrayList<>();
        try {
            for (Field field : fields) {
                Object val = field.get(o);
                if (val != null) {
                    list.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return list;


    }


    public static List<String> obj2StrValue(Object o) {
        List<Field> fields = loopFileds(o.getClass());
        List<String> list = new ArrayList<>();
        try {
            for (Field field : fields) {
                Object val = field.get(o);
                if (val != null) {
                    list.add(val.toString());
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<Field> loopFileds(Class clz) {
        List<Field> fields = new LinkedList<>();
        recursiveLoopFileds(fields, clz);
        return fields;
    }

    private static void recursiveLoopFileds(List<Field> fields, Class clz) {
        Field[] fieldAry = clz.getDeclaredFields();
        AccessibleObject.setAccessible(fieldAry, true);
        for (Field field : fieldAry) {
            // 静态属性过滤
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            fields.add(field);
        }
        if (clz.getSuperclass() != null) {
            recursiveLoopFileds(fields, clz.getSuperclass());
        }
    }

}
