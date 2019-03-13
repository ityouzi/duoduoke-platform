package com.fulihui.redisdubbo.demo.weixin.weixin.request;


import java.util.Map;

import org.near.toolkit.model.ToString;

import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;

/**
 * 微信请求
 * Created by Willard on 2015/9/8.
 */
public abstract class WeixinRequest<T> extends ToString {
    private static final long serialVersionUID = 3774983044285476145L;

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
