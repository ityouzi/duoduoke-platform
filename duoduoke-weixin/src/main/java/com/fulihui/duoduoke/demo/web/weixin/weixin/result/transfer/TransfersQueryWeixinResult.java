package com.fulihui.duoduoke.demo.web.weixin.weixin.result.transfer;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询企业转账到零钱响应参数
 */
@Getter
@Setter
@XStreamAlias("xml")
public class TransfersQueryWeixinResult extends AbstractTransResult {
    private static final long serialVersionUID = -1575807864560693136L;

    /** 微信订单号 */
    @XStreamAlias("detail_id")
    private String            detailId;
    /** 转账状态 */
    @XStreamAlias("status")
    private String            status;
    /** 失败原因 */
    @XStreamAlias("reason")
    private String            reason;
    /** 收款用户 openid */
    @XStreamAlias("openid")
    private String            openid;
    /** 收款用户姓名 */
    @XStreamAlias("transfer_name")
    private String            transferName;

    @XStreamAlias("transfer_time")
    private String            transferTime;

    /** 付款金额 */
    @XStreamAlias("payment_amount")
    private String            paymentAmount;
    /** 转账时间 */
    @XStreamAlias("payment_time")
    private String            paymentTime;
    /** 付款描述 */
    @XStreamAlias("desc")
    private String            desc;

    @XStreamAlias("appid")
    private String            appid;
}
