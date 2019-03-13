package com.fulihui.redisdubbo.demo.api.response;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-9
 */
@Setter
@Getter
public class GoodsSearchInfoResponse extends ToString {

    private static final long serialVersionUID = -508087926394729238L;
    /**
     * 参与多多进宝的商品ID
     */
    private String goods_id;
    /**
     * 商品名称
     */
    private String goods_name;
    /**
     * 商品描述
     */
    private String goods_desc;
    /**
     * 商品缩略图
     */
    private String goods_thumbnail_url;
    /**
     * 商品主图
     */
    private String goods_image_url;
    /**
     * 商品详情图列表
     */
    private String goods_gallery_urls;

    /**
     * 已售卖件数
     */
    private Integer sold_quantity;
    /**
     * 最小拼团价格，单位为分
     */
    private Integer min_group_price;
    /**
     * 最小单买价格，单位为分
     */
    private Integer min_normal_price;
    /**
     * 店铺名称
     */
    private String mall_name;
    /**
     * 类目id
     */
    private Integer category_id;
    /**
     * 类目名称
     */
    private String category_name;

    private boolean has_coupon;
    /**
     * 优惠券门槛价格，单位为分
     */
    private Integer coupon_min_order_amount;
    /**
     * 优惠券面额，单位为分
     */
    private Integer coupon_discount;
    /**
     * 优惠券总数量
     */
    private Integer coupon_total_quantity;
    /**
     * 优惠券剩余数量
     */
    private Integer coupon_remain_quantity;
    /**
     * 优惠券生效时间，UNIX时间戳
     */
    private String coupon_start_time;
    /**
     * 优惠券失效时间，UNIX时间戳
     */
    private String coupon_end_time;
    /**
     * 佣金比例，千分比
     */
    private Integer promotion_rate;
    /**
     * 商品评价分
     */
    private Integer goods_eval_score;
    /**
     * 商品评价数量
     */
    private Integer goods_eval_count;
    /**
     * 类目
     */
    private Integer cat_id;
    /**
     * 描述评分
     */
    private Integer avg_desc;
    /**
     * 物流评分
     */
    private Integer avg_lgst;
    /**
     * 服务评分
     */
    private Integer avg_serv;

}
