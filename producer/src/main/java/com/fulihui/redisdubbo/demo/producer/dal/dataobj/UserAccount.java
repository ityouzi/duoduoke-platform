package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_account.id
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private Integer id;
    /**
     * user_account.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private String userId;
    /**
     * user_account.balance
     * 余额
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private Long balance;
    /**
     * user_account.state
     * 状态[1:启用,0:禁用]
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private String state;
    /**
     * user_account.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private Date gmtCreate;
    /**
     * user_account.create_by
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private String createBy;
    /**
     * user_account.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private Date gmtModified;
    /**
     * user_account.modified_by
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private String modifiedBy;
    /**
     * user_account.user_account_type
     * 账户类型
     *
     * @mbg.generated 2018-12-06 09:58:55
     */
    private String userAccountType;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", balance=").append(balance);
        sb.append(", state=").append(state);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", createBy=").append(createBy);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", userAccountType=").append(userAccountType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}