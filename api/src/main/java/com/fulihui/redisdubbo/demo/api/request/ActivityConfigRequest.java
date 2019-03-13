package com.fulihui.redisdubbo.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/10/15 13:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityConfigRequest extends PageRequest {
    /**
     * 标识列
     */
    private Integer id;

    /**
     * 活动类型 [1:签到活动] [2:翻牌活动]
     */
    private Integer type;

    /**
     * 活动状态 [1:有效][2:无效]
     */
    private Integer state;

    /**
     * 活动开始时间
     */
    private Date    startTime;

    /**
     * 活动结束时间
     */
    private Date    endTime;

    public ActivityConfigRequest(Integer id) {
        this.id = id;
    }

}
