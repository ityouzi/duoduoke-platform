package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import java.util.List;

import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-8
 */
public class OrderSnIncrementResult extends DuoJsonResult {


    /**
     * order_list_get_response : {"order_list":[{"order_sn":"180710-367485256392167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191299,"order_settle_time":null,"order_verify_time":1531198470,"order_receive_time":null,"order_pay_time":1531191305,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":4,"order_status_desc":"审核失败","verify_time":1531198470000,"order_group_success_time":1531191305,"order_modify_at":1531198470,"status":null,"type":0,"group_id":451367485256392200,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"},{"order_sn":"180710-142705951612167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191679,"order_settle_time":null,"order_verify_time":null,"order_receive_time":null,"order_pay_time":1531192710,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":1,"order_status_desc":"已成团","verify_time":null,"order_group_success_time":1531192710,"order_modify_at":1531192721,"status":null,"type":0,"group_id":451142705951612160,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"}],"total_count":2}
     */

    private OrderListGetResponseBean order_list_get_response;

    public OrderListGetResponseBean getOrder_list_get_response() {
        return order_list_get_response;
    }

    public void setOrder_list_get_response(OrderListGetResponseBean order_list_get_response) {
        this.order_list_get_response = order_list_get_response;
    }

    private ErrorResponseBean error_response;

   // {"error_response":{"error_msg":"时间跨度不能超过24小时","sub_msg":"时间跨度不能超过24小时","sub_code":null,"error_code":50001,"request_id":"15464049615056181"}}

    public ErrorResponseBean getError_response() {
        return error_response;
    }

    public void setError_response(ErrorResponseBean error_response) {
        this.error_response = error_response;
    }

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

        public String getError_msg() {
            return error_msg;
        }

        public void setError_msg(String error_msg) {
            this.error_msg = error_msg;
        }

        public String getSub_msg() {
            return sub_msg;
        }

        public void setSub_msg(String sub_msg) {
            this.sub_msg = sub_msg;
        }

        public Object getSub_code() {
            return sub_code;
        }

        public void setSub_code(Object sub_code) {
            this.sub_code = sub_code;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        public String getRequest_id() {
            return request_id;
        }

        public void setRequest_id(String request_id) {
            this.request_id = request_id;
        }
    }

    public static class OrderListGetResponseBean extends ToString {
        /**
         * order_list : [{"order_sn":"180710-367485256392167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191299,"order_settle_time":null,"order_verify_time":1531198470,"order_receive_time":null,"order_pay_time":1531191305,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":4,"order_status_desc":"审核失败","verify_time":1531198470000,"order_group_success_time":1531191305,"order_modify_at":1531198470,"status":null,"type":0,"group_id":451367485256392200,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"},{"order_sn":"180710-142705951612167","goods_id":864621591,"goods_name":"品彩拖鞋女夏家用室内浴室洗澡防滑居家拖鞋可爱男家居凉拖鞋情侣","goods_thumbnail_url":"http://t00img.yangkeduo.com/t01img/images/2018-06-13/d4926d4cd361a6ed6cd4d8ef66202211.jpeg","goods_quantity":1,"goods_price":990,"order_amount":790,"order_create_time":1531191679,"order_settle_time":null,"order_verify_time":null,"order_receive_time":null,"order_pay_time":1531192710,"promotion_rate":350,"promotion_amount":276,"batch_no":"","order_status":1,"order_status_desc":"已成团","verify_time":null,"order_group_success_time":1531192710,"order_modify_at":1531192721,"status":null,"type":0,"group_id":451142705951612160,"auth_duo_id":0,"custom_parameters":"abcd","p_id":"240009_18781180"}]
         * total_count : 2
         */

        private Integer total_count;
        private List<OrderListBean> order_list;

        public Integer getTotal_count() {
            return total_count;
        }

        public void setTotal_count(Integer total_count) {
            this.total_count = total_count;
        }

        public List<OrderListBean> getOrder_list() {
            return order_list;
        }

