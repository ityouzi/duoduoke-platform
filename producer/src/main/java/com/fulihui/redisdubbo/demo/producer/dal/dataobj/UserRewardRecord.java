package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserRewardRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_reward_record.id
     *
     * @mbg.generated 2018-09-04 17:01:14
     */
    private Integer id;
    /**
     * user_reward_record.user_id
     * 用户Id
     *
     * @mbg.generated 2018-09-04 17:01:14
     */
    private String userId;
    /**
     * user_reward_record.order_sn
     * 订单编号
     *
     * @mbg.generated 2018-09-04 17:01:14
     */
    private String orderSn;
    /**
     * user_reward_record.help_user_id
     * 助力用户
     *
     * @mbg.generated 2018-09-04 17:01:14
     */
    private String helpUserId;
    /**
     * user_reward_record.help_percent
     * 助力百分比
     *
     * @mbg.generated 2018-09-04 17:01:14
     */
    private Double helpPercent;
    /**
     * user_reward_record.create_time
     * 创建时间
     *
     * @mbg.generated 2018-09-04 17:01:14
     */
    private Date createTime;
    /**
     * user_reward_record.update_time
     * 修改时间
     *
     * @mbg.generated 2018-09-04 17:01:14
     */
    private Date updateTime;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", helpUserId=").append(helpUserId);
        sb.append(", helpPercent=").append(helpPercent);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}