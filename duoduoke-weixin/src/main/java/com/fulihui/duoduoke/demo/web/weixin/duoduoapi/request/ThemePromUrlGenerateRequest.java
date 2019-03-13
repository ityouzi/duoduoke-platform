package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.ThemePromUrlGenerateResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

import lombok.Data;

/**
 * Created by lizhi on 2018-12-06.
 */
@Data
public class ThemePromUrlGenerateRequest extends DuoduoJsonRequest<ThemePromUrlGenerateResult> {

    private static final long serialVersionUID = -5078227661285750327L;
    private String            pid;

    private String            theme_id_list;

    private boolean           generate_short_url;

    private boolean           generate_mobile;

    private String            custom_parameters;

    private boolean           generate_weapp_webview;

    private boolean           we_app_web_view_short_url;
    private boolean           we_app_web_wiew_url;

    @Override
    protected void childParam() {
        addParam("pid", pid);
        addParam("theme_id_list", theme_id_list);
        addParam("generate_short_url", generate_short_url + "");
        addParam("generate_mobile", generate_mobile + "");
        addParam("custom_parameters", custom_parameters);
        addParam("generate_weapp_webview", generate_weapp_webview + "");
        addParam("we_app_web_view_short_url", we_app_web_view_short_url + "");
        addParam("we_app_web_wiew_url", we_app_web_wiew_url + "");
    }

    @Override
    public String service() {
        return "http://gw-api.pinduoduo.com/api/router";
    }

    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public ThemePromUrlGenerateResult parseResult(String respStr) {
        ThemePromUrlGenerateResult result = JSONObject.parseObject(respStr,
            ThemePromUrlGenerateResult.class);
        checkResult(result);
        return result;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }

    @Override
    public String requestData() {
        return null;
    }
}
