package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SignUserConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * sign_user_config.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-10-15 13:35:45
     */
    private String userId;
    /**
     * sign_user_config.state
     * 状态[1:启用,0:禁用]
     *
     * @mbg.generated 2018-10-15 13:35:45
     */
    private String state;
    /**
     * sign_user_config.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-15 13:35:45
     */
    private Date gmtCreate;
    /**
     * sign_user_config.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-15 13:35:45
     */
    private Date gmtModified;
    /**
     * sign_user_config.sign_flop_count
     * 签到翻牌机会
     *
     * @mbg.generated 2018-10-15 13:35:45
     */
    private Integer signFlopCount;
    /**
     * sign_user_config.share_flop_count
     * 分享翻牌机会
     *
     * @mbg.generated 2018-10-15 13:35:45
     */
    private Integer shareFlopCount;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", state=").append(state);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", signFlopCount=").append(signFlopCount);
        sb.append(", shareFlopCount=").append(shareFlopCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}