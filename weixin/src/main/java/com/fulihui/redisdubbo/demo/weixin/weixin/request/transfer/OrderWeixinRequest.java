package com.fulihui.redisdubbo.demo.weixin.weixin.request.transfer;

import com.fulihui.redisdubbo.demo.weixin.weixin.request.WeixinRequest;

/**
 * 微信订单抽象请求对象
 * Created by Willard on 2015/9/17.
 */
public abstract class OrderWeixinRequest<T> extends WeixinRequest<T> {

    private static final long serialVersionUID = 5130287943719074065L;

    /* 公众账号ID Required */
    protected String          appid;

    /* 商户号 Required */
    protected String          mch_id;

    /* 设备号 */
    protected String          device_info;

    /* 随机字符串 Required */
    protected String          nonce_str;

    /* 签名 Required */
    protected String          sign;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
