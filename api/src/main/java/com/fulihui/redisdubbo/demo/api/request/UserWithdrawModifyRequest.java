package com.fulihui.redisdubbo.demo.api.request;


import com.fulihui.redisdubbo.demo.api.enums.WithdrawStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author: JY
 * @date: 2018/7/13 9:53
 */
@Setter @Getter
public class UserWithdrawModifyRequest extends ToString {

    private Long id;

    private WithdrawStatusEnum statusEnum;

    /**
     * 审核描述 审核失败时必填
     */
    private String remark;

    /**
     * 审核人 审核成功、失败必填
     */
    private String auditor;

}
