package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.TemplateSendTask;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.TemplateSendTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateSendTaskMapper {
    long countByExample(TemplateSendTaskExample example);

    int deleteByExample(TemplateSendTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TemplateSendTask record);

    int insertSelective(TemplateSendTask record);

    List<TemplateSendTask> selectByExample(TemplateSendTaskExample example);

    TemplateSendTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TemplateSendTask record, @Param("example") TemplateSendTaskExample example);

    int updateByExample(@Param("record") TemplateSendTask record, @Param("example") TemplateSendTaskExample example);

    int updateByPrimaryKeySelective(TemplateSendTask record);

    int updateByPrimaryKey(TemplateSendTask record);
}