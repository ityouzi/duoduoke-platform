package com.fulihui.duoduoke.demo.web.param;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/11/14 0014 10:04
 */
@Setter
@Getter
public class ExemptionGoodInfoParam extends ToString {
    private static final long serialVersionUID = 6207131546454549415L;
    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private String goodsId;
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;


    @ApiModelProperty(value = "活动id")
    private Integer activityId;





}
