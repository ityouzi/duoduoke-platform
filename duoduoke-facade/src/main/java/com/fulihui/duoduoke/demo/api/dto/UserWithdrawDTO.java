package com.fulihui.duoduoke.demo.api.dto;


import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/7/12 14:20
 */
@Setter
@Getter
public class UserWithdrawDTO extends ToString {
    private static final long serialVersionUID = 1L;
    /**
     *
     *
     * user_withdraw.id
     * 主键
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private Long id;

    /**
     *
     *
     * user_withdraw.user_id
     * 用户Id
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private String userId;

    /**
     *
     *
     * user_withdraw.withdraw_type
     * 提现类型[wechat]
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private String withdrawType;

    /**
     *
     *
     * user_withdraw.withdraw_amount
     * 提现金额 单位-分
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private Long withdrawAmount;

    /**
     *
     *
     * user_withdraw.open_id
     * 提现账号的openId
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private String openId;

    /**
     *
     *
     * user_withdraw.status
     * 状态[101:待审核][102:审核通过][103:审核驳回][201:打款中][202:打款失败][203打款成功]
     * @see WithdrawStatusEnum
     * @mbg.generated 2018-07-10 16:07:26
     */
    private String status;

    /**
     *
     *
     * user_withdraw.auditor
     * 审核人
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private String auditor;

    /**
     *
     *
     * user_withdraw.audit_time
     * 审核时间
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private Date auditTime;

    /**
     *
     *
     * user_withdraw.audit_remark
     * 审核驳回描述
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private String auditRemark;

    /**
     *
     *
     * user_withdraw.out_trade_no
     * 商户订单号
     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private String outTradeNo;

    /**
     *
     *
     * user_withdraw.gmt_create

     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private Date gmtCreate;

    /**
     *
     *
     * user_withdraw.gmt_modified

     *
     * @mbg.generated 2018-07-10 16:07:26
     */
    private Date gmtModified;
}
