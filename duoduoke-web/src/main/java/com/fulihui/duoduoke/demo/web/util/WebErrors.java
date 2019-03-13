package com.fulihui.duoduoke.demo.web.util;


import com.fulihui.duoduoke.demo.common.except.IError;

/**
 * h5 web 服务异常枚举，错误码区间起始值 201
 *
 * @author Administrator
 */
public enum WebErrors implements IError<Integer> {
    /**
     * 交易已受理，请等候
     */
    WECHAT_TRANS_UNKNOW(1, "交易已受理，请等候"),;

    Integer errcode;
    String errmsg;

    WebErrors(Integer errcode, String errmsg) {
        this.errcode = 2010000 + errcode;
        this.errmsg = errmsg;
    }

    @Override
    public Integer errcode() {
        return errcode;
    }

    @Override
    public String errmsg() {
        return errmsg;
    }
}
