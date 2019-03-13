package com.fulihui.duoduoke.demo.web.weixin.weixin.request;

import com.alibaba.fastjson.JSON;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import com.fulihui.duoduoke.demo.web.weixin.weixin.result.OAuthUserInfoWeixinResult;

import lombok.Setter;

/**
 * 获取微信用户信息请求封装
 * Created by Willard on 2015/9/9.
 */
@Setter
public class OAuthUserInfoWeixinRequest extends WeixinJsonRequest<OAuthUserInfoWeixinResult> {
    private static final long serialVersionUID = 8163938314085547469L;

    /** 网页授权接口调用凭证 */
    private String accessToken;
    /** 用户的唯一标识 */
    private String openid;
    /** 返回国家地区语言版本 */
    private String lang;

    public OAuthUserInfoWeixinRequest() {
        lang = "zh_CN";
    }

    @Override
    protected void childParam() {
        addParam("access_token", accessToken);
        addParam("openid", openid);
        addParam("lang", lang);
    }

    @Override
    public String service() {
        return "https://api.weixin.qq.com/sns/userinfo";
    }

    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public OAuthUserInfoWeixinResult parseResult(String respStr) {
        OAuthUserInfoWeixinResult result = JSON.parseObject(respStr,
                OAuthUserInfoWeixinResult.class);
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

}
