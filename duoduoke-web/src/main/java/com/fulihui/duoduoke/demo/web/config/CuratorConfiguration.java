package com.fulihui.duoduoke.demo.web.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * zookeeper 分布式设置--用于锁操作
 *
 * @author: Levon
 * @version: v 0.1 2018-06-11 15:34
 */
@Configuration
public class CuratorConfiguration {

    @Value("${mutex.zkServers}")
    private String zkServers;

    /**
     * session超时 毫秒
     */
    @Value("${mutex.timeout}")
    private int timeout;

    @Bean
    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString(zkServers)
                .sessionTimeoutMs(timeout)
                .retryPolicy(retryPolicy)
                .build();
        cf.start();
        return cf;
    }

    public static void main(String[] args) {


    }
}
