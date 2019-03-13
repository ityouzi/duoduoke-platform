package org.near.webmvcsupport.error;

/**
 * 系统业务异常
 * Created by willa on 2015/10/30.
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 3167548619219259341L;

    private CommonError       error;

    public BizException(CommonError error) {
        super(error.getErrorMessage());
        this.error = error;
    }

    public BizException(String errCode, String errMsg) {
        super(errMsg);
        this.error = new SimpleCommonError(errCode, errMsg);
    }

    public BizException(CommonError error, Throwable cause) {
        super(error.getErrorMessage(), cause);
        this.error = error;
    }

    public BizException(String errCode, String errMsg, Throwable cause) {
        super(errMsg, cause);
        this.error = new SimpleCommonError(errCode, errMsg);
    }

    public CommonError getError() {
        return error;
    }
}
