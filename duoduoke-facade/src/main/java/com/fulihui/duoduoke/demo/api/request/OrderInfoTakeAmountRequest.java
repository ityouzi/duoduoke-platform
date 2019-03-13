package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Setter
@Getter
public class OrderInfoTakeAmountRequest extends AbstractServiceRequest {

    private static final long serialVersionUID = -7426164634336727962L;

    private Integer           id;

    /**
     * order_info.order_sn
     * 推广订单编号
     */
    private String            orderSn;

    /**
     * order_info.goods_id
     * 商品ID
     */
    private String            goodsId;

    /**
     * order_info.goods_name
     * 商品标题
     */
    private String            goodsName;

    /**
     * order_info.goods_thumbnail_url
     * 商品缩略图
     */
    private String            goodsThumbnailUrl;

    /**
     * order_info.goods_quantity
     * 购买商品的数量
     */
    private Integer           goodsQuantity;

    /**
     * order_info.goods_price
     * 订单中sku的单件价格，单位为分
     */
    private Integer           goodsPrice;

    /**
     * order_info.order_amount
     * 实际支付金额，单位为分
     */
    private Integer           orderAmount;

    /**
     * order_info.order_create_time
     * 订单生成时间，UNIX时间戳
     */
    private Date              orderCreateTime;

    /**
     * order_info.order_settle_time
     */
    private Date              orderSettleTime;

    /**
     * order_info.order_verify_time
     * 审核时间
     */
    private Date              orderVerifyTime;

    /**
     * order_info.order_receive_time
     * 订单确认签收时间
     */
    private Date              orderReceiveTime;

    /**
     * order_info.order_pay_time
     * 支付时间
     */
    private Date              orderPayTime;

    /**
     * order_info.promotion_rate
     * 佣金比例，千分比
     */
    private Integer           promotionRate;

    /**
     * order_info.promotion_amount
     * 佣金金额，单位为分
     */
    private Integer           promotionAmount;

    /**
     * order_info.batch_no
     */
    private String            batchNo;

    /**
     * order_info.order_status
     * 订单状态： -1 未支付; 0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）;10-已处罚
     */
    private String            orderStatus;

    /**
     * order_info.order_status_desc
     * 订单状态描述
     */
    private String            orderStatusDesc;

    /**
     * order_info.verify_time
     */
    private Date              verifyTime;

    /**
     * order_info.order_group_success_time
     * 成团时间
     */
    private Date              orderGroupSuccessTime;

    /**
     * order_info.order_modify_at
     * 最后更新时间
     */
    private Date              orderModifyAt;

    /**
     * order_info.status
     */
    private String            status;

    /**
     * order_info.type
     * 订单来源：0—单品（领券页）推广 1—红包活动推广 2—领券页底部推荐
     */
    private String            type;

    /**
     * order_info.group_id
     */
    private String            groupId;

    /**
     * order_info.auth_duo_id
     */
    private String            authDuoId;

    /**
     * order_info.custom_parameters
     * 自定义参数，标志订单来源于哪个自定义参数-用户id
     */
    private String            customParameters;

    /**
     * order_info.p_id
     * 推广位ID
     */
    private String            pId;

    /**
     * order_info.gmt_create
     */
    private Date              gmtCreate;

    /**
     * order_info.gmt_modified
     */
    private Date              gmtModified;

    /**
     * order_info.user_order_status
     * 业务订单状态
     */
    private String            userOrderStatus;

    /**
     * order_info.user_order_status_desc
     * 业务订单状态描述
     */
    private String            userOrderStatusDesc;

    /**
     * 订单推荐人
     */
    private String            orderUserReferee;

    /**
     * 订单推广来源
     */
    private String            orderPromotionSource;

    /**
     * 订单渠道标示
     */
    private String            channelsCode;
    /**
     *
     *
     * order_info.promo_type
     * 订单推广方式类型
     *
     * @mbg.generated 2019-01-16 17:34:06
     */
    private String            promoType;
    /**
     * 只落地
     */
    private Boolean           landing;
}
