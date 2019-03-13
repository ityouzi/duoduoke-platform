package com.fulihui.duoduoke.demo.producer.dal.dao;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.Advert;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.AdvertExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AdvertMapper {
    long countByExample(AdvertExample example);

    int deleteByExample(AdvertExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Advert record);

    int insertSelective(Advert record);

    List<Advert> selectByExample(AdvertExample example);

    Advert selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Advert record, @Param("example") AdvertExample example);

    int updateByExample(@Param("record") Advert record, @Param("example") AdvertExample example);

    int updateByPrimaryKeySelective(Advert record);

    int updateByPrimaryKey(Advert record);
}