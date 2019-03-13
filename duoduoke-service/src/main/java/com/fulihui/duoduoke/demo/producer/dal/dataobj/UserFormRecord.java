package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class UserFormRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_form_record.id
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private Integer id;
    /**
     * user_form_record.open_id
     * 用户openId
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private String openId;
    /**
     * user_form_record.app_id
     * 小程序appId
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private String appId;
    /**
     * user_form_record.form_id
     * 小程序formId
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private String formId;
    /**
     * user_form_record.create_time
     * 创建时间
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private Date createTime;
    /**
     * user_form_record.update_time
     * 修改时间
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private Date updateTime;
    /**
     * user_form_record.form_status
     * 状态
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private String formStatus;
    /**
     * user_form_record.user_id
     * 用户信息
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private String userId;
    /**
     * user_form_record.form_type
     * 类型
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private String formType;
    /**
     * user_form_record.form_desc
     *
     * @mbg.generated 2018-07-14 16:15:41
     */
    private String formDesc;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", appId=").append(appId);
        sb.append(", formId=").append(formId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", formStatus=").append(formStatus);
        sb.append(", userId=").append(userId);
        sb.append(", formType=").append(formType);
        sb.append(", formDesc=").append(formDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}