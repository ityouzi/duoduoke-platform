package org.near.webmvcsupport.error;

/**
 *
 * Created by Willard.Hu on 2016/5/9.
 */
public class SimpleCommonError implements CommonError {
    private String errCode;
    private String errMsg;

    public SimpleCommonError(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public String getErrorCode() {
        return errCode;
    }

    @Override
    public String getErrorMessage() {
        return errMsg;
    }
}
