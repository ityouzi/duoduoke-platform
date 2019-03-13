package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/7/16 16:21
 */
@Getter
@Setter
public class UserWithdrawCreateRequest extends ToString {
    private static final long serialVersionUID = 1L;

    /**
     * user_withdraw.user_id
     * 用户Id
    
     */
    private String            userId;

    /**
     * user_withdraw.withdraw_type
     * 提现类型[wechat]
     * @see com.fulihui.duoduoke.demo.producer.facade.enums.TradeWithDrawTypeEnum
     */
    private String            withdrawType;

    /**
     * user_withdraw.withdraw_amount
     * 提现金额 单位-分
    
     */
    private Long              withdrawAmount;

    /**
     * user_withdraw.open_id
     * 提现账号的openId
     * @mbg.generated 2018-07-10 16:07:26
     */
    private String            openId;

    /**
     * 外部订单号
     */
    private String            outTradeNo;

    /**
     * user_withdraw.status
     * 状态[101:待审核][102:审核通过][103:审核驳回][201:打款中][202:打款失败][203打款成功]
     * @see com.fulihui.duoduoke.demo.producer.facade.enums.WithdrawStatusEnum
     */
    private String            status;

    /**
     * user_withdraw.auditor
     * 审核人
     *
    
     */
    private String            auditor;

    /**
     * user_withdraw.audit_time
     * 审核时间
     *
    
     */
    private Date              auditTime;

    /**
     * user_withdraw.audit_remark
     * 审核驳回描述
    
     */
    private String            auditRemark;

}
