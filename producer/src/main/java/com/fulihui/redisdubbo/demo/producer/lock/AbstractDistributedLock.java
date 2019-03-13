package com.fulihui.redisdubbo.demo.producer.lock;

/**
 * @author lizhi
 */
public class AbstractDistributedLock implements DistributedLock {

    @Override
    public boolean lock(String key) {
        return lock(key, TIMEOUT_SECOND);
    }

    @Override
    public boolean lock(String key, long expire) {
        return false;
    }

    @Override
    public boolean releaseLock(String key) {
        return false;
    }

}
