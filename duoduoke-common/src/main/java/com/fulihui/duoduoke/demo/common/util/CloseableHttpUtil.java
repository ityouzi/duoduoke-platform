package com.fulihui.duoduoke.demo.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Closeable http util.
 *
 * @author lizhi
 * @date 2018 -7-7
 */
public class CloseableHttpUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloseableHttpUtil.class);

    /**
     * Send template post string.
     *
     * @param url   the url
     * @param param the param
     * @return string
     * @throws IOException the io exception
     */
    public static String sendTemplatePost(String url, String param) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        LOGGER.info("sendTemplatePost,request-url:{},param:{}", url, param);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        // 解决中文乱码问题
        StringEntity stringEntity = new StringEntity(param, "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(stringEntity);
        LOGGER.info("Executing request :{}", httpPost.getRequestLine());
        // Create a custom response handler
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
        String responseBody = httpclient.execute(httpPost, responseHandler);
        LOGGER.info("responseBody:{}", responseBody);
        return responseBody;
    }


    /**
     * Do post string.
     *
     * @param url       the url
     * @param paramsMap the params map
     * @return string string
     */
    public static String doPost(String url, Map<String, Object> paramsMap) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(5 * 1000).setConnectionRequestTimeout(5 * 1000)
                .setSocketTimeout(5 * 1000).setRedirectsEnabled(true).build();
        httpPost.setConfig(requestConfig);

        List<NameValuePair> list = new ArrayList<>();
        for (String key : paramsMap.keySet()) {
            list.add(new BasicNameValuePair(key, String.valueOf(paramsMap.get(key))));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            LOGGER.info("httpPost ======>>>{} ", EntityUtils.toString(httpPost.getEntity()));
            HttpResponse response = httpClient.execute(httpPost);
            String strResult;
            if (response.getStatusLine().getStatusCode() == 200) {
                strResult = EntityUtils.toString(response.getEntity());
                LOGGER.info("success Response: {}", strResult);
                return strResult;
            } else {
                LOGGER.error("Error Response: {}", response.getStatusLine().toString());
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("post failure :caused by-->{}", e.getMessage());
            return null;
        } finally {
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}
