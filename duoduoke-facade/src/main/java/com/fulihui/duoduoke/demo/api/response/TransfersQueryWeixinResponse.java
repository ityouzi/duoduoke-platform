package com.fulihui.duoduoke.demo.api.response;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-8-30
 */
@Setter
@Getter
public class TransfersQueryWeixinResponse extends ToString {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";

    protected String returnCode;
    protected String returnMsg;
    /**
     * 业务结果
     */

    protected String resultCode;
    /**
     * 错误代码
     */

    protected String errCode;
    /**
     * 错误代码描述
     */

    protected String errCodeDes;

    /**
     * 商户号
     */
    protected String mchId;
    /**
     * 随机字符串
     */
    protected String nonceStr;
    /**
     * 签名
     */

    public String sign;
    /**
     * 商户订单号
     */

    protected String partnerTradeNo;


    /**
     * 微信订单号
     */
    private String detailId;
    /**
     * 转账状态
     */
    private String status;
    /**
     * 失败原因
     */
    private String reason;
    /**
     * 收款用户 openid
     */

    private String openid;
    /**
     * 收款用户姓名
     */

    private String transferName;


    private String transferTime;

    /**
     * 付款金额
     */

    private String paymentAmount;
    /**
     * 转账时间
     */

    private String paymentTime;
    /**
     * 付款描述
     */

    private String desc;


    private String appid;


    public boolean isSuccess() {
        return SUCCESS.equals(returnCode) && SUCCESS.equals(resultCode);
    }


}
