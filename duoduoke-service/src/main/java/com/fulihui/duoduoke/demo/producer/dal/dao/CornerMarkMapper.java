package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.CornerMark;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.CornerMarkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CornerMarkMapper {
    long countByExample(CornerMarkExample example);

    int deleteByExample(CornerMarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CornerMark record);

    int insertSelective(CornerMark record);

    List<CornerMark> selectByExample(CornerMarkExample example);

    CornerMark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CornerMark record, @Param("example") CornerMarkExample example);

    int updateByExample(@Param("record") CornerMark record, @Param("example") CornerMarkExample example);

    int updateByPrimaryKeySelective(CornerMark record);

    int updateByPrimaryKey(CornerMark record);
}