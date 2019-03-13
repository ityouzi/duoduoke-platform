package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Setter @Getter
public class UserAccountDetailVO extends ToString {
    private static final long serialVersionUID = -1273293440826899406L;

    /**
     * 支出
     * 收入
     * <p>
     * INCOME("0", "收入"),
     * <p>
     * OUTLAY("1", "支出"),;
     *
     * @see com.fulihui.duoduoke.facade.enums.UserAccountOptTypeEnum
     */
    @ApiModelProperty(value = "0=收入,1=支出")
    private String optType;
    @ApiModelProperty(value = "类型描述")
    private String optTypeDesc;
    /**
     * /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private String amount;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String remark;
    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private String time;
}
