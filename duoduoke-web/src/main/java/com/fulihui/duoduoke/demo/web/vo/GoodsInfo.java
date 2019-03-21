package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * Created by lizhi on 2018/7/10 0010.
 */
@Getter
@Setter
public class GoodsInfo extends ToString {


    /**
     * goods_info.id
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * goods_info.goods_id
     * 商品编码
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    @ApiModelProperty(value = "商品id")
    private String goodsId;

    /**
     * goods_info.goods_name
     * 商品标题
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    @ApiModelProperty(value = "商品标题")
    private String goodsName;

    /**
     * goods_info.goods_desc
     * 商品描述
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    @ApiModelProperty(value = "商品描述")
    private String goodsDesc;

    /**
     * goods_info.goods_thumbnail_url
     * 商品缩略图
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    @ApiModelProperty(value = "商品缩略图")
    private String goodsThumbnailUrl;

    /**
     * goods_info.goods_image_url
     * 商品主图
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    @ApiModelProperty(value = "商品主图")
    private String goodsImageUrl;

    /**
     * goods_info.sold_quantity
     * 已售卖件数
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    @ApiModelProperty(value = "已售卖件数")
    private Integer soldQuantity;

    /**
     * goods_info.mall_name
     * 店铺名称
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String mallName;

    /**
     * goods_info.min_normal_price
     * 最小单买价格单位为分
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    @ApiModelProperty(value = "价格")

    private Integer minNormalPrice;

    /**
     * goods_info.min_group_price
     * 最小拼团价格单位为分
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer minGroupPrice;

    /**
     * goods_info.opt_name
     * 商品标签名
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String optName;

    /**
     * goods_info.opt_id
     * 商品标签ID
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer optId;

    /**
     * goods_info.cat_ids
     * 商品类目ID
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String catIds;

    /**
     * goods_info.level_one
     * 1级类目
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer levelOne;

    /**
     * goods_info.level_two
     * 2级类目
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer levelTwo;

    /**
     * goods_info.level_three
     * 3级类目
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer levelThree;

    /**
     * goods_info.has_coupon
     * 是否有优惠券
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String hasCoupon;

    /**
     * goods_info.avg_serv
     * 服务评分
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer avgServ;

    /**
     * goods_info.avg_lgst
     * 物流评分
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer avgLgst;

    /**
     * goods_info.avg_desc
     * 描述评分
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer avgDesc;

    /**
     * goods_info.goods_gallery_urls
     * 商品轮播列表
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String goodsGalleryUrls;

    /**
     * goods_info.goods_eval_count
     * 商品评价数量
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer goodsEvalCount;

    /**
     * goods_info.goods_eval_score
     * 商品评价分
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String goodsEvalScore;

    /**
     * goods_info.promotion_rate
     * 佣金比例千分比
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer promotionRate;

    /**
     * goods_info.coupon_end_time
     * 优惠券失效时间UNIX时间戳
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Date couponEndTime;

    /**
     * goods_info.coupon_start_time
     * 优惠券失效时间UNIX时间戳
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Date couponStartTime;

    /**
     * goods_info.coupon_remain_quantity
     * 优惠券剩余数量
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer couponRemainQuantity;

    /**
     * goods_info.coupon_total_quantity
     * 优惠券总数量
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer couponTotalQuantity;

    /**
     * goods_info.coupon_discount
     * 优惠券面额单位为分
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer couponDiscount;

    /**
     * goods_info.coupon_min_order_amount
     * 优惠券门槛价格单位为分
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer couponMinOrderAmount;

    /**
     * goods_info.gmt_create
     * 创建时间
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Date gmtCreate;

    /**
     * goods_info.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Date gmtModified;

    /**
     * goods_info.goods_sn
     * 商品序列码
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String goodsSn;

    /**
     * goods_info.goods_type
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String goodsType;

    /**
     * goods_info.detail_update
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Date detailUpdate;

    /**
     * goods_info.is_choose
     * 是否优选
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String isChoose;

    /**
     * goods_info.choose_sort
     * 1是0否
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer chooseSort;

    /**
     * goods_info.sort
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private Integer sort;

    /**
     * goods_info.state
     * 上下架状态0:上架；1下架；2初始化3过期
     *
     * @mbg.generated 2019-03-20 17:32:25
     */
    private String state;


    private String salePrice;


    @ApiModelProperty(value = "奖励金额")
    private String awardPrice;


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
