/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

@Getter
@Setter
public class TradeCreateRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = -3168584467229738015L;

    private String            tradeNo;

    /**
     * 付款人类型
     */
    private String            payerType;
    /**
     * 付款人
     */
    private String            payer;
    /**
     * 收款人类型
     */
    private String            payeeType;
    /**
     * 收款人
     */
    private String            payee;
    /**
     * 交易金额，单位分
     */
    private Long              amount;
    /**
     * 交易状态
     */
    private String            state;
    /**
     * 交易类目
     */
    private String            category;
    /**
     * 交易支付类型
     */
    private String            payType;
    /**
     * 第三方交易号
     */
    private String            thirdTradeNo;
    /**
     * 交易描述
     */
    private String            description;
    /**
     * 交易备注
     */
    private String            remark;

}
