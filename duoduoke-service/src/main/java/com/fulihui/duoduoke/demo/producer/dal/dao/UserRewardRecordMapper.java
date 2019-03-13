package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserRewardRecord;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserRewardRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRewardRecordMapper {
    long countByExample(UserRewardRecordExample example);

    int deleteByExample(UserRewardRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRewardRecord record);

    int insertSelective(UserRewardRecord record);

    List<UserRewardRecord> selectByExample(UserRewardRecordExample example);

    UserRewardRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRewardRecord record, @Param("example") UserRewardRecordExample example);

    int updateByExample(@Param("record") UserRewardRecord record, @Param("example") UserRewardRecordExample example);

    int updateByPrimaryKeySelective(UserRewardRecord record);

    int updateByPrimaryKey(UserRewardRecord record);
}