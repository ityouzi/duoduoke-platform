package com.fulihui.redisdubbo.demo.weixin.weixin.request;

import com.alibaba.fastjson.JSON;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.AccessTokenWeixinResult;

/**
 * 接口调用凭证请求参数封装
 * Created by Willard on 2015/9/15.
 */
public class AccessTokenWeixinRequest extends WeixinJsonRequest<AccessTokenWeixinResult> {
    private static final long serialVersionUID = -8542137133128616460L;

    /**
    *
    *获取access_token填写client_credential
    *
     **/
    private String            grant_type       = "client_credential";

    @Override
    protected void childParam() {
        addParam("grant_type", grant_type);
    }

    @Override
    public String service() {
        return "https://api.weixin.qq.com/cgi-bin/token";
    }

    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public AccessTokenWeixinResult parseResult(String respStr) {
        AccessTokenWeixinResult result = JSON.parseObject(respStr, AccessTokenWeixinResult.class);
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

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
