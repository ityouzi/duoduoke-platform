package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionChannelsLink;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.PromotionChannelsLinkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PromotionChannelsLinkMapper {
    long countByExample(PromotionChannelsLinkExample example);

    int deleteByExample(PromotionChannelsLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionChannelsLink record);

    int insertSelective(PromotionChannelsLink record);

    List<PromotionChannelsLink> selectByExample(PromotionChannelsLinkExample example);

    PromotionChannelsLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionChannelsLink record, @Param("example") PromotionChannelsLinkExample example);

    int updateByExample(@Param("record") PromotionChannelsLink record, @Param("example") PromotionChannelsLinkExample example);

    int updateByPrimaryKeySelective(PromotionChannelsLink record);

    int updateByPrimaryKey(PromotionChannelsLink record);
}