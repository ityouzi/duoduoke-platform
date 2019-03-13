package com.fulihui.duoduoke.demo.api.dto.sign;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by lizhi on 2018-10-16.
 */
@Setter
@Getter
public class SignInPrizeDTO extends ToString {
    private static final long serialVersionUID = -5139389598781247926L;
    /**
     * 累计签到次数
     */
    private Integer signCount;

    /**
     * activity_sign_prize.prize_type
     * 奖品类型 [1:签到奖金] [2:账户余额]
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer prizeType;

    /**
     * activity_sign_prize.prize_money
     * 奖品金额
     */
    private Integer prizeMoney;

}
