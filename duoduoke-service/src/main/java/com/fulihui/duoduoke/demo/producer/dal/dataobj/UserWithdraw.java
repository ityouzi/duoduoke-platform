package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * The type User withdraw.
 *
 * @author Administrator
 */
@Setter
@Getter
public class UserWithdraw implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_withdraw.id
     * 主键
     */
    private Long id;
    /**
     * user_withdraw.user_id
     * 用户Id
     */
    private String userId;
    /**
     * user_withdraw.withdraw_type
     * 提现类型[wechat]
     */
    private String withdrawType;
    /**
     * user_withdraw.withdraw_amount
     * 提现金额 单位-分
     */
    private Long withdrawAmount;
    /**
     * user_withdraw.open_id
     * 提现账号的openId
     */
    private String openId;
    /**
     * user_withdraw.status
     * 状态[101:待审核][102:审核通过][103:审核驳回][201:打款中][202:打款失败][203打款成功]
     */
    private String status;
    /**
     * user_withdraw.auditor
     * 审核人
     */
    private String auditor;
    /**
     * user_withdraw.audit_time
     * 审核时间
     */
    private Date auditTime;
    /**
     * user_withdraw.audit_remark
     * 审核驳回描述
     */
    private String auditRemark;
    /**
     * user_withdraw.out_trade_no
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * user_withdraw.gmt_create
     */
    private Date gmtCreate;
    /**
     * user_withdraw.gmt_modified
     *
     * @mbg.generated 2018-07-17 10:04:01
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", withdrawType=").append(withdrawType);
        sb.append(", withdrawAmount=").append(withdrawAmount);
        sb.append(", openId=").append(openId);
        sb.append(", status=").append(status);
        sb.append(", auditor=").append(auditor);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", auditRemark=").append(auditRemark);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}