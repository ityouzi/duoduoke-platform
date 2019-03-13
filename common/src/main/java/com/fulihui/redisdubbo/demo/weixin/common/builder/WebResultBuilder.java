package com.fulihui.redisdubbo.demo.weixin.common.builder;

import com.fulihui.redisdubbo.demo.weixin.common.result.WebResult;

/**
 * @author: JY
 * @date: 2018/7/6 15:50
 */
public class WebResultBuilder {

    protected WebResult result;

    public WebResultBuilder() {
        result = new WebResult();
    }

    public WebResultBuilder(WebResult result) {
        this.result = result;
    }

    /**
     * 成功
     * @return
     */
    public WebResultBuilder ok() {
        result.setCode(WebResult.SUCCESS);
        result.setData(true);
        result.setMsg("ok");
        return this;
    }

    /**
     * 失败
     * @return
     */
    public WebResultBuilder error() {
        result.setCode(WebResult.FAIL);
        result.setData(false);
        result.setMsg("error");
        return this;
    }

    /**
     * 设置数据
     * @param data
     * @param <T>
     * @return
     */
    public <T> WebResultBuilder data(T data) {
        result.setData(data);
        return this;
    }

    public <T> WebResultBuilder dataExt(T dataExtMsg) {
        result.setDataExtMsg(dataExtMsg);
        return this;
    }

    /**
     * 设置消息
     * @param msg
     * @return
     */
    public WebResultBuilder msg(String msg) {
        result.setMsg(msg);
        return this;
    }

    /**
     * 设置Code
     * @param code
     * @return
     */
    public WebResultBuilder code(Integer code) {
        result.setCode(code);
        return this;
    }

    public WebResult builder() {
        return result;
    }

    /**
     * 构建PaeResult
     * @return
     */
    public WebPageResultBuilder page() {
        return new WebPageResultBuilder(result);
    }

}
