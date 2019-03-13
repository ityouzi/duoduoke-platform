package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class Trade implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * trade.trade_no
     * 交易号
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String tradeNo;
    /**
     * trade.payer_type
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String payerType;
    /**
     * trade.payer
     * 付款方
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String payer;
    /**
     * trade.payee_type
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String payeeType;
    /**
     * trade.payee
     * 收款方
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String payee;
    /**
     * trade.amount
     * 金额
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private Long amount;
    /**
     * trade.state
     * 状态
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String state;
    /**
     * trade.category
     * 交易分类
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String category;
    /**
     * trade.pay_type
     * 支付方式
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String payType;
    /**
     * trade.third_trade_no
     * 外部交易号
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String thirdTradeNo;
    /**
     * trade.description
     * 描述
     *
     * @mbg.generated 2018-07-11 20:43:48
     */
    private String description;
    /**
     * trade.remark
     * 标记
     *
     * @mbg.generated 2018-07-11 20:43:48
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", payerType=").append(payerType);
        sb.append(", payer=").append(payer);
        sb.append(", payeeType=").append(payeeType);
        sb.append(", payee=").append(payee);
        sb.append(", amount=").append(amount);
        sb.append(", state=").append(state);
        sb.append(", category=").append(category);
        sb.append(", payType=").append(payType);
        sb.append(", thirdTradeNo=").append(thirdTradeNo);
        sb.append(", description=").append(description);
        sb.append(", remark=").append(remark);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", createBy=").append(createBy);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}