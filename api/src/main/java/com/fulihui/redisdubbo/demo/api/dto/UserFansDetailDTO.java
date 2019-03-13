package com.fulihui.redisdubbo.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-7-30
 */
@Setter
@Getter
public class UserFansDetailDTO extends ToString {
    private static final long serialVersionUID = -5624448848269597584L;


    private Integer id;

    /**
     * user_fans.user_id
     **/
    private String userId;

    /**
     * user_fans.statistics_date
     * 统计时间
     *
     * @mbg.generated 2018-07-31 15:10:25
     */
    private Date statisticsDate;

    /**
     * user_fans.one_fans_num
     * 一级粉丝数量
     *
     * @mbg.generated 2018-07-31 15:10:25
     */
    private Integer oneFansNum;

    /**
     * user_fans.two_fans_num
     * 二级粉丝数量
     *
     * @mbg.generated 2018-07-31 15:10:25
     */
    private Integer twoFansNum;

    /**
     * user_fans.subsidy_amount
     * 补贴金额
     *
     * @mbg.generated 2018-07-31 15:10:25
     */
    private Integer subsidyAmount;

    /**
     * user_fans.order_num
     * 订单数量
     *
     * @mbg.generated 2018-07-31 15:10:25
     */
    private Integer orderNum;

    /**
     * user_fans.gmt_create
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * user_fans.gmt_modified
     * 修改时间
     **/
    private Date gmtModified;

}
