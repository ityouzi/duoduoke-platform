package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/8/3 11:27
 */
@Setter
@Getter
public class WechatTokenDTO {

    /**
     *
     *
     * wechat_token.token_value
     * token值
     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private String tokenValue;

    /**
     *
     *
     * wechat_token.expires_sec
     * 失效时间
     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private Long expiresSec;



    /**
     *
     *
     * wechat_token.id

     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private Integer id;

    /**
     *
     *
     * wechat_token.appid
     * appid
     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private String appid;

    /**
     *
     *
     * wechat_token.token_type
     * token类型
     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private String tokenType;



    /**
     *
     *
     * wechat_token.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private Date gmtCreate;

    /**
     *
     *
     * wechat_token.create_by

     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private String createBy;

    /**
     *
     *
     * wechat_token.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private Date gmtModified;

    /**
     *
     *
     * wechat_token.modified_by

     *
     * @mbg.generated 2018-07-05 17:09:46
     */
    private String modifiedBy;


    /**
     *
     *
     * wechat_token.last_gmt_modified
     * 上次刷新授权时间
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private Date lastGmtModified;

    /**
     *
     *
     * wechat_token.expires_in

     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private Long expiresIn;
}
