package org.near.servicesupport.request;

import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Willard.Hu on 2016/3/19.
 */

public class RequestBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(RequestBuilder.class);
    private static String ip;
    private static String hostName;

    static {
        // 类初始化时获取网络ip和本机名称
        try {
            InetAddress netAddress = InetAddress.getLocalHost();
            if (netAddress != null) {
                ip = netAddress.getHostAddress();
                hostName = netAddress.getHostName();
            }
        } catch (UnknownHostException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static <T extends AbstractServiceRequest> T build(Class<T> clz) {
        return build(clz, RequestBuilder.hostName, RequestBuilder.ip);
    }

    public static <T extends AbstractServiceRequest> T build(Class<T> clz, String hostName) {
        return build(clz, hostName, RequestBuilder.ip);
    }

    public static <T extends AbstractServiceRequest> T build(Class<T> clz, String hostName, String ip) {
        try {
            T req = clz.newInstance();
            Method m;
            try {
                m = clz.getMethod("setClientName", String.class);
                m.invoke(req, hostName);
            } catch (NoSuchMethodException ignore) {
            }
            try {
                m = clz.getMethod("setClientIp", String.class);
                m.invoke(req, ip);
            } catch (NoSuchMethodException ignore) {
            }
            return req;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> TRequest<T> buildT(T condition) {
        return buildT(condition, RequestBuilder.ip, RequestBuilder.hostName);
    }

    public static <T> TRequest<T> buildT(T condition, String ip, String hostName) {
        TRequest<T> req = new TRequest<>();
        req.setClientIp(StringUtil.isBlank(ip) ? RequestBuilder.ip : ip);
        req.setClientName(StringUtil.isBlank(hostName) ? RequestBuilder.hostName : hostName);
        req.setCondition(condition);
        return req;
    }

    public static <T> TPageRequest<T> buildPageT(T condition, int page, int rows) {
        return buildPageT(condition, page, rows, RequestBuilder.ip, RequestBuilder.hostName);
    }

    public static <T> TPageRequest<T> buildPageT(T condition, int page, int rows, String ip,
                                                 String hostName) {
        TPageRequest<T> req = new TPageRequest<>();
        Class<?> clz = req.getClass();
        Method m;
        try {
            m = clz.getMethod("setClientName", String.class);
            m.invoke(req, hostName);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignore) {
        }
        try {
            m = clz.getMethod("setClientIp", String.class);
            m.invoke(req, ip);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignore) {
        }
        req.setCondition(condition);
        req.setPage(page);
        req.setRows(rows);
        return req;
    }

}
