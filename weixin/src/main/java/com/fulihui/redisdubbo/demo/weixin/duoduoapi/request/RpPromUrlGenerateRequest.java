package com.fulihui.redisdubbo.demo.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.weixin.duoduoapi.result.RpPromUrlGenerateResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;

import lombok.Data;

/**
 *
 * 生成商城推广链接接口
 * @author lizhi
 * @date 2018-12-06
 */
@Data
public class RpPromUrlGenerateRequest extends DuoduoJsonRequest<RpPromUrlGenerateResult> {
    private static final long serialVersionUID = -8191004317304868808L;
    /**
     * 是否生成短链接。true-是，false-否，默认false
     */
    private boolean           generate_short_url;
    /**
     * 推广位列表，例如：["60005_612"]
     */
    private String            p_id_list;
    /**
     * 自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。
     */
    private String            custom_parameters;
    /**
     * 是否唤起微信客户端， 默认false 否，true 是
     */
    private boolean           generate_weapp_webview;
    /**
     * 唤起微信app推广短链接
     */
    private boolean           we_app_web_view_short_url;
    /**
     * 唤起微信app推广链接
     */
    private boolean           we_app_web_wiew_url;
    /**
     * 是否生成小程序推广
     */
    private boolean           generate_we_app;

    @Override
    protected void childParam() {
        addParam("generate_short_url", generate_short_url + "");
        addParam("p_id_list", p_id_list);
        addParam("custom_parameters", custom_parameters);
        addParam("generate_weapp_webview", generate_weapp_webview + "");
        addParam("we_app_web_view_short_url", we_app_web_view_short_url + "");
        addParam("we_app_web_wiew_url", we_app_web_wiew_url + "");
        addParam("generate_we_app", generate_we_app + "");

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
    public RpPromUrlGenerateResult parseResult(String respStr) {
        RpPromUrlGenerateResult result = JSONObject.parseObject(respStr,
            RpPromUrlGenerateResult.class);
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
