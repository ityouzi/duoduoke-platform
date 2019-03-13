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
public class UserShareFansVO extends ToString {

    private static final long serialVersionUID = -43070171182324438L;
    /**
     * 累计粉丝
     */
    @ApiModelProperty(value = "累计粉丝")
    private Integer accumulativeFans;
    @ApiModelProperty(value = "累计收入")
    private String accumulativeIncome;
    @ApiModelProperty(value = "累计订单数量")
    private Integer accumulativeOrderNum;

}
