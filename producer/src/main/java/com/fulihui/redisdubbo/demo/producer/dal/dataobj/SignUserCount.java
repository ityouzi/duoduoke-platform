package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SignUserCount implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * sign_user_count.id
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer id;
    /**
     * sign_user_count.user_id
     * 用户id
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private String userId;
    /**
     * sign_user_count.last_time
     * 上次打开签到日期
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Date lastTime;
    /**
     * sign_user_count.continuous_count
     * 已经连续签到次数
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer continuousCount;
    /**
     * sign_user_count.total_count
     * 签到总次数
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Integer totalCount;
    /**
     * sign_user_count.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Date gmtCreate;
    /**
     * sign_user_count.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Date gmtModified;
    /**
     * sign_user_count.sign_time
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Date signTime;
    /**
     * sign_user_count.cycle_time
     * 签到周期
     *
     * @mbg.generated 2018-10-19 16:22:01
     */
    private Date cycleTime;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", continuousCount=").append(continuousCount);
        sb.append(", totalCount=").append(totalCount);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", signTime=").append(signTime);
        sb.append(", cycleTime=").append(cycleTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}