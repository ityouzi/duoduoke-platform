package org.near.servicesupport.util;

import java.util.Map;
import java.util.TreeMap;

import org.near.toolkit.security.codec.MD5Coder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by Willard.Hu on 2016/3/3.
 */
public class SignUtil {
    private static final Logger log = LoggerFactory.getLogger(SignUtil.class);

    /**
     * 生成签名
     */
    public static String genSign(TreeMap<String, String> param, String key) {
        String paramStr = "";
        if (param != null && !param.isEmpty()) {
            paramStr = genParamStr(param);
        }
        paramStr += key;
        String sign = MD5Coder.md5Encode(paramStr).toUpperCase();
        log.debug("param:{} | key:{} | sign:{}", new Object[] { param, key, sign });
        return sign;
    }

    private static String genParamStr(TreeMap<String, String> param) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getValue() == null || entry.getValue().isEmpty()) { // 值不为空才添加
                continue;
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        log.debug("param str:{}", sb.toString());
        return sb.toString();
    }

}
