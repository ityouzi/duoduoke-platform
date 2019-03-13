package com.fulihui.redisdubbo.demo.weixin.weixin.request;

import com.alibaba.fastjson.JSON;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.AuthAccessTokenWeixinResult;

/**
 * 微信获取授权access_token请求参数封装
 * Created by Willard on 2015/9/8.
 */
public class AuthAccessTokenWeixinRequest extends WeixinJsonRequest<AuthAccessTokenWeixinResult> {

    private static final long serialVersionUID = -8542137133128616460L;

    /**
     * 填写第一步获取的code参数
     * */
    private String            code;

    /**
     * 填写为authorization_code
     * */
    private String            grant_type       = "authorization_code";

    @Override
    protected void childParam() {
        addParam("code", code);
        addParam("grant_type", grant_type);
    }

    @Override
    public String service() {
        return "https://api.weixin.qq.com/sns/oauth2/access_token";
    }

    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public AuthAccessTokenWeixinResult parseResult(String respStr) {
        AuthAccessTokenWeixinResult result = JSON.parseObject(respStr,
            AuthAccessTokenWeixinResult.class);
        checkResult(result);
        return result;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.SSL_GET;
    }

    @Override
    public String requestData() {
        return null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
