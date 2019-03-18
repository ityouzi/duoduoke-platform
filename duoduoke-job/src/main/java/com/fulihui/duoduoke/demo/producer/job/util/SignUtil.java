package com.fulihui.duoduoke.demo.producer.job.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.near.toolkit.security.codec.MD5Coder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/6 0006 14:54
 */
public class SignUtil {

    private static Logger logger = LoggerFactory.getLogger(SignUtil.class);

    /**
     * 生成服务器签名算法
     */
    public static String genServiceSign(List<String> paramKeys, Map<String, Object> paramValues, String key) {
        if (paramKeys == null || paramValues == null) {
            return null;
        }
        String paramStr = genEncryptText(paramKeys, paramValues);
        paramStr += key;
        paramStr = key + paramStr;
        logger.debug("sing str:{}", paramStr);
        return MD5Coder.md5Encode(paramStr).toUpperCase();
    }


    /**
     * 排序拼接参数列表,paramKeys参数的字符串数组，paramValues参数值的字符串数组
     *
     * @return
     */
    private static String genEncryptText(List<String> paramKeys, Map<String, Object> paramValues) {
        StringBuilder encryptText = new StringBuilder();
        Collections.sort(paramKeys);
        for (int i = 0, size = paramKeys.size(); i < size; i++) {
            String key = paramKeys.get(i);
            if ("param".equals(key)) {
                continue;
            }
            Object o = paramValues.get(key);
            encryptText.append(key).append(o.toString());
        }
        return encryptText.toString();
    }


}
