package com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer;

import com.fulihui.redisdubbo.demo.weixin.weixin.result.WeixinXMLResult;

/**
 * 微信订单接口返回抽象
 * Created by Willard on 2015/9/17.
 */
public abstract class OrderWeixinResult extends WeixinXMLResult {
    private static final long serialVersionUID = 5479614115387505422L;

    /* 公众账号ID */
    protected String          appid;

    /* 商户号 */
    protected String          mch_id;

    /* 设备号 */
    protected String          device_info;

    /* 随机字符串 */
    protected String          nonce_str;

    /* 签名 */
    protected String          sign;

    /* 业务结果 */
    protected String          result_code;

    /* 错误代码 */
    protected String          err_code;

    /* 错误代码描述 */
    protected String          err_code_des;

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

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }
}
