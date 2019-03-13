package com.fulihui.duoduoke.demo.web.vo.sign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * @author Administrator
 */
@Setter
@Getter
public class SignUserRecordVO extends ToString {
    private static final long serialVersionUID = 8887706862913842352L;

    @ApiModelProperty(value = "周期累计签到次数")
    private Integer cycleSignNum;
    @ApiModelProperty(value = "周期签到详细信息")

    private List<SignUserRecordDetailVO> list;
    @ApiModelProperty(value = "周期签到对应奖品信息")
    private List<SignInPrizeVO> prizeList;
    @ApiModelProperty(value = "1=立即签到,4=今日已签到,2=今日签到有翻牌机会,3=分享可得一次翻牌机会,5=今日分享有翻牌机会")
    private Integer signStatus;
    @ApiModelProperty(value = "签到的id ")
    private Integer id;
    @ApiModelProperty(value = "当前签到第几天")
    private Integer days;
    @ApiModelProperty(value = "是否可以补签")
    private Boolean isSupplement;

    @ApiModelProperty(value = "未使用的签到奖金,注：如果字段的值不等于空并且大于0则显示该字段")
    private String notSignedBonus;
}