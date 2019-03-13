package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserRedPackageRecord;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserRedPackageRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRedPackageRecordMapper {
    long countByExample(UserRedPackageRecordExample example);

    int deleteByExample(UserRedPackageRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRedPackageRecord record);

    int insertSelective(UserRedPackageRecord record);

    List<UserRedPackageRecord> selectByExample(UserRedPackageRecordExample example);

    UserRedPackageRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRedPackageRecord record, @Param("example") UserRedPackageRecordExample example);

    int updateByExample(@Param("record") UserRedPackageRecord record, @Param("example") UserRedPackageRecordExample example);

    int updateByPrimaryKeySelective(UserRedPackageRecord record);

    int updateByPrimaryKey(UserRedPackageRecord record);
}