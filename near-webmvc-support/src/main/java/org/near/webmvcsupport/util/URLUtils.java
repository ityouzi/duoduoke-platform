package org.near.webmvcsupport.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * URL工具
 * Created by Willard on 2015/8/25.
 */
public class URLUtils {
    private static final Logger log = LoggerFactory.getLogger(URLUtils.class);

    /**
     * url编码，默认utf8
     */
    public static String urlEncode(String s) {
        return urlEncode(s, "utf-8");
    }

    /**
     * url编码
     */
    public static String urlEncode(String s, String charset) {
        if (StringUtil.isBlank(s)) {
            return StringUtil.EMPTY_STRING;
        }
        try {
            return URLEncoder.encode(s, charset);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        return StringUtil.EMPTY_STRING;
    }

    /**
     * url解码，默认utf8
     */
    public static String urlDecode(String s) {
        return urlDecode(s, "utf-8");
    }

    /**
     * url解码
     */
    public static String urlDecode(String s, String charset) {
        if (StringUtil.isBlank(s)) {
            return StringUtil.EMPTY_STRING;
        }
        try {
            return URLDecoder.decode(s, charset);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        return StringUtil.EMPTY_STRING;
    }

    /**
     * 获取服务地址
     */
    public static String getHostURL(HttpServletRequest request) {
        StringBuilder url = new StringBuilder();
        url.append(request.getScheme()).append("://").append(request.getServerName());
        if (request.getServerPort() != 80 && request.getServerPort() != 443) {
            url.append(":").append(request.getServerPort());
        }
        if (!"/".equals(request.getContextPath())) {
            url.append(request.getContextPath());
        }
        return url.toString();
    }

    /**
     * 获取请求全链接
     * <p>反向代理时，会发生问题，因此将方法改成host作为参数传入，使用getFullRequestURL
     * <p>此方法将在1.0.2 后被删除
     */
    @Deprecated
    public static String getRequestURL(HttpServletRequest request) {
        /* FIXME 1.0.2 方法删除 */
        StringBuilder url = new StringBuilder();
        url.append(getHostURL(request));
        url.append(request.getServletPath());
        String queryString = request.getQueryString();
        if (StringUtil.isNotBlank(queryString)) {
            url.append("?").append(queryString);
        }
        return url.toString();
    }

    /**
     * 获取全请求地址，包含请求参数
     */
    public static String getFullRequestURL(String hostURL, HttpServletRequest request) {
        if (!hostURL.startsWith(request.getScheme())) {
            throw new IllegalArgumentException("非法的请求参数 hostURL:" + hostURL);
        }
        StringBuilder url = new StringBuilder(hostURL);
        if (!hostURL.endsWith("/")) {
            url.append("/");
        }
        url.append(request.getServletPath());
        String queryString = request.getQueryString();
        if (StringUtil.isNotBlank(queryString)) {
            url.append("?").append(queryString);
        }
        return url.toString();
    }
}
