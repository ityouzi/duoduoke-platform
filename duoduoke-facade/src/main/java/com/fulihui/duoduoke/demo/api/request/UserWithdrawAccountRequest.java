package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: JY
 * @date: 2018/7/17 15:21
 */
@Setter
@Getter
public class UserWithdrawAccountRequest {

    /**
     * 提现的用户id
     */

    private String userId;

    /**
     * 提现金额 单为分
     */

    private Long withdrawAmount;

    /**
     * 提现的openid
     */

    private String openId;
    /**
     * appId
     */

    private String miniAppId;
    /**
     * 商户id
     */
    private String mchId;
    /**
     * 签名key
     */

    private String signKey;
    /**
     * certFile 文件地址
     */

    private String certFile;
}
