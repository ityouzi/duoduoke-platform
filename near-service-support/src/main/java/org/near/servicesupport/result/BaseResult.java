package org.near.servicesupport.result;

import org.near.toolkit.model.ToString;

/**
 * 基础返回封装
 * Created by willard on 16-2-26.
 */
public class BaseResult extends ToString {
    private static final long  serialVersionUID = -8086646618727821661L;
    public static final int    SUCCESS          = 0;
    public static final String SUCC_MSG         = "ok";

    /* 错误代码，初始化-1标示没有被赋值过，0为成功 */
    private int                errcode          = -1;
    /* 错误描述 */
    private String             errmsg           = "";

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
