package com.fulihui.duoduoke.demo.producer.job.util;

import java.util.Date;

/**
 *
 * @author lizhi
 * @date 2018-7-10
 */
public class DateTimestampUtil {
    /**
     * 获取精确到秒的时间戳
     *
     * @return
     */
    public static String getSecondTimestamp(Date date) {
        if (null == date) {
            return "0";
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return timestamp.substring(0, length - 3);
        } else {
            return "0";
        }

    }
}
