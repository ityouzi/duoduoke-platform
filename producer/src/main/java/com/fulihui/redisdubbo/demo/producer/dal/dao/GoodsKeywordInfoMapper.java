package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsKeywordInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsKeywordInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsKeywordInfoMapper {
    long countByExample(GoodsKeywordInfoExample example);

    int deleteByExample(GoodsKeywordInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsKeywordInfo record);

    int insertSelective(GoodsKeywordInfo record);

    List<GoodsKeywordInfo> selectByExample(GoodsKeywordInfoExample example);

    GoodsKeywordInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsKeywordInfo record, @Param("example") GoodsKeywordInfoExample example);

    int updateByExample(@Param("record") GoodsKeywordInfo record, @Param("example") GoodsKeywordInfoExample example);

    int updateByPrimaryKeySelective(GoodsKeywordInfo record);

    int updateByPrimaryKey(GoodsKeywordInfo record);
}