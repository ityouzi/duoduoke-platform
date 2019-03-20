package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsMark;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsMarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMarkMapper {
    long countByExample(GoodsMarkExample example);

    int deleteByExample(GoodsMarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsMark record);

    int insertSelective(GoodsMark record);

    List<GoodsMark> selectByExample(GoodsMarkExample example);

    GoodsMark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsMark record, @Param("example") GoodsMarkExample example);

    int updateByExample(@Param("record") GoodsMark record, @Param("example") GoodsMarkExample example);

    int updateByPrimaryKeySelective(GoodsMark record);

    int updateByPrimaryKey(GoodsMark record);
}