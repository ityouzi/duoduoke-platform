package com.fulihui.redisdubbo.demo.weixin.weixin.result;

import lombok.Data;

/**
 * 微信获取授权access_token返回参数封装
 *
 * @author Willard
 * @date 2015/9/8
 */
@Data
public class AuthAccessTokenWeixinResult extends WeixinJsonResult {

    private static final long serialVersionUID = -8529833110945463050L;

    private String            access_token;

    private String            expires_in;

    private String            refresh_token;

    private String            openid;

    private String            scope;

    private String            unionid;

}
