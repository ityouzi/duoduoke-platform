package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SignInConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * sign_in_config.id
     *
     * @mbg.generated 2018-10-11 17:37:13
     */
    private Long id;
    /**
     * sign_in_config.days
     * 签到天数（目前最大七天）
     *
     * @mbg.generated 2018-10-11 17:37:13
     */
    private Integer days;
    /**
     * sign_in_config.gmt_create
     *
     * @mbg.generated 2018-10-11 17:37:13
     */
    private Date gmtCreate;
    /**
     * sign_in_config.gmt_modified
     *
     * @mbg.generated 2018-10-11 17:37:13
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", days=").append(days);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}