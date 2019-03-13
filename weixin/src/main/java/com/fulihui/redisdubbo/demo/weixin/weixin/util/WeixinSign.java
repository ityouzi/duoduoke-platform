package com.fulihui.redisdubbo.demo.weixin.weixin.util;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口签名
 * Created by Willard on 2015/9/17.
 */
public class WeixinSign {

    private static Logger logger = LoggerFactory.getLogger(WeixinSign.class);

    /**
     * 生成服务器签名算法
     */
    public static String genServiceSign(Map<String, Object> param, String key) {
        if (param == null || param.isEmpty()) {
            return null;
        }
        String paramStr = genParamStr(param);
        paramStr += "&key=" + key;
        logger.debug("sing str:{}", paramStr);
        return DigestUtils.md5Hex(paramStr);
    }

    /**
     * 生成js api签名算法
     */
    public static String genJsapiSign(Map<String, Object> param) {
        logger.debug("genJsapiSign - args[{}]", param);
        if (param == null || param.isEmpty()) {
            return null;
        }
        String paramStr = genParamStr(param);
        logger.debug("sing str:{}", paramStr);
        return DigestUtils.sha1Hex(paramStr);
    }

    private static String genParamStr(Map<String, Object> param) {
        TreeMap<String, Object> sorted = new TreeMap<>(param);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : sorted.entrySet()) {
            // 值不为空才添加
            if (entry.getValue() == null || entry.getValue().toString().isEmpty()) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue().toString());
        }
        return sb.toString();
    }
}
