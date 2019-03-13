package com.fulihui.duoduoke.demo.api.api;

/**
 *
 * @author lizhi
 * @date 2018-9-11
 */
public interface DistributedLockService {

    boolean lock(String key, long expire);

    boolean releaseLock(String key);
}
