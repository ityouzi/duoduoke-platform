package com.fulihui.redisdubbo.demo.api.request.sign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 * @date 2018-10-17
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class SignAwardRequest extends PageRequest {


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
    private List<String> prizeStatus;

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

    private String sortInfo;
    /**
     * sign_award.bind_order_status
     * 绑定的订单状态
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private String bindOrderStatus;

}
