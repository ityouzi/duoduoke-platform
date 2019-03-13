package com.fulihui.duoduoke.demo.common.util;

import com.google.common.base.Strings;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Objects;


/**
 * @Author: WangShuai
 * @Description: MD5Util
 * @Date: Create in 2018/6/6 12:41
 * @Modified By:
 */
public final class MD5Util {
    private static final Logger LOG = LoggerFactory.getLogger(MD5Util.class);

    private static final String KEY_ALGORITHM = "MD5";

    private static final String CHAR_SET = "UTF-8";

    private MD5Util() {

    }

    public static String md5WithBase64(String content) {
        byte[] buf = md5(content);
        return bytesToBase64(buf);
    }

    public static String md5WithHex(String content) {
        byte[] buf = md5(content);
        return bytesToHex(buf);
    }

    private static byte[] md5(String content) {
        if (Strings.isNullOrEmpty(content)) {
            return null;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("MD5Util md5 content : {}", content);
        }
        byte[] buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance(KEY_ALGORITHM);
            buf = md.digest(content.getBytes(CHAR_SET));
        } catch (Exception e) {
            LOG.error("md5 content : {}, error : {}", content, e);
        }

        return buf;
    }

    public static String bytesToHex(byte[] buf) {
        if (Objects.isNull(buf)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        byte b;
        for (int i = 0; i < buf.length; i++) {
            b = buf[i];
            boolean negative = true;
            int abs = Math.abs(b);
            if (negative) {
                abs = abs | 0x80;
            }
            String temp = Integer.toHexString(abs & 0xFF);
            if (temp.length() == 1) {
                sb.append("0");
            }
            sb.append(temp.toLowerCase());
        }
        return sb.toString();
    }

    public static byte[] hexToBytes(String hex) {
        byte[] buf = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i = i + 2) {
            String subStr = hex.substring(i, i + 2);
            boolean negative = false;
            int inte = Integer.parseInt(subStr, 16);
            if (inte > 127) {
                negative = true;
            }
            if (inte == 128) {
                inte = -128;
            } else if (negative) {
                inte = 0 - (inte & 0x7F);
            }
            byte b = (byte) inte;
            buf[i / 2] = b;
        }
        return buf;
    }

    public static String bytesToBase64(byte[] buf) {
        try {
            return new String(Base64.encodeBase64(buf), CHAR_SET);
        } catch (UnsupportedEncodingException e) {
            LOG.error("bytesToBase64 error : {}", e);
        }
        return null;
    }

    public static byte[] base64ToBytes(String base64) {
        return Base64.decodeBase64(base64);
    }
}
