package com.fulihui.redisdubbo.demo.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.weixin.duoduoapi.result.DuoduoCmsPromUrlGenerateResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lizhi
 * @date 2018-12-05
 */
@Setter
@Getter
public class DuoduoCmsPromUrlGenerateRequest extends
                                             DuoduoJsonRequest<DuoduoCmsPromUrlGenerateResult> {
    private static final long serialVersionUID = 1651503032322651393L;
    /**
     * 非必填 是否生成短链接。true-是，false-否，默认false
     */
    private boolean           generate_short_url;

    /**
     *  推广位列表，例如：["60005_612"]
     */

    private String            p_id_list;

    /**
     * 非必填     是否生成手机跳转链接。true-是，false-否，默认false
     */
    private boolean           generate_mobile;

    /**
     * 非必填
     */
    private boolean           multi_group;
    /**
     * 自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。
     */
    private String            custom_parameters;

    /**
     * 是否唤起微信客户端， 默认false 否，true 是
     */

    private boolean           generate_weapp_webview;
    /**
     * 是否唤起微信客户端， 默认false 否，true 是
     */
    private boolean           we_app_web_view_short_url;
    /**
     * 唤起微信app推广链接
     */
    private boolean           we_app_web_view_url;
    /**
     * 0, "1.9包邮"；1, "今日爆款"； 2, "品牌清仓"； 4,"PC端专属商城"；5，“赚多多币兑现金”；不传值为默认商城；
     */
    private Integer           channel_type;

    @Override
    protected void childParam() {

        addParam("generate_short_url", generate_short_url + "");
        addParam("p_id_list", p_id_list);
        addParam("generate_mobile", generate_mobile + "");
        addParam("multi_group", multi_group + "");
        addParam("custom_parameters", custom_parameters + "");
        addParam("generate_weapp_webview", generate_weapp_webview + "");
        addParam("we_app_web_view_short_url", we_app_web_view_short_url + "");
        addParam("we_app_web_view_url", we_app_web_view_url + "");
        addParam("channel_type", channel_type + "");

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
    public DuoduoCmsPromUrlGenerateResult parseResult(String respStr) {
        DuoduoCmsPromUrlGenerateResult result = JSONObject.parseObject(respStr,
            DuoduoCmsPromUrlGenerateResult.class);
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
