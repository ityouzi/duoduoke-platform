package com.fulihui.duoduoke.demo.producer.lock;

/**
 * @author lizhi
 */
public interface DistributedLock {

    /**
     * The constant TIMEOUT_SECOND.
     */
    public static final long TIMEOUT_SECOND = 30;

    /**
     * Lock boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean lock(String key);

    /**
     * Lock boolean.
     *
     * @param key    the key
     * @param expire the expire
     * @return the boolean
     */
    boolean lock(String key, long expire);

    /**
     * Release lock boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean releaseLock(String key);
}
