package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFansDetail;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFansDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFansDetailMapper {
    long countByExample(UserFansDetailExample example);

    int deleteByExample(UserFansDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFansDetail record);

    int insertSelective(UserFansDetail record);

    List<UserFansDetail> selectByExample(UserFansDetailExample example);

    UserFansDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFansDetail record, @Param("example") UserFansDetailExample example);

    int updateByExample(@Param("record") UserFansDetail record, @Param("example") UserFansDetailExample example);

    int updateByPrimaryKeySelective(UserFansDetail record);

    int updateByPrimaryKey(UserFansDetail record);
}