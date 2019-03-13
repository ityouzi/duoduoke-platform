package com.fulihui.duoduoke.demo.web.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author lizhi
 * @date 2018-7-17
 */
@Getter
public enum UserWithdrawStatusEnum implements BaseEnum {

    /**
     * 审核中
     */
    AUDIT_ING("1", "审核中"),
    /**
     * 提现成功
     */
    AUDIT_SUCCESS("2", "提现成功"),
    /**
     * 提现失败
     */
    AUDIT_FAIL("3", "提现失败"),;
    String code;
    String desc;

    UserWithdrawStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
