package com.fulihui.duoduoke.demo.web.weixin.duoduoapi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.near.toolkit.common.StringUtil;
import org.springframework.stereotype.Component;

import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request.DuoRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.DuoResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpClientUtil;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpClientUtilRequest;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/6 0006 16:04
 */
@Component
public class DuoduoHttpClientImpl implements DuoduoHttpClient {


    @Override
    public <T extends DuoResult> T invokeService(DuoRequest<T> request) {
        if (StringUtil.isBlank(request.service())) {
            throw new IllegalArgumentException("service can not be blank");
        }
        String resp;
        HttpClientUtilRequest httpClientUtilRequest = new HttpClientUtilRequest();
        httpClientUtilRequest.setUrl(request.service());
        httpClientUtilRequest.setParams(request.urlParam());
        httpClientUtilRequest.setData(request.requestData());
        httpClientUtilRequest.setUrlFoot(request.urlEndStr());

        switch (request.httpMethod()) {
            case SSL_GET:
                resp = HttpClientUtil.doSSLGet(httpClientUtilRequest);
                break;
            case SSL_POST:
                resp = HttpClientUtil.doSSLPost(httpClientUtilRequest);
                break;
            case GET:
                resp = HttpClientUtil.doGet(httpClientUtilRequest);
                break;
            case POST:
                resp = HttpClientUtil.doPost(httpClientUtilRequest);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported http method:"
                        + request.httpMethod().name());
        }
        return request.parseResult(resp);
    }

    /**
     * @see
     */
    @Override
    public String assembleURL(DuoRequest<String> request) {
        if (StringUtil.isBlank(request.service())) {
            throw new IllegalArgumentException("service can not be blank");
        }
        Map<String, String> param = request.urlParam();
        StringBuilder sb = new StringBuilder();
        sb.append(request.service());
        if (param != null && !param.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : param.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                try {
                    sb.append(entry.getKey()).append("=")
                            .append(URLEncoder.encode(entry.getValue(), "utf-8"));
                } catch (UnsupportedEncodingException ignore) {
                }
            }
        }
        if (StringUtil.isNotBlank(request.urlEndStr())) {
            sb.append(request.urlEndStr());
        }
        return sb.toString();
    }
}
