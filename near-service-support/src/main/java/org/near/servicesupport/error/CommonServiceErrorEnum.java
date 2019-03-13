package org.near.servicesupport.error;

/**
 * 公共异常 错误码 100-199
 * <p>已废弃，后续使用 Errors.Commons</p>
 *
 * @author Willard.Hu
 * @date 2016/3/3
 */

public enum CommonServiceErrorEnum implements ServiceError {

    SYSTEM_ERROR(100, "系统异常"),

    REQUEST_PARAMETER_ERROR(101, "请求参数错误"),

    ;

    private int errcode;
    private String errmsg;

    CommonServiceErrorEnum(int errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    @Override
    public int getErrcode() {
        return errcode;
    }

    @Override
    public String getErrmsg() {
        return errmsg;
    }
}
