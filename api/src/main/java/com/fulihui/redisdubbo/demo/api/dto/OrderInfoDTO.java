package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Setter
@Getter
public class OrderInfoDTO extends ToString {
    private static final long serialVersionUID = -3141626515890980380L;
    /**
     * order_info.id
     */
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
     * order_info.order_commission_snapshot
     * 订单佣金返利快照
     *
     * @mbg.generated 2018-07-16 15:34:41
     */
    private Integer           orderCommissionSnapshot;

    /**
     * order_info.order_user_referee
     * 订单推荐人
     *
     * @mbg.generated 2018-07-16 15:56:26
     */
    private String            orderUserReferee;

    /**
     * order_info.help_money
     * 翻倍金额，单位为分
     *
     * @mbg.generated 2018-09-05 16:47:39
     */
    private Integer           helpMoney;

    /**
     * order_info.help_status
     * 助力状态
     *
     * @mbg.generated 2018-09-05 16:47:39
     */
    private String            helpStatus;

    /**
     * order_info
     * 助力百分比
     *
     * @mbg.generated 2018-09-05 16:47:39
     */
    private Double            helpPercent;
    /**
     * order_info.send_time
     * 发送时间
     *
     * @mbg.generated 2018-09-10 16:40:52
     */
    private Date              sendTime;
    /**
     * 订单类型
     */
    private String            orderType;

    /**
     * order_info.double_percent
     * 加倍比例,百分比
     *
     * @mbg.generated 2018-09-20 16:41:20
     */
    private Double            doublePercent;

    /**
     * order_info.exemption_amount
     * 免单金额
     *
     * @mbg.generated 2018-11-14 11:21:28
     */
    private Integer           exemptionAmount;

    /**
     * promotion_channels_order.channels_code
     * 推广渠道code
     *
     * @mbg.generated 2018-12-04 15:46:13
     */
    private String            channelsCode;

    /**
     * promotion_channels_order.order_promotion_source
     * 订单推广来源
     *
     * @mbg.generated 2018-12-04 15:46:13
     */
    private String            orderPromotionSource;

    private Double            orderPromotionCommission;

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
     *
     *
     * order_info.order_pay_time_ext
     * 支付时间扩展
     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date              orderPayTimeExt;


    /**
     *
     *
     * order_info.order_modify_at_ext

     *
     * @mbg.generated 2019-01-17 11:21:37
     */
    private Date              orderModifyAtExt;

}
