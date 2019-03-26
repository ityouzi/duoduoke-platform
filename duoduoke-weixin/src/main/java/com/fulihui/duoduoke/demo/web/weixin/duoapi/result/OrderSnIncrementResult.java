package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-8
 */
@Data
public class OrderSnIncrementResult extends DuoJsonResult {


    /**
     * order_list_get_response : {"order_list":[{"orderSn":"180710-367485256392167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191299,"order_settle_time":null,"order_verify_time":1531198470,"order_receive_time":null,"order_pay_time":1531191305,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":4,"order_status_desc":"审核失败","verify_time":1531198470000,"order_group_success_time":1531191305,"order_modify_at":1531198470,"status":null,"type":0,"group_id":451367485256392200,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"},{"orderSn":"180710-142705951612167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191679,"order_settle_time":null,"order_verify_time":null,"order_receive_time":null,"order_pay_time":1531192710,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":1,"order_status_desc":"已成团","verify_time":null,"order_group_success_time":1531192710,"order_modify_at":1531192721,"status":null,"type":0,"group_id":451142705951612160,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"}],"total_count":2}
     */
    @JsonProperty("order_list_get_response")
    private OrderListGetResponseBean orderListGetResponse;

    @JsonProperty("error_response")
    private ErrorResponseBean errorResponse;

    // {"error_response":{"error_msg":"时间跨度不能超过24小时","sub_msg":"时间跨度不能超过24小时","sub_code":null,"error_code":50001,"request_id":"15464049615056181"}}


    @Data
    public static class ErrorResponseBean {
        /**
         * error_msg : 时间跨度不能超过24小时
         * sub_msg : 时间跨度不能超过24小时
         * sub_code : null
         * error_code : 50001
         * request_id : 15464049615056181
         */
        @JsonProperty("error_msg")
        private String errorMsg;

        @JsonProperty("sub_msg")
        private String subMsg;

        @JsonProperty("sub_code")
        private String subCode;

        @JsonProperty("error_code")
        private String errorCode;


        @JsonProperty("request_id")
        private String requestId;


    }

    @Data
    public static class OrderListGetResponseBean extends ToString {
        /**
         * order_list : [{"orderSn":"180710-367485256392167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191299,"order_settle_time":null,"order_verify_time":1531198470,"order_receive_time":null,"order_pay_time":1531191305,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":4,"order_status_desc":"审核失败","verify_time":1531198470000,"order_group_success_time":1531191305,"order_modify_at":1531198470,"status":null,"type":0,"group_id":451367485256392200,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"},{"orderSn":"180710-142705951612167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191679,"order_settle_time":null,"order_verify_time":null,"order_receive_time":null,"order_pay_time":1531192710,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":1,"order_status_desc":"已成团","verify_time":null,"order_group_success_time":1531192710,"order_modify_at":1531192721,"status":null,"type":0,"group_id":451142705951612160,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"}]
         * total_count : 2
         */
        @JsonProperty("total_count")
        private Integer totalCount;

        @JsonProperty("order_list")
        private List<OrderListBean> orderList;


        @Data
        public static class OrderListBean extends ToString {

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

        }
    }
}
