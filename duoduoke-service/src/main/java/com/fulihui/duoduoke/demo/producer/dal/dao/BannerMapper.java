package com.fulihui.duoduoke.demo.producer.dal.dao;



import com.fulihui.duoduoke.demo.producer.dal.dataobj.Banner;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.BannerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    long countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}