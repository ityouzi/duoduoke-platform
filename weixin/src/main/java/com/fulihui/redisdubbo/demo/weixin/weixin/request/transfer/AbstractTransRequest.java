package com.fulihui.redisdubbo.demo.weixin.weixin.request.transfer;

import com.fulihui.redisdubbo.demo.weixin.weixin.request.AbstractXmlRequest;
import org.apache.commons.lang3.RandomStringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Willard.Hu on 2017/12/5.
 */
public abstract class AbstractTransRequest<T> extends AbstractXmlRequest<T> {
    private static final long serialVersionUID = -6524857585929495277L;

    /** 商户号 Required */
    @XStreamAlias("mch_id")
    protected String mchId;
    /** 随机字符串 Required */
    @XStreamAlias("nonce_str")
    protected String nonceStr;
    /** 签名 Required */
    @XStreamAlias("sign")
    protected String sign;

    public AbstractTransRequest() {
        nonceStr = RandomStringUtils.randomAlphanumeric(32);
    }

    public abstract void genSign(String signKey);



    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }


    public String getMchId() {
        return mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSign() {
        return sign;
    }
}
