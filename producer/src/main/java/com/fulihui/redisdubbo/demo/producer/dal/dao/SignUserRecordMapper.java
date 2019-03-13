package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignUserRecordMapper {
    long countByExample(SignUserRecordExample example);

    int deleteByExample(SignUserRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SignUserRecord record);

    int insertSelective(SignUserRecord record);

    List<SignUserRecord> selectByExample(SignUserRecordExample example);

    SignUserRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SignUserRecord record, @Param("example") SignUserRecordExample example);

    int updateByExample(@Param("record") SignUserRecord record, @Param("example") SignUserRecordExample example);

    int updateByPrimaryKeySelective(SignUserRecord record);

    int updateByPrimaryKey(SignUserRecord record);
}