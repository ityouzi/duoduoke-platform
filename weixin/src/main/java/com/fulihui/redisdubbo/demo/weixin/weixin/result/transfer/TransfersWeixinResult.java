package com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer;


import com.fulihui.redisdubbo.demo.weixin.weixin.result.WeixinXMLResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

/**
 * 企业转账到零钱响应参数
 * @author Administrator
 */
@Getter
@Setter
@XStreamAlias("xml")
public class TransfersWeixinResult extends WeixinXMLResult {
    private static final long serialVersionUID = -6123566196531800475L;

    /** 公众账号ID */
    @XStreamAlias("mch_appid")
    protected String mchAppid;
    /** 商户号 */
    @XStreamAlias("mchid")
    protected String mchid;
    /** 设备号 */
    @XStreamAlias("device_info")
    protected String deviceInfo;
    /** 随机字符串 */
    @XStreamAlias("nonce_str")
    protected String nonceStr;
    /** 签名 */
    @XStreamAlias("sign")
    protected String sign;
    /** 商户订单号 */
    @XStreamAlias("partner_trade_no")
    private   String partnerTradeNo;
    /** 微信订单号 */
    @XStreamAlias("payment_no")
    private   String paymentNo;
    /** 微信支付成功时间 */
    @XStreamAlias("payment_time")
    private   String paymentTime;

}
