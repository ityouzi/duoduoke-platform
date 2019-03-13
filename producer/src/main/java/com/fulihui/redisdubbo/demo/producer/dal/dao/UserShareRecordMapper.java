package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserShareRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserShareRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserShareRecordMapper {
    long countByExample(UserShareRecordExample example);

    int deleteByExample(UserShareRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserShareRecord record);

    int insertSelective(UserShareRecord record);

    List<UserShareRecord> selectByExample(UserShareRecordExample example);

    UserShareRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserShareRecord record, @Param("example") UserShareRecordExample example);

    int updateByExample(@Param("record") UserShareRecord record, @Param("example") UserShareRecordExample example);

    int updateByPrimaryKeySelective(UserShareRecord record);

    int updateByPrimaryKey(UserShareRecord record);
}