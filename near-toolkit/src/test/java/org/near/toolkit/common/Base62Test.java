package org.near.toolkit.common;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 *
 * Created by Willard.Hu on 2016/5/2.
 */
public class Base62Test {

    private static char[] CODE;

    static { // 用非顺序规律[a..z,0..9,A..Z]
        CODE = new char[62];
        int idx = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            CODE[idx++] = (char) i;
        }
        for (int i = '0'; i <= '9'; i++) {
            CODE[idx++] = (char) i;
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            CODE[idx++] = (char) i;
        }
    }

    public static String to62(long num) {
        if (num == 0) {
            return "0";
        }
        // TODO 负数处理，记录是否是负数，转整数计算，返回时判断如果是负数，返回值前面加‘-’
        StringBuilder sb = new StringBuilder();
        long n = num;
        while (n > 0) {
            int i = (int) (n % 62);
            sb.append(CODE[i]);
            n /= 62;
        }
        return sb.toString();
    }

    @Test
    public void test_001() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            System.out.println(to62(System.currentTimeMillis()));
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }

}
