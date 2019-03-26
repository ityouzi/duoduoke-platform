package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wahaha
 */

@Data
public class OrderColorIncrementResult extends DuoJsonResult {

    /**
     * order_list_get_response : {"total_count":2,"order_list":[{"match_channel":8,"goods_price":3432,"promotion_rate":200,"verify_time":null,"type":15,"order_status":1,"order_create_time":1546916976,"order_settle_time":null,"order_verify_time":null,"order_group_success_time":1546918421,"order_amount":3432,"order_modify_at":1546918427,"auth_duo_id":20002,"goods_name":"蜂蜜天然农家自产野生土蜂蜜原蜜百花蜜洋槐蜜枣花蜜结晶蜜二斤装","batch_no":"","goods_quantity":1,"goods_id":4789941332,"goods_thumbnail_url":"http://t00img.yangkeduo.com/goods/images/2018-12-08/ef3016093af67d46d9cd9e60060a3c46.jpeg","order_receive_time":null,"custom_parameters":"-1","promotion_amount":686,"order_pay_time":1546917019,"group_id":633374476636970000,"duo_coupon_amount":0,"order_status_desc":"已成团","orderSn":"190108-374476636970002","p_id":"240009_44622411","zs_duo_id":null},{"match_channel":8,"goods_price":2990,"promotion_rate":10,"verify_time":null,"type":15,"order_status":1,"order_create_time":1546917047,"order_settle_time":null,"order_verify_time":null,"order_group_success_time":1546918408,"order_amount":1990,"order_modify_at":1546918414,"auth_duo_id":20002,"goods_name":"【领券立减10】新货新疆薄皮核桃新货特价1000g坚果零食送核桃夹","batch_no":"","goods_quantity":1,"goods_id":6577510,"goods_thumbnail_url":"http://t00img.yangkeduo.com/goods/images/2018-12-27/6d8917403c3c5b81b6fb5e21332b3aba.jpeg","order_receive_time":null,"custom_parameters":"","promotion_amount":20,"order_pay_time":1546917047,"group_id":633005587600433500,"duo_coupon_amount":0,"order_status_desc":"已成团","orderSn":"190108-005587600433598","p_id":"240009_44622411","zs_duo_id":null}],"request_id":"15476239120173090"}
     */
    @JsonProperty("order_list_get_response")
    private OrderListGetResponseBean orderListGetResponse;

    @Data
    public static class OrderListGetResponseBean {
        /**
         * total_count : 2
         * order_list : [{"match_channel":8,"goods_price":3432,"promotion_rate":200,"verify_time":null,"type":15,"order_status":1,"order_create_time":1546916976,"order_settle_time":null,"order_verify_time":null,"order_group_success_time":1546918421,"order_amount":3432,"order_modify_at":1546918427,"auth_duo_id":20002,"goods_name":"蜂蜜天然农家自产野生土蜂蜜原蜜百花蜜洋槐蜜枣花蜜结晶蜜二斤装","batch_no":"","goods_quantity":1,"goods_id":4789941332,"goods_thumbnail_url":"http://t00img.yangkeduo.com/goods/images/2018-12-08/ef3016093af67d46d9cd9e60060a3c46.jpeg","order_receive_time":null,"custom_parameters":"-1","promotion_amount":686,"order_pay_time":1546917019,"group_id":633374476636970000,"duo_coupon_amount":0,"order_status_desc":"已成团","orderSn":"190108-374476636970002","p_id":"240009_44622411","zs_duo_id":null},{"match_channel":8,"goods_price":2990,"promotion_rate":10,"verify_time":null,"type":15,"order_status":1,"order_create_time":1546917047,"order_settle_time":null,"order_verify_time":null,"order_group_success_time":1546918408,"order_amount":1990,"order_modify_at":1546918414,"auth_duo_id":20002,"goods_name":"【领券立减10】新货新疆薄皮核桃新货特价1000g坚果零食送核桃夹","batch_no":"","goods_quantity":1,"goods_id":6577510,"goods_thumbnail_url":"http://t00img.yangkeduo.com/goods/images/2018-12-27/6d8917403c3c5b81b6fb5e21332b3aba.jpeg","order_receive_time":null,"custom_parameters":"","promotion_amount":20,"order_pay_time":1546917047,"group_id":633005587600433500,"duo_coupon_amount":0,"order_status_desc":"已成团","orderSn":"190108-005587600433598","p_id":"240009_44622411","zs_duo_id":null}]
         * request_id : 15476239120173090
         */
        @JsonProperty("total_count")
        private Integer totalCount;

