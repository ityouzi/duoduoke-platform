package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import java.util.Map;

import org.near.toolkit.model.ToString;

import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/6 0006 16:10
 */
public abstract class DuoduoRequest<T> extends ToString {

    private static final long serialVersionUID = 27157892109885660L;

    public Map<String, String> urlParam() {
        return null;
    }

    abstract protected void childParam();

    abstract public String service();

    abstract public String urlEndStr();

    abstract public T parseResult(String respStr);

    abstract public HttpMethodEnum httpMethod();

    abstract public String requestData();
}
