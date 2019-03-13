/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

/**
 * @author lizhi
 */
@Getter
@Setter
public class UserAccountCreateRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = 7760790111410635379L;

    /**
     * 用户唯一标识
     */
    private String            userId;

    /**
     *
     *@see com.fulihui.duoduoke.demo.producer.facade.enums.UserAccountType
     * user_account.user_account_type
     * 账户类型
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private String            userAccountType;
}
