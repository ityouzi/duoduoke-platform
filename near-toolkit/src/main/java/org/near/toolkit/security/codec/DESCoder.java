package org.near.toolkit.security.codec;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * DES对称加密解密算法<br>
 * <hr>
 * 密钥长度：56<br>
 * 密钥默认长度：56<br>
 * 工作模式：ECB、CBC、PCBC、CTR、CTS、CFB、CFB8-CFB128、OFB、OFB8-OFB128<br>
 * 填充方式：NoPadding、PKCS5Padding、ISO10126Padding
 */
public class DESCoder {

    /** 字符编码 */
    private static final String CHARSET          = "UTF-8";

    /** 密钥算法 */
    private static final String KEY_ALGORITHM    = "DES";

    /** 加密、解密算法 */
    private static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /** 密钥长度 */
    private static final int    KEY_SIZE         = 56;

    /**
     * 加密，默认编码utf-8
     */
    public static String encrypt(String src, String key) {
        return encrypt(src, key, CHARSET);
    }

    /**
     * 加密，自定义编码
     */
    public static String encrypt(String src, String key, String charset) {
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
            //key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] bytes = cipher.doFinal(src.getBytes(charset));
            return Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            throw new CodecException(e);
        }
    }

    /**
     * 解密，默认编码utf-8
     */
    public static String decrypt(String encrypted, String key) {
        return decrypt(encrypted, key, CHARSET);
    }

    /**
     * 解密，自定义编码
     */
    public static String decrypt(String encrypted, String key, String charset) {
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
            //key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.decodeBase64(encrypted.getBytes(charset))));
        } catch (Exception e) {
            throw new CodecException(e);
        }
    }

    /**
     * 将密钥字符串转为密钥对象
     */
    private static Key toKey(String key) {
        return new SecretKeySpec(Base64.decodeBase64(key), KEY_ALGORITHM);
    }

    /**
     * 生成DES密钥
     */
    public static String genKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            keyGenerator.init(KEY_SIZE);
            SecretKey secretKey = keyGenerator.generateKey();
            return Base64.encodeBase64String(secretKey.getEncoded());
        } catch (Exception e) {
            throw new CodecException(e);
        }
    }
}
