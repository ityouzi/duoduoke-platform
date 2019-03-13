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
public class UserAccountDTO extends ToString {
    private static final long serialVersionUID = 1325669396943833814L;
    /**
     * user_account.id
     *
     * @mbg.generated 2018-07-11 16:23:12
     */
    private Integer           id;

    /**
     * user_account.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-07-11 16:23:12
     */
    private String            userId;

    /**
     * user_account.balance
     * 余额
     *
     * @mbg.generated 2018-07-11 16:23:12
     */
    private Long              balance;

    /**
     * user_account.state
     *
     * @mbg.generated 2018-07-11 16:23:12
     */
    private String            state;

    /**
     * user_account.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-07-11 16:23:12
     */
    private Date              gmtCreate;

    /**
     * user_account.create_by
     *
     * @mbg.generated 2018-07-11 16:23:12
     */
    private String            createBy;

    /**
     * user_account.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-07-11 16:23:12
     */
    private Date              gmtModified;

    /**
     * user_account.modified_by
     *
     * @mbg.generated 2018-07-11 16:23:12
     */
    private String            modifiedBy;

    /**
     *
     *
     * user_account.user_account_type
     * 账户类型
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private String            userAccountType;

}