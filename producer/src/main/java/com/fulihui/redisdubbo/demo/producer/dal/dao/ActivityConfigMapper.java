package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ActivityConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ActivityConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityConfigMapper {
    long countByExample(ActivityConfigExample example);

    int deleteByExample(ActivityConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityConfig record);

    int insertSelective(ActivityConfig record);

    List<ActivityConfig> selectByExample(ActivityConfigExample example);

    ActivityConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityConfig record, @Param("example") ActivityConfigExample example);

    int updateByExample(@Param("record") ActivityConfig record, @Param("example") ActivityConfigExample example);

    int updateByPrimaryKeySelective(ActivityConfig record);

    int updateByPrimaryKey(ActivityConfig record);
}