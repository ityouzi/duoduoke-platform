package com.fulihui.redisdubbo.demo.vo.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018-10-12.
 */
@Setter
@Getter
public class SignInPrizeVO extends ToString {
    private static final long serialVersionUID = -7603548023190207222L;
    @ApiModelProperty(value = "签到奖品金额")
    private String            signAmount;
    @ApiModelProperty(value = "签到次数")
    private Integer           signCount;
    @ApiModelProperty(value = "奖品类型 [1:签到奖金] [2:账户余额]")
    private Integer           prizeType;
    @ApiModelProperty(value = "奖品ID")
    private Integer           prizeId;
}
