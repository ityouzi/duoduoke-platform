package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author lizhi
 * @date 2018/7/6 0006
 */
@Data
public class DuoGoodsDetailResult extends DuoJsonResult {


    @JsonProperty("goods_detail_response")
    private GoodsDetailResponseBean goodsDetailResponse;

    @Data
    public static class GoodsDetailResponseBean {

        @JsonProperty("goods_details")
        private GoodsDetailsBean goodsDetails;

        @Data
        public static class GoodsDetailsBean {

            @JsonProperty("avg_desc")
            private String avgDesc;


            @JsonProperty("avg_lgst")
            private String avgLgst;


            @JsonProperty("avg_serv")
            private String avgServ;

            @JsonProperty("cat_id")
            private String catId;

            @JsonProperty("cat_ids")
            private CatIdsBean catIds;

            @JsonProperty("coupon_discount")
            private String couponDiscount;

            @JsonProperty("coupon_end_time")
            private String couponEndTime;


            @JsonProperty("coupon_min_order_amount")
            private String couponMinOrderAmount;

            @JsonProperty("coupon_remain_quantity")
            private String couponRemainQuantity;


            @JsonProperty("coupon_start_time")
            private String couponStartTime;


            @JsonProperty("coupon_total_quantity")
            private String couponTotalQuantity;


            @JsonProperty("desc_pct")
            private String descPct;

            @JsonProperty("goods_desc")
            private String goodsDesc;

            @JsonProperty("goods_eval_count")
            private String goodsEvalCount;


            @JsonProperty("goods_eval_score")
            private String goodsEvalScore;


            @JsonProperty("goods_gallery_urls")
            private GoodsGalleryUrlsBean goodsGalleryUrls;


            @JsonProperty("goods_id")
            private String goodsId;

            @JsonProperty("goods_image_url")
            private String goodsImageUrl;

            @JsonProperty("goods_name")
            private String goodsName;

            @JsonProperty("lgst_pct")
            private String lgstPct;

            @JsonProperty("mall_coupon_discount_pct")
            private String mallCouponDiscountPct;

            @JsonProperty("mall_coupon_end_time")
            private String mallCouponEndTime;

            @JsonProperty("mall_coupon_id")
            private String mallCouponId;

            @JsonProperty("mall_coupon_max_discount_amount")
            private String mallCouponMaxDiscountAmount;


            @JsonProperty("mall_coupon_min_order_amount")
            private String mallCouponMinOrderAmount;


            @JsonProperty("mall_coupon_remain_quantity")
            private String mallCouponRemainQuantity;

            @JsonProperty("mall_coupon_start_time")

            private String mallCouponStartTime;


            @JsonProperty("mall_coupon_total_quantity")
            private String mallCouponTotalQuantity;


            @JsonProperty("mall_name")
            private String mallName;


            @JsonProperty("min_group_price")
            private String minGroupPrice;


            @JsonProperty("min_normal_price")
            private String minNormalPrice;


            @JsonProperty("opt_id")

            private String optId;


            @JsonProperty("opt_ids")
            private OptIdsBean optIds;

            @JsonProperty("opt_name")
            private String optName;


            @JsonProperty("promotion_rate")
            private String promotionRate;


            @JsonProperty("serv_pct")
            private String servPct;

            @JsonProperty("sold_quantity")
            private String soldQuantity;

            @Data
            public static class CatIdsBean {
            }

            @Data
            public static class GoodsGalleryUrlsBean {
            }

            @Data
            public static class OptIdsBean {
            }
        }
    }
}
