package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

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
     * order_list_get_response : {"order_list":[{"order_sn":"180710-367485256392167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191299,"order_settle_time":null,"order_verify_time":1531198470,"order_receive_time":null,"order_pay_time":1531191305,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":4,"order_status_desc":"审核失败","verify_time":1531198470000,"order_group_success_time":1531191305,"order_modify_at":1531198470,"status":null,"type":0,"group_id":451367485256392200,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"},{"order_sn":"180710-142705951612167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191679,"order_settle_time":null,"order_verify_time":null,"order_receive_time":null,"order_pay_time":1531192710,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":1,"order_status_desc":"已成团","verify_time":null,"order_group_success_time":1531192710,"order_modify_at":1531192721,"status":null,"type":0,"group_id":451142705951612160,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"}],"total_count":2}
     */

    private OrderListGetResponseBean order_list_get_response;


    private ErrorResponseBean error_response;

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

        private String error_msg;
        private String sub_msg;
        private Object sub_code;
        private int error_code;
        private String request_id;


    }

    @Data
    public static class OrderListGetResponseBean extends ToString {
        /**
         * order_list : [{"order_sn":"180710-367485256392167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191299,"order_settle_time":null,"order_verify_time":1531198470,"order_receive_time":null,"order_pay_time":1531191305,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":4,"order_status_desc":"审核失败","verify_time":1531198470000,"order_group_success_time":1531191305,"order_modify_at":1531198470,"status":null,"type":0,"group_id":451367485256392200,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"},{"order_sn":"180710-142705951612167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191679,"order_settle_time":null,"order_verify_time":null,"order_receive_time":null,"order_pay_time":1531192710,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":1,"order_status_desc":"已成团","verify_time":null,"order_group_success_time":1531192710,"order_modify_at":1531192721,"status":null,"type":0,"group_id":451142705951612160,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"}]
         * total_count : 2
         */

        private Integer total_count;
        private List<OrderListBean> order_list;

        @Data
        public static class OrderListBean extends ToString {
            /**
             * order_sn : 180710-367485256392167
             * goods_id : 864621591
             * goods_name : 品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣
             * goods_thumbnail_url : http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg
             * goods_quantity : 1
             * goods_price : 990
             * order_amount : 790
             * order_create_time : 1531191299
             * order_settle_time : null
             * order_verify_time : 1531198470
             * order_receive_time : null
             * order_pay_time : 1531191305
             * promotion_rate : 350
             * promotion_amount : 276
             * batch_no :
             * order_status : 4
             * order_status_desc : 审核失败
             * verify_time : 1531198470000
             * order_group_success_time : 1531191305
             * order_modify_at : 1531198470
             * status : null
             * type : 0
             * group_id : 451367485256392200
             * auth_duo_id : 0
             * custom_parameters : abcd
             * p_id : 240009_18781180
             */

            private String order_sn;
            private String goods_id;
            private String goods_name;
            private String goods_thumbnail_url;
            private Integer goods_quantity;
            private Integer goods_price;
            private Integer order_amount;
            private Integer order_create_time;
            private Integer order_settle_time;
            private Integer order_verify_time;
            private Integer order_receive_time;
            private Integer order_pay_time;
            private Integer promotion_rate;
            private Integer promotion_amount;
            private String batch_no;
            private Integer order_status;
            private String order_status_desc;
            private Long verify_time;
            private Integer order_group_success_time;
            private Integer order_modify_at;
            private String status;
            private Integer type;
            private Long group_id;
            private Integer auth_duo_id;
            private String custom_parameters;
            private String p_id;
            
        }
    }
}
