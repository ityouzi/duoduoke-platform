package com.fulihui.redisdubbo.demo.weixin.weixin;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.near.toolkit.common.StringUtil;
import org.springframework.stereotype.Component;

import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpClientUtil;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpClientUtilRequest;
import com.fulihui.redisdubbo.demo.weixin.weixin.request.WeixinRequest;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.WeixinResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.util.CertInfo;
import com.fulihui.redisdubbo.demo.weixin.weixin.util.CertUtil;

/**
 * WeixinClient 实现类
 *
 * @author lizhi
 */
@Component
public class WeixinClientImpl implements WeixinClient {

    /**
     * @see WeixinClient#invokeService(WeixinRequest)
     */
    @Override
    public <T extends WeixinResult> T invokeService(WeixinRequest<T> request) {
        if (StringUtil.isBlank(request.service())) {
            throw new IllegalArgumentException("service can not be blank");
        }
        String resp;
        HttpClientUtilRequest httpClientUtilRequest = new HttpClientUtilRequest();
        httpClientUtilRequest.setUrl(request.service());
        httpClientUtilRequest.setParams(request.urlParam());
        httpClientUtilRequest.setData(request.requestData());
        httpClientUtilRequest.setUrlFoot(request.urlEndStr());

        CertInfo certInfo;
        switch (request.httpMethod()) {
            case SSL_GET:
                resp = HttpClientUtil.doSSLGet(httpClientUtilRequest);
                break;
            case CERT_SSL_GET:
                certInfo = CertUtil.getCertInfo();
                httpClientUtilRequest.setCertFile(certInfo.getCertFile());
                httpClientUtilRequest.setCertPwd(certInfo.getCertPwd());
                resp = HttpClientUtil.doCertSSLGet(httpClientUtilRequest);
                break;
            case SSL_POST:
                resp = HttpClientUtil.doSSLPost(httpClientUtilRequest);
                break;
            case POST:
                resp = HttpClientUtil.doPost(httpClientUtilRequest);
                break;
            case CERT_SSL_POST:
                certInfo = CertUtil.getCertInfo();
                httpClientUtilRequest.setCertFile(certInfo.getCertFile());
                httpClientUtilRequest.setCertPwd(certInfo.getCertPwd());
                resp = HttpClientUtil.doCertSSLPost(httpClientUtilRequest);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported http method:"
                        + request.httpMethod().name());
        }
        return request.parseResult(resp);
    }

    /**
     * @see WeixinClient#assembleURL(WeixinRequest)
     */
    @Override
    public String assembleURL(WeixinRequest<String> request) {
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
