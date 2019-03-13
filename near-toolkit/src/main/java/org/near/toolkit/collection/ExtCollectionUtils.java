/*
 * Copyright 2014 www.wecheer-tech.com
 */
package org.near.toolkit.collection;

import org.near.toolkit.common.StringUtil;

import java.util.*;

/**
 * 扩展集合工具类，主要包含闭包，过滤器等可以减少代码复杂度的工具
 */
public class ExtCollectionUtils {

    /** 
     * Filter the collection by applying a Predicate to each element. If the
     * predicate returns false, remove the element.
     * <p>
     * If the input collection or predicate is null, there is no change made.
     * 
     * @param collection  the collection to get the input from, may be null
     * @param predicate  the predicate to use as a filter, may be null
     */
    public static <T> void filter(Collection<T> collection, Predicate<T> predicate) {
        if (collection != null && predicate != null) {
            for (Iterator<T> it = collection.iterator(); it.hasNext();) {
                if (!predicate.evaluate(it.next())) {
                    it.remove();
                }
            }
        }
    }

    /** 
     * Filter the collection by applying a Predicate to each element. If the
     * predicate returns false, remove the element.
     * <p>
     * If the input collection or predicate is null, there is no change made.
     * 
     * @param collection  the collection to get the input from, may be null
     * @param predicate  the predicate to use as a filter, may be null
     */
    public static <T> Collection<T> collect(Collection<T> collection, Predicate<T> predicate) {
        if (collection != null && predicate != null) {
            Collection<T> collection2 = new ArrayList<T>();
            T next = null;
            for (Iterator<T> it = collection.iterator(); it.hasNext();) {
                next = it.next();
                if (predicate.evaluate(next)) {
                    collection2.add(next);
                }
            }

            return collection2;
        }
        return Collections.emptyList();
    }

    /** 
     * Finds the first element in the given collection which matches the given predicate.
     * <p>
     * If the input collection or predicate is null, or no element of the collection 
     * matches the predicate, null is returned.
     *
     * @param collection  the collection to search, may be null
     * @param predicate  the predicate to use, may be null
     * @return the first element of the collection which matches the predicate or null if none could be found
     */
    public static <T> T find(Collection<T> collection, Predicate<T> predicate) {
        if (!isEmpty(collection) && predicate != null) {
            T item = null;
            for (Iterator<T> iter = collection.iterator(); iter.hasNext();) {
                item = iter.next();
                if (predicate.evaluate(item)) {
                    return item;
                }
            }
        }
        return null;
    }

    /** 
     * Finds the first element in the given collection which matches the given predicate.
     * <p>
     * If the input collection or predicate is null, or no element of the collection 
     * matches the predicate, null is returned.
     *
     * @param inputIterator  the collection to search, may be null
     * @param predicate  the predicate to use, may be null
     * @return the first element of the collection which matches the predicate or null if none could be found
     */
    public static <T> T find(Iterator<T> inputIterator, Predicate<T> predicate) {
        if (inputIterator != null && predicate != null) {
            T item = null;
            while (inputIterator.hasNext()) {
                item = inputIterator.next();
                if (predicate.evaluate(item)) {
                    return item;
                }
            }
        }
        return null;
    }

    /** 
     * Returns a new Collection consisting of the elements of inputCollection transformed
     * by the given transformer.
     * <p>
     * If the input transformer is null, the result is an empty list.
     * 
     * @param inputCollection  the collection to get the input from, may not be null
     * @param transformer  the transformer to use, may be null
     * @return the transformed result (new list)
     * @throws NullPointerException if the input collection is null
     */
    public static <T, S> Collection<S> collect(Collection<T> inputCollection,
                                               Transformer<T, S> transformer) {
        if (inputCollection == null) {
            return null;
        }
        List<S> answer = new ArrayList<S>(inputCollection.size());
        collect(inputCollection, transformer, answer);
        return answer;
    }

    /**
     * 
     * 
     * @param inputCollection
     * @param transformer
     * @param predicate
     * @return
     */
    public static <T, S> Collection<S> collect(Collection<T> inputCollection,
                                               Transformer<T, S> transformer, Predicate<T> predicate) {
        if (inputCollection == null) {
            return null;
        }
        List<S> answer = new ArrayList<S>(inputCollection.size());
        collect(inputCollection, transformer, predicate, answer);
        return answer;
    }

    /** 
     * Transforms all elements from the inputIterator with the given transformer 
     * and adds them to the outputCollection.
     * <p>
     * If the input iterator or transformer is null, the result is an empty list.
     * 
     * @param inputIterator  the iterator to get the input from, may be null
     * @param transformer  the transformer to use, may be null
     * @return the transformed result (new list)
     */
    public static <T, S> Collection<S> collect(Iterator<T> inputIterator,
                                               Transformer<T, S> transformer) {
        List<S> answer = new ArrayList<S>();
        collect(inputIterator, transformer, answer);
        return answer;
    }

