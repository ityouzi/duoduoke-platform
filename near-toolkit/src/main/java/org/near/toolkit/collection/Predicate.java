/*
 * Copyright 2014 www.wecheer-tech.com
 */
package org.near.toolkit.collection;

/**
 * 策略筛选器
 */
public interface Predicate<T> {

    /**
     * Use the specified parameter to perform a test that returns true or false.
     *
     * @param t the object to evaluate, should not be changed
     * @return true or false
     * @throws IllegalArgumentException (runtime) if the input is invalid
     */
    boolean evaluate(T t);

}
