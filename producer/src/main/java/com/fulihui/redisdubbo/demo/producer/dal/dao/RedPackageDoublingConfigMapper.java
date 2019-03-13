package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.RedPackageDoublingConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.RedPackageDoublingConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RedPackageDoublingConfigMapper {
    long countByExample(RedPackageDoublingConfigExample example);

    int deleteByExample(RedPackageDoublingConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RedPackageDoublingConfig record);

    int insertSelective(RedPackageDoublingConfig record);

    List<RedPackageDoublingConfig> selectByExample(RedPackageDoublingConfigExample example);

    RedPackageDoublingConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RedPackageDoublingConfig record, @Param("example") RedPackageDoublingConfigExample example);

    int updateByExample(@Param("record") RedPackageDoublingConfig record, @Param("example") RedPackageDoublingConfigExample example);

    int updateByPrimaryKeySelective(RedPackageDoublingConfig record);

    int updateByPrimaryKey(RedPackageDoublingConfig record);
}