package com.fulihui.duoduoke.demo.producer.dal.dao;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.PositionBanner;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PositionBannerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionBannerMapper {
    long countByExample(PositionBannerExample example);

    int deleteByExample(PositionBannerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PositionBanner record);

    int insertSelective(PositionBanner record);

    List<PositionBanner> selectByExample(PositionBannerExample example);

    PositionBanner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PositionBanner record, @Param("example") PositionBannerExample example);

    int updateByExample(@Param("record") PositionBanner record, @Param("example") PositionBannerExample example);

    int updateByPrimaryKeySelective(PositionBanner record);

    int updateByPrimaryKey(PositionBanner record);
}