    /**
     * 
     * 
     * @param inputIterator
     * @param transformer
     * @param predicate
     * @return
     */
    public static <T, S> Collection<S> collect(Iterator<T> inputIterator,
                                               Transformer<T, S> transformer, Predicate<T> predicate) {
        List<S> answer = new ArrayList<S>();
        collect(inputIterator, transformer, predicate, answer);
        return answer;
    }

    /** 
     * Transforms all elements from inputCollection with the given transformer 
     * and adds them to the outputCollection.
     * <p>
     * If the input collection or transformer is null, there is no change to the 
     * output collection.
     *
     * @param inputCollection  the collection to get the input from, may be null
     * @param transformer  the transformer to use, may be null
     * @param outputCollection  the collection to output into, may not be null
     * @return the outputCollection with the transformed input added
     * @throws NullPointerException if the output collection is null
     */
    public static <T, S> Collection<S> collect(Collection<T> inputCollection,
                                               final Transformer<T, S> transformer,
                                               final Collection<S> outputCollection) {
        if (inputCollection != null) {
            return collect(inputCollection.iterator(), transformer, outputCollection);
        }
        return outputCollection;
    }

    /**
     * 
     * 
     * @param inputCollection
     * @param transformer
     * @param predicate
     * @param outputCollection
     * @return
     */
    public static <T, S> Collection<S> collect(Collection<T> inputCollection,
                                               final Transformer<T, S> transformer,
                                               final Predicate<T> predicate,
                                               final Collection<S> outputCollection) {
        if (inputCollection != null) {
            return collect(inputCollection.iterator(), transformer, predicate, outputCollection);
        }
        return outputCollection;
    }

    /** 
     * Transforms all elements from the inputIterator with the given transformer 
     * and adds them to the outputCollection.
     * <p>
     * If the input iterator or transformer is null, there is no change to the 
     * output collection.
     *
     * @param inputIterator  the iterator to get the input from, may be null
     * @param transformer  the transformer to use, may be null
     * @param outputCollection  the collection to output into, may not be null
     * @return the outputCollection with the transformed input added
     * @throws NullPointerException if the output collection is null
     */
    public static <T, S> Collection<S> collect(Iterator<T> inputIterator,
                                               final Transformer<T, S> transformer,
                                               final Collection<S> outputCollection) {
        if (inputIterator != null && transformer != null) {
            T item = null;
            while (inputIterator.hasNext()) {
                item = inputIterator.next();
                S value = transformer.transform(item);
                if (value != null) {
                    outputCollection.add(value);
                }
            }
        }
        return outputCollection;
    }

    /**
     * 
     * 
     * @param inputIterator
     * @param transformer
     * @param predicate
     * @param outputCollection
     * @return
     */
    public static <T, S> Collection<S> collect(Iterator<T> inputIterator,
                                               final Transformer<T, S> transformer,
                                               final Predicate<T> predicate,
                                               final Collection<S> outputCollection) {
        if (inputIterator != null && transformer != null && predicate != null) {
            T item = null;
            while (inputIterator.hasNext()) {
                item = inputIterator.next();
                if (predicate.evaluate(item)) {
                    S value = transformer.transform(item);
                    if (value != null) {
                        outputCollection.add(value);
                    }
                }
            }
        }
        return outputCollection;
    }

    /** 
     * Executes the given closure on each element in the collection.
     * <p>
     * If the input collection or closure is null, there is no change made.
     * 
     *  <tt>final Map<String, String> map = new HashMap<String, String>();
     *  MCollectionUtils.forAllDo(goodsOrder.getBuyClauseInfos(), new Closure<ClauseInfo>() {
     *  
     *      @Override
     *      public void execute(ClauseInfo input) {
     *          map.put(input.getName(), input.getInputValue());
     *      }
     *  });
     *  goodsOrderDetail.setExtensions(map);
     *  </tt>
     * 
     * @param collection  the collection to get the input from, may be null
     * @param closure  the closure to perform, may be null
     */
    public static <T> void forAllDo(Collection<T> collection, Closure<T> closure) {
        if (!isEmpty(collection) && closure != null) {
            for (Iterator<T> it = collection.iterator(); it.hasNext();) {
                closure.execute(it.next());
            }
        }
    }

    /**
     * 将target中的非空内容合并到SRC中
     * 
     * @param src 源MAP
     * @param target 目标MAP
     * @return
     */
    public static <K, V> Map<K, V> mergeMap(Map<K, V> src, Map<K, V> target) {
        if (src == null) {
            return target;
        }

        Iterator<K> it = target.keySet().iterator();
        K key;
        V value;
        while (it.hasNext()) {
            key = it.next();
            value = target.get(key);
            if (value == null || "".equals(value)) {
                continue;
            }
            src.put(key, value);
        }
        return src;
    }

    /**
     * list-> string
     * 
     * @param input
     * @return
     */
    public static String toString(Collection<?> input) {
        if (isEmpty(input)) {
            return StringUtil.EMPTY_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object value : input) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }

    /**
     * 判断集合是否是空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

}
