/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.request;


import com.fulihui.redisdubbo.demo.api.enums.WithdrawStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

/**
 * The type Trade update state request.
 *
 * @author Willard.Hu on 2017/11/23.
 */
@Getter
@Setter
public class TradeUpdateStateRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = 4617906560533849995L;

    /**
     * 交易号
     */
    private String tradeNo;
    /**
     * 交易状态
     */
    private String state;
    /**
     * 交易操作备注
     */
    private String remark;
    /**
     * 第三方交易号
     */
    private String thirdTradeNo;

    /**
     * 是否退款(false下不执行账户退款),退款时userid和amount不能为空
     */
    private boolean isRefund = false;

    private String userId;


    /**
     * 提现金额 单为分
     */

    private Long withdrawAmount;


    private Long id;

    private WithdrawStatusEnum statusEnum;


}
