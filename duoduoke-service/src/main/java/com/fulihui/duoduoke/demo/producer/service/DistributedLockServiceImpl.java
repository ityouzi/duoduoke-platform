package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.DistributedLockService;
import com.fulihui.duoduoke.demo.producer.lock.DistributedLock;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author lizhi
 * @date 2018-9-11
 */
@Service(version = "${demo.service.version}")

public class DistributedLockServiceImpl implements DistributedLockService {

    @Resource
    private DistributedLock zookeeperDistributedLock;

    @Override
    public boolean lock(String key, long expire) {
        return zookeeperDistributedLock.lock(key, expire);
    }

    @Override
    public boolean releaseLock(String key) {
        return zookeeperDistributedLock.releaseLock(key);
    }
}
