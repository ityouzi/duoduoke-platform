package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Setter
@Getter
public class UserOrderVO extends ToString {
    private static final long serialVersionUID = -761768097226281243L;
    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间")
    private String            orderCreateTime;
    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private String            orderSn;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String            goodsName;
    /**
     * 商品缩略图
     */
    @ApiModelProperty(value = "商品缩略图")
    private String            goodsThumbnailUrl;
    /**
     * 订单状态描述
     */
    @ApiModelProperty(value = "订单状态描述")
    private String            orderStatusDesc;
    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    private String            orderStatus;
    /**
     * 订单总额
     */
    @ApiModelProperty(value = "订单总额")
    private String            orderTotal;
    /**
     * 返利金额=(预估奖||已奖励)
     */
    @ApiModelProperty(value = "返利金额=(预估奖||已奖励)")
    private String            rebateAmount;
    /**
     * 订单描述
     */
    @ApiModelProperty(value = "订单描述")
    private String            orderDesc;

    @ApiModelProperty(value = "EXT订单状态")
    private String            extOrderStatus;

    /**
     * 订单状态描述
     */
    @ApiModelProperty(value = "EXT订单状态描述")
    private String            extOrderStatusDesc;

    @ApiModelProperty(value = "级别")
    private Integer           level;
    /**
     * 订单标签
     */
    @ApiModelProperty(value = "订单标签")
    private String            tag;

    @ApiModelProperty(value = "是否显示（分享得奖励翻倍）  on=开启 || off、字段或者为空=关闭,end=结束")
    private String            helpStatus;

    @ApiModelProperty(value = "翻倍金额")
    private String            helpMoney;
    /**
     * 订单类型
     */

    @ApiModelProperty(value = "订单类型, orderType为空或者等于零,0=常规订单 ,1=翻倍订单,2=加倍订单,3=免单返现订单")
    private String            orderType;
    /**
     * 基础金额
     */
    @ApiModelProperty(value = "基础金额")
    private String            basisAmount;

    /**
     * 加倍金额
     */
    @ApiModelProperty(value = "加倍金额")
    private String            doubleAmount;

    /**
     * 免单返现金额
     */
    @ApiModelProperty(value = "免单返现金额")
    private String            cashBackAmount;

    @ApiModelProperty(value = "免单商品页标题")
    private String            exemptionGoodsName;

}
