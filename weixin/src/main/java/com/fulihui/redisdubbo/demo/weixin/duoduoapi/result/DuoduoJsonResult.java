package com.fulihui.redisdubbo.demo.weixin.duoduoapi.result;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/6 0006 16:10
 */
public class DuoduoJsonResult extends DuoduoResult {

    private static final long serialVersionUID = -1301760348595553532L;
    protected boolean success;
    protected String          error_code;
    protected String          error_msg;
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
