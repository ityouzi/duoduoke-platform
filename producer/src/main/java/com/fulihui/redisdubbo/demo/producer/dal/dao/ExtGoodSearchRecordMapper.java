package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodSearchRecordStatistics;

import java.util.List;
import java.util.Map;


/**
 * @author: JY
 * @date: 2018/7/30 13:31
 */
public interface ExtGoodSearchRecordMapper {

    /**
     * 统计次数查询
     *
     * @return
     */
    List<GoodSearchRecordStatistics> selectStatistics(Map<String, Object> params);

}
