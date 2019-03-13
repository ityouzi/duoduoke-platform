package com.fulihui.duoduoke.demo.web.vo;

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
public class UserRewardVO extends ToString {


    @ApiModelProperty(value = "是否助力成功")
    private boolean           success = false;
    @ApiModelProperty(value = "助力错误码")
    private String            errorCode;
    @ApiModelProperty(value = "助力错误码信息")
    private String            errorMessage;

    @ApiModelProperty(value = "助力值")
    private Double helpPercent;






}
