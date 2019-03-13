package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignUserConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignUserConfigMapper {
    long countByExample(SignUserConfigExample example);

    int deleteByExample(SignUserConfigExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SignUserConfig record);

    int insertSelective(SignUserConfig record);

    List<SignUserConfig> selectByExample(SignUserConfigExample example);

    SignUserConfig selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SignUserConfig record, @Param("example") SignUserConfigExample example);

    int updateByExample(@Param("record") SignUserConfig record, @Param("example") SignUserConfigExample example);

    int updateByPrimaryKeySelective(SignUserConfig record);

    int updateByPrimaryKey(SignUserConfig record);
}