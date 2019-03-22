package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018/7/6 0006
 */
@Setter
@Getter
public class DuoGoodsDetailApiResult extends ToString {

    private static final long serialVersionUID = -8152980452929248723L;
    private String goods_id;
    private String goods_name;
    private String goods_desc;
    private String goods_thumbnail_url;
    private String goods_image_url;
    private Integer sold_quantity;
    private String goods_gallery_urls;
    private Integer min_group_price;
    private Integer min_normal_price;
    private String mall_name;
    private Integer opt_id;
    private String opt_name;
    private boolean has_coupon;
    private String cat_ids;
    private Integer coupon_min_order_amount;
    private Integer coupon_discount;
    private Integer coupon_total_quantity;
    private Integer coupon_remain_quantity;
    private String coupon_start_time;
    private String coupon_end_time;
    private Integer promotion_rate;
    private String goods_eval_score;
    private Integer goods_eval_count;
    private Integer avg_desc;
    private Integer avg_lgst;
    private Integer avg_serv;

}
