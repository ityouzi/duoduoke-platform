package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author Administrator
 */
@Setter
@Getter
public class UserFormRecordDTO extends ToString {
    private static final long serialVersionUID = 6875232137368996969L;
    /**
     * user_form_record.id
     *
     *
     */
    private Integer id;

    /**
     * user_form_record.open_id
     * 用户openId
     *
     *
     */
    private String openId;

    /**
     * user_form_record.app_id
     * 小程序appId
     *
     *
     */
    private String appId;

    /**
     * user_form_record.form_id
     * 小程序formId
     *
     *
     */
    private String formId;

    /**
     * user_form_record.create_time
     * 创建时间
     *
     *
     */
    private Date createTime;

    /**
     * user_form_record.update_time
     * 修改时间
     *
     *
     */
    private Date updateTime;

    /**
     * user_form_record.form_status
     * 状态
     *
     *
     */
    private String formStatus;

    /**
     * user_form_record.user_id
     * 用户信息
     *
     *
     */
    private String userId;

    /**
     * user_form_record.form_type
     * 类型
     *
     *
     */
    private String formType;

    /**
     * user_form_record.form_desc
     *
     *
     */
    private String formDesc;


}