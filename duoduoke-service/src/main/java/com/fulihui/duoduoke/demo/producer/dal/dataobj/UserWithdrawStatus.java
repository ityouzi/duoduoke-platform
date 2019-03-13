package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class UserWithdrawStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_withdraw_status.id
     *
     * @mbg.generated 2018-07-17 10:07:51
     */
    private Long id;
    /**
     * user_withdraw_status.withdraw_id
     *
     * @mbg.generated 2018-07-17 10:07:51
     */
    private Long withdrawId;
    /**
     * user_withdraw_status.status
     *
     * @mbg.generated 2018-07-17 10:07:51
     */
    private String status;
    /**
     * user_withdraw_status.gmt_create
     *
     * @mbg.generated 2018-07-17 10:07:51
     */
    private Date gmtCreate;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", withdrawId=").append(withdrawId);
        sb.append(", status=").append(status);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}