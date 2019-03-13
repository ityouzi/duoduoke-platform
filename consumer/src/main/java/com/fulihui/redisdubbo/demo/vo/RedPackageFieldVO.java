package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-9-10
 */
@Setter
@Getter
public class RedPackageFieldVO extends ToString {
    /**
     * public static final Boolean TRUE = new Boolean(true);
     * public static final Boolean FALSE = new Boolean(false);
     * /**
     * * The {@code Boolean} object corresponding to the primitive
     * * value {@code false}.
     */
    private static final long serialVersionUID = -2587056902298979631L;
    @ApiModelProperty(value = "是否专场已经关闭(true =关闭,false=未关闭)")
    private Boolean close;

    /**
     * 专场id
     */
    @ApiModelProperty(value = "专场id")
    private Integer id;

    /**
     * 专场名称
     */
    @ApiModelProperty(value = "专场名称")
    private String title;

    /**
     * 专场状态[1:有效][2:无效]
     */
    @ApiModelProperty(value = "专场状态[1:有效][2:无效]")
    private Short state;


    /**
     * 专场类型[1:红包专场][2:无助力红包专场]
     */
    @ApiModelProperty(value = "专场类型[1:红包专场][2:无助力红包专场]")
    private Integer type;

    /**
     * 有效时间
     */
    @ApiModelProperty(value = "有效时间")
    private Integer validTime;

    /**
     * 订单pid
     */
    private String orderPid;

    /**
     * 基础红包金额
     */
    @ApiModelProperty(value = "基础红包金额")
    private Integer baseRedPacket;

    /**
     * 助力红包金额
     */
    @ApiModelProperty(value = "助力红包金额")
    private Integer assistanceRedPacket;

    /**
     * 分享的标题
     */
    @ApiModelProperty(value = "分享的标题")
    private String shareTitle;

    /**
     * 分享的图片
     */
    @ApiModelProperty(value = "分享的图片")
    private String shareImg;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
    @ApiModelProperty(value = "当前时间")
    private Date nowTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "是否显示(true =显示,false=不显示)")
    private Boolean show;

    @ApiModelProperty("红包专场商品类型, 1:基础红包专场商品  2:助力红包专场商品 ")
    private String help;
    @ApiModelProperty("领取id")
    private String recordId;
}
