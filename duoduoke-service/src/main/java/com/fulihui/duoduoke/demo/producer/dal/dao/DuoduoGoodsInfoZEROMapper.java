package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoGoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DuoduoGoodsInfoZEROMapper {

    long countByExample(DuoduoGoodsInfoExample example);

    int deleteByExample(DuoduoGoodsInfoExample example);

    int deleteByPrimaryKey(Integer id);

    long insert(DuoGoodsInfo record);

    long insertSelective(DuoGoodsInfo record);

    List<DuoGoodsInfo> selectByExample(DuoduoGoodsInfoExample example);

    DuoGoodsInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DuoGoodsInfo record, @Param("example") DuoduoGoodsInfoExample example);

    int updateByExample(@Param("record") DuoGoodsInfo record, @Param("example") DuoduoGoodsInfoExample example);

    int updateByPrimaryKeySelective(DuoGoodsInfo record);

    int updateByPrimaryKey(DuoGoodsInfo record);
}