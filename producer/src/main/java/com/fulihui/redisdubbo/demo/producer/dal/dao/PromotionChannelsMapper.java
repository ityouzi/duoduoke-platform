package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionChannels;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionChannelsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PromotionChannelsMapper {
    long countByExample(PromotionChannelsExample example);

    int deleteByExample(PromotionChannelsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionChannels record);

    int insertSelective(PromotionChannels record);

    List<PromotionChannels> selectByExample(PromotionChannelsExample example);

    PromotionChannels selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionChannels record, @Param("example") PromotionChannelsExample example);

    int updateByExample(@Param("record") PromotionChannels record, @Param("example") PromotionChannelsExample example);

    int updateByPrimaryKeySelective(PromotionChannels record);

    int updateByPrimaryKey(PromotionChannels record);
}