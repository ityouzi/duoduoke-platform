/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.web.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lizhi
 */
@Getter
@Setter
@ToString
public class WithDrawParam extends FormIdParam {
    /**
     * 提现方式 {@link com.fulihui.duoduoke.demo.producer.facade.enums.TradeWithDrawTypeEnum}
     */
    @ApiModelProperty("提现方式")
    private String withDrawTo;
    @ApiModelProperty("提现金额")
    private String withdrawAmount;


}
