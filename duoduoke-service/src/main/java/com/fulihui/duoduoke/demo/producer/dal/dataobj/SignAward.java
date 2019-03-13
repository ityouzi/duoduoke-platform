package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SignAward implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * sign_award.id
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Integer id;
    /**
     * sign_award.user_id
     * 用户唯一标识
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private String userId;
    /**
     * sign_award.activity_type
     * 活动类型 [1:签到活动] [2:翻牌活动]'
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private String activityType;
    /**
     * sign_award.sign_count
     * 累计签到次数
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Integer signCount;
    /**
     * sign_award.prize_status
     * 奖品状态[0:未使用,1:已绑定,2:奖金已发放,3:已过期]
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private String prizeStatus;
    /**
     * sign_award.prize_type
     * 奖品类型 [1:签到奖金] [2:账户余额]
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private String prizeType;
    /**
     * sign_award.prize_percent
     * 奖品百分比
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Integer prizePercent;
    /**
     * sign_award.prize_money
     * 奖品金额
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Integer prizeMoney;
    /**
     * sign_award.over_order_money
     * '订单金额满多少可用',
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Integer overOrderMoney;
    /**
     * sign_award.useful_day
     * 奖品有效天数
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Integer usefulDay;
    /**
     * sign_award.order_sn
     * 订单号
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private String orderSn;
    /**
     * sign_award.cycle_time
     * 周期时间
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Date cycleTime;
    /**
     * sign_award.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Date gmtCreate;
    /**
     * sign_award.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private Date gmtModified;
    /**
     * sign_award.bind_order_status
     * 绑定的订单状态
     *
     * @mbg.generated 2018-11-13 15:03:30
     */
    private String bindOrderStatus;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", activityType=").append(activityType);
        sb.append(", signCount=").append(signCount);
        sb.append(", prizeStatus=").append(prizeStatus);
        sb.append(", prizeType=").append(prizeType);
        sb.append(", prizePercent=").append(prizePercent);
        sb.append(", prizeMoney=").append(prizeMoney);
        sb.append(", overOrderMoney=").append(overOrderMoney);
        sb.append(", usefulDay=").append(usefulDay);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", cycleTime=").append(cycleTime);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", bindOrderStatus=").append(bindOrderStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}