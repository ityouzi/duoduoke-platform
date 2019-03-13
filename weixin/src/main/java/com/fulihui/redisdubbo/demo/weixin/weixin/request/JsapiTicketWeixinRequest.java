package com.fulihui.redisdubbo.demo.weixin.weixin.request;

import com.alibaba.fastjson.JSON;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.JsapiTicketWeixinResult;



/**
 * jsapi票据接口请求参数
 * Created by Willard on 2015/9/24.
 */
public class JsapiTicketWeixinRequest extends WeixinJsonRequest<JsapiTicketWeixinResult> {
    private static final long serialVersionUID = 6069580201782627647L;

    private String access_token;
    private String type = "jsapi";

    @Override
    protected void childParam() {
        addParam("access_token", access_token);
        addParam("type", type);
    }

    @Override
    public String service() {
        return "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    }

    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public JsapiTicketWeixinResult parseResult(String respStr) {
        JsapiTicketWeixinResult result = JSON.parseObject(respStr, JsapiTicketWeixinResult.class);
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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
