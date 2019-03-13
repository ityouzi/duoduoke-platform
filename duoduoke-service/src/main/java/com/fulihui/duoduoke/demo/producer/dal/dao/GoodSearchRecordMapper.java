package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodSearchRecord;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodSearchRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodSearchRecordMapper {
    long countByExample(GoodSearchRecordExample example);

    int deleteByExample(GoodSearchRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodSearchRecord record);

    int insertSelective(GoodSearchRecord record);

    List<GoodSearchRecord> selectByExample(GoodSearchRecordExample example);

    GoodSearchRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodSearchRecord record, @Param("example") GoodSearchRecordExample example);

    int updateByExample(@Param("record") GoodSearchRecord record, @Param("example") GoodSearchRecordExample example);

    int updateByPrimaryKeySelective(GoodSearchRecord record);

    int updateByPrimaryKey(GoodSearchRecord record);
}