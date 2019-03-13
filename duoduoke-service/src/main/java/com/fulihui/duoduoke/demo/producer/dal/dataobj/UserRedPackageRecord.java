package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserRedPackageRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_red_package_record.id
     * 主键
     *
     * @mbg.generated 2018-09-10 13:59:29
     */
    private Integer id;
    /**
     * user_red_package_record.user_id
     * 用户id
     *
     * @mbg.generated 2018-09-10 13:59:29
     */
    private String userId;
    /**
     * user_red_package_record.field_id
     * 专场ID
     *
     * @mbg.generated 2018-09-10 13:59:29
     */
    private Integer fieldId;
    /**
     * user_red_package_record.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-09-10 13:59:29
     */
    private Date gmtCreate;
    /**
     * user_red_package_record.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-09-10 13:59:29
     */
    private Date gmtModified;
    /**
     * user_red_package_record.help
     * 1:助力，2：基础
     *
     * @mbg.generated 2018-09-10 13:59:29
     */
    private String help;
    /**
     * user_red_package_record.end_time
     *
     * @mbg.generated 2018-09-10 13:59:29
     */
    private Date endTime;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", fieldId=").append(fieldId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", help=").append(help);
        sb.append(", endTime=").append(endTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}