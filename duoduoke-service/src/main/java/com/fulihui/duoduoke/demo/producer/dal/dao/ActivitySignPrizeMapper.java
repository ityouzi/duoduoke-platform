package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.ActivitySignPrize;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.ActivitySignPrizeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ActivitySignPrizeMapper {
    long countByExample(ActivitySignPrizeExample example);

    int deleteByExample(ActivitySignPrizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivitySignPrize record);

    int insertSelective(ActivitySignPrize record);

    List<ActivitySignPrize> selectByExample(ActivitySignPrizeExample example);

    ActivitySignPrize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivitySignPrize record, @Param("example") ActivitySignPrizeExample example);

    int updateByExample(@Param("record") ActivitySignPrize record, @Param("example") ActivitySignPrizeExample example);

    int updateByPrimaryKeySelective(ActivitySignPrize record);

    int updateByPrimaryKey(ActivitySignPrize record);
}