package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

/**
 * @author lizhi
 * @date 2018-7-8
 */
@Setter
@Getter
public class GoodsPromotionGenerateRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = 6384947339888377572L;
    /**
     * 推广位ID
     * <p>
     * 必填
     */
    private String            p_id;
    /**
     * 推广位ID
     * <p>
     * 必填
     * 商品ID，仅支持单个查询
     */
    private String            goods_id_list;

    /**
     * 必填
     * <p>
     * 是否生成短链接，true-是，false-否
     */
    private boolean           generate_short_url;
    /**
     * 自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。
     */
    private String            custom_parameters;
    /**
     * 1、单人团推广链接：用户访问单人团推广链接H5页面，
     * 可直接购买商品无需拼团。
     * （若用户访问APP，则按照多人团推广链接处理）2、多人团推广链接
     * ：用户访问双人团推广链接开团，若用户分享给他人参团，则开团者和参团者的佣金均结算给推手。
     */
    private boolean           multi_group;

    /**
     * 是否生成小程序推广
     */
    private boolean           generate_we_app;
    /**
     * 是否生成唤起微信客户端链接，true-是，false-否，默认false
     */
    private Boolean           generate_weapp_webview;

}
