package com.fulihui.redisdubbo.demo.api.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author lizhi
 * @date 2018-7-11
 */
public class Collections {

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static <T> List<T> emptyList() {
        return java.util.Collections.emptyList();
    }

    public static <K, V> Map<K, V> emptyMap() {
        return java.util.Collections.emptyMap();
    }

    public static <T> List<T> asList(T... elems) {
        return Arrays.asList(elems);
    }

    public static <T> List<T> singletonList(T elem) {
        return java.util.Collections.singletonList(elem);
    }

    public static <T> Set<T> singleton(T elem) {
        return java.util.Collections.singleton(elem);
    }

    public static <T, R> List<R> transform(Collection<T> src, Function<? super T, ? extends R> mapper) {
        if (isEmpty(src)) {
            return emptyList();
        }
        return src.stream().map(mapper).collect(Collectors.toList());
    }


}
