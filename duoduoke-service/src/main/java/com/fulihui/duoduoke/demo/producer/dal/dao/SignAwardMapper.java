package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignAward;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.SignAwardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignAwardMapper {
    long countByExample(SignAwardExample example);

    int deleteByExample(SignAwardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SignAward record);

    int insertSelective(SignAward record);

    List<SignAward> selectByExample(SignAwardExample example);

    SignAward selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SignAward record, @Param("example") SignAwardExample example);

    int updateByExample(@Param("record") SignAward record, @Param("example") SignAwardExample example);

    int updateByPrimaryKeySelective(SignAward record);

    int updateByPrimaryKey(SignAward record);
}