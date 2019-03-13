package com.fulihui.duoduoke.demo.producer.dal.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
public interface ExtOrderFansDetailMapper {

    long querySum(@Param("pUserId") String pUserId,
                  @Param("orderStatus") String orderStatus);

}