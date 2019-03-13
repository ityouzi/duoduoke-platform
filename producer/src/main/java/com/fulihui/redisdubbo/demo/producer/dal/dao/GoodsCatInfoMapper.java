package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsCatInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsCatInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCatInfoMapper {
    long countByExample(GoodsCatInfoExample example);

    int deleteByExample(GoodsCatInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCatInfo record);

    int insertSelective(GoodsCatInfo record);

    List<GoodsCatInfo> selectByExample(GoodsCatInfoExample example);

    GoodsCatInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsCatInfo record, @Param("example") GoodsCatInfoExample example);

    int updateByExample(@Param("record") GoodsCatInfo record, @Param("example") GoodsCatInfoExample example);

    int updateByPrimaryKeySelective(GoodsCatInfo record);

    int updateByPrimaryKey(GoodsCatInfo record);
}