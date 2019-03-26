package com.fulihui.duoduoke.demo.api.dto;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

@Data
public class UserRewardRecordDTO extends ToString {
    /**
    *
    *
    * user_reward_record.id
    
     *
     * @mbg.generated 2018-09-03 16:10:19
     */
    private Integer id;

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

    /**
    *
    *
    * user_reward_record.create_time
     * 创建时间
     *
     * @mbg.generated 2018-09-03 16:10:19
     */
    private Date createTime;

    /**
    *
    *
    * user_reward_record.update_time
     * 修改时间
     *
     * @mbg.generated 2018-09-03 16:10:19
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;


}