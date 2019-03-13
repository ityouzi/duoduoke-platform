package com.fulihui.redisdubbo.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 *
 * @author lizhi
 * @date 2018-7-16
 */
@Setter @Getter
public class OrderStatusCountVO extends ToString {

    private static final long serialVersionUID = 2882350921379460085L;
    /**
     * 待确认
     */
    @ApiModelProperty(value = "待确认数量")
    private Long confirmedCount;
    /**
     * 待结算
     */
    @ApiModelProperty(value = "待结算数量")
    private Long settlementCount;
    /**
     * 最近下单数量
     */
    @ApiModelProperty(value = "最近下单数量")
    private Long recentCount;


}

