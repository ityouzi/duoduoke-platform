package com.fulihui.duoduoke.demo.web.weixin.weixin.result;

/**
 * 接口调用凭证返回参数封装
 * Created by Willard on 2015/9/15.
 */
public class AccessTokenWeixinResult extends WeixinJsonResult {
    private static final long serialVersionUID = 8335301091383839970L;

    /* 获取到的凭证 */
    private String            access_token;

    /* 凭证有效时间，单位：秒 */
    private int               expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
