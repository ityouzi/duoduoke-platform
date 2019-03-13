package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018/7/10 0010.
 */
@Getter
@Setter
public class GoodsInfoList extends ToString {

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
     * duoduo_goods_info.goods_thumbnail_url
     * 商品缩略图
     */
    @ApiModelProperty(value = "商品缩略图")
    private String goodsThumbnailUrl;


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



    @ApiModelProperty("判断是否有优惠券,有值")
    private boolean hasCoupon;

    @ApiModelProperty("今日成交量")
    private Integer saleNumToday;


}
