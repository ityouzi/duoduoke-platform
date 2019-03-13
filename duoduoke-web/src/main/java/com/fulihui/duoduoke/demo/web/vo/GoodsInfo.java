package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018/7/10 0010.
 */
@Getter
@Setter
public class GoodsInfo extends ToString {

    private static final long serialVersionUID = -8526865706594452148L;
    /**
     * duoduo_goods_info.id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * duoduo_goods_info.goods_id
     * 商品编码
     */
    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    /**
     * duoduo_goods_info.goods_name
     * 商品标题
     */
    @ApiModelProperty(value = "商品标题")
    private String goodsName;

    /**
     * duoduo_goods_info.goods_desc
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String goodsDesc;

    /**
     * duoduo_goods_info.goods_thumbnail_url
     * 商品缩略图
     */
    @ApiModelProperty(value = "商品缩略图")
    private String goodsThumbnailUrl;

    /**
     * duoduo_goods_info.goods_image_url
     * 商品主图
     */
    @ApiModelProperty(value = "商品主图")
    private String goodsImageUrl;

    /**
     * duoduo_goods_info.sold_quantity
     * 已售卖件数
     */
    @ApiModelProperty(value = "已售卖件数")
    private Integer soldQuantity;


    /**
     * duoduo_goods_info.min_group_price
     * 最小拼团价格单位为分
     */
    @ApiModelProperty(value = "价格")
    private String minGroupPrice;

    @ApiModelProperty(value = "券后价格")
    private String salePrice;


    @ApiModelProperty(value = "奖励金额")
    private String awardPrice;


    /**
     * duoduo_goods_info.goods_gallery_urls
     * 商品轮播列表
     */
    @ApiModelProperty("轮播图")
    private String[] goodsGalleryUrls;


    /**
     * duoduo_goods_info.coupon_end_time
     * 优惠券失效时间UNIX时间戳
     */
    @ApiModelProperty("优惠券失效时间")
    private String couponEndTime;

    /**
     * duoduo_goods_info.coupon_start_time
     * 优惠券失效时间UNIX时间戳
     */
    @ApiModelProperty("优惠券生效时间")
    private String couponStartTime;

    /**
     * duoduo_goods_info.coupon_remain_quantity
     * 优惠券剩余数量
     */
    @ApiModelProperty("优惠券剩余数量")
    private Integer couponRemainQuantity;


    /**
     * duoduo_goods_info.coupon_discount
     * 优惠券面额单位为分
     */
    @ApiModelProperty("优惠券面额")
    private String couponDiscount;

    @ApiModelProperty("判断是否有优惠券,有值")
    private boolean hasCoupon;

    @ApiModelProperty("生成后的商品推广链接")
    private GoodsPromotionUrlVO promotionUrlVO;


    @ApiModelProperty(value = "分享赚金额")
    private String sharePrice;

    @ApiModelProperty("24小时成交量")
    private Integer saleNum24;

    @ApiModelProperty("分享人userId")
    private String shareUserId;

    @ApiModelProperty("pid")
    private String pid;


    @ApiModelProperty("角标图")
    private String markUrl;

    @ApiModelProperty(value = "基础金额")
    private String basicsPrice;

    @ApiModelProperty(value = "加倍金额")
    private String doublePrice;

    @ApiModelProperty(value = "活动过期时间")
    private long activityStopTime;

    @ApiModelProperty(value = "当前时间")
    private long nowTime;

    @ApiModelProperty(value = "加倍结束时间")
    private long doubleStopTime;

    @ApiModelProperty(value = "奖励加倍结束状态:ON:未结束;OFF:结束")
    private String doubleState;


    //是否有加倍活动 "0"，有加倍活动包含未开始
    private String isActivity;

}
