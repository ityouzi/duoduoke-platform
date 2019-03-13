package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.AppConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.AppConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AppConfigMapper {
    long countByExample(AppConfigExample example);

    int deleteByExample(AppConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppConfig record);

    int insertSelective(AppConfig record);

    List<AppConfig> selectByExample(AppConfigExample example);

    AppConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppConfig record, @Param("example") AppConfigExample example);

    int updateByExample(@Param("record") AppConfig record, @Param("example") AppConfigExample example);

    int updateByPrimaryKeySelective(AppConfig record);

    int updateByPrimaryKey(AppConfig record);
}