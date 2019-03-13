package com.fulihui.duoduoke.demo.api.dto.sign;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author Administrator
 */
@Setter
@Getter
public class SignAwardDTO extends ToString {
    private static final long serialVersionUID = -6109718111499402094L;
    /**
     * sign_award.id
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Integer id;

    /**
     * sign_award.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private String userId;

    /**
     * sign_award.activity_type
     * 活动类型 [1:签到活动] [2:翻牌活动]'
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private String activityType;

    /**
     * sign_award.sign_count
     * 累计签到次数
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Integer signCount;

    /**
     * sign_award.prize_status
     * 奖品状态
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private String prizeStatus;

    /**
     * sign_award.prize_type
     * 奖品类型 [1:签到奖金] [2:账户余额]
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private String prizeType;

    /**
     * sign_award.prize_percent
     * 奖品百分比
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Integer prizePercent;

    /**
     * sign_award.prize_money
     * 奖品金额
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Integer prizeMoney;

    /**
     * sign_award.over_order_money
     * '订单金额满多少可用',
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Integer overOrderMoney;

    /**
     * sign_award.useful_day
     * 奖品有效天数
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Integer usefulDay;

    /**
     * sign_award.order_sn
     * 订单号
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private String orderSn;

    /**
     * sign_award.cycle_time
     * 周期时间
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Date cycleTime;

    /**
     * sign_award.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Date gmtCreate;

    /**
     * sign_award.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-18 17:58:20
     */
    private Date gmtModified;

    private String bindOrderStatus;
}