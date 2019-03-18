package com.fulihui.duoduoke.demo.producer.job.schedule;

import static org.near.toolkit.common.DateUtils.formatNewFormat;

import java.util.Date;

import com.fulihui.duoduoke.demo.api.api.job.OrderSysDataService;
import com.fulihui.duoduoke.demo.producer.job.model.CustomParameters;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author lizhi
 * @date 2018-7-10
 */
@Component
public class OrderColorIncrementJob implements SimpleJob {
    private static final Logger LOGGER  = LoggerFactory.getLogger(OrderColorIncrementJob.class);

    @Autowired
    OrderSysDataService orderSysDataService;
    private volatile boolean    running = false;

    @Override
    public void execute(ShardingContext shardingContext) {

        LOGGER.info("订单拉取数据开始:{}", formatNewFormat(new Date()));

        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }
        running = true;
        try {
            orderSysDataService.fetchColor(new Date(),Boolean.TRUE);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        running = false;
        LOGGER.info("running改值成功");
        LOGGER.info("订单拉取数据结束:{}", formatNewFormat(new Date()));

    }

    public static void main(String[] args) {

        String parameters = "";
        System.out.println(StringUtil.isNotBlank(parameters));
        CustomParameters object = JSONObject.parseObject(parameters, CustomParameters.class);
        System.out.println(object);
    }
}
