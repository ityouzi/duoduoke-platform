package com.fulihui.duoduoke.demo.web.weixin.weixin.request.transfer;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import com.fulihui.duoduoke.demo.web.weixin.weixin.request.AbstractXmlRequest;
import org.apache.commons.lang3.RandomStringUtils;

import com.fulihui.duoduoke.demo.web.weixin.weixin.result.transfer.TransfersWeixinResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.util.WeixinSign;
import com.fulihui.duoduoke.demo.web.weixin.weixin.util.XStreams;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

/**
 * 企业转账到零钱请求参数
 *
 * @author lizhi
 */
@Getter
@Setter
@XStreamAlias("xml")
public class TransfersWeixinRequest extends AbstractXmlRequest<TransfersWeixinResult> {
    private static final long serialVersionUID = 4582207153556508567L;

    /**
     * 公众账号 appid
     */
    @XStreamAlias("mch_appid")
    private String mchAppid;
    /**
     * 商户号
     */
    @XStreamAlias("mchid")
    private String mchid;
    /**
     * 设备号
     */
    @XStreamAlias("device_info")
    protected String deviceInfo;
    /**
     * 随机字符串 Required
     */
    @XStreamAlias("nonce_str")
    protected String nonceStr;
    /**
     * 签名 Required
     */
    @XStreamAlias("sign")
    protected String sign;
    /**
     * 商户订单号
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;
    /**
     * 用户 openid
     */
    @XStreamAlias("openid")
    private String openid;
    /**
     * 校验用户姓名选项  NO_CHECK：不校验真实姓名<p>
     * FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）<p>
     * OPTION_CHECK：针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
     */
    @XStreamAlias("check_name")
    private String checkName;
    /**
     * 收款用户姓名
     */
    @XStreamAlias("re_user_name")
    private String reUserName;
    /**
     * 金额
     */
    @XStreamAlias("amount")
    private Integer amount;
    /**
     * 描述
     */
    @XStreamAlias("desc")
    private String desc;
    /**
     * IP地址
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    public TransfersWeixinRequest() {
        nonceStr = RandomStringUtils.randomAlphanumeric(32);
        try {
            InetAddress iaddr = InetAddress.getLocalHost();
            spbillCreateIp = iaddr.getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public void genSign(String signKey) {
        Map<String, Object> signData = new HashMap<>();
        signData.put("mch_appid", mchAppid);
        signData.put("mchid", mchid);
        signData.put("device_info", deviceInfo);
        signData.put("nonce_str", nonceStr);
        signData.put("partner_trade_no", partnerTradeNo);
        signData.put("openid", openid);
        signData.put("check_name", checkName);
        signData.put("re_user_name", reUserName);
        signData.put("amount", amount);
        signData.put("desc", desc);
        signData.put("spbill_create_ip", spbillCreateIp);

        sign = WeixinSign.genServiceSign(signData, signKey);
    }

    @Override
    public String service() {
        return "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
    }

    @Override
    public TransfersWeixinResult parseResult(String respStr) {
        return (TransfersWeixinResult) XStreams.build(TransfersWeixinResult.class).fromXML(respStr);
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.CERT_SSL_POST;
    }

    @Override
    public String requestData() {
        return toXML();
    }

}
