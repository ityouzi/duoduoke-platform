/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.fulihui.duoduoke.demo.producer.job.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.fulihui.duoduoke.demo.producer.job.schedule.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizhi
 */
@Configuration
public class JobConfig {

    @Autowired
    private ZookeeperRegistryCenter regCenter;


    @Bean
    public UserWithdrawalCheckJob userWithdrawalCheckJob() {
        return new UserWithdrawalCheckJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler userWithdrawalCheckJobScheduler(final UserWithdrawalCheckJob userWithdrawalCheckJob,
                                                        @Value("${userWithdrawalCheckJob.cron}") final String cron,
                                                        @Value("${userWithdrawalCheckJob.shardingTotalCount}") final int shardingTotalCount,
                                                        @Value("${userWithdrawalCheckJob.shardingItemParameters}") final String shardingItemParameters,
                                                        @Value("${userWithdrawalCheckJob.disabled}") final boolean disabled

    ) {
        return new SpringJobScheduler(userWithdrawalCheckJob, regCenter,
                getLiteJobConfiguration(userWithdrawalCheckJob.getClass(), cron, shardingTotalCount,
                        shardingItemParameters, disabled));
    }


    @Bean
    public OrderIncrementJob orderIncrementJob() {
        return new OrderIncrementJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler orderIncrementJobScheduler(final OrderIncrementJob orderIncrementJob,
                                                   @Value("${orderIncrementJob.cron}") final String cron,
                                                   @Value("${orderIncrementJob.shardingTotalCount}") final int shardingTotalCount,
                                                   @Value("${orderIncrementJob.shardingItemParameters}") final String shardingItemParameters,
                                                   @Value("${orderIncrementJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(orderIncrementJob, regCenter,
                getLiteJobConfiguration(orderIncrementJob.getClass(), cron, shardingTotalCount,
                        shardingItemParameters, disabled));
    }

    @Bean
    public OrderSendJob orderSendJob() {
        return new OrderSendJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler orderSendJobScheduler(final OrderSendJob orderSendJob,
                                              @Value("${orderSendJob.cron}") final String cron,
                                              @Value("${orderSendJob.shardingTotalCount}") final int shardingTotalCount,
                                              @Value("${orderSendJob.shardingItemParameters}") final String shardingItemParameters,
                                              @Value("${orderSendJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(orderSendJob, regCenter, getLiteJobConfiguration(
                orderSendJob.getClass(), cron, shardingTotalCount, shardingItemParameters, disabled));
    }

    @Bean
    public UserFormIdJob userFormIdJob() {
        return new UserFormIdJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler userFormIdJobScheduler(final UserFormIdJob userFormIdJob,
                                               @Value("${userFormIdJob.cron}") final String cron,
                                               @Value("${userFormIdJob.shardingTotalCount}") final int shardingTotalCount,
                                               @Value("${userFormIdJob.shardingItemParameters}") final String shardingItemParameters,
                                               @Value("${userFormIdJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(userFormIdJob, regCenter, getLiteJobConfiguration(
                userFormIdJob.getClass(), cron, shardingTotalCount, shardingItemParameters, disabled));
    }


    @Bean
    public TaskSendCheckJob taskSendCheckJob() {
        return new TaskSendCheckJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler taskSendCheckJobScheduler(final TaskSendCheckJob taskSendCheckJob,
                                                  @Value("${taskSendCheckJob.cron}") final String cron,
                                                  @Value("${taskSendCheckJob.shardingTotalCount}") final int shardingTotalCount,
                                                  @Value("${taskSendCheckJob.shardingItemParameters}") final String shardingItemParameters,
                                                  @Value("${taskSendCheckJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(taskSendCheckJob, regCenter,
                getLiteJobConfiguration(taskSendCheckJob.getClass(), cron, shardingTotalCount,
                        shardingItemParameters, disabled));
    }

    @Bean
    public SignAwardSettlementJob signAwardSettlementJob() {
        return new SignAwardSettlementJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler signAwardSettlementJobScheduler(final SignAwardSettlementJob signAwardSettlementJob,
                                                        @Value("${signAwardSettlementJob.cron}") final String cron,
                                                        @Value("${signAwardSettlementJob.shardingTotalCount}") final int shardingTotalCount,
                                                        @Value("${signAwardSettlementJob.shardingItemParameters}") final String shardingItemParameters,
                                                        @Value("${signAwardSettlementJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(signAwardSettlementJob, regCenter,
                getLiteJobConfiguration(signAwardSettlementJob.getClass(), cron, shardingTotalCount,
                        shardingItemParameters, disabled));
    }

    /**
     * @Description 任务配置类
     */
    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters,
                                                         final boolean disabled) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
                JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                        .shardingItemParameters(shardingItemParameters).build(),
                jobClass.getCanonicalName())).overwrite(true).disabled(disabled).build();
    }


