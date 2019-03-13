package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PromotionChannelsOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * promotion_channels_order.id
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Integer id;
    /**
     * promotion_channels_order.channels_code
     * 推广渠道code
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String channelsCode;
    /**
     * promotion_channels_order.order_sn
     * 推广订单编号
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String orderSn;
    /**
     * promotion_channels_order.goods_id
     * 商品ID
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String goodsId;
    /**
     * promotion_channels_order.goods_name
     * 商品标题
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String goodsName;
    /**
     * promotion_channels_order.goods_thumbnail_url
     * 商品缩略图
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String goodsThumbnailUrl;
    /**
     * promotion_channels_order.goods_quantity
     * 购买商品的数量
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Integer goodsQuantity;
    /**
     * promotion_channels_order.goods_price
     * 订单中sku的单件价格，单位为分
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Integer goodsPrice;
    /**
     * promotion_channels_order.order_amount
     * 实际支付金额，单位为分
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Integer orderAmount;
    /**
     * promotion_channels_order.order_create_time
     * 订单生成时间，UNIX时间戳
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderCreateTime;
    /**
     * promotion_channels_order.order_settle_time
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderSettleTime;
    /**
     * promotion_channels_order.order_verify_time
     * 审核时间
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderVerifyTime;
    /**
     * promotion_channels_order.order_receive_time
     * 订单确认签收时间
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderReceiveTime;
    /**
     * promotion_channels_order.order_pay_time
     * 支付时间
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderPayTime;
    /**
     * promotion_channels_order.order_pay_time_ext
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderPayTimeExt;
    /**
     * promotion_channels_order.promotion_rate
     * 佣金比例，千分比
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Integer promotionRate;
    /**
     * promotion_channels_order.promotion_amount
     * 佣金金额，单位为分
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Integer promotionAmount;
    /**
     * promotion_channels_order.p_id
     * 推广位ID
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String pId;
    /**
     * promotion_channels_order.custom_parameters
     * 自定义参数，标志订单来源于哪个自定义参数-用户id
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String customParameters;
    /**
     * promotion_channels_order.order_status
     * 订单状态： -1 未支付; 0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）;10-已处罚
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String orderStatus;
    /**
     * promotion_channels_order.order_status_desc
     * 订单状态描述
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String orderStatusDesc;
    /**
     * promotion_channels_order.user_order_status
     * 业务订单状态
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String userOrderStatus;
    /**
     * promotion_channels_order.user_order_status_desc
     * 业务订单状态描述
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String userOrderStatusDesc;
    /**
     * promotion_channels_order.verify_time
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date verifyTime;
    /**
     * promotion_channels_order.order_group_success_time
     * 成团时间
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderGroupSuccessTime;
    /**
     * promotion_channels_order.order_modify_at
     * 最后更新时间
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderModifyAt;
    /**
     * promotion_channels_order.order_modify_at_ext
     * 最后更新时间扩展方便查询
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date orderModifyAtExt;
    /**
     * promotion_channels_order.status
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String status;
    /**
     * promotion_channels_order.batch_no
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String batchNo;
    /**
     * promotion_channels_order.type
     * 订单来源：0—单品（领券页）推广 1—红包活动推广 2—领券页底部推荐
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String type;
    /**
     * promotion_channels_order.group_id
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String groupId;
    /**
     * promotion_channels_order.auth_duo_id
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String authDuoId;
    /**
     * promotion_channels_order.gmt_create
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date gmtCreate;
    /**
     * promotion_channels_order.gmt_modified
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Date gmtModified;
    /**
     * promotion_channels_order.order_commission_snapshot
     * 订单佣金返利快照,百分比
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Integer orderCommissionSnapshot;
    /**
     * promotion_channels_order.order_promotion_source
     * 订单推广来源
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String orderPromotionSource;
    /**
     * promotion_channels_order.order_promotion_commission
     * 订单推广返利
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private Double orderPromotionCommission;
    /**
     * promotion_channels_order.promo_type
     *
     * @mbg.generated 2019-01-17 12:52:46
     */
    private String promoType;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", channelsCode=").append(channelsCode);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsThumbnailUrl=").append(goodsThumbnailUrl);
        sb.append(", goodsQuantity=").append(goodsQuantity);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", orderCreateTime=").append(orderCreateTime);
        sb.append(", orderSettleTime=").append(orderSettleTime);
        sb.append(", orderVerifyTime=").append(orderVerifyTime);
        sb.append(", orderReceiveTime=").append(orderReceiveTime);
        sb.append(", orderPayTime=").append(orderPayTime);
        sb.append(", orderPayTimeExt=").append(orderPayTimeExt);
        sb.append(", promotionRate=").append(promotionRate);
        sb.append(", promotionAmount=").append(promotionAmount);
        sb.append(", pId=").append(pId);
        sb.append(", customParameters=").append(customParameters);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderStatusDesc=").append(orderStatusDesc);
        sb.append(", userOrderStatus=").append(userOrderStatus);
        sb.append(", userOrderStatusDesc=").append(userOrderStatusDesc);
        sb.append(", verifyTime=").append(verifyTime);
        sb.append(", orderGroupSuccessTime=").append(orderGroupSuccessTime);
        sb.append(", orderModifyAt=").append(orderModifyAt);
        sb.append(", orderModifyAtExt=").append(orderModifyAtExt);
        sb.append(", status=").append(status);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", type=").append(type);
        sb.append(", groupId=").append(groupId);
        sb.append(", authDuoId=").append(authDuoId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", orderCommissionSnapshot=").append(orderCommissionSnapshot);
        sb.append(", orderPromotionSource=").append(orderPromotionSource);
        sb.append(", orderPromotionCommission=").append(orderPromotionCommission);
        sb.append(", promoType=").append(promoType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}