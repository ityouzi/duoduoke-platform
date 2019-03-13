package com.fulihui.duoduoke.demo.web.weixin.weixin.http;


import com.fulihui.duoduoke.demo.web.weixin.weixin.util.LoggerUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;


/**
 * Http client 工具类
 *
 * @author
 */
public class HttpClientUtil {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger("HTTPCLIENT_UTIL_LOG");

    /**
     * GET请求
     */
    public static String doGet(HttpClientUtilRequest request) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String fullUrl = genFullGetUrl(request.getUrl(), request.getParams(), request.getUrlFoot());
            return executeGet(httpClient, fullUrl);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * HTTPS GET请求 无需证书
     */
    public static String doSSLGet(HttpClientUtilRequest request) {
        try (CloseableHttpClient httpClient = genSSLHttpClient()) {
            String fullUrl = genFullGetUrl(request.getUrl(), request.getParams(),
                    request.getUrlFoot());
            return executeGet(httpClient, fullUrl);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * HTTPS GET请求 需要证书
     */
    public static String doCertSSLGet(HttpClientUtilRequest request) {
        try (CloseableHttpClient httpClient = genCertSSLHttpClient(request.getCertFile(),
                request.getCertPwd())) {
            String fullUrl = genFullGetUrl(request.getUrl(), request.getParams(),
                    request.getUrlFoot());
            return executeGet(httpClient, fullUrl);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取全Get请求路径
     */
    private static String genFullGetUrl(String url, Map<String, String> params, String urlFoot) {
        String paramStr = paramsMapToString(params);
        StringBuilder fullUrl = new StringBuilder(url);
        if (StringUtil.isNotBlank(paramStr)) {
            fullUrl.append("?").append(paramStr);
        }
        if (StringUtil.isNotBlank(urlFoot)) {
            fullUrl.append(urlFoot);
        }
        return fullUrl.toString();
    }

    /**
     * GET请求公共处理部分
     */
    private static String executeGet(CloseableHttpClient httpClient, String fullURL) {
        long start = System.currentTimeMillis();
        logger.info("[GET] - {}", fullURL);
        HttpGet httpGet = new HttpGet(fullURL);
        CloseableHttpResponse response = null;
        int status = 0;
        String resp = "-";
        try {
            response = httpClient.execute(httpGet);
            if (response != null && (status = response.getStatusLine().getStatusCode()) == 200) {
                HttpEntity entity = response.getEntity();
                resp = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            // status, resp, {used}ms
            logger.info("{}, {}, {}ms", status,
                    logger.isDebugEnabled() ? resp : LoggerUtils.cutString(resp, 50, 20),
                    System.currentTimeMillis() - start);
            if (!httpGet.isAborted()) {
                httpGet.abort();
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return resp;
    }

    /**
     * POST请求
     */
    public static String doPost(HttpClientUtilRequest request) {
        String resp = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            // 如果有请求体，params当作请求参数，否则params当form表单
            if (StringUtil.isBlank(request.getData())) {
                resp = executePost(httpclient, request.getUrl(), request.getParams());
            } else {
                String fullUrl = genFullGetUrl(request.getUrl(), request.getParams(),
                        request.getUrlFoot());
                resp = executePost(httpclient, fullUrl, request.getData());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resp;
    }

    /**
     * 执行https post请求 无需证书
     */
    public static String doSSLPost(HttpClientUtilRequest request) {
        String resp = null;
        try (CloseableHttpClient httpclient = genSSLHttpClient()) {
            // 如果有请求体，params当作请求参数，否则params当form表单
            if (StringUtil.isBlank(request.getData())) {
                resp = executePost(httpclient, request.getUrl(), request.getParams());
            } else {
                String fullUrl = genFullGetUrl(request.getUrl(), request.getParams(),
                        request.getUrlFoot());
                resp = executePost(httpclient, fullUrl, request.getData());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resp;
    }

    /**
     * 执行https post请求 需要证书
     */
    public static String doCertSSLPost(HttpClientUtilRequest request) {
        String resp = null;
        try (CloseableHttpClient httpclient = genCertSSLHttpClient(request.getCertFile(),
                request.getCertPwd())) {
            // 如果有请求体，params当作请求参数，否则params当form表单
            if (StringUtil.isBlank(request.getData())) {
                resp = executePost(httpclient, request.getUrl(), request.getParams());
            } else {
                String fullUrl = genFullGetUrl(request.getUrl(), request.getParams(),
                        request.getUrlFoot());
                resp = executePost(httpclient, fullUrl, request.getData());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resp;
    }

    private static String executePost(CloseableHttpClient httpclient, String url, Map<String, String> formParams)
            throws UnsupportedEncodingException {
        List<NameValuePair> valuePairs = new ArrayList<>();
        if (formParams != null && !formParams.isEmpty()) {
            for (Map.Entry<String, String> entry : formParams.entrySet()) {
                valuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return executePost(httpclient, url, new UrlEncodedFormEntity(valuePairs));
    }

    private static String executePost(CloseableHttpClient httpclient, String url, String requestBody) {
        return executePost(httpclient, url, new StringEntity(requestBody, "utf-8"));
    }

    /**
     * 执行http post请求
     */
    private static String executePost(CloseableHttpClient httpclient, String url, HttpEntity reqEntity) {
        logger.info("[POST] - {}, {}", url, reqEntity);
        long start = System.currentTimeMillis();
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;
        int status = 0;
        String resp = "-";
        try {
            httpPost = new HttpPost(url);
            httpPost.setEntity(reqEntity);
            response = httpclient.execute(httpPost);

            if (response != null && (status = response.getStatusLine().getStatusCode()) == 200) {
                HttpEntity respEntity = response.getEntity();
                resp = EntityUtils.toString(respEntity, "utf-8");
                EntityUtils.consume(respEntity);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            // status, resp, {used}ms
            logger.info("{}, {}, {}ms", status,
                    logger.isDebugEnabled() ? resp : LoggerUtils.cutString(resp, 50, 20),
                    System.currentTimeMillis() - start);
            if (httpPost != null && !httpPost.isAborted()) {
                httpPost.abort();
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return resp;
    }

    /**
     * 获取有ssl特性的httpclient，用于https请求
     */
    private static CloseableHttpClient genSSLHttpClient() throws KeyManagementException,
            NoSuchAlgorithmException {
        SSLContext sslContext = SSLContext.getInstance("SSL");
        // 不让https请求校验证书
        sslContext.init(null, new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] xcs, String string)
                    throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] xcs, String string)
                    throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }}, null);

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    /**
     * 需要证书的https请求处理
     */
    private static CloseableHttpClient genCertSSLHttpClient(String certFile, String certPwd)
            throws Exception {
        if (StringUtil.isBlank(certFile)) {
            throw new IllegalArgumentException("certFile can not be blank");
        }
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (FileInputStream instream = new FileInputStream(new File(certFile))) {
            keyStore.load(instream, certPwd.toCharArray());
        }
        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, certPwd.toCharArray()).build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
                new String[]{"TLSv1"}, null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    /**
     * map转String形式的http url，?k=v&k=v...
     * k按字符串排序
     *
     * @param params map参数
     * @return 请求参数字符串
     */
    public static String paramsSortedMapToString(Map<String, String> params) {
        return paramsMapToString(new TreeMap<>(params));
    }

    /**
     * map转String形式的http url，?k=v&k=v...
     *
     * @param params map参数
     * @return 请求参数字符串
     */
    public static String paramsMapToString(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return StringUtil.EMPTY_STRING;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }

    /**
     * http url字符串参数转map
     *
     * @param params 请求参数字符串 k1=v1&k2=v2&k3=v3
     * @return map集合
     */
    public static Map<String, String> paramsStringToMap(String params) {
        String[] kvary = StringUtil.split(params, '&');
        if (kvary == null || kvary.length == 0) {
            return Collections.emptyMap();
        }
        Map<String, String> mapParm = new HashMap<>();
        for (String kv : kvary) {
            if (!StringUtil.contains(kv, '=')) {
                throw new IllegalArgumentException("url params:" + params);
            }
            String[] k_v = StringUtil.split(kv, "=");
            mapParm.put(k_v[0], k_v[1]);
        }
        return mapParm;
    }

}