        public void setOrder_list(List<OrderListBean> order_list) {
            this.order_list = order_list;
        }

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

            public String getOrder_sn() {
                return order_sn;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
            }

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

            public String getGoods_thumbnail_url() {
                return goods_thumbnail_url;
            }

            public void setGoods_thumbnail_url(String goods_thumbnail_url) {
                this.goods_thumbnail_url = goods_thumbnail_url;
            }

            public Integer getGoods_quantity() {
                return goods_quantity;
            }

            public void setGoods_quantity(Integer goods_quantity) {
                this.goods_quantity = goods_quantity;
            }

            public Integer getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(Integer goods_price) {
                this.goods_price = goods_price;
            }

            public Integer getOrder_amount() {
                return order_amount;
            }

            public void setOrder_amount(Integer order_amount) {
                this.order_amount = order_amount;
            }

            public Integer getOrder_create_time() {
                return order_create_time;
            }

            public void setOrder_create_time(Integer order_create_time) {
                this.order_create_time = order_create_time;
            }

            public Integer getOrder_settle_time() {
                return order_settle_time;
            }

            public void setOrder_settle_time(Integer order_settle_time) {
                this.order_settle_time = order_settle_time;
            }

            public Integer getOrder_verify_time() {
                return order_verify_time;
            }

            public void setOrder_verify_time(Integer order_verify_time) {
                this.order_verify_time = order_verify_time;
            }

            public Integer getOrder_receive_time() {
                return order_receive_time;
            }

            public void setOrder_receive_time(Integer order_receive_time) {
                this.order_receive_time = order_receive_time;
            }

            public Integer getOrder_pay_time() {
                return order_pay_time;
            }

            public void setOrder_pay_time(Integer order_pay_time) {
                this.order_pay_time = order_pay_time;
            }

            public Integer getPromotion_rate() {
                return promotion_rate;
            }

            public void setPromotion_rate(Integer promotion_rate) {
                this.promotion_rate = promotion_rate;
            }

            public Integer getPromotion_amount() {
                return promotion_amount;
            }

            public void setPromotion_amount(Integer promotion_amount) {
                this.promotion_amount = promotion_amount;
            }

            public String getBatch_no() {
                return batch_no;
            }

            public void setBatch_no(String batch_no) {
                this.batch_no = batch_no;
            }

            public Integer getOrder_status() {
                return order_status;
            }

            public void setOrder_status(Integer order_status) {
                this.order_status = order_status;
            }

            public String getOrder_status_desc() {
                return order_status_desc;
            }

            public void setOrder_status_desc(String order_status_desc) {
                this.order_status_desc = order_status_desc;
            }

            public Long getVerify_time() {
                return verify_time;
            }

            public void setVerify_time(Long verify_time) {
                this.verify_time = verify_time;
            }

            public Integer getOrder_group_success_time() {
                return order_group_success_time;
            }

            public void setOrder_group_success_time(Integer order_group_success_time) {
                this.order_group_success_time = order_group_success_time;
            }

            public Integer getOrder_modify_at() {
                return order_modify_at;
            }

            public void setOrder_modify_at(Integer order_modify_at) {
                this.order_modify_at = order_modify_at;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Integer getType() {
                return type;
            }

            public void setType(Integer type) {
                this.type = type;
            }

            public Long getGroup_id() {
                return group_id;
            }

            public void setGroup_id(Long group_id) {
                this.group_id = group_id;
            }

            public Integer getAuth_duo_id() {
                return auth_duo_id;
            }

            public void setAuth_duo_id(Integer auth_duo_id) {
                this.auth_duo_id = auth_duo_id;
            }

            public String getCustom_parameters() {
                return custom_parameters;
            }

            public void setCustom_parameters(String custom_parameters) {
                this.custom_parameters = custom_parameters;
            }

            public String getP_id() {
                return p_id;
            }

            public void setP_id(String p_id) {
                this.p_id = p_id;
            }
        }
    }
}
