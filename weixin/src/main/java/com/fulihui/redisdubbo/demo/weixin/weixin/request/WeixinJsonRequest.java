package com.fulihui.redisdubbo.demo.weixin.weixin.request;

import java.util.Map;
import java.util.TreeMap;

import org.near.toolkit.common.StringUtil;

import com.fulihui.redisdubbo.demo.weixin.weixin.result.WeixinJsonResult;

/**
 * 微信请求
 *
 */
public abstract class WeixinJsonRequest<T> extends WeixinRequest<T> {
    private static final long     serialVersionUID = 3774983044285476145L;

    /** 公众号的唯一标识 */
    protected String              appid;
    /** 公众号的appsecret */
    protected String              secret;

    /** 参数 */
    protected Map<String, String> param            = new TreeMap<>();

    @Override
    public Map<String, String> urlParam() {
        addParam("appid", appid);
        addParam("secret", secret);
        childParam();
        return param;
    }

    protected void addParam(String key, String value) {
        if (StringUtil.isNotBlank(value)) {
            param.put(key, value);
        }
    }

    protected void checkResult(WeixinJsonResult result) {
        result
            .setSuccess(StringUtil.isBlank(result.getErrcode()) || "0".equals(result.getErrcode()));
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
