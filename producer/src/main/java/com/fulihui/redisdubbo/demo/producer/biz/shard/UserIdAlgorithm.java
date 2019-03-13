package com.fulihui.redisdubbo.demo.producer.biz.shard;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Optional;


/**
 * sharding-jdbc 2.0 table algorithm
 *
 * @author: Levon
 * @version: v 0.1 2017-10-25 10:10
 */
public class UserIdAlgorithm implements PreciseShardingAlgorithm<String> {

    protected final transient Logger LOGGER = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        String s = "256953320239820800";
        int i = new HashCodeBuilder().append(s).hashCode();
        int abs = Math.abs(i);
        String s1 = String.valueOf(abs % 20);
        System.out.println(s1);

        String s2 = new String(Base64.decodeBase64("BASE-6LaK6L+H5bGx5LiY"));
        System.out.println(s2);
    }

    @Override
    public String doSharding(Collection<String> availableTargetNames,
                             PreciseShardingValue<String> shardingValue) {
        int i = new HashCodeBuilder().append(shardingValue.getValue()).hashCode();
        int abs = Math.abs(i);
        Optional<String> opt = availableTargetNames.stream()
                .filter(it -> it.endsWith(String.valueOf(abs % availableTargetNames.size())))
                .findFirst();
        if (!opt.isPresent()) {
            throw new IllegalArgumentException(
                    "Sharding Value '" + shardingValue + "' could not match table");
        }
        String index = opt.get();
        String userId = shardingValue.getValue();
        LOGGER.info("userId:{},当前定位表:{}", userId, index);
        return index;
    }
}
