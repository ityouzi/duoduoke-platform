package com.fulihui.redisdubbo.demo.weixin.common.except;

/**
 * @author lizhi
 */

public enum CommonErrors implements IError<Integer> {
    /**
     * 系统异常，请稍后再试
     */
    SYSTEM_ERROR(1, "系统异常，请稍后再试"),
    /**
     * 非法请求参数
     */
    ILLIGEAL_REQUEST_ERROR(2, "非法请求参数"),
    /**
     * 用户名密码错误
     */
    ACCOUNT_PASSWORD_FAILED(4, "用户名密码错误"),
    /**
     * 微信打款失败
     */
    WECHAT_PAY_ERROR(201, "微信打款失败"),
    /**
     * 用户账户的余额小于提现金额
     */
    ACCOUNT_SYSTEM_ERROR(5, "用户账户的余额小于提现金额"),
    /**
     * 用户账户的余额为空
     */
    ACCOUNT_ERROR(6, "用户账户的余额为空"),
    /**
     * 商户平台认证文件未查询到
     */
    CERT_FILE_SYSTEM_ERROR(8, "商户平台认证文件未查询到"),

    /**
     * 该用户已有提现的交易
     */
    USER_TRADE_ERROR(7, "该用户已有提现的交易"),


    /**
     * 自己不能跟自己补签
     */
    USER_SUPPLEMENT_SELF_ERROR(8, "自己不能跟自己补签"),

    ;

    int errcode;
    String errmsg;

    CommonErrors(int errcode, String errmsg) {
        this.errcode = 1000000 + errcode;
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
