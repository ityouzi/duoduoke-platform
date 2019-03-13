package org.near.toolkit.security.codec;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Willard.Hu on 2017/2/16 0016.
 */
public class AESCoderTest {

    private String key = "ZBScz/egWJkEQ48nhDdT2g==";
    private String str = "fulihui.com";

    @Test
    public void encrypt() throws Exception {
        String encrypt = AESCoder.encrypt(str, key);
        System.out.println(encrypt);
    }

    @Test
    public void decrypt() throws Exception {
        String src = AESCoder.decrypt("OBlLryyS5T+Wz3+1o82FYQ==", key);
        Assert.assertEquals(src, str);
    }

    @Test
    public void genKey() throws Exception {
        String key = AESCoder.genKey();
        System.out.println(key);
    }

}