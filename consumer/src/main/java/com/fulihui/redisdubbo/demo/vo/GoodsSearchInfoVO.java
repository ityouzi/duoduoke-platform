package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-16
 */
@Setter @Getter
public class GoodsSearchInfoVO extends ToString {
    private static final long serialVersionUID = -582234046099116753L;

    @ApiModelProperty(value = "参与多多进宝的商品ID")
    private String goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品描述")
    private String goodsDesc;

    @ApiModelProperty(value = "商品缩略图")
    private String goodsThumbnailUrl;

    @ApiModelProperty(value = "商品主图")
    private String goodsImageUrl;


    @ApiModelProperty(value = "商品详情图列表")
    private String goodsGalleryUrls;


    @ApiModelProperty(value = "已售卖件数")
    private String soldQuantity;

    @ApiModelProperty(value = " 最小拼团价格，单位为分")
    private String minGroupPrice;


    @ApiModelProperty(value = "最小单买价格，单位为分")
    private String minNormalPrice;

    @ApiModelProperty(value = "券后价")
    private String salePrice;


    @ApiModelProperty(value = "店铺名称")
    private String mallName;

    @ApiModelProperty(value = "类目id")
    private String categoryId;

    @ApiModelProperty(value = "类目名称")
    private String categoryName;

    @ApiModelProperty(value = "是否有优惠")
    private Boolean hasCoupon;

    @ApiModelProperty(value = "优惠券门槛价格，单位为分")
    private String couponMinOrderAmount;

    @ApiModelProperty(value = "优惠券面额，单位为分")
    private String couponDiscount;

    @ApiModelProperty(value = "优惠券总数量")
    private String couponTotalQuantity;

    @ApiModelProperty(value = "优惠券剩余数量")
    private String couponRemainQuantity;

    @ApiModelProperty(value = "优惠券生效时间")
    private String couponStartTime;

    @ApiModelProperty(value = "优惠券失效时间")
    private String couponEndTime;

    @ApiModelProperty(value = "佣金比例")
    private String promotionPate;

    @ApiModelProperty(value = "商品评价分")
    private String goodsEvalScore;

    @ApiModelProperty(value = "商品评价数量")
    private String goodsEvalCount;

    @ApiModelProperty(value = "")
    private String catId;

    @ApiModelProperty(value = "描述评分")
    private String avgDesc;

    @ApiModelProperty(value = "物流评分")
    private String avgLgst;

    @ApiModelProperty(value = "服务评分")
    private String avgServ;


    @ApiModelProperty(value = "奖励金额")
    private String awardPrice;

    @ApiModelProperty(value = "分享赚金额")
    private String sharePrice;



}
