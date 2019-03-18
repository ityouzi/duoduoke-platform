package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfoExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsInfoMapper {
    long countByExample(GoodsInfoExample example);

    int deleteByExample(GoodsInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfoWithBLOBs record);

    int insertSelective(GoodsInfoWithBLOBs record);

    List<GoodsInfoWithBLOBs> selectByExampleWithBLOBs(GoodsInfoExample example);

    List<GoodsInfo> selectByExample(GoodsInfoExample example);

    GoodsInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsInfoWithBLOBs record, @Param("example") GoodsInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsInfoWithBLOBs record, @Param("example") GoodsInfoExample example);

    int updateByExample(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

    int updateByPrimaryKeySelective(GoodsInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsInfoWithBLOBs record);

    int updateByPrimaryKey(GoodsInfo record);
}