package com.fulihui.duoduoke.demo.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-17
 */
@Setter @Getter
public class UserWithdrawVO extends ToString {
    private static final long serialVersionUID = 6756893818907443762L;


    /**
     * user_withdraw.withdraw_amount
     * 提现金额 单位-分
     *
     * @mbg.generated 2018-07-17 10:04:01
     */
    @ApiModelProperty(value = "金额")
    private String withdrawAmount;
    /**
     * ("1", "审核中"),
     * ("2","提现成功"),
     * ("3","提现失败"),;
     * user_withdraw.status
     * 状态[101:待审核][102:审核通过][103:审核驳回][201:打款中][202:打款失败][203打款成功]
     */
    @ApiModelProperty(value = "状态[1:审核中][2:提现成功,3:提现失败]")
    private String status;
    @ApiModelProperty(value = "状态描述")
    private String statusDesc;
    /**
     * 审核驳回描述
     */
    @ApiModelProperty(value = "审核驳回描述")
    private String auditRemark;
    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private String time;


}
