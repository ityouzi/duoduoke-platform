package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/4 0004 9:53
 */
@Setter
@Getter
public class UserRewardInfoVO extends ToString {


    @ApiModelProperty(value = "用户")
    private String userId;

    @ApiModelProperty(value = "用户头像")
    private String userImg;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户助力值")
    private Double userPercent;

    @ApiModelProperty(value = "用户剩余助力值")
    private Double userSurplusPercent;

    @ApiModelProperty(value = "是否助力:true助力 false：未助力")
    private boolean isHelp;

    @ApiModelProperty(value = "助力状态:ONGOING:进行中;EXPIRED:已过期;SUCCEED:已完成;")
    private String helpState;

    @ApiModelProperty(value = "好友助力榜")
    private List<UserRewardRecordVO> recordVOList;

    @ApiModelProperty(value = "分享标题")
    private String shareTitle;

    @ApiModelProperty(value = "分享图片")
    private String shareImg;

    @ApiModelProperty(value = "红包专场id")
    private String redPackageId;

    @ApiModelProperty(value = "助力结束时间")
    private Date stopTime;

    @ApiModelProperty(value = "当前服务器时间")
    private Date nowTime;






}
