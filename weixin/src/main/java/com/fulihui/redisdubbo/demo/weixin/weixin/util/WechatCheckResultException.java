package com.fulihui.redisdubbo.demo.weixin.weixin.util;

/**
 * 微信返回结果验证异常
 *
 * @author lizhi
 */
public class WechatCheckResultException extends RuntimeException {
    private static final long serialVersionUID = 8031713890467258841L;

    private String errcode;
    private String errmsg;

    public WechatCheckResultException(String errcode, String errmsg) {
        super(errmsg);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    @Override
    public String toString() {
        return "WechatCheckResultException{" + "errcode='" + errcode + '\'' + ", errmsg='" + errmsg
                + '\'' + '}';
    }
}
