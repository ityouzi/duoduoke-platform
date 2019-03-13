package com.fulihui.redisdubbo.demo.weixin.weixin.request.transfer;

import java.util.Map;

import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer.TransfersQueryWeixinResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.util.WeixinSign;
import com.fulihui.redisdubbo.demo.weixin.weixin.util.XStreams;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询企业转账到零钱请求参数
 * @author Administrator
 */
@Getter
@Setter
@XStreamAlias("xml")
public class TransfersQueryWeixinRequest extends AbstractTransRequest<TransfersQueryWeixinResult> {
    private static final long serialVersionUID = -8298413257153901019L;

    /** 商户号的appid */
    @XStreamAlias("appid")
    private String            appid;
    /** 商户订单号 */
    @XStreamAlias("partner_trade_no")
    private String            partnerTradeNo;

    @Override
    public String service() {
        return "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";
    }

    @Override
    public TransfersQueryWeixinResult parseResult(String respStr) {
        return (TransfersQueryWeixinResult) XStreams.build(TransfersQueryWeixinResult.class)
            .fromXML(respStr);
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.CERT_SSL_POST;
    }

    @Override
    public String requestData() {
        return toXML();
    }

    @Override
    public void genSign(String signKey) {
        Map<String, Object> signData = Maps.newHashMap();
        signData.put("nonce_str", nonceStr);
        signData.put("partner_trade_no", partnerTradeNo);
        signData.put("mch_id", mchId);
        signData.put("appid", appid);
        sign = WeixinSign.genServiceSign(signData, signKey);
    }
}
