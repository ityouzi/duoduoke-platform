package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-9
 */
@Data
public class DuoGoodsSearchResult extends DuoJsonResult {

    private static final long serialVersionUID = 587531104576055239L;
    /**
     * goods_search_response : {"goods_list":[{"goods_id":595564668,"goods_name":"4条装/男士内裤高档纯棉弹力棉中腰平角内裤宽松大码吸湿透气内裤男短裤底裤裤头无痕内裤青年纯棉裆四角裤衩潮平角裤","goods_desc":null,"goods_thumbnail_url":"http://t04img.yangkeduo.com/images/2018-03-01/1ca25ffc5970a992d0e13d0f298280ee.jpeg","goods_image_url":"http://t05img.yangkeduo.com/images/2018-03-01/2948f580ade557320c7e9267f497940b.jpeg","goods_gallery_urls":null,"sold_quantity":67,"min_group_price":3890,"min_normal_price":4400,"mall_name":"雅姿网商","category_id":743,"category_name":"男装","has_coupon":true,"coupon_min_order_amount":3700,"coupon_discount":2000,"coupon_total_quantity":5000,"coupon_remain_quantity":3800,"coupon_start_time":1520870400,"coupon_end_time":1521475199,"promotion_rate":300,"goods_eval_score":0,"goods_eval_count":0,"cat_id":288,"avg_desc":494,"avg_lgst":494,"avg_serv":494}],"total_count":24}
     */
    @JsonProperty("goods_search_response")
    private GoodsSearchResponseBean goodsSearchResponse;

    @Data
    public static class GoodsSearchResponseBean extends ToString {
        private static final long serialVersionUID = -7691353590085060862L;
        /**
         * goods_list : [{"goods_id":595564668,"goods_name":"4条装/男士内裤高档纯棉弹力棉中腰平角内裤宽松大码吸湿透气内裤男短裤底裤裤头无痕内裤青年纯棉裆四角裤衩潮平角裤","goods_desc":null,"goods_thumbnail_url":"http://t04img.yangkeduo.com/images/2018-03-01/1ca25ffc5970a992d0e13d0f298280ee.jpeg","goods_image_url":"http://t05img.yangkeduo.com/images/2018-03-01/2948f580ade557320c7e9267f497940b.jpeg","goods_gallery_urls":null,"sold_quantity":67,"min_group_price":3890,"min_normal_price":4400,"mall_name":"雅姿网商","category_id":743,"category_name":"男装","has_coupon":true,"coupon_min_order_amount":3700,"coupon_discount":2000,"coupon_total_quantity":5000,"coupon_remain_quantity":3800,"coupon_start_time":1520870400,"coupon_end_time":1521475199,"promotion_rate":300,"goods_eval_score":0,"goods_eval_count":0,"cat_id":288,"avg_desc":494,"avg_lgst":494,"avg_serv":494}]
         * total_count : 24
         */
        @JsonProperty("total_count")
        private Integer total_count;

        @JsonProperty("goods_list")
        private List<GoodsListBean> goodsList;


        @Data
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

            @JsonProperty("goods_id")
            private String goodsId;


            @JsonProperty("goods_name")
            private String goodsName;


            @JsonProperty("goods_desc")
            private String goodsDesc;


            @JsonProperty("goods_thumbnail_url")
            private String goodsThumbnailUrl;

            @JsonProperty("goods_image_url")
            private String goodsImageUrl;

            @JsonProperty("goods_gallery_urls")
            private String goodsGalleryUrls;

            @JsonProperty("sold_quantity")
            private Integer soldQuantity;

            @JsonProperty("min_group_price")
            private Integer minGroupPrice;

            @JsonProperty("min_normal_price")
            private Integer minNormalPrice;

            @JsonProperty("mall_name")
            private String mallName;

            @JsonProperty("category_id")
            private Integer categoryId;

            @JsonProperty("category_name")
            private String categoryName;

            @JsonProperty("has_coupon")
            private boolean hasCoupon;

            @JsonProperty("coupon_min_order_amount")
            private Integer couponMinOrderAmount;

            @JsonProperty("coupon_discount")
            private Integer couponDiscount;

            @JsonProperty("coupon_total_quantity")
            private Integer couponTotalQuantity;

            @JsonProperty("coupon_remain_quantity")
            private Integer couponRemainQuantity;

            @JsonProperty("coupon_start_time")
            private String couponStartTime;

            @JsonProperty("coupon_end_time")
            private String couponEndTime;

            @JsonProperty("promotion_rate")
            private Integer promotionRate;

            @JsonProperty("goods_eval_score")
            private Integer goodsEvalScore;

            @JsonProperty("goods_eval_count")
            private Integer goodsEvalCount;

            @JsonProperty("cat_id")
            private Integer catId;

            @JsonProperty("avg_desc")
            private Integer avgDesc;

            @JsonProperty("avg_lgst")
            private Integer avgLgst;

            @JsonProperty("avg_serv")
            private Integer avgServ;

        }
    }
}
