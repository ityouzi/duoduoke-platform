package com.fulihui.duoduoke.demo.web.weixin.weixin.request;


import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

import lombok.Setter;

/**
 * 授权页面请求参数封装
 * Created by Willard on 2015/9/9.
 */
@Setter
public class OAuthWeixinRequest extends WeixinJsonRequest<String> {

    private static final long serialVersionUID = -5367257670435295180L;

    /** 授权后重定向的回调链接地址 */
    private String redirectUri;
    /** 返回类型，请填写code */
    private String responseType;
    /** 应用授权作用域 */
    private String scope;
    /** 重定向后会带上state参数 */
    private String state;

    public OAuthWeixinRequest() {
        responseType = "code";
    }

    @Override
    protected void childParam() {
        addParam("redirect_uri", redirectUri);
        addParam("response_type", responseType);
        addParam("scope", scope);
        addParam("state", state);
    }

    @Override
    public String service() {
        return "https://open.weixin.qq.com/connect/oauth2/authorize";
    }

    @Override
    public String urlEndStr() {
        return "#wechat_redirect";
    }

    @Override
    public String parseResult(String respStr) {
        return respStr;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.SSL_GET;
    }

    @Override
    public String requestData() {
        return null;
    }

}
