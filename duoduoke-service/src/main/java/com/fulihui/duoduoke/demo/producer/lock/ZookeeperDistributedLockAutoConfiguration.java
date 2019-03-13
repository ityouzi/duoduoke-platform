package com.fulihui.duoduoke.demo.producer.lock;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lizhi
 */
@Configuration
@EnableConfigurationProperties(ZookeeperDistributedLockProperties.class)
public class ZookeeperDistributedLockAutoConfiguration {

    private final Logger logger = LoggerFactory
            .getLogger(ZookeeperDistributedLockAutoConfiguration.class);

    @Autowired
    private ZookeeperDistributedLockProperties zookeeperDistributedLockProperties;

    /**
     * Curator framework curator framework.
     *
     * @return the curator framework
     */
    @Bean
    public CuratorFramework curatorFramework() {
        ZookeeperDistributedLockProperties.Zookeeper zkConfig = zookeeperDistributedLockProperties
                .getZk();
        logger.debug("zookeeper registry center init, server lists is: {}.",
                zkConfig.getServerLists());
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
                .connectString(zkConfig.getServerLists())
                .retryPolicy(new ExponentialBackoffRetry(zkConfig.getBaseSleepTimeMilliseconds(),
                        zkConfig.getMaxRetries(), zkConfig.getMaxSleepTimeMilliseconds()))
                .namespace(zkConfig.getNamespace());
        if (0 != zkConfig.getSessionTimeoutMilliseconds()) {
            builder.sessionTimeoutMs(zkConfig.getSessionTimeoutMilliseconds());
        }
        if (0 != zkConfig.getConnectionTimeoutMilliseconds()) {
            builder.connectionTimeoutMs(zkConfig.getConnectionTimeoutMilliseconds());
        }
        if (!Strings.isNullOrEmpty(zkConfig.getDigest())) {
            builder.authorization("digest", zkConfig.getDigest().getBytes(Charsets.UTF_8))
                    .aclProvider(new ACLProvider() {

                        @Override
                        public List<ACL> getDefaultAcl() {
                            return ZooDefs.Ids.CREATOR_ALL_ACL;
                        }

                        @Override
                        public List<ACL> getAclForPath(final String path) {
                            return ZooDefs.Ids.CREATOR_ALL_ACL;
                        }
                    });
        }
        CuratorFramework curatorFramework = builder.build();
        curatorFramework.start();
        try {
            if (!curatorFramework.blockUntilConnected(
                    zkConfig.getMaxSleepTimeMilliseconds() * zkConfig.getMaxRetries(),
                    TimeUnit.MILLISECONDS)) {
                curatorFramework.close();
                throw new KeeperException.OperationTimeoutException();
            }
        } catch (Exception e) {
            logger.error("zk exception", e);
        }
        return curatorFramework;
    }

    /**
     * Zookeeper distributed lock distributed lock.
     *
     * @param curatorFramework the curator framework
     * @return the distributed lock
     */
    @Bean
    @ConditionalOnBean(CuratorFramework.class)
    public DistributedLock zookeeperDistributedLock(CuratorFramework curatorFramework) {
        return new ZookeeperDistributedLock(curatorFramework);
    }
}

@Data
class A {

    //级数

    private Integer level;
    //月度应纳税所得额
    private String monthly;
    //税率（％）

    private Integer rate;
    //速算扣除数

    private Integer deduction;

    public static void main(String[] args) {

        A a1 = new A();
        a1.setMonthly("0-3000");
        a1.setLevel(1);
        a1.setDeduction(0);
        a1.setRate(3);

        A a2 = new A();
        a2.setMonthly("3000-12000");
        a2.setLevel(2);
        a2.setDeduction(10);
        a2.setRate(210);

        A a3 = new A();
        a3.setMonthly("12000-25000");
        a3.setLevel(3);
        a3.setDeduction(20);
        a3.setRate(1410);

        A a4 = new A();
        a4.setMonthly("25000-35000");
        a4.setLevel(4);
        a4.setDeduction(25);
        a4.setRate(2660);

        A a5 = new A();
        a5.setMonthly("35000-55000");
        a5.setLevel(5);
        a5.setDeduction(30);
        a5.setRate(4410);

        A a6 = new A();
        a6.setMonthly("55000-80000");
        a6.setLevel(6);
        a6.setDeduction(35);
        a6.setRate(7160);

        A a7 = new A();
        a7.setMonthly("80000-80000");
        a7.setLevel(7);
        a7.setDeduction(45);
        a7.setRate(15160);
        List list = Lists.newArrayList(a1, a2, a3, a4, a5, a6, a7);
        Object o = JSON.toJSON(list);
        System.out.println(o);
        System.out.println(Integer.MAX_VALUE);
    }
}
