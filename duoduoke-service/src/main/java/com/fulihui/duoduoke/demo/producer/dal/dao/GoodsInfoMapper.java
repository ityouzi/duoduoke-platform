package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsInfoMapper {
    long countByExample(GoodsInfoExample example);

    int deleteByExample(GoodsInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    List<GoodsInfo> selectByExample(GoodsInfoExample example);

    GoodsInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

    int updateByExample(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}