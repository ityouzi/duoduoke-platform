package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class UserAccountDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_account_detail.id
     * 主键
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private Long id;
    /**
     * user_account_detail.user_id
     * 用户id
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private String userId;
    /**
     * user_account_detail.amount
     * 金额 分为单位
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private Long amount;
    /**
     * user_account_detail.opt_type
     * 操作类型 [0:收入][1:支出]
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private String optType;
    /**
     * user_account_detail.remark
     * 描述
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private String remark;
    /**
     * user_account_detail.out_trade_no
     * 订单id
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private String outTradeNo;
    /**
     * user_account_detail.biz_code
     * 业务代码
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private String bizCode;
    /**
     * user_account_detail.source_code
     * 来源业务编码
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private String sourceCode;
    /**
     * user_account_detail.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private Date gmtCreate;
    /**
     * user_account_detail.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private Date gmtModified;
    /**
     * user_account_detail.operator
     *
     * @mbg.generated 2018-07-12 10:33:26
     */
    private String operator;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append(", optType=").append(optType);
        sb.append(", remark=").append(remark);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", bizCode=").append(bizCode);
        sb.append(", sourceCode=").append(sourceCode);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", operator=").append(operator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}