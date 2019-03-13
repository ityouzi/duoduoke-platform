package com.fulihui.redisdubbo.demo.weixin.duoduoapi.result;

import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018/7/6 0006
 */
public class DuoduoGoodsDetailApiResult extends ToString{

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
    private String  opt_name;
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

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public String getGoods_thumbnail_url() {
        return goods_thumbnail_url;
    }

    public void setGoods_thumbnail_url(String goods_thumbnail_url) {
        this.goods_thumbnail_url = goods_thumbnail_url;
    }

    public String getGoods_image_url() {
        return goods_image_url;
    }

    public void setGoods_image_url(String goods_image_url) {
        this.goods_image_url = goods_image_url;
    }

    public Integer getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(Integer sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public Integer getMin_group_price() {
        return min_group_price;
    }

    public void setMin_group_price(Integer min_group_price) {
        this.min_group_price = min_group_price;
    }

    public Integer getMin_normal_price() {
        return min_normal_price;
    }

    public void setMin_normal_price(Integer min_normal_price) {
        this.min_normal_price = min_normal_price;
    }

    public String getMall_name() {
        return mall_name;
    }

    public void setMall_name(String mall_name) {
        this.mall_name = mall_name;
    }

    public Integer getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(Integer opt_id) {
        this.opt_id = opt_id;
    }

    public String getOpt_name() {
        return opt_name;
    }

    public void setOpt_name(String opt_name) {
        this.opt_name = opt_name;
    }

    public boolean isHas_coupon() {
        return has_coupon;
    }

    public void setHas_coupon(boolean has_coupon) {
        this.has_coupon = has_coupon;
    }

    public String getCat_ids() {
        return cat_ids;
    }

    public void setCat_ids(String cat_ids) {
        this.cat_ids = cat_ids;
    }

    public Integer getCoupon_min_order_amount() {
        return coupon_min_order_amount;
    }

    public void setCoupon_min_order_amount(Integer coupon_min_order_amount) {
        this.coupon_min_order_amount = coupon_min_order_amount;
    }

    public Integer getCoupon_discount() {
        return coupon_discount;
    }

    public void setCoupon_discount(Integer coupon_discount) {
        this.coupon_discount = coupon_discount;
    }

    public Integer getCoupon_total_quantity() {
        return coupon_total_quantity;
    }

    public void setCoupon_total_quantity(Integer coupon_total_quantity) {
        this.coupon_total_quantity = coupon_total_quantity;
    }

    public Integer getCoupon_remain_quantity() {
        return coupon_remain_quantity;
    }

    public void setCoupon_remain_quantity(Integer coupon_remain_quantity) {
        this.coupon_remain_quantity = coupon_remain_quantity;
    }

    public String getCoupon_start_time() {
        return coupon_start_time;
    }

    public void setCoupon_start_time(String coupon_start_time) {
        this.coupon_start_time = coupon_start_time;
    }

    public String getCoupon_end_time() {
        return coupon_end_time;
    }

    public void setCoupon_end_time(String coupon_end_time) {
        this.coupon_end_time = coupon_end_time;
    }


    public String getGoods_eval_score() {
        return goods_eval_score;
    }

    public void setGoods_eval_score(String goods_eval_score) {
        this.goods_eval_score = goods_eval_score;
    }

    public Integer getPromotion_rate() {
        return promotion_rate;
    }

    public void setPromotion_rate(Integer promotion_rate) {
        this.promotion_rate = promotion_rate;
    }

    public Integer getGoods_eval_count() {
        return goods_eval_count;
    }

    public void setGoods_eval_count(Integer goods_eval_count) {
        this.goods_eval_count = goods_eval_count;
    }

    public Integer getAvg_desc() {
        return avg_desc;
    }

    public void setAvg_desc(Integer avg_desc) {
        this.avg_desc = avg_desc;
    }

    public Integer getAvg_lgst() {
        return avg_lgst;
    }

    public void setAvg_lgst(Integer avg_lgst) {
        this.avg_lgst = avg_lgst;
    }

    public Integer getAvg_serv() {
        return avg_serv;
    }

    public void setAvg_serv(Integer avg_serv) {
        this.avg_serv = avg_serv;
    }

    public String getGoods_gallery_urls() {
        return goods_gallery_urls;
    }

    public void setGoods_gallery_urls(String goods_gallery_urls) {
        this.goods_gallery_urls = goods_gallery_urls;
    }
}
