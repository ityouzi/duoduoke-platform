package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.HomeColumn;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.HomeColumnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeColumnMapper {
    long countByExample(HomeColumnExample example);

    int deleteByExample(HomeColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HomeColumn record);

    int insertSelective(HomeColumn record);

    List<HomeColumn> selectByExample(HomeColumnExample example);

    HomeColumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HomeColumn record, @Param("example") HomeColumnExample example);

    int updateByExample(@Param("record") HomeColumn record, @Param("example") HomeColumnExample example);

    int updateByPrimaryKeySelective(HomeColumn record);

    int updateByPrimaryKey(HomeColumn record);
}