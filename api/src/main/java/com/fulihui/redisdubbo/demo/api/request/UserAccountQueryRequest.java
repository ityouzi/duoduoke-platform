/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.List;

/**
 * @author lizhi
 */
@Getter
@Setter
public class UserAccountQueryRequest extends PageRequest {
    private static final long serialVersionUID = 1680198827869990027L;

    private Long              lastId;

    private String            userId;
    /**
     * @see com.fulihui.redisdubbo.demo.producer.facade.enums.UserAccountBizCode
     */
    private List<String>      bizCodes;
    /**
     * @see com.fulihui.redisdubbo.demo.producer.facade.enums.UserAccountOptTypeEnum
     */
    private String            optType;

    private Long              amount;

    /**
     *
     * @see com.fulihui.redisdubbo.demo.producer.facade.enums.UserAccountType
     * user_account.user_account_type
     * 账户类型
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private String            userAccountType;
}
