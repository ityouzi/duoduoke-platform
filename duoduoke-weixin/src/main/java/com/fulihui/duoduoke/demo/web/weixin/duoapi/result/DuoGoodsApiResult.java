package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Data;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/11 0011 18:39
 */
@Data
public class DuoGoodsApiResult extends ToString {

    private String goods_id;//商品id
    private String goods_name; //商品name
    private String goods_desc;//商品描述
    private String goods_thumbnail_url;//商品缩略图
    private String goods_image_url;//商品主图
    private Integer sold_quantity;//已售卖件数
    private Integer min_group_price;//最小单买价格，单位为分
    private Integer min_normal_price;//最小拼团价格，单位为分
    private String mall_name;//店铺名称
    private Integer opt_id;//商品标签ID
    private String opt_name;//商品标签名
    private boolean has_coupon;
    private String cat_ids;//类目id
    private Integer coupon_min_order_amount;//优惠券门槛价格，单位为分
    private Integer coupon_discount;//优惠券面额，单位为分
    private Integer coupon_total_quantity;//优惠券总数量
    private Integer coupon_remain_quantity;//优惠券剩余数量
    private String coupon_start_time;//优惠券生效时间，UNIX时间戳
    private String coupon_end_time;//优惠券失效时间，UNIX时间戳
    private Integer promotion_rate;//佣金比例，千分比
    private String goods_eval_score;//商品评价分
    private Integer goods_eval_count;//商品评价数量
    private Integer avg_desc;//描述评分
    private Integer avg_lgst;//物流评分
    private Integer avg_serv;//服务评分
    private Integer sale_num24;//今日成交量

}