        @JsonProperty("request_id")
        private String requestId;

        @JsonProperty("order_list")
        private List<OrderListBean> orderList;

        @Data
        public static class OrderListBean {
            /**
             * match_channel : 8
             * goods_price : 3432
             * promotion_rate : 200
             * verify_time : null
             * type : 15
             * order_status : 1
             * order_create_time : 1546916976
             * order_settle_time : null
             * order_verify_time : null
             * order_group_success_time : 1546918421
             * order_amount : 3432
             * order_modify_at : 1546918427
             * auth_duo_id : 20002
             * goods_name : 蜂蜜天然农家自产野生土蜂蜜原蜜百花蜜洋槐蜜枣花蜜结晶蜜二斤装
             * batch_no :
             * goods_quantity : 1
             * goods_id : 4789941332
             * goods_thumbnail_url : http://t00img.yangkeduo.com/goods/images/2018-12-08/ef3016093af67d46d9cd9e60060a3c46.jpeg
             * order_receive_time : null
             * custom_parameters : -1
             * promotion_amount : 686
             * order_pay_time : 1546917019
             * group_id : 633374476636970000
             * duo_coupon_amount : 0
             * order_status_desc : 已成团
             * orderSn : 190108-374476636970002
             * p_id : 240009_44622411
             * zs_duo_id : null
             */
            @JsonProperty("order_sn")
            private String orderSn;


            @JsonProperty("goods_id")
            private String goodsId;

            @JsonProperty("goods_name")
            private String goodsName;

            @JsonProperty("goods_thumbnail_url")
            private String goodsThumbnailUrl;


            @JsonProperty("goods_quantity")
            private String goodsQuantity;

            @JsonProperty("goods_price")
            private String goodsPrice;

            @JsonProperty("order_amount")
            private String orderAmount;

            @JsonProperty("order_create_time")
            private String orderCreateTime;

            @JsonProperty("order_settle_time")
            private String orderSettleTime;

            @JsonProperty("order_verify_time")
            private String orderVerifyTime;

            @JsonProperty("order_receive_time")
            private String orderReceiveTime;

            @JsonProperty("order_pay_time")
            private String orderPayTime;

            @JsonProperty("promotion_rate")
            private String promotionRate;

            @JsonProperty("promotion_amount")
            private String promotionAmount;

            @JsonProperty("batch_no")
            private String batchNo;

            @JsonProperty("order_status")
            private String orderStatus;

            @JsonProperty("order_status_desc")
            private String orderStatusDesc;


            @JsonProperty("verify_time")
            private String verifyTime;


            @JsonProperty("order_group_success_time")
            private String orderGroupSuccessTime;


            @JsonProperty("order_modify_at")
            private String orderModifyAt;

            @JsonProperty("status")
            private String status;


            @JsonProperty("type")
            private String type;

            @JsonProperty("group_id")
            private String groupId;

            @JsonProperty("auth_duo_id")
            private String authDuoId;


            @JsonProperty("custom_parameters")
            private String customParameters;

            @JsonProperty("p_id")
            private String pId;

            @JsonProperty("match_channel")
            private String matchChannel;


            @JsonProperty("zs_duo_id")
            private String zsDuoId;


        }
    }
}
