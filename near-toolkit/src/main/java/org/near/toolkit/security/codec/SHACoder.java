package org.near.toolkit.security.codec;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

/**
 * SHA摘要加密算法
 */
public class SHACoder {

    /** 加密算法 */
    private static final String ALGORITHM = "SHA";

    /** 字符编码 */
    private static final String CHARSET   = "UTF-8";

    /**
     * 将原文加密生成摘要字符串，默认编码utf-8
     */
    public static String SHAEncode(String src) {
        return SHAEncode(src, CHARSET);
    }

    /**
     * 将原文加密生成摘要字符串，自定义编码
     */
    public static String SHAEncode(String src, String charset) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            return Hex.encodeHexString(md.digest(src.getBytes(charset)));
        } catch (Exception e) {
            throw new CodecException(e);
        }
    }

}
