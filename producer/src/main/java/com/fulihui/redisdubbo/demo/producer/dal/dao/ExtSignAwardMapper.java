package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.SignAward;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtSignAwardMapper {

    List<SignAward> queryLastValidity(@Param("prizeType") String prizeType,
                                      @Param("prizeStatus") String prizeStatus,
                                      @Param("activityType") String activityType);


    long querySumPrizeMoney(
            @Param("userId") String userId,
            @Param("prizeType") List<String> prizeType,
            @Param("prizeStatus") List<String> prizeStatus,
            @Param("activityType") List<String> activityType);


    long queryExceedDayCount(@Param("prizeStatus") String prizeStatus, @Param("bindOrderStatus") String bindOrderStatus);


    List<SignAward> queryExceedDay(@Param("prizeStatus") String prizeStatus,
                                   @Param("bindOrderStatus") String bindOrderStatus,
                                   @Param("offset") int offset,
                                   @Param("limit") int limit);


}