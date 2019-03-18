package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result;

import java.util.List;

import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018-7-9.
 */
public class DuoGoodsSearchResult extends DuoJsonResult {

    private static final long serialVersionUID = 587531104576055239L;
    /**
     * goods_search_response : {"goods_list":[{"goods_id":595564668,"goods_name":"4条装/男士内裤高档纯棉弹力棉中腰平角内裤宽松大码吸湿透气内裤男短裤底裤裤头无痕内裤青年纯棉裆四角裤衩潮平角裤","goods_desc":null,"goods_thumbnail_url":"http://t04img.yangkeduo.com/images/2018-03-01/1ca25ffc5970a992d0e13d0f298280ee.jpeg","goods_image_url":"http://t05img.yangkeduo.com/images/2018-03-01/2948f580ade557320c7e9267f497940b.jpeg","goods_gallery_urls":null,"sold_quantity":67,"min_group_price":3890,"min_normal_price":4400,"mall_name":"雅姿网商","category_id":743,"category_name":"男装","has_coupon":true,"coupon_min_order_amount":3700,"coupon_discount":2000,"coupon_total_quantity":5000,"coupon_remain_quantity":3800,"coupon_start_time":1520870400,"coupon_end_time":1521475199,"promotion_rate":300,"goods_eval_score":0,"goods_eval_count":0,"cat_id":288,"avg_desc":494,"avg_lgst":494,"avg_serv":494}],"total_count":24}
     */

    private GoodsSearchResponseBean goods_search_response;

    public GoodsSearchResponseBean getGoods_search_response() {
        return goods_search_response;
    }

    public void setGoods_search_response(GoodsSearchResponseBean goods_search_response) {
        this.goods_search_response = goods_search_response;
    }

    public static class GoodsSearchResponseBean extends ToString {
        private static final long serialVersionUID = -7691353590085060862L;
        /**
         * goods_list : [{"goods_id":595564668,"goods_name":"4条装/男士内裤高档纯棉弹力棉中腰平角内裤宽松大码吸湿透气内裤男短裤底裤裤头无痕内裤青年纯棉裆四角裤衩潮平角裤","goods_desc":null,"goods_thumbnail_url":"http://t04img.yangkeduo.com/images/2018-03-01/1ca25ffc5970a992d0e13d0f298280ee.jpeg","goods_image_url":"http://t05img.yangkeduo.com/images/2018-03-01/2948f580ade557320c7e9267f497940b.jpeg","goods_gallery_urls":null,"sold_quantity":67,"min_group_price":3890,"min_normal_price":4400,"mall_name":"雅姿网商","category_id":743,"category_name":"男装","has_coupon":true,"coupon_min_order_amount":3700,"coupon_discount":2000,"coupon_total_quantity":5000,"coupon_remain_quantity":3800,"coupon_start_time":1520870400,"coupon_end_time":1521475199,"promotion_rate":300,"goods_eval_score":0,"goods_eval_count":0,"cat_id":288,"avg_desc":494,"avg_lgst":494,"avg_serv":494}]
         * total_count : 24
         */

        private Integer total_count;
        private List<GoodsListBean> goods_list;

        public Integer getTotal_count() {
            return total_count;
        }

        public void setTotal_count(Integer total_count) {
            this.total_count = total_count;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean extends ToString {
            private static final long serialVersionUID = -4247932458420259023L;
            /**
             * goods_id : 595564668
             * goods_name : 4条装/男士内裤高档纯棉弹力棉中腰平角内裤宽松大码吸湿透气内裤男短裤底裤裤头无痕内裤青年纯棉裆四角裤衩潮平角裤
             * goods_desc : null
             * goods_thumbnail_url : http://t04img.yangkeduo.com/images/2018-03-01/1ca25ffc5970a992d0e13d0f298280ee.jpeg
             * goods_image_url : http://t05img.yangkeduo.com/images/2018-03-01/2948f580ade557320c7e9267f497940b.jpeg
             * goods_gallery_urls : null
             * sold_quantity : 67
             * min_group_price : 3890
             * min_normal_price : 4400
             * mall_name : 雅姿网商
             * category_id : 743
             * category_name : 男装
             * has_coupon : true
             * coupon_min_order_amount : 3700
             * coupon_discount : 2000
             * coupon_total_quantity : 5000
             * coupon_remain_quantity : 3800
             * coupon_start_time : 1520870400
             * coupon_end_time : 1521475199
             * promotion_rate : 300
             * goods_eval_score : 0
             * goods_eval_count : 0
             * cat_id : 288
             * avg_desc : 494
             * avg_lgst : 494
             * avg_serv : 494
             */

            private String goods_id;
            private String goods_name;
            private String goods_desc;
            private String goods_thumbnail_url;
            private String goods_image_url;
            private String goods_gallery_urls;
            private Integer sold_quantity;
            private Integer min_group_price;
            private Integer min_normal_price;
            private String mall_name;
            private Integer category_id;
            private String category_name;
            private boolean has_coupon;
            private Integer coupon_min_order_amount;
            private Integer coupon_discount;
            private Integer coupon_total_quantity;
            private Integer coupon_remain_quantity;
            private String coupon_start_time;
            private String coupon_end_time;
            private Integer promotion_rate;
            private Integer goods_eval_score;
            private Integer goods_eval_count;
            private Integer cat_id;
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

            public String getGoods_gallery_urls() {
                return goods_gallery_urls;
            }

            public void setGoods_gallery_urls(String goods_gallery_urls) {
                this.goods_gallery_urls = goods_gallery_urls;
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

            public Integer getCategory_id() {
                return category_id;
            }

            public void setCategory_id(Integer category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public boolean isHas_coupon() {
                return has_coupon;
            }

            public void setHas_coupon(boolean has_coupon) {
                this.has_coupon = has_coupon;
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

            public Integer getPromotion_rate() {
                return promotion_rate;
            }

            public void setPromotion_rate(Integer promotion_rate) {
                this.promotion_rate = promotion_rate;
            }

            public Integer getGoods_eval_score() {
                return goods_eval_score;
            }

            public void setGoods_eval_score(Integer goods_eval_score) {
                this.goods_eval_score = goods_eval_score;
            }

            public Integer getGoods_eval_count() {
                return goods_eval_count;
            }

            public void setGoods_eval_count(Integer goods_eval_count) {
                this.goods_eval_count = goods_eval_count;
            }

            public Integer getCat_id() {
                return cat_id;
            }

            public void setCat_id(Integer cat_id) {
                this.cat_id = cat_id;
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
        }
    }
}
