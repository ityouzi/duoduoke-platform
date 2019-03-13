package com.fulihui.duoduoke.demo.web.weixin.weixin.util;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/6 0006 16:34
 */
public class LoggerUtils {

    /**
     * 截取字符串，取前后show长度的字符串，中间用'...'拼接，定义 protected 用于测试类测试
     *
     * @param str   原字符串
     * @param limit 到达限制长度后截取，不到限制长度的直接返回原字符串
     * @param show  前后显示的字符串长度，show 必须满足 show * 2 <= limit
     * @return 处理后的字符串
     */
    public static String cutString(String str, int limit, int show) {
        if (str.length() <= limit) {
            return str;
        }
        if (show * 2 > limit) {
            throw new IllegalArgumentException(
                    "The multiples of the 'show' cannot be greater than 'limit'");
        }
        return str.substring(0, show) + "..." + str.substring(str.length() - show);
    }
}
