package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @author lizhi
 */
@Setter @Getter
public class WechatConfigRequest extends PageRequest {
    private static final long serialVersionUID = -2396980438116007066L;
    /**
     * wechat_config.id
     * 主键
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private Integer id;

    /**
     * wechat_config.config_code
     * 微信配置标识
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String configCode;

    /**
     * wechat_config.env_type
     * 环境类型
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String envType;

    /**
     * wechat_config.app_id
     * 微信appid
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String appId;

    /**
     * wechat_config.appsecret
     * 微信 appsecret
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String appsecret;

    /**
     * wechat_config.mch_id
     * 商户id
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String mchId;

    /**
     * wechat_config.sign_key
     * 签名key
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String signKey;

    /**
     * wechat_config.cert_file
     * 证书地址
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String certFile;

    /**
     * wechat_config.token
     * token令牌
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String token;

    /**
     * wechat_config.encoding_aes_key
     * 消息加解密密钥
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private String encodingAesKey;

    /**
     * wechat_config.gmt_create
     * 创建日期
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private Date gmtCreate;

    /**
     * wechat_config.gmt_modified
     * 更新日期
     *
     * @mbg.generated 2018-07-09 16:47:26
     */
    private Date gmtModified;


}