package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Setter @Getter
public class UserFormInsertRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = 4314709199255645113L;
    /**
     * user_form_record.open_id
     * 用户openId
     */
    private String openId;

    /**
     * user_form_record.app_id
     * 小程序appId
     */
    private String appId;

    /**
     * user_form_record.form_id
     * 小程序formId
     */
    private String formId;


    /**
     * user_form_record.user_id
     * 用户信息
     */
    private String userId;

    /**
     * user_form_record.form_type
     * 类型
     */
    private String formType;

    /**
     * user_form_record.form_desc
     */
    private String formDesc;

}
