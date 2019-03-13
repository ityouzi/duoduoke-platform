package com.fulihui.redisdubbo.demo.vo.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-10-15
 */
@Setter
@Getter
public class UserSignAwardVO extends ToString {
    private static final long serialVersionUID = 9158635646614321128L;
    @ApiModelProperty(value = "奖品时间")
    private String            awardDate;
    @ApiModelProperty(value = "有效期")
    private String            validityPeriod;

    @ApiModelProperty(value = "活动类型 , [1:签到活动] [2:翻牌活动]'")
    private String            activityType;

    @ApiModelProperty(value = "绑定的订单号")
    private String            orderSn;
    @ApiModelProperty(value = "奖品金额")
    private String            prizeMoney;

    @ApiModelProperty(value = "单金额满多少可用")
    private String            overOrderMoney;

    @ApiModelProperty(value = "主键id")
    private Integer           signAwardId;



}
