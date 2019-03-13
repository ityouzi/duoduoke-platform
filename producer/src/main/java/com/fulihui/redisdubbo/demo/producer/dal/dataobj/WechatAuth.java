package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class WechatAuth implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * wechat_auth.id
     * 主键
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private Integer id;
    /**
     * wechat_auth.open_id
     * open_id
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String openId;
    /**
     * wechat_auth.user_id
     * 主体唯一标识
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String userId;
    /**
     * wechat_auth.user_type
     * 主体类型
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String userType;
    /**
     * wechat_auth.appid
     * appid
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String appid;
    /**
     * wechat_auth.unionid
     * unionid
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String unionid;
    /**
     * wechat_auth.subscribe
     * 是否关注
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String subscribe;
    /**
     * wechat_auth.gmt_create
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private Date gmtCreate;
    /**
     * wechat_auth.create_by
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String createBy;
    /**
     * wechat_auth.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private Date gmtModified;
    /**
     * wechat_auth.modified_by
     *
     * @mbg.generated 2018-07-07 10:19:33
     */
    private String modifiedBy;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", userId=").append(userId);
        sb.append(", userType=").append(userType);
        sb.append(", appid=").append(appid);
        sb.append(", unionid=").append(unionid);
        sb.append(", subscribe=").append(subscribe);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", createBy=").append(createBy);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}