package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsTabel;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsTabelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTabelMapper {
    long countByExample(GoodsTabelExample example);

    int deleteByExample(GoodsTabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsTabel record);

    int insertSelective(GoodsTabel record);

    List<GoodsTabel> selectByExample(GoodsTabelExample example);

    GoodsTabel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsTabel record, @Param("example") GoodsTabelExample example);

    int updateByExample(@Param("record") GoodsTabel record, @Param("example") GoodsTabelExample example);

    int updateByPrimaryKeySelective(GoodsTabel record);

    int updateByPrimaryKey(GoodsTabel record);
}