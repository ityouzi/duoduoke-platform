package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.DuoduoGoodsInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.DuoduoGoodsInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DuoduoGoodsInfoZEROMapper {

    long countByExample(DuoduoGoodsInfoExample example);

    int deleteByExample(DuoduoGoodsInfoExample example);

    int deleteByPrimaryKey(Integer id);

    long insert(DuoduoGoodsInfo record);

    long insertSelective(DuoduoGoodsInfo record);

    List<DuoduoGoodsInfo> selectByExample(DuoduoGoodsInfoExample example);

    DuoduoGoodsInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DuoduoGoodsInfo record, @Param("example") DuoduoGoodsInfoExample example);

    int updateByExample(@Param("record") DuoduoGoodsInfo record, @Param("example") DuoduoGoodsInfoExample example);

    int updateByPrimaryKeySelective(DuoduoGoodsInfo record);

    int updateByPrimaryKey(DuoduoGoodsInfo record);
}