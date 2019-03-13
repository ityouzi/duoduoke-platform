package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignUserCount;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignUserCountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignUserCountMapper {
    long countByExample(SignUserCountExample example);

    int deleteByExample(SignUserCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SignUserCount record);

    int insertSelective(SignUserCount record);

    List<SignUserCount> selectByExample(SignUserCountExample example);

    SignUserCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SignUserCount record, @Param("example") SignUserCountExample example);

    int updateByExample(@Param("record") SignUserCount record, @Param("example") SignUserCountExample example);

    int updateByPrimaryKeySelective(SignUserCount record);

    int updateByPrimaryKey(SignUserCount record);
}