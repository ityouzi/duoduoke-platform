package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-31
 */
@Setter @Getter
public class UserInvitationVO extends ToString {
    private static final long serialVersionUID = 8927393434732924006L;
    @ApiModelProperty(value = "今日新增好友")
    private Integer dayFansNum;
    @ApiModelProperty(value = "昨日新增好友")
    private Integer yesterdayFansNum;
    @ApiModelProperty(value = "本月新增好友")
    private Integer monthFansNum;


    @ApiModelProperty(value = "今日预估补贴")
    private String daySubsidyAmount;
    @ApiModelProperty(value = "昨日预估补贴")
    private String yesterdaySubsidyAmount;
    @ApiModelProperty(value = "本月预估补贴")
    private String monthSubsidyAmount;

    @ApiModelProperty(value = "今日预估订单")
    private Integer dayOrder;
    @ApiModelProperty(value = "昨日预估订单")
    private Integer yesterdayOrder;
    @ApiModelProperty(value = "本月预估订单")
    private Integer monthOrder;

    @ApiModelProperty(value = "累计")
    private UserShareFansVO shareFans;
}
