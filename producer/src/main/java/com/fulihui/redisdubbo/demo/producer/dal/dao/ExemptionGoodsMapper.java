package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExemptionGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExemptionGoodsMapper {
    long countByExample(ExemptionGoodsExample example);

    int deleteByExample(ExemptionGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExemptionGoods record);

    int insertSelective(ExemptionGoods record);

    List<ExemptionGoods> selectByExample(ExemptionGoodsExample example);

    ExemptionGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExemptionGoods record, @Param("example") ExemptionGoodsExample example);

    int updateByExample(@Param("record") ExemptionGoods record, @Param("example") ExemptionGoodsExample example);

    int updateByPrimaryKeySelective(ExemptionGoods record);

    int updateByPrimaryKey(ExemptionGoods record);
}