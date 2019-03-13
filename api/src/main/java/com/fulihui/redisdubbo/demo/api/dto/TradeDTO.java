/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.dto;



import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Setter
@Getter
public class TradeDTO extends ToString {
    private static final long serialVersionUID = -1903737138957986086L;

    /**
     * 交易号
     */
    private String tradeNo;
    /**
     * 付款人类型
     */
    private String payerType;
    /**
     * 付款人
     */
    private String payer;
    /**
     * 收款人类型
     */
    private String payeeType;
    /**
     * 收款人
     */
    private String payee;
    /**
     * 交易金额，单位分
     */
    private Long amount;
    /**
     * 交易状态
     */
    private String state;
    /**
     * 交易类型
     */
    private String category;
    /**
     * 交易支付类型
     * category 为 {@link TradeCategoryEnum#WITH_DRAW } 时，取值 {@link com.fulihui.redisdubbo.demo.producer.facade.enums.TradeWithDrawTypeEnum}<p/>
     */
    private String payType;
    /**
     * 第三方交易号
     */
    private String thirdTradeNo;
    /**
     * 交易描述
     */
    private String description;
    /**
     * 交易备注
     */
    private String remark;


    /**
     * trade.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private Date gmtCreate;

    /**
     * trade.create_by
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String createBy;

    /**
     * trade.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private Date gmtModified;

    /**
     * trade.modified_by
     * 修改人
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String modifiedBy;
}
