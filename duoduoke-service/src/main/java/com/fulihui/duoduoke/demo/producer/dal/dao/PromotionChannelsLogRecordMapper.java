package com.fulihui.duoduoke.demo.producer.dal.dao;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsLogRecord;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsLogRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PromotionChannelsLogRecordMapper {
    long countByExample(PromotionChannelsLogRecordExample example);

    int deleteByExample(PromotionChannelsLogRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionChannelsLogRecord record);

    int insertSelective(PromotionChannelsLogRecord record);

    List<PromotionChannelsLogRecord> selectByExample(PromotionChannelsLogRecordExample example);

    PromotionChannelsLogRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionChannelsLogRecord record, @Param("example") PromotionChannelsLogRecordExample example);

    int updateByExample(@Param("record") PromotionChannelsLogRecord record, @Param("example") PromotionChannelsLogRecordExample example);

    int updateByPrimaryKeySelective(PromotionChannelsLogRecord record);

    int updateByPrimaryKey(PromotionChannelsLogRecord record);
}