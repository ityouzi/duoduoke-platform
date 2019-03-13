package com.fulihui.duoduoke.demo.producer.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-10-17
 */
@Setter
@Getter
public class ActivitySignPrizeModel implements AwardWeightModel {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 活动id 对应active_config主键
     */
    private Integer activityId;

    /**
     * 累计签到次数
     */
    private Integer signCount;

    /**
     * 奖品类型 [1:签到奖金] [2:账户余额]
     */
    private Integer prizeType;

    /**
     * 奖品百分比
     */
    private Integer prizePercent;

    /**
     * 奖品金额
     */
    private Integer prizeMoney;

    /**
     * 订单金额满多少可用
     */
    private Integer overOrderMoney;

    /**
     * 奖品有效天数
     */
    private Integer usefulDay;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    @Override
    public double weight() {
        return this.prizePercent;
    }
}
