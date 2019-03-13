package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class DuoduoGoodsInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * duoduo_goods_info.id
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer id;
    /**
     * duoduo_goods_info.goods_id
     * 商品编码
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Long goodsId;
    /**
     * duoduo_goods_info.goods_name
     * 商品标题
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsName;
    /**
     * duoduo_goods_info.goods_desc
     * 商品描述
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsDesc;
    /**
     * duoduo_goods_info.goods_thumbnail_url
     * 商品缩略图
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsThumbnailUrl;
    /**
     * duoduo_goods_info.goods_image_url
     * 商品主图
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsImageUrl;
    /**
     * duoduo_goods_info.sold_quantity
     * 已售卖件数
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer soldQuantity;
    /**
     * duoduo_goods_info.mall_name
     * 店铺名称
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String mallName;
    /**
     * duoduo_goods_info.min_normal_price
     * 最小单买价格单位为分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer minNormalPrice;
    /**
     * duoduo_goods_info.min_group_price
     * 最小拼团价格单位为分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer minGroupPrice;
    /**
     * duoduo_goods_info.opt_name
     * 商品标签名
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String optName;
    /**
     * duoduo_goods_info.opt_id
     * 商品标签ID
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer optId;
    /**
     * duoduo_goods_info.cat_ids
     * 商品类目ID
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String catIds;
    /**
     * duoduo_goods_info.level_one
     * 1级类目
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer levelOne;
    /**
     * duoduo_goods_info.level_two
     * 2级类目
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer levelTwo;
    /**
     * duoduo_goods_info.level_three
     * 3级类目
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer levelThree;
    /**
     * duoduo_goods_info.has_coupon
     * 是否有优惠券
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String hasCoupon;
    /**
     * duoduo_goods_info.avg_serv
     * 服务评分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer avgServ;
    /**
     * duoduo_goods_info.avg_lgst
     * 物流评分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer avgLgst;
    /**
     * duoduo_goods_info.avg_desc
     * 描述评分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer avgDesc;
    /**
     * duoduo_goods_info.goods_gallery_urls
     * 商品轮播列表
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsGalleryUrls;
    /**
     * duoduo_goods_info.goods_eval_count
     * 商品评价数量
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer goodsEvalCount;
    /**
     * duoduo_goods_info.goods_eval_score
     * 商品评价分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsEvalScore;
    /**
     * duoduo_goods_info.promotion_rate
     * 佣金比例千分比
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer promotionRate;
    /**
     * duoduo_goods_info.coupon_end_time
     * 优惠券失效时间UNIX时间戳
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Date couponEndTime;
    /**
     * duoduo_goods_info.coupon_start_time
     * 优惠券失效时间UNIX时间戳
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Date couponStartTime;
    /**
     * duoduo_goods_info.coupon_remain_quantity
     * 优惠券剩余数量
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer couponRemainQuantity;
    /**
     * duoduo_goods_info.coupon_total_quantity
     * 优惠券总数量
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer couponTotalQuantity;
    /**
     * duoduo_goods_info.coupon_discount
     * 优惠券面额单位为分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer couponDiscount;
    /**
     * duoduo_goods_info.coupon_min_order_amount
     * 优惠券门槛价格单位为分
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer couponMinOrderAmount;
    /**
     * duoduo_goods_info.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Date gmtCreate;
    /**
     * duoduo_goods_info.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Date gmtModified;
    /**
     * duoduo_goods_info.goods_sn
     * 商品序列码
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsSn;
    /**
     * duoduo_goods_info.goods_type
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String goodsType;
    /**
     * duoduo_goods_info.detail_update
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Date detailUpdate;
    /**
     * duoduo_goods_info.is_choose
     * 是否优选
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String isChoose;
    /**
     * duoduo_goods_info.choose_sort
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer chooseSort;
    /**
     * duoduo_goods_info.sort
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private Integer sort;
    /**
     * duoduo_goods_info.state
     * 上下架状态
     *
     * @mbg.generated 2018-07-11 11:22:20
     */
    private String state;
    private Integer saleNum24;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", goodsThumbnailUrl=").append(goodsThumbnailUrl);
        sb.append(", goodsImageUrl=").append(goodsImageUrl);
        sb.append(", soldQuantity=").append(soldQuantity);
        sb.append(", mallName=").append(mallName);
        sb.append(", minNormalPrice=").append(minNormalPrice);
        sb.append(", minGroupPrice=").append(minGroupPrice);
        sb.append(", optName=").append(optName);
        sb.append(", optId=").append(optId);
        sb.append(", catIds=").append(catIds);
        sb.append(", levelOne=").append(levelOne);
        sb.append(", levelTwo=").append(levelTwo);
        sb.append(", levelThree=").append(levelThree);
        sb.append(", hasCoupon=").append(hasCoupon);
        sb.append(", avgServ=").append(avgServ);
        sb.append(", avgLgst=").append(avgLgst);
        sb.append(", avgDesc=").append(avgDesc);
        sb.append(", goodsGalleryUrls=").append(goodsGalleryUrls);
        sb.append(", goodsEvalCount=").append(goodsEvalCount);
        sb.append(", goodsEvalScore=").append(goodsEvalScore);
        sb.append(", promotionRate=").append(promotionRate);
        sb.append(", couponEndTime=").append(couponEndTime);
        sb.append(", couponStartTime=").append(couponStartTime);
        sb.append(", couponRemainQuantity=").append(couponRemainQuantity);
        sb.append(", couponTotalQuantity=").append(couponTotalQuantity);
        sb.append(", couponDiscount=").append(couponDiscount);
        sb.append(", couponMinOrderAmount=").append(couponMinOrderAmount);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", detailUpdate=").append(detailUpdate);
        sb.append(", isChoose=").append(isChoose);
        sb.append(", chooseSort=").append(chooseSort);
        sb.append(", sort=").append(sort);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}