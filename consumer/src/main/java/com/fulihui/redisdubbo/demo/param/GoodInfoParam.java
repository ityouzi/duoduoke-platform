package com.fulihui.redisdubbo.demo.param;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/10 0010 18:30
 */
@Setter
@Getter
public class GoodInfoParam extends FormIdParam {
    private static final long serialVersionUID = 6207131546454549415L;
    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long goodsId;
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;
    /**
     * 二级类目
     */
    @ApiModelProperty("二级类目")
    private Integer levelTwo;
    /**
     * 一级类目
     */
    @ApiModelProperty("一级类目")
    private Integer levelOne;

    @ApiModelProperty("优选:1是;0否/和一级类目二选一")
    private String isChoose;

    @ApiModelProperty("是否全部")
    private boolean isAll = false;

    @ApiModelProperty("分享id")
    private String shareId;

    @ApiModelProperty("推广id")
    private String pId;

    @ApiModelProperty("小程序码参数")
    private String scene;

    @ApiModelProperty("小程序版本")
    private String version;
}
