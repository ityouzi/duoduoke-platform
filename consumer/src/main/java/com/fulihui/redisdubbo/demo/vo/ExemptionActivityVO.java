package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.near.toolkit.model.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/11/14 17:25
 */
@Data
public class ExemptionActivityVO extends ToString {

    private static final long      serialVersionUID = -1359951219027352786L;
    /**
     * banner图片地址
     */
    @ApiModelProperty(value = "banner图片地址")
    private String                 bannerImgPath;

    /**
     * 规则描述
     */
    @ApiModelProperty(value = "活动规则描述")
    private String                 ruleRemark;

    /**
     * 分享标题
     */
    @ApiModelProperty(value = "分享标题")
    private String                 shareTitle;

    /**
     * 分享图片地址
     */
    @ApiModelProperty(value = "分享图片地址")
    private String                 shareImgPath;

    /**
     * 活动截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "距离活动结束剩余毫秒数")
    private Long                   endTimestamp;

    /**
     * 活动状态
     */
    @ApiModelProperty(value = "活动状态 1:开启 2：关闭")
    private Integer                activityState;

    /**
     * 活动商品列表
     */
    private List<ExemptionGoodsVO> commoditys;
}
