package com.fulihui.duoduoke.demo.api.dto.sign;

import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class SignUserCountDTO extends ToString {

    private Integer id;

    /**
    *
    *
    * sign_user_count.user_id
     * 用户id
     *
     * @mbg.generated 2018-10-12 10:08:48
     */
    private String  userId;

    /**
    *
    *
    * sign_user_count.last_time
     * 上次打开签到日期
     *
     * @mbg.generated 2018-10-12 10:08:48
     */
    private Date    lastTime;

    /**
    *
    *
    * sign_user_count.continuous_count
     * 已经连续签到次数
     *
     * @mbg.generated 2018-10-12 10:08:48
     */
    private Integer continuousCount;

    /**
    *
    *
    * sign_user_count.total_count
     * 签到总次数
     *
     * @mbg.generated 2018-10-12 10:08:48
     */
    private Integer totalCount;

    /**
    *
    *
    * sign_user_count.gmt_create
     * 创建时间
     *
     * @mbg.generated 2018-10-12 10:08:48
     */
    private Date    gmtCreate;

    /**
    *
    *
    * sign_user_count.gmt_modified
     * 修改时间
     *
     * @mbg.generated 2018-10-12 10:08:48
     */
    private Date    gmtModified;

    /**
    *
    *
    * sign_user_count.sign_time
    
     *
     * @mbg.generated 2018-10-12 10:08:48
     */
    private Date    signTime;

    private Date cycleTime;

}