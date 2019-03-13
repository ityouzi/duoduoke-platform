package com.fulihui.duoduoke.demo.web.weixin.weixin.result;

/**
 * 微信返回超类
 * Created by SSM on 2015/9/8.
 */
public class WeixinJsonResult extends WeixinResult {

    private static final long serialVersionUID = -9101467147209342206L;
    protected boolean success;
    protected String          errcode;
    protected String          errmsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
