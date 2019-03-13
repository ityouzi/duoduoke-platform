package org.near.toolkit.security.codec;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * AES对称加密解密算法-JDK实现<br>
 * <hr>
 * 密钥长度：128<br>
 * 密钥默认长度：128<br>
 * 工作模式：ECB、CBC、PCBC、CTR、CTS、CFB、CFB8-CFB128、OFB、OFB8-OFB128<br>
 * 填充方式：NoPadding、PKCS5Padding、ISO10126Padding
 */
public class AESCoder {

    /**
     * 字符编码
     */
    private static final String CHARSET = "UTF-8";

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 加密、解密算法
     */
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 密钥长度
     */
    private static final int KEY_SIZE = 128;

    /**
     * 加密，默认编码utf-8，返回字符串
     */
    public static String encrypt(String src, String key) {
        return encrypt(src, key, CHARSET);
    }

    /**
     * 加密，自定义编码，返回字符串
     */
    public static String encrypt(String src, String key, String charset) {
        return Base64.encodeBase64String(encryptBytes(src, key, charset));
    }

    /**
     * 加密，默认编码utf-8，返回byte数组
     */
    public static byte[] encryptBytes(String src, String key) {
        return encryptBytes(src, key, CHARSET);
    }

    /**
     * 加密，自定义编码，返回byte数组
     */
    public static byte[] encryptBytes(String src, String key, String charset) {
        try {
            Key keySpec = toKey(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return cipher.doFinal(src.getBytes(charset));
        } catch (Exception e) {
            throw new CodecException(e);
        }
    }

    /**
     * 加密，默认编码utf-8
     */
    public static String encryptURLSafe(String src, String key) {
        return encryptURLSafe(src, key, CHARSET);
    }

    /**
     * 加密，自定义编码
     */
    public static String encryptURLSafe(String src, String key, String charset) {
        try {
            Key keySpec = toKey(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return Base64.encodeBase64URLSafeString(cipher.doFinal(src.getBytes(charset)));
        } catch (Exception e) {
            throw new CodecException(e);
        }
    }

    /**
     * 解密，传入字符串，默认编码utf-8
     */
    public static String decrypt(String encrypted, String key) {
        return decrypt(encrypted, key, CHARSET);
    }

    /**
     * 解密，传入字符串，自定义编码
     */
    public static String decrypt(String encrypted, String key, String charset) {
        return decrypt(Base64.decodeBase64(encrypted), Base64.decodeBase64(key), charset);
    }

    /**
     * 解密，传入byte[]数组，默认编码 UTF-8
     *
     * @param encrypted 密文 byte[]
     * @param key       key byte[]
     * @return 解密后的内容
     */
    public static String decrypt(byte[] encrypted, byte[] key) {
        return decrypt(encrypted, key, CHARSET);
    }

    /**
     * 解密，传入byte[]数组，自定义编码
     *
     * @param encrypted 密文 byte[]
     * @param key       key byte[]
     * @param charset   编码
     * @return 解密后的内容
     */
    public static String decrypt(byte[] encrypted, byte[] key, String charset) {
        try {
            Key keySpec = toKey(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return new String(cipher.doFinal(encrypted), charset);
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
     * 将密钥字节数组转换为密钥对象
     *
     * @param bytes 密钥字节数组
     * @return {@link Key}
     */
    private static Key toKey(byte[] bytes) {
        return new SecretKeySpec(bytes, KEY_ALGORITHM);
    }

    /**
     * 生成AES密钥
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
