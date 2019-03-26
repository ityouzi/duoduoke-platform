package com.fulihui.duoduoke.demo.api.request;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class UserRewardRecordRequest extends ToString {


    private static final long serialVersionUID = 8708150094159768426L;
    /**
    *
    *
    * user_reward_record.user_id
     * 用户Id
     *
     * @mbg.generated 2018-09-03 16:10:19
     */
    private String userId;

    /**
    *
    *
    * user_reward_record.orderSn
     * 订单编号
     *
     * @mbg.generated 2018-09-03 16:10:19
     */
    private String orderSn;

    /**
    *
    *
    * user_reward_record.help_user_id
     * 助力用户
     *
     * @mbg.generated 2018-09-03 16:10:19
     */
    private String helpUserId;

    /**
    *
    *
    * user_reward_record.help_percent
     * 助力百分比
     *
     * @mbg.generated 2018-09-03 16:10:19
     */
    private Double helpPercent;

    private String orderBy;

    private Date startCreateTime;

    private Date stopCreateTime;

}