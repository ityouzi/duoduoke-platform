/*
 * Copyright 2014 www.wecheer-tech.com
 */
package org.near.toolkit.collection;

/**
 * 元素转化
 */
public interface Transformer<T, S> {

    /**
     * Transforms the input object (leaving it unchanged) into some output object.
     * @param input  the object to be transformed, should be left unchanged
     * @return a transformed object
     */
    S transform(T input);

}
