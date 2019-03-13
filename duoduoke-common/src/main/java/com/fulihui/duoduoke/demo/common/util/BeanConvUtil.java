package com.fulihui.duoduoke.demo.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean工具类
 *
 * @auther: Levon
 * @version: V 0.1 2017-12-12 14:43
 */
public class BeanConvUtil {


    /**
     * Bean复制工具,bean的字段名相同会被复制，其它会被忽略
     *
     * @param source 源
     * @param clazz  要转换的类型
     * @return
     */
    public static <T, S> T copy(S source, Class<T> clazz) {
        try {
            T target = clazz.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Bean复制工具,bean的字段名相同会被复制，其它会被忽略
     *
     * @param source           源
     * @param clazz            要转换的类型
     * @param ignoreProperties 要忽略的字段
     * @return
     */
    public static <T, S> T copy(S source, Class<T> clazz, String... ignoreProperties) {
        try {
            T target = clazz.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Bean List复制工具,List中bean的字段名相同会被复制，其它会被忽略
     *
     * @param sourceList 源
     * @param clazz      要转换的类型
     * @return
     */
    public static <T, S> List<T> copy(List<S> sourceList, Class<T> clazz) {
        List<T> targetList = new ArrayList<>();
        for (Object source : sourceList) {
            targetList.add(copy(source, clazz));
        }
        return targetList;
    }

    /**
     * Bean List复制工具,List中bean的字段名相同会被复制，其它会被忽略
     *
     * @param sourceList       源
     * @param clazz            要转换的类型
     * @param ignoreProperties 要忽略的字段
     * @return
     */
    public static <T, S> List<T> copy(List<S> sourceList, Class<T> clazz, String... ignoreProperties) {
        List<T> targetList = new ArrayList<>();
        for (Object source : sourceList) {
            targetList.add(copy(source, clazz, ignoreProperties));
        }
        return targetList;
    }

}
