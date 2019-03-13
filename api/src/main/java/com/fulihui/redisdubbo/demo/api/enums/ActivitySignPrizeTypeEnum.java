package com.fulihui.redisdubbo.demo.api.enums;

import lombok.Getter;
import org.near.toolkit.model.BaseEnum;

/**
 *
 * @author lizhi
 * @date 2018-10-18
 */
@Getter
public enum ActivitySignPrizeTypeEnum implements BaseEnum {

                                                           /**
                                                            * 签到奖金
                                                            */
                                                           BONUS("1", "签到奖金"),
                                                           /**
                                                            * 账户余额
                                                            */
                                                           BALANCE("2", "账户余额"),;

    String code;
    String desc;

    ActivitySignPrizeTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
