package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-16
 */
@Setter @Getter
public class UserBalanceVO extends ToString {

    private static final long serialVersionUID = 4747761158970084931L;
    @ApiModelProperty(value = "余额")
    private String balance;
    @ApiModelProperty(value = "是否有提现中的任务")
    private Boolean hasWithdraw;
    @ApiModelProperty(value = "提现页面类型")
    private String withdrawalType;
}
