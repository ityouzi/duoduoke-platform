package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class UserFansDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * user_fans_detail.id
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private Integer id;
    /**
     * user_fans_detail.user_id
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private String userId;
    /**
     * user_fans_detail.statistics_date
     * 统计时间
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private Date statisticsDate;
    /**
     * user_fans_detail.one_fans_num
     * 一级粉丝数量
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private Integer oneFansNum;
    /**
     * user_fans_detail.two_fans_num
     * 二级粉丝数量
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private Integer twoFansNum;
    /**
     * user_fans_detail.subsidy_amount
     * 补贴金额
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private Integer subsidyAmount;
    /**
     * user_fans_detail.order_num
     * 订单数量
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private Integer orderNum;
    /**
     * user_fans_detail.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private Date gmtCreate;
    /**
     * user_fans_detail.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-08-01 14:05:31
     */
    private Date gmtModified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", statisticsDate=").append(statisticsDate);
        sb.append(", oneFansNum=").append(oneFansNum);
        sb.append(", twoFansNum=").append(twoFansNum);
        sb.append(", subsidyAmount=").append(subsidyAmount);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}