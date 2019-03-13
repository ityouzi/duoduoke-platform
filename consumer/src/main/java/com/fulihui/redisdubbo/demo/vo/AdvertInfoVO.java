package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:08
 */
@Setter
@Getter
public class AdvertInfoVO extends ToString {

    private static final long serialVersionUID = -3375465829342621575L;
    /**
     * goods_cat_info.id
     */
    @ApiModelProperty(value ="主键id")
    private Long id;

    /**
     *
     *
     * advert.advert_img
     * 广告图
     *
     * @mbg.generated 2018-08-02 11:24:12
     */
    @ApiModelProperty(value ="广告图")
    private String advertImg;


    @ApiModelProperty(value ="跳转地址")
    private String imgUrl;

    /**
     *
     *
     * advert.type
     * 小程序地址
     *
     * @mbg.generated 2018-08-02 16:18:19
     */
    @ApiModelProperty(value ="地址类型0:h5;1:小程序")
    private String type;


    @ApiModelProperty(value ="名称")
    private String title;

}
