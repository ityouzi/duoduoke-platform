package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wahaha
 */
@Setter
@Getter
public class DuoOrderDetailGetResult extends DuoJsonResult {

    private static final long serialVersionUID = -5146002878359596895L;

    @JsonProperty("order_detail_response")
    private OrderDetailResponseBean orderDetailResponse;


    @Data
    public static class OrderDetailResponseBean {

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

        @JsonProperty("order_create_time")
        private String orderCreateTime;

        @JsonProperty("order_pay_time")
        private String orderPayTime;

        @JsonProperty("order_group_success_time")
        private String orderGroupSuccessTime;

        @JsonProperty("order_receive_time")
        private String orderReceiveTime;

        @JsonProperty("order_verify_time")
        private String orderVerifyTime;

        @JsonProperty("order_settle_time")
        private String orderSettleTime;

        @JsonProperty("order_modify_at")
        private String orderModifyAt;


        @JsonProperty("match_channel")
        private String matchChannel;

        @JsonProperty("type")
        private String type;

        @JsonProperty("group_id")
        private String groupId;

        @JsonProperty("auth_duo_id")
        private String authDuoId;

        @JsonProperty("zs_duo_id")
        private String zsDuoId;

        @JsonProperty("custom_parameters")
        private String customParameters;

        @JsonProperty("cps_sign")
        private String cpsSign;

        @JsonProperty("url_last_generate_time")
        private String urlLastGenerateTime;

        @JsonProperty("point_time")
        private String pointTime;

        @JsonProperty("return_status")
        private String returnStatus;

        @JsonProperty("pid")
        private String pId;


    }
}
