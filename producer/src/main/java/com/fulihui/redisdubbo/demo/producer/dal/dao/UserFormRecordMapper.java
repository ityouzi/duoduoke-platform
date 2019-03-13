package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFormRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFormRecordMapper {
    long countByExample(UserFormRecordExample example);

    int deleteByExample(UserFormRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFormRecord record);

    int insertSelective(UserFormRecord record);

    List<UserFormRecord> selectByExample(UserFormRecordExample example);

    UserFormRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFormRecord record, @Param("example") UserFormRecordExample example);

    int updateByExample(@Param("record") UserFormRecord record, @Param("example") UserFormRecordExample example);

    int updateByPrimaryKeySelective(UserFormRecord record);

    int updateByPrimaryKey(UserFormRecord record);
}