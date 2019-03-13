package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatPushTemplateContent;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatPushTemplateContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatPushTemplateContentMapper {
    long countByExample(WechatPushTemplateContentExample example);

    int deleteByExample(WechatPushTemplateContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatPushTemplateContent record);

    int insertSelective(WechatPushTemplateContent record);

    List<WechatPushTemplateContent> selectByExample(WechatPushTemplateContentExample example);

    WechatPushTemplateContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatPushTemplateContent record, @Param("example") WechatPushTemplateContentExample example);

    int updateByExample(@Param("record") WechatPushTemplateContent record, @Param("example") WechatPushTemplateContentExample example);

    int updateByPrimaryKeySelective(WechatPushTemplateContent record);

    int updateByPrimaryKey(WechatPushTemplateContent record);
}