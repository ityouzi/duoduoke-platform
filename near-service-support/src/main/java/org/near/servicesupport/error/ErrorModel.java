package org.near.servicesupport.error;

import org.near.toolkit.model.ToString;

/**
 * 错误模型
 * Created by Willard.Hu on 2016/4/28.
 */
public class ErrorModel extends ToString {
    private static final long serialVersionUID = -2631199550967941533L;
    private int               errcode;
    private String            errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
