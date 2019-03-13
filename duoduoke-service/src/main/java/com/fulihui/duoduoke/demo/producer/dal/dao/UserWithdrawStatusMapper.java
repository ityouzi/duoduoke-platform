package com.fulihui.duoduoke.demo.producer.dal.dao;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdrawStatus;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdrawStatusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserWithdrawStatusMapper {
    long countByExample(UserWithdrawStatusExample example);

    int deleteByExample(UserWithdrawStatusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserWithdrawStatus record);

    int insertSelective(UserWithdrawStatus record);

    List<UserWithdrawStatus> selectByExample(UserWithdrawStatusExample example);

    UserWithdrawStatus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserWithdrawStatus record, @Param("example") UserWithdrawStatusExample example);

    int updateByExample(@Param("record") UserWithdrawStatus record, @Param("example") UserWithdrawStatusExample example);

    int updateByPrimaryKeySelective(UserWithdrawStatus record);

    int updateByPrimaryKey(UserWithdrawStatus record);
}