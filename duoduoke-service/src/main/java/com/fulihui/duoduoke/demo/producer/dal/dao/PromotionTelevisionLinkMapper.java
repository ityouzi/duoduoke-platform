package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionTelevisionLink;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionTelevisionLinkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PromotionTelevisionLinkMapper {
    long countByExample(PromotionTelevisionLinkExample example);

    int deleteByExample(PromotionTelevisionLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionTelevisionLink record);

    int insertSelective(PromotionTelevisionLink record);

    List<PromotionTelevisionLink> selectByExample(PromotionTelevisionLinkExample example);

    PromotionTelevisionLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionTelevisionLink record, @Param("example") PromotionTelevisionLinkExample example);

    int updateByExample(@Param("record") PromotionTelevisionLink record, @Param("example") PromotionTelevisionLinkExample example);

    int updateByPrimaryKeySelective(PromotionTelevisionLink record);

    int updateByPrimaryKey(PromotionTelevisionLink record);
}