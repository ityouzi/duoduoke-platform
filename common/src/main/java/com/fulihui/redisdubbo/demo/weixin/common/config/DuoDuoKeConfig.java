package com.fulihui.redisdubbo.demo.weixin.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author lizhi
 * @date 2018-7-5
 */
@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "redisdubbo.demo.producer")
public class DuoDuoKeConfig implements Serializable {

    private static final long serialVersionUID = 3180772229513818514L;
    /**
     * client_id：
     */
    private String            clientId;

    /**
     * client_secret
     */
    private String            clientSecret;

    /**
     * 微信小程序appid
     */

    private String            miniAppid;

    /**
     * 微信小程序appSecret
     */

    private String            miniAppSecret;

    /**
     * authUrl
     */
    private String            authUrl;

    /**
     * templateUrl
     */
    private String            templateUrl;

    /**
     * tokenUrl
     */
    private String            tokenUrl;

    /**
     * 微信商户平台商户id
     */
    private String            mchid;

    /**
     * 微信商户平台转账证书文件夹地址
     */
    private String            certFile;
    /**
     * zk 地址
     */
    private String            zkAddress;

    private String            minipage;

    private String            miniProductPage;

    private String            duoAuthCallBackUrl;

    private String            duoTokenUrl;

    /**
     * 微信公众号appId
     */
    private String            wxPnAppId;

    /**
     * 微信公众号appId
     */
    private String            wxPnAppSecret;
    /**
     * 微信公众号授权回调地址
     */
    private String            wxPnCallbackUrl;

}
