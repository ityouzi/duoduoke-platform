package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.GoodsPromotionUrlGenerateResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 生成多多进宝商品推广链接
 *
 * @author lizhi
 * @date 2018-7-8
 */
@Setter
@Getter
public class DuoGoodsGenerateRequest extends DuoJsonRequest<GoodsPromotionUrlGenerateResult> {

    private static final long serialVersionUID = 2280213285246906402L;
    /**
     * 推广位ID
     */
    private String            p_id;

    /**
     * 商品ID，仅支持单个查询
     */
    private String            goods_id_list;

    private boolean           generate_short_url;

    private boolean           multi_group;
    /**
     * 自定义参数
     */
    private String            custom_parameters;
    /**
     * 是否生成小程序推广
     */
    private boolean           generate_we_app;
    /**
     * 是否生成唤起微信客户端链接，true-是，false-否，默认false
     */
    private boolean           generate_weapp_webview;

    /**
     * goods_id_list
     * <p>
     * string
     * <p>
     * 必填
     * <p>
     * 商品ID，仅支持单个查询
     * <p>
     * generate_short_url
     * <p>
     * boolean
     * <p>
     * 必填
     * <p>
     * 是否生成短链接，true-是，false-否
     * <p>
     * multi_group
     * <p>
     * boolean
     * <p>
     * 非必填
     * <p>
     * true--生成多人团推广链接 false--生成单人团推广链接（默认false）1、单人团推广链接：用户访问单人团推广链接H5页面，可直接购买商品无需拼团。（若用户访问APP，则按照多人团推广链接处理）2、多人团推广链接：用户访问双人团推广链接开团，若用户分享给他人参团，则开团者和参团者的佣金均结算给推手。
     * <p>
     * custom_parameters
     * <p>
     * string
     * <p>
     * 非必填
     * <p>
     * 自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。
     */
    @Override
    protected void childParam() {
        addParam("p_id", p_id);
        addParam("goods_id_list", goods_id_list);
        addParam("generate_short_url", generate_short_url + "");
        addParam("custom_parameters", custom_parameters);
        addParam("multi_group", multi_group + "");
        addParam("generate_we_app", generate_we_app + "");
        addParam("generate_weapp_webview", generate_weapp_webview + "");
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
    public GoodsPromotionUrlGenerateResult parseResult(String respStr) {
        GoodsPromotionUrlGenerateResult result = JSONObject.parseObject(respStr,
            GoodsPromotionUrlGenerateResult.class);
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
