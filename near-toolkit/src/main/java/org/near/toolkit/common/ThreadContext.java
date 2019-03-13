package org.near.toolkit.common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程级上下文对象，同一线程的共享对象
 *
 * @author Willard.Hu on 2016/11/15 0015.
 */
public class ThreadContext {
    /**
     * 单例支持，这个类使用单例模式用起来更合适，同一个线程使用一个上下文对象。
     */
    private volatile static ThreadContext instance;

    /**
     * 对象锁，用于单例模式创建对象时使用
     */
    private static Lock lock = new ReentrantLock();

    /**
     * 获取单例实例对象，对象只会被创建一次，默认使用 InheritableThreadLocal 线程对象。
     * <p>Spring 应用可以直接使用 Bean 来实现单例。</p>
     *
     * @return {@link ThreadContext}
     */
    public static ThreadContext getInstance() {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new ThreadContext();
            }
            lock.unlock();
        }
        return instance;
    }

    /**
     * 获取单例实例对象，使用指定的线程对象。
     * <p>Spring 应用可以直接使用 Bean 来实现单例。</p>
     *
     * @param threadCache {@link ThreadLocal}
     * @return {@link ThreadContext}
     */
    public static ThreadContext getInstance(ThreadLocal<ConcurrentMap<String, Object>> threadCache) {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new ThreadContext(threadCache);
            }
            lock.unlock();
        }
        return instance;
    }

    /**
     * 本地线程对象，在同一线程中，包装 ConcurrentMap 类型的数据
     */
    private ThreadLocal<ConcurrentMap<String, Object>> threadCache;

    public ThreadContext() {
        this(new InheritableThreadLocal<>());
    }

    public ThreadContext(ThreadLocal<ConcurrentMap<String, Object>> threadCache) {
        this.threadCache = threadCache;
        threadCache.set(new ConcurrentHashMap<>());
    }

    /**
     * 添加属性，如果已有则覆盖，并且返回旧值
     */
    public Object setAttribute(String key, Object value) {
        return threadCache.get().put(key, value);
    }

    /**
     * 获取属性的值
     */
    public Object getAttribute(String key) {
        return threadCache.get().get(key);
    }

    /**
     * 判断属性是否存在
     */
    public boolean hasAttribute(String key) {
        return getAttribute(key) != null;
    }

    /**
     * 移除属性，并且返回被移除的值
     */
    public Object removeAttribute(String key) {
        return threadCache.get().remove(key);
    }

    /**
     * 清除线程缓存
     */
    public void clear() {
        threadCache.remove();
    }
}
