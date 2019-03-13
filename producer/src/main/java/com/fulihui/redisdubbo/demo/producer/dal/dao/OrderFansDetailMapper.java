package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderFansDetail;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderFansDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFansDetailMapper {
    long countByExample(OrderFansDetailExample example);

    int deleteByExample(OrderFansDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderFansDetail record);

    int insertSelective(OrderFansDetail record);

    List<OrderFansDetail> selectByExample(OrderFansDetailExample example);

    OrderFansDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderFansDetail record, @Param("example") OrderFansDetailExample example);

    int updateByExample(@Param("record") OrderFansDetail record, @Param("example") OrderFansDetailExample example);

    int updateByPrimaryKeySelective(OrderFansDetail record);

    int updateByPrimaryKey(OrderFansDetail record);
}