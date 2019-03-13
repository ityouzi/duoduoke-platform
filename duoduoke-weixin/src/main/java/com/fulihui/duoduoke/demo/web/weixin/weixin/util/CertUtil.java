package com.fulihui.duoduoke.demo.web.weixin.weixin.util;


/**
 * @author LIZHI
 */
public class CertUtil {

    private static ThreadLocal<CertInfo> threadCache = new InheritableThreadLocal<>();

    /**
     * 将认证信息放入线程缓存
     */
    public static void setCertInfo(CertInfo certInfo) {
        threadCache.set(certInfo);
    }

    /**
     * 从线程缓存取出认证信息
     */
    public static CertInfo getCertInfo() {
        return threadCache.get();
    }

    /**
     * 清除线程缓存
     */
    public static void clear() {
        threadCache.remove();
    }

}
