package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.StoreGoods;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.StoreGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreGoodsMapper {
    long countByExample(StoreGoodsExample example);

    int deleteByExample(StoreGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreGoods record);

    int insertSelective(StoreGoods record);

    List<StoreGoods> selectByExample(StoreGoodsExample example);

    StoreGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreGoods record, @Param("example") StoreGoodsExample example);

    int updateByExample(@Param("record") StoreGoods record, @Param("example") StoreGoodsExample example);

    int updateByPrimaryKeySelective(StoreGoods record);

    int updateByPrimaryKey(StoreGoods record);
}