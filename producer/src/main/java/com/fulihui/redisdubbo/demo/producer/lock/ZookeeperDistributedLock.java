package com.fulihui.redisdubbo.demo.producer.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author lizhi
 */
public class ZookeeperDistributedLock extends AbstractDistributedLock {

    private final Logger logger = LoggerFactory
            .getLogger(ZookeeperDistributedLock.class);

    private CuratorFramework curatorFramework;

    private Map<Long, InterProcessMutex> lockMap = new ConcurrentHashMap<Long, InterProcessMutex>();

    public ZookeeperDistributedLock(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }

    @Override
    public boolean lock(String key, long expire) {
        synchronized (key) {
            long threadId = Thread.currentThread().getId();
            try {
                InterProcessMutex interProcessMutex;
                if (lockMap.containsKey(threadId)) {
                    interProcessMutex = lockMap.get(threadId);
                } else {
                    interProcessMutex = new InterProcessMutex(curatorFramework, "/" + key);
                    lockMap.put(threadId, interProcessMutex);
                }
                boolean lock = interProcessMutex.acquire(expire, TimeUnit.SECONDS);
                if (lock) {
                    logger.info(threadId + " hold lock:" + key);
                }
                return lock;
            } catch (Exception e) {
                lockMap.remove(threadId);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean releaseLock(String key) {
        long threadId = Thread.currentThread().getId();
        try {
            InterProcessMutex interProcessMutex;
            if (lockMap.containsKey(threadId)) {
                interProcessMutex = lockMap.get(threadId);
                lockMap.remove(threadId);
            } else {
                interProcessMutex = new InterProcessMutex(curatorFramework, "/" + key);
            }
            interProcessMutex.release();
            logger.info(threadId + " release lock:" + key);
        } catch (Exception e) {
            //			throw new RuntimeException(e);
        } finally {
            lockMap.remove(threadId);
        }
        return true;
    }

}
