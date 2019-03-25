package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Data;

/**
 * @author wahaha
 */
@Data
public class DuoOrderDetailGetResult extends DuoJsonResult {

    private static final long serialVersionUID = -5146002878359596895L;
    /**
     * order_detail_response : {"order_sn":null,"goods_id":null,"goods_name":null,"goods_thumbnail_url":null,"goods_quantity":null,"goods_price":null,"order_amount":null,"promotion_rate":null,"promotion_amount":null,"batch_no":null,"order_status":null,"order_status_desc":null,"order_create_time":1535546872,"order_pay_time":null,"order_group_success_time":null,"order_receive_time":null,"order_verify_time":null,"order_settle_time":null,"order_modify_at":null,"match_channel":5,"type":0,"group_id":null,"auth_duo_id":null,"zs_duo_id":null,"custom_parameters":null,"cps_sign":"CC210035_735_12b26d652b895c8ae77a8a0b7553919b","url_last_generate_time":1535618102,"point_time":null,"return_status":null,"pid":"210035_735"}
     */

    private OrderDetailResponseBean order_detail_response;




    @Data
    public static class OrderDetailResponseBean {
        /**
         * order_sn : null
         * goods_id : null
         * goods_name : null
         * goods_thumbnail_url : null
         * goods_quantity : null
         * goods_price : null
         * order_amount : null
         * promotion_rate : null
         * promotion_amount : null
         * batch_no : null
         * order_status : null
         * order_status_desc : null
         * order_create_time : 1535546872
         * order_pay_time : null
         * order_group_success_time : null
         * order_receive_time : null
         * order_verify_time : null
         * order_settle_time : null
         * order_modify_at : null
         * match_channel : 5
         * type : 0
         * group_id : null
         * auth_duo_id : null
         * zs_duo_id : null
         * custom_parameters : null
         * cps_sign : CC210035_735_12b26d652b895c8ae77a8a0b7553919b
         * url_last_generate_time : 1535618102
         * point_time : null
         * return_status : null
         * pid : 210035_735
         */

        private String order_sn;
        private String goods_id;
        private String goods_name;
        private String goods_thumbnail_url;
        private String goods_quantity;
        private String goods_price;
        private String order_amount;
        private String promotion_rate;
        private String promotion_amount;
        private String batch_no;
        private String order_status;
        private String order_status_desc;
        private String order_create_time;
        private String order_pay_time;
        private String order_group_success_time;
        private String order_receive_time;
        private String order_verify_time;
        private String order_settle_time;
        private String order_modify_at;
        private String match_channel;
        private String type;
        private String group_id;
        private String auth_duo_id;
        private String zs_duo_id;
        private String custom_parameters;
        private String cps_sign;
        private String url_last_generate_time;
        private String point_time;
        private String return_status;
        private String pid;


    }
}
