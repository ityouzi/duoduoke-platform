package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ActivityConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExtActivityConfig;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author: JY
 * @date: 2018/10/15 14:41
 */
public interface ExtActivityConfigMapper {

    /**
     * 查询时间范围有冲突的活动
     *
     * @param startTime
     * @param endTime
     * @param type
     * @return
     */
    List<ActivityConfig> queryConflict(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("type") Integer type);

    /**
     * 查询当前可用活动
     *
     * @param type
     * @return
     */
    ExtActivityConfig queryUsingActivity(@Param("type") Integer type);
}
