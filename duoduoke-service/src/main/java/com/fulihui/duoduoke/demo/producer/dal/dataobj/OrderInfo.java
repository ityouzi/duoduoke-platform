package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo extends PromotionChannelsOrder {
    private static final long serialVersionUID = 1L;
    /**
     * order_info.id
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer id;
    /**
     * order_info.order_sn
     * 推广订单编号
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String orderSn;
    /**
     * order_info.goods_id
     * 商品ID
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String goodsId;
    /**
     * order_info.goods_name
     * 商品标题
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String goodsName;
    /**
     * order_info.goods_thumbnail_url
     * 商品缩略图
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String goodsThumbnailUrl;
    /**
     * order_info.goods_quantity
     * 购买商品的数量
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer goodsQuantity;
    /**
     * order_info.goods_price
     * 订单中sku的单件价格，单位为分
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer goodsPrice;
    /**
     * order_info.order_amount
     * 实际支付金额，单位为分
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer orderAmount;
    /**
     * order_info.order_create_time
     * 订单生成时间，UNIX时间戳
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderCreateTime;
    /**
     * order_info.order_settle_time
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderSettleTime;
    /**
     * order_info.order_verify_time
     * 审核时间
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderVerifyTime;
    /**
     * order_info.order_receive_time
     * 订单确认签收时间
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderReceiveTime;
    /**
     * order_info.order_pay_time
     * 支付时间
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderPayTime;
    /**
     * order_info.order_pay_time_ext
     * 支付时间扩展
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderPayTimeExt;
    /**
     * order_info.promotion_rate
     * 佣金比例，千分比
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer promotionRate;
    /**
     * order_info.promotion_amount
     * 佣金金额，单位为分
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer promotionAmount;
    /**
     * order_info.p_id
     * 推广位ID
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String pId;
    /**
     * order_info.custom_parameters
     * 自定义参数，标志订单来源于哪个自定义参数-用户id
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String customParameters;
    /**
     * order_info.order_status
     * 订单状态： -1 未支付; 0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）;10-已处罚
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String orderStatus;
    /**
     * order_info.order_status_desc
     * 订单状态描述
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String orderStatusDesc;
    /**
     * order_info.user_order_status
     * 业务订单状态
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String userOrderStatus;
    /**
     * order_info.user_order_status_desc
     * 业务订单状态描述
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String userOrderStatusDesc;
    /**
     * order_info.verify_time
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date verifyTime;
    /**
     * order_info.order_group_success_time
     * 成团时间
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderGroupSuccessTime;
    /**
     * order_info.order_modify_at
     * 最后更新时间
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderModifyAt;
    /**
     * order_info.order_modify_at_ext
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date orderModifyAtExt;
    /**
     * order_info.status
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String status;
    /**
     * order_info.batch_no
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String batchNo;
    /**
     * order_info.type
     * 订单来源：0—单品（领券页）推广 1—红包活动推广 2—领券页底部推荐
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String type;
    /**
     * order_info.group_id
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String groupId;
    /**
     * order_info.auth_duo_id
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String authDuoId;
    /**
     * order_info.gmt_create
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date gmtCreate;
    /**
     * order_info.gmt_modified
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date gmtModified;
    /**
     * order_info.order_commission_snapshot
     * 订单佣金返利快照,百分比
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer orderCommissionSnapshot;
    /**
     * order_info.order_user_referee
     * 订单推荐人
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String orderUserReferee;
    /**
     * order_info.help_money
     * 翻倍金额，单位为分
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer helpMoney;
    /**
     * order_info.help_status
     * 助力状态
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String helpStatus;
    /**
     * order_info.help_percent
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Double helpPercent;
    /**
     * order_info.send_time
     * 发送时间
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date sendTime;
    /**
     * order_info.order_type
     * 订单类型
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String orderType;
    /**
     * order_info.double_percent
     * 加倍比例,百分比
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Double doublePercent;
    /**
     * order_info.exemption_amount
     * 免单金额
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Integer exemptionAmount;
    /**
     * order_info.promo_type
     * 订单推广方式类型
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private String promoType;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
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
        sb.append(", orderUserReferee=").append(orderUserReferee);
        sb.append(", helpMoney=").append(helpMoney);
        sb.append(", helpStatus=").append(helpStatus);
        sb.append(", helpPercent=").append(helpPercent);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", orderType=").append(orderType);
        sb.append(", doublePercent=").append(doublePercent);
        sb.append(", exemptionAmount=").append(exemptionAmount);
        sb.append(", promoType=").append(promoType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}