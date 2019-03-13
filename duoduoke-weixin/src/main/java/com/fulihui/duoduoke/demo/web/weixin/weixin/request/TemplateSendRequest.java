package com.fulihui.duoduoke.demo.web.weixin.weixin.request;

import java.util.Map;
import java.util.TreeMap;

import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import org.near.toolkit.common.StringUtil;

import com.alibaba.fastjson.JSON;
import com.fulihui.duoduoke.demo.web.weixin.weixin.result.TemplateSendResult;
import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/12 0012 14:35
 */
@Setter
@Getter
public class TemplateSendRequest extends WeixinRequest<TemplateSendResult> {
    private static final long serialVersionUID = 8975814043604338483L;
    private transient String access_token;
    private String touser;
    private String template_id;
    private String page;
    private String form_id;
    private String emphasis_keyword;
    private Object data;

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
        return "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send";
    }

    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public TemplateSendResult parseResult(String respStr) {
        TemplateSendResult sendResult = new Gson().fromJson(respStr, TemplateSendResult.class);
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