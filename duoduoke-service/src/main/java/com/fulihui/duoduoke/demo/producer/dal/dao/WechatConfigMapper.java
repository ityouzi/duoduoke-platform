package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatConfigMapper {
    long countByExample(WechatConfigExample example);

    int deleteByExample(WechatConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatConfig record);

    int insertSelective(WechatConfig record);

    List<WechatConfig> selectByExample(WechatConfigExample example);

    WechatConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatConfig record, @Param("example") WechatConfigExample example);

    int updateByExample(@Param("record") WechatConfig record, @Param("example") WechatConfigExample example);

    int updateByPrimaryKeySelective(WechatConfig record);

    int updateByPrimaryKey(WechatConfig record);
}