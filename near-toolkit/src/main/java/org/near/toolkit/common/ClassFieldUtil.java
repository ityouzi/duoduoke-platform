package org.near.toolkit.common;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 类属性工具
 * Created by Willard.Hu on 2016/3/5.
 */
public class ClassFieldUtil {


    /**
     * 获取类属性集合，嗲用端可以再使用 AccessibleObject.setAccessible(fields[], true) 将属性可直接通过对象访问值<br/>
     * 默认 superLimit=Object.class, ignoreStatic = true
     *
     * @param clz 要获取属性的类
     * @return 获取到的属性集合
     */
    public static List<Field> getClassFields(Class<?> clz) {
        return getClassFields(clz, Object.class, true);
    }

    /**
     * 获取类属性集合，嗲用端可以再使用 AccessibleObject.setAccessible(fields[], true) 将属性可直接通过对象访问值<br/>
     * 默认 ignoreStatic = true
     *
     * @param clz        要获取属性的类
     * @param superLimit 父类限制
     * @return 获取到的属性集合
     */
    public static List<Field> getClassFields(Class<?> clz, Class<?> superLimit) {
        return getClassFields(clz, superLimit, true);
    }

    /**
     * 获取类属性集合，嗲用端可以再使用 AccessibleObject.setAccessible(fields[], true) 将属性可直接通过对象访问值
     *
     * @param clz          要获取属性的类
     * @param superLimit   父类限制
     * @param ignoreStatic 是否过滤静态属性
     * @return 获取到的属性集合
     */
    public static List<Field> getClassFields(Class<?> clz, Class<?> superLimit, boolean ignoreStatic) {
        if (clz == superLimit) {
            return Collections.emptyList();
        }
        List<Field> fields = new LinkedList<>();
        for (; ; ) {
            appendFields(clz, fields, ignoreStatic);
            clz = clz.getSuperclass();
            if (clz == superLimit) {
                break;
            }
        }
        return fields;
    }

    private static void appendFields(Class<?> clz, List<Field> fieldList, boolean ignoreStatic) {
        Field[] fields = clz.getDeclaredFields();
        for (Field f : fields) {
            // 需要过滤静态属性，则过滤
            if (ignoreStatic && Modifier.isStatic(f.getModifiers())) {
                continue;
            }
            fieldList.add(f);
        }
    }

}
