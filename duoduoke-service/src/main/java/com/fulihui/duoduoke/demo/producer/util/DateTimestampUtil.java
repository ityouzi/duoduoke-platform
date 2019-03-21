package com.fulihui.duoduoke.demo.producer.util;

import org.apache.http.util.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.near.toolkit.common.DateUtils.parseNewFormat;

/**
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

    public static Date unixToDate(String timestampString, String formats) {
        if (TextUtils.isEmpty(formats)) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }

        Long timestamp = Long.parseLong(timestampString) * 1000;
        String format = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        try {
            return parseNewFormat(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
