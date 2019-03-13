package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsDoublesReward;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodsDoublesRewardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDoublesRewardMapper {
    long countByExample(GoodsDoublesRewardExample example);

    int deleteByExample(GoodsDoublesRewardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDoublesReward record);

    int insertSelective(GoodsDoublesReward record);

    List<GoodsDoublesReward> selectByExample(GoodsDoublesRewardExample example);

    GoodsDoublesReward selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsDoublesReward record, @Param("example") GoodsDoublesRewardExample example);

    int updateByExample(@Param("record") GoodsDoublesReward record, @Param("example") GoodsDoublesRewardExample example);

    int updateByPrimaryKeySelective(GoodsDoublesReward record);

    int updateByPrimaryKey(GoodsDoublesReward record);

}