    @Bean
    public SignOrderConfirmReceiptJob signOrderConfirmReceiptJob() {
        return new SignOrderConfirmReceiptJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler signOrderConfirmReceiptJobScheduler(final SignOrderConfirmReceiptJob signOrderConfirmReceiptJob,
                                                            @Value("${signOrderConfirmReceiptJob.cron}") final String cron,
                                                            @Value("${signOrderConfirmReceiptJob.shardingTotalCount}") final int shardingTotalCount,
                                                            @Value("${signOrderConfirmReceiptJob.shardingItemParameters}") final String shardingItemParameters,
                                                            @Value("${signOrderConfirmReceiptJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(signOrderConfirmReceiptJob, regCenter,
                getLiteJobConfiguration(signOrderConfirmReceiptJob.getClass(), cron, shardingTotalCount,
                        shardingItemParameters, disabled));
    }


    @Bean
    public OrderDetailGetJob orderDetailGetJob() {
        return new OrderDetailGetJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler orderDetailGetJobScheduler(final OrderDetailGetJob orderDetailGetJob,
                                                   @Value("${orderDetailGetJob.cron}") final String cron,
                                                   @Value("${orderDetailGetJob.shardingTotalCount}") final int shardingTotalCount,
                                                   @Value("${orderDetailGetJob.shardingItemParameters}") final String shardingItemParameters,
                                                   @Value("${orderDetailGetJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(orderDetailGetJob, regCenter,
                getLiteJobConfiguration(orderDetailGetJob.getClass(), cron, shardingTotalCount,
                        shardingItemParameters, disabled));
    }

    @Bean
    public OrderColorIncrementJob orderColorIncrementJob() {
        return new OrderColorIncrementJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler orderColorIncrementJobScheduler(final OrderColorIncrementJob orderColorIncrementJob,
                                                        @Value("${orderColorIncrementJob.cron}") final String cron,
                                                        @Value("${orderColorIncrementJob.shardingTotalCount}") final int shardingTotalCount,
                                                        @Value("${orderColorIncrementJob.shardingItemParameters}") final String shardingItemParameters,
                                                        @Value("${orderColorIncrementJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(orderColorIncrementJob, regCenter,
                getLiteJobConfiguration(orderColorIncrementJob.getClass(), cron, shardingTotalCount,
                        shardingItemParameters, disabled));
    }

    @Bean
    public CatGoodsJob catGoodsJob() {
        return new CatGoodsJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler catGoodsJobScheduler(final CatGoodsJob catGoodsJob,
                                             @Value("${catGoodsJob.cron}") final String cron,
                                             @Value("${catGoodsJob.shardingTotalCount}") final int shardingTotalCount,
                                             @Value("${catGoodsJob.shardingItemParameters}") final String shardingItemParameters,
                                             @Value("${catGoodsJob.disabled}") final boolean disabled) {
        return new SpringJobScheduler(catGoodsJob, regCenter,
                getLiteJobConfiguration(catGoodsJob.getClass(), cron, shardingTotalCount,
                        shardingItemParameters, disabled));
    }

}
