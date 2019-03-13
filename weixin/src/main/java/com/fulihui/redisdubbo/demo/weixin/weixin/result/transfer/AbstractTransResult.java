package com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer;


import com.fulihui.redisdubbo.demo.weixin.weixin.result.WeixinXMLResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Willard.Hu on 2017/12/5.
 */
@Getter
@Setter
public abstract class AbstractTransResult extends WeixinXMLResult {
    private static final long serialVersionUID = 2087232875366939117L;

    /** 商户号 */
    @XStreamAlias("mch_id")
    protected String mchId;
    /** 随机字符串 */
    @XStreamAlias("nonce_str")
    protected String nonceStr;
    /** 签名 */
    @XStreamAlias("sign")
    public String sign;
    /** 商户订单号 */
    @XStreamAlias("partner_trade_no")
    protected String partnerTradeNo;
}
