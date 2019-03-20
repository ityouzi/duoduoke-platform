package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018/7/10 0010
 */
@Getter
@Setter
public class ExemptionGoodsVO extends ToString {

    private static final long serialVersionUID = -8526865706594452148L;

    @ApiModelProperty(value = "id")
    private Integer           id;

    @ApiModelProperty(value = "商品id")
    private String              goodsId;

    @ApiModelProperty(value = "活动id")
    private Integer           activityId;

    @ApiModelProperty(value = "商品标题")
    private String            exemptionGoodsName;

    @ApiModelProperty(value = "自定义说明")
    private String            goodsDesc;

    @ApiModelProperty(value = "支付金额")
    private String            payAmount;

    @ApiModelProperty(value = "返利金额")
    private String            backAmount;

    @ApiModelProperty(value = "商品缩略图")
    private String            goodsThumbnailUrl;

    /**
     * duoduo_goods_info.goods_gallery_urls
     * 商品轮播列表
     */
    @ApiModelProperty("轮播图")
    private String[]          goodsGalleryUrls;

    @ApiModelProperty("状态 [1:开启][2:关闭][3:不展示]")
    private Integer           state;

    @ApiModelProperty("剩余数量")
    private Integer           surplusNum;

    @ApiModelProperty(value = "当前时间")
    private Long              nowTime;

    @ApiModelProperty(value = "限量数量")
    private Integer           exemptionNum;

    @ApiModelProperty(value = "抢完时间")
    private String gmtReceive;
}
