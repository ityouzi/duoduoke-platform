package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivitySignPrize implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * activity_sign_prize.id
     * 主键
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer id;
    /**
     * activity_sign_prize.activity_id
     * 活动id 对应active_config主键
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer activityId;
    /**
     * activity_sign_prize.sign_count
     * 累计签到次数
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer signCount;
    /**
     * activity_sign_prize.prize_type
     * 奖品类型 [1:签到奖金] [2:账户余额]
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer prizeType;
    /**
     * activity_sign_prize.prize_percent
     * 奖品百分比
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer prizePercent;
    /**
     * activity_sign_prize.prize_money
     * 奖品金额
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer prizeMoney;
    /**
     * activity_sign_prize.over_order_money
     * 订单金额满多少可用
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer overOrderMoney;
    /**
     * activity_sign_prize.useful_day
     * 奖品有效天数
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Integer usefulDay;
    /**
     * activity_sign_prize.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Date gmtCreate;
    /**
     * activity_sign_prize.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-11 14:06:08
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", signCount=").append(signCount);
        sb.append(", prizeType=").append(prizeType);
        sb.append(", prizePercent=").append(prizePercent);
        sb.append(", prizeMoney=").append(prizeMoney);
        sb.append(", overOrderMoney=").append(overOrderMoney);
        sb.append(", usefulDay=").append(usefulDay);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}