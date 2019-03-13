package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatToken;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatTokenMapper {
    long countByExample(WechatTokenExample example);

    int deleteByExample(WechatTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatToken record);

    int insertSelective(WechatToken record);

    List<WechatToken> selectByExample(WechatTokenExample example);

    WechatToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatToken record, @Param("example") WechatTokenExample example);

    int updateByExample(@Param("record") WechatToken record, @Param("example") WechatTokenExample example);

    int updateByPrimaryKeySelective(WechatToken record);

    int updateByPrimaryKey(WechatToken record);
}