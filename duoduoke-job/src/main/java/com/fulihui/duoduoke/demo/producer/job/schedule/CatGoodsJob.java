package com.fulihui.duoduoke.demo.producer.job.schedule;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.fulihui.duoduoke.demo.api.api.GoodsCatInfoService;
import com.fulihui.duoduoke.demo.producer.job.Consts;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CatGoodsJob implements SimpleJob {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrderIncrementJob.class);

    private static final Logger JOB_MONITOR_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.JOB_MONITOR);

    @Reference
    GoodsCatInfoService goodsCatInfoService;
    private volatile boolean running = false;

    @Override
    public void execute(ShardingContext shardingContext) {

        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }
        running = true;
        try {
            goodsCatInfoService.doCatSyc();
        } catch (Exception e) {
        }


        running = false;
        LOGGER.info("running改值成功");
    }

}
