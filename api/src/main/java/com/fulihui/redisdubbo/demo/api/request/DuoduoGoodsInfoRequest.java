package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

@Setter @Getter
public class DuoduoGoodsInfoRequest extends PageRequest {
    private static final long serialVersionUID = -4254698836990658501L;
    /**
    *
    *
    * duoduo_goods_info.id
    
     *
     *
     */
    private Integer id;

    /**
    *
    *
    * duoduo_goods_info.goods_id
     * 商品编码
     *
     *
     */
    private Long goodsId;

    /**
    *
    *
    * duoduo_goods_info.goods_name
     * 商品标题
     *
     *
     */
    private String goodsName;

    /**
    *
    *
    * duoduo_goods_info.goods_desc
     * 商品描述
     *
     *
     */
    private String goodsDesc;

    /**
    *
    *
    * duoduo_goods_info.goods_thumbnail_url
     * 商品缩略图
     *
     *
     */
    private String goodsThumbnailUrl;

    /**
    *
    *
    * duoduo_goods_info.goods_image_url
     * 商品主图
     *
     *
     */
    private String goodsImageUrl;

    /**
    *
    *
    * duoduo_goods_info.sold_quantity
     * 已售卖件数
     *
     *
     */
    private Integer soldQuantity;

    /**
    *
    *
    * duoduo_goods_info.mall_name
     * 店铺名称
     *
     *
     */
    private String mallName;

    /**
    *
    *
    * duoduo_goods_info.min_normal_price
     * 最小单买价格单位为分
     *
     *
     */
    private Integer minNormalPrice;

    /**
    *
    *
    * duoduo_goods_info.min_group_price
     * 最小拼团价格单位为分
     *
     *
     */
    private Integer minGroupPrice;

    /**
    *
    *
    * duoduo_goods_info.opt_name
     * 商品标签名
     *
     *
     */
    private String optName;

    /**
    *
    *
    * duoduo_goods_info.opt_id
     * 商品标签ID 
     *
     *
     */
    private Integer optId;

    /**
    *
    *
    * duoduo_goods_info.cat_ids
     * 商品类目ID
     *
     *
     */
    private String catIds;

    /**
    *
    *
    * duoduo_goods_info.level_one
     * 1级类目
     *
     *
     */
    private Integer levelOne;

    /**
    *
    *
    * duoduo_goods_info.level_two
     * 2级类目
     *
     *
     */
    private Integer levelTwo;

    /**
    *
    *
    * duoduo_goods_info.level_three
     * 3级类目
     *
     *
     */
    private Integer levelThree;

    /**
    *
    *
    * duoduo_goods_info.has_coupon
     * 是否有优惠券
     *
     *
     */
    private String hasCoupon;

    /**
    *
    *
    * duoduo_goods_info.avg_serv
     * 服务评分
     *
     *
     */
    private Integer avgServ;

    /**
    *
    *
    * duoduo_goods_info.avg_lgst
     * 物流评分
     *
     *
     */
    private Integer avgLgst;

    /**
    *
    *
    * duoduo_goods_info.avg_desc
     * 描述评分
     *
     *
     */
    private Integer avgDesc;

    /**
    *
    *
    * duoduo_goods_info.goods_gallery_urls
     * 商品轮播列表
     *
     *
     */
    private String goodsGalleryUrls;

    /**
    *
    *
    * duoduo_goods_info.goods_eval_count
     * 商品评价数量
     *
     *
     */
    private String goodsEvalCount;

    /**
    *
    *
    * duoduo_goods_info.goods_eval_score
     * 商品评价分
     *
     *
     */
    private String goodsEvalScore;

    /**
    *
    *
    * duoduo_goods_info.promotion_rate
     * 佣金比例千分比
     *
     *
     */
    private String promotionRate;

    /**
    *
    *
    * duoduo_goods_info.coupon_end_time
     * 优惠券失效时间UNIX时间戳
     *
     *
     */
    private Date couponEndTime;

    /**
    *
    *
    * duoduo_goods_info.coupon_start_time
     * 优惠券失效时间UNIX时间戳
     *
     *
     */
    private Date couponStartTime;

    /**
    *
    *
    * duoduo_goods_info.coupon_remain_quantity
     * 优惠券剩余数量
     *
     *
     */
    private Integer couponRemainQuantity;

    /**
    *
    *
    * duoduo_goods_info.coupon_total_quantity
     * 优惠券总数量
     *
     *
     */
    private Integer couponTotalQuantity;

    /**
    *
    *
    * duoduo_goods_info.coupon_discount
     * 优惠券面额单位为分
     *
     *
     */
    private Integer couponDiscount;

    /**
    *
    *
    * duoduo_goods_info.coupon_min_order_amount
     * 优惠券门槛价格单位为分
     *
     *
     */
    private Integer couponMinOrderAmount;

    /**
    *
    *
    * duoduo_goods_info.gmt_create
     * 创建时间
     *
     *
     */
    private Date gmtCreate;

    /**
    *
    *
    * duoduo_goods_info.gmt_modified
     * 修改时间
     *
     *
     */
    private Date gmtModified;

    /**
    *
    *
    * duoduo_goods_info.goods_sn
     * 商品序列码
     *
     *
     */
    private String goodsSn;

    /**
    *
    *
    * duoduo_goods_info.goods_type
    
     *
     *
     */
    private String goodsType;

    /**
    *
    *
    * duoduo_goods_info.detail_update
    
     *
     *
     */
    private Date detailUpdate;

    /**
    *
    *
    * duoduo_goods_info.is_choose
     * 是否优选
     *
     *
     */
    private String isChoose;

    /**
    *
    *
    * duoduo_goods_info.choose_sort
    
     *
     * @mbg.generated GoodsChooseEnum
     */
    private Integer chooseSort;

    /**
    *
    *
    * duoduo_goods_info.sort
    
     *
     *
     */
    private Integer sort;

    /**
    *
    *
    * duoduo_goods_info.state
     * 上下架状态
     *
     * @mbg.generated GoodsStateEnum
     */
    private String state;

    //排序字段
    private String orderByClause;

    /**
     * 角标Id
     */
    private Integer markId;

}