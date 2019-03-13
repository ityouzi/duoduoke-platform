package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetail;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserAccountDetailMapper {
    long countByExample(UserAccountDetailExample example);

    int deleteByExample(UserAccountDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAccountDetail record);

    int insertSelective(UserAccountDetail record);

    List<UserAccountDetail> selectByExample(UserAccountDetailExample example);

    UserAccountDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAccountDetail record, @Param("example") UserAccountDetailExample example);

    int updateByExample(@Param("record") UserAccountDetail record, @Param("example") UserAccountDetailExample example);

    int updateByPrimaryKeySelective(UserAccountDetail record);

    int updateByPrimaryKey(UserAccountDetail record);
}