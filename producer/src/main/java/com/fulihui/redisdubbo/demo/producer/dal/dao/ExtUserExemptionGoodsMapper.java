package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserExemptionGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ExtUserExemptionGoodsMapper {

    long queryExceedDayCount(@Param("state") String state,
                             @Param("bindOrderStatus") String bindOrderStatus);

    List<UserExemptionGoods> queryExceedDay(@Param("state") String state,
                                            @Param("bindOrderStatus") String bindOrderStatus,
                                            @Param("offset") int offset, @Param("limit") int limit);

}