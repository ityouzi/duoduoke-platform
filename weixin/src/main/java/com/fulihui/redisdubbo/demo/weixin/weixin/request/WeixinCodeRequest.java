package com.fulihui.redisdubbo.demo.weixin.weixin.request;

import java.util.Map;
import java.util.TreeMap;

import org.near.toolkit.common.StringUtil;

import com.alibaba.fastjson.JSON;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.WeixinCodeResult;
import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/12 0012 14:35
 */
@Setter @Getter
public class WeixinCodeRequest extends WeixinRequest<WeixinCodeResult> {
    private static final long serialVersionUID = 8975814043604338483L;
    private transient String access_token;
    private String scene;
    private String page;
    private int width = 180;
    private boolean auto_color;
    private Object line_color;
    private boolean is_hyaline;

    @Override
    public Map<String, String> urlParam() {
        Map<String, String> param = new TreeMap<>();
        if (StringUtil.isNotBlank(access_token)) {
            param.put("access_token", access_token);
        }
        return param;
    }

    @Override
    protected void childParam() {

    }


    @Override
    public String service() {
        return "https://api.weixin.qq.com/wxa/getwxacodeunlimit";
    }

    @Override
    public String urlEndStr() {
        return null;
    }


    @Override
    public WeixinCodeResult parseResult(String respStr) {
        WeixinCodeResult sendResult = new Gson().fromJson(respStr, WeixinCodeResult.class);
        sendResult.setSuccess(StringUtil.equals(sendResult.getErrcode(), "0") && StringUtil.equals(sendResult.getErrmsg(), "ok"));
        return sendResult;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }

    @Override
    public String requestData() {
        return JSON.toJSONString(this);
    }
}