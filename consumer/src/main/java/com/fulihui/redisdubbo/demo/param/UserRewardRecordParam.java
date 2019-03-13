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
public class UserRewardRecordParam extends FormIdParam {

    @ApiModelProperty("订单号")
    private String orderSn;

    @ApiModelProperty("userId")
    private String userId;



}
