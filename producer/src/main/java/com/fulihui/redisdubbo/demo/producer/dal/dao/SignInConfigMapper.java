package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignInConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignInConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignInConfigMapper {
    long countByExample(SignInConfigExample example);

    int deleteByExample(SignInConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SignInConfig record);

    int insertSelective(SignInConfig record);

    List<SignInConfig> selectByExample(SignInConfigExample example);

    SignInConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SignInConfig record, @Param("example") SignInConfigExample example);

    int updateByExample(@Param("record") SignInConfig record, @Param("example") SignInConfigExample example);

    int updateByPrimaryKeySelective(SignInConfig record);

    int updateByPrimaryKey(SignInConfig record);
}