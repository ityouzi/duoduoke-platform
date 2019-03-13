package com.fulihui.duoduoke.demo.producer.dal.dao;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserPosterImg;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserPosterImgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPosterImgMapper {
    long countByExample(UserPosterImgExample example);

    int deleteByExample(UserPosterImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPosterImg record);

    int insertSelective(UserPosterImg record);

    List<UserPosterImg> selectByExample(UserPosterImgExample example);

    UserPosterImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPosterImg record, @Param("example") UserPosterImgExample example);

    int updateByExample(@Param("record") UserPosterImg record, @Param("example") UserPosterImgExample example);

    int updateByPrimaryKeySelective(UserPosterImg record);

    int updateByPrimaryKey(UserPosterImg record);
}