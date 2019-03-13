package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.RedPackageField;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.RedPackageFieldExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RedPackageFieldMapper {
    long countByExample(RedPackageFieldExample example);

    int deleteByExample(RedPackageFieldExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RedPackageField record);

    int insertSelective(RedPackageField record);

    List<RedPackageField> selectByExample(RedPackageFieldExample example);

    RedPackageField selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RedPackageField record, @Param("example") RedPackageFieldExample example);

    int updateByExample(@Param("record") RedPackageField record, @Param("example") RedPackageFieldExample example);

    int updateByPrimaryKeySelective(RedPackageField record);

    int updateByPrimaryKey(RedPackageField record);
}