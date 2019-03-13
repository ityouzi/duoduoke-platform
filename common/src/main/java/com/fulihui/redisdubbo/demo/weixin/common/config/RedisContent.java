package com.fulihui.redisdubbo.demo.weixin.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/3 0003 15:38
 */
public class RedisContent {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static final String GROUP = "DUODUOKE";
    public static final String DUODUO_GOODS_TABLE = GROUP + ":GOODS_TABLE";
    public static final String DUODUO_GOODS_SERCH = GROUP + ":GOODS_SERCH";
    public static final String DUODUO_GOODS_SERCHREQUEST = GROUP + ":GOODS_SERCH_REQUEST";
}
