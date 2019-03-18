package com.fulihui.duoduoke.demo.producer.job.schedule;

import com.fulihui.duoduoke.demo.api.api.TemplateSendTaskService;
import com.fulihui.duoduoke.demo.producer.job.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author: JY
 * @date: 2018/8/17 14:30
 */
public class TaskSendCheckJob implements SimpleJob {

    @org.apache.dubbo.config.annotation.Reference
    TemplateSendTaskService templateSendTaskService;

    private static final Logger logger = LoggerFactory.getLogger(Consts.LoggerName.JOB_MONITOR);

    @Override
    public void execute(ShardingContext shardingContext) {
        long startTime = System.currentTimeMillis();
        try {
            logger.info("读取待推送的消息开始");
            templateSendTaskService.checkSend();
        } catch (Exception ex) {
            logger.error("读取待推送的消息失败：{}", ex);
        }
        long elapseTime = System.currentTimeMillis() - startTime;

        logger.info("读取待推送的消息结束,{}ms", elapseTime);
    }

}
