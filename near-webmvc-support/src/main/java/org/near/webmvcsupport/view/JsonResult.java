package org.near.webmvcsupport.view;

import org.near.toolkit.model.ToString;

/**
 * json返回对象
 * Created by Willard.Hu on 2016/5/9.
 */
public class JsonResult<T> extends ToString {
    private static final long serialVersionUID = 6183808108104989362L;
    private boolean           success;
    private String            errorCode;
    private String            errorMessage;
    private T                 info;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
