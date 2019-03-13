package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsOrderExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PromotionChannelsOrderMapper {
    long countByExample(PromotionChannelsOrderExample example);

    int deleteByExample(PromotionChannelsOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionChannelsOrder record);

    int insertSelective(PromotionChannelsOrder record);

    List<PromotionChannelsOrder> selectByExample(PromotionChannelsOrderExample example);

    PromotionChannelsOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionChannelsOrder record, @Param("example") PromotionChannelsOrderExample example);

    int updateByExample(@Param("record") PromotionChannelsOrder record, @Param("example") PromotionChannelsOrderExample example);

    int updateByPrimaryKeySelective(PromotionChannelsOrder record);

    int updateByPrimaryKey(PromotionChannelsOrder record);
}