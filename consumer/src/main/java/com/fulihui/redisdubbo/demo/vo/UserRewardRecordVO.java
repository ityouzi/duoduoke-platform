package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/4 0004 9:53
 */
@Setter
@Getter
public class UserRewardRecordVO extends ToString {

    @ApiModelProperty(value = "主键")
    private Integer id;


    @ApiModelProperty(value = "助力用户")
    private String helpUserId;

    @ApiModelProperty(value = "助力值")
    private Double helpPercent;

    @ApiModelProperty(value = "时间")
    private String createTime;

    @ApiModelProperty(value = "助力用户头像")
    private String helpUserImg;

    @ApiModelProperty(value = "助力用户昵称")
    private String helpNickName;


}
