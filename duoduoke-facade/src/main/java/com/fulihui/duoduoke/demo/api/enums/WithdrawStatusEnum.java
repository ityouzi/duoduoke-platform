package com.fulihui.duoduoke.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 * @author: JY
 * @date: 2018/7/12 14:26
 */
@Getter
public enum WithdrawStatusEnum implements BaseEnum {

                                                    /**
                                                     * 待审核
                                                     */
                                                    waitAudit("101", "待审核"),
                                                    /**
                                                     * //审核通过 -- 待GIT打款
                                                     */
                                                    auditPass("102", "待打款"),
                                                    /**
                                                     * 提现驳回
                                                     */
                                                    auditReject("103", "提现驳回"),
                                                    /**
                                                     * 打款中
                                                     */
                                                    withdrawing("201", "打款中"),
                                                    /**
                                                     * 打款失败
                                                     */
                                                    withdrawFail("202", "打款失败"),
                                                    /**
                                                     * 打款成功
                                                     */
                                                    withdrawSuccess("203", "打款成功");
    String code;
    String desc;

    WithdrawStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
