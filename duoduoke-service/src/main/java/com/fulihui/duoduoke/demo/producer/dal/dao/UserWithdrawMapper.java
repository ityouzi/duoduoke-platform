package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdraw;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdrawExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserWithdrawMapper {
    long countByExample(UserWithdrawExample example);

    int deleteByExample(UserWithdrawExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserWithdraw record);

    int insertSelective(UserWithdraw record);

    List<UserWithdraw> selectByExample(UserWithdrawExample example);

    UserWithdraw selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserWithdraw record, @Param("example") UserWithdrawExample example);

    int updateByExample(@Param("record") UserWithdraw record, @Param("example") UserWithdrawExample example);

    int updateByPrimaryKeySelective(UserWithdraw record);

    int updateByPrimaryKey(UserWithdraw record);
}