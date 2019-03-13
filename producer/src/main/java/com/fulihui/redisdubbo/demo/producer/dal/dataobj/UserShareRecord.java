package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class UserShareRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_share_record.id
     *
     * @mbg.generated 2018-08-24 14:33:49
     */
    private Integer id;
    /**
     * user_share_record.user_id
     * 用户Id
     *
     * @mbg.generated 2018-08-24 14:33:49
     */
    private String userId;
    /**
     * user_share_record.good_id
     * 商品id
     *
     * @mbg.generated 2018-08-24 14:33:49
     */
    private String goodId;
    /**
     * user_share_record.pid
     * pid
     *
     * @mbg.generated 2018-08-24 14:33:49
     */
    private String pid;
    /**
     * user_share_record.create_time
     * 创建时间
     *
     * @mbg.generated 2018-08-24 14:33:49
     */
    private Date createTime;
    /**
     * user_share_record.update_time
     * 修改时间
     *
     * @mbg.generated 2018-08-24 14:33:49
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
        sb.append(", goodId=").append(goodId);
        sb.append(", pid=").append(pid);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}