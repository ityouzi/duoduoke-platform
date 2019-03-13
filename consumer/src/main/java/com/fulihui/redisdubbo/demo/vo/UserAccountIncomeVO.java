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
public class UserAccountIncomeVO extends ToString {
    private static final long serialVersionUID = 748195256605809663L;
    /**
     * 累计收入
     */
    @ApiModelProperty(value = "累计收入")
    private String accumulativeIncome;
    @ApiModelProperty(value = "审核中收入")
    private String auditIncome;


}
