package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserExemptionGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserExemptionGoodsMapper {
    long countByExample(UserExemptionGoodsExample example);

    int deleteByExample(UserExemptionGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserExemptionGoods record);

    int insertSelective(UserExemptionGoods record);

    List<UserExemptionGoods> selectByExample(UserExemptionGoodsExample example);

    UserExemptionGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserExemptionGoods record, @Param("example") UserExemptionGoodsExample example);

    int updateByExample(@Param("record") UserExemptionGoods record, @Param("example") UserExemptionGoodsExample example);

    int updateByPrimaryKeySelective(UserExemptionGoods record);

    int updateByPrimaryKey(UserExemptionGoods record);
}