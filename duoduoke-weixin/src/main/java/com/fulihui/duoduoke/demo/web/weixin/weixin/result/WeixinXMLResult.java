package com.fulihui.duoduoke.demo.web.weixin.weixin.result;


import com.fulihui.duoduoke.demo.web.weixin.weixin.util.WechatCheckResultException;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信xml返回
 */
@Getter
@Setter
public class WeixinXMLResult extends WeixinResult {
    private static final long serialVersionUID = -1762921803717637141L;
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";

    @XStreamAlias("return_code")
    protected String returnCode;
    @XStreamAlias("return_msg")
    protected String returnMsg;
    /**
     * 业务结果
     */
    @XStreamAlias("result_code")
    protected String resultCode;
    /**
     * 错误代码
     */
    @XStreamAlias("err_code")
    protected String errCode;
    /**
     * 错误代码描述
     */
    @XStreamAlias("err_code_des")
    protected String errCodeDes;

    public boolean isSuccess() {
        return SUCCESS.equals(returnCode) && SUCCESS.equals(resultCode);
    }

    public void check() {
        if (!SUCCESS.equals(returnCode)) {
            throw new WechatCheckResultException(returnCode, returnMsg);
        }
        if (!SUCCESS.equals(resultCode)) {
            throw new WechatCheckResultException(errCode, errCodeDes);
        }
    }
}
