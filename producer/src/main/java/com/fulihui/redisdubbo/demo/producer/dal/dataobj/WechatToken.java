package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WechatToken implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * wechat_token.id
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private Integer id;
    /**
     * wechat_token.appid
     * appid
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private String appid;
    /**
     * wechat_token.token_type
     * token类型
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private String tokenType;
    /**
     * wechat_token.token_value
     * token值
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private String tokenValue;
    /**
     * wechat_token.expires_sec
     * 失效时间
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private Long expiresSec;
    /**
     * wechat_token.gmt_create
     * 创建时间
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private Date gmtCreate;
    /**
     * wechat_token.create_by
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private String createBy;
    /**
     * wechat_token.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private Date gmtModified;
    /**
     * wechat_token.modified_by
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private String modifiedBy;
    /**
     * wechat_token.last_gmt_modified
     * 上次刷新授权时间
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private Date lastGmtModified;
    /**
     * wechat_token.expires_in
     *
     * @mbg.generated 2019-01-03 14:11:25
     */
    private Long expiresIn;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appid=").append(appid);
        sb.append(", tokenType=").append(tokenType);
        sb.append(", tokenValue=").append(tokenValue);
        sb.append(", expiresSec=").append(expiresSec);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", createBy=").append(createBy);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", lastGmtModified=").append(lastGmtModified);
        sb.append(", expiresIn=").append(expiresIn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}