package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 *
 * @author lizhi
 * @date 2018-7-11
 */
@Setter
@Getter
public class UserAccountDetailDTO extends ToString {
    private static final long serialVersionUID = -876375548950129878L;
    /**
     * user_account_detail.id
     * 主键
     */
    private Long id;

    /**
     * user_account_detail.user_id
     * 用户id
     */
    private String userId;

    /**
     * user_account_detail.amount
     * 金额 分为单位
     */
    private Long amount;

    /**
     * user_account_detail.opt_type
     * 操作类型 [0:收入][1:支出]
     */
    private String optType;

    /**
     * user_account_detail.remark
     * 描述
     */
    private String remark;

    /**
     * user_account_detail.out_trade_no
     * 订单id
     */
    private String outTradeNo;

    /**
     * user_account_detail.biz_code
     * 业务代码
     */
    private String bizCode;

    /**
     * user_account_detail.source_code
     * 来源业务编码
     */
    private String sourceCode;

    /**
     * user_account_detail.gmt_create
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * user_account_detail.gmt_modified
     * 修改时间
     */
    private Date gmtModified;
}
