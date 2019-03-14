package com.fulihui.duoduoke.demo.producer.zubs;

import org.near.toolkit.common.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/19 0019 15:31
 */
public class Const {

    public static final String GOODSUPDATE = "DUODUOKE_GOODSUPDATE";

    public static final String GOODSCHECK = "DUODUOKE_GOODSCHECk";

    public static final String ORDER_INCREMENT = "DUODUOKE_ORDER_INCREMENT";

    /**
     * 发送模板消息
     */
    public static final String SEND_TEMPLATE = "DUODUOKE_SEND_TEMPLATE";

    public static final String DUODUOKE_ORDER_PUSH = "DUODUOKE_ORDER_PUSH";

    public static final String DUODUOKE_DOUBLE_ORDER_PUSH = "DUODUOKE_DOUBLE_ORDER_PUSH";

    public static final String DUODUOKE_FROM_RECORD = "DUODUOKE_FROM_RECORD";


    public static final String DUODUOKE_HELP = "DUODUOKE_HELP";

    public static Date CHECK_TIME;

    static {
        try {
            CHECK_TIME = DateUtils.parseWebFormat("2018-09-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
