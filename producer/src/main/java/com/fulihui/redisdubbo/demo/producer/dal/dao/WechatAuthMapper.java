package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatAuth;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatAuthMapper {
    long countByExample(WechatAuthExample example);

    int deleteByExample(WechatAuthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatAuth record);

    int insertSelective(WechatAuth record);

    List<WechatAuth> selectByExample(WechatAuthExample example);

    WechatAuth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatAuth record, @Param("example") WechatAuthExample example);

    int updateByExample(@Param("record") WechatAuth record, @Param("example") WechatAuthExample example);

    int updateByPrimaryKeySelective(WechatAuth record);

    int updateByPrimaryKey(WechatAuth record);
}