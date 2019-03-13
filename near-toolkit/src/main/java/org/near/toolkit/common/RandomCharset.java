package org.near.toolkit.common;

import java.util.Random;

/**
 * 废弃的工具类，使用apache-commons的包工具类
 * @see org.apache.commons.lang3.RandomStringUtils
 * @author Created by Willard.Hu on 2016/6/8.
 */
@Deprecated
public class RandomCharset {

    private static final char[] NUMBER  = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    private static final char[] LETTER  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
            'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    private static final char[] MIXTURE = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    private static Random       random  = new Random();

    /**
     * 随机生成指定长度的数字字符串
     */
    public static String randomNumber(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(NUMBER[random.nextInt(NUMBER.length)]);
        }
        return sb.toString();
    }

    /**
     * 随机生成指定长度的大小写字母字符串
     */
    public static String randomLetter(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(LETTER[random.nextInt(LETTER.length)]);
        }
        return sb.toString();
    }

    /**
     * 随机生成指定长度的数字、大小写字母混合的字符串
     */
    public static String randomMixture(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(MIXTURE[random.nextInt(MIXTURE.length)]);
        }
        return sb.toString();
    }
}
