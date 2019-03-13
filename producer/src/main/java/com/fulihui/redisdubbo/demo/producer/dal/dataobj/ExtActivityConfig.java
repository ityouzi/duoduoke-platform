package com.fulihui.redisdubbo.demo.producer.dal.dataobj;

import lombok.Data;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/10/16 14:56
 */
@Data
public class ExtActivityConfig extends ActivityConfig {

    /**
     * 活动奖品
     */
    private List<ActivitySignPrize> activityPrize;
}
