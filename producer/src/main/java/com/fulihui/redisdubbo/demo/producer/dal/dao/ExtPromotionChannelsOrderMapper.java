package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GroupChannelsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author wahaha
 */
public interface ExtPromotionChannelsOrderMapper {

    List<GroupChannelsOrder> queryGroup(@Param("start") int start, @Param("rows") int rows,
                                        @Param("channelsCode") String channelsCode,
                                        @Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate,
                                        @Param("promoType") String promoType,
                                        @Param("orderStatusList") List<String> orderStatusList,
                                        @Param("userOrderStatusList") List<String> userOrderStatusList,
                                        @Param("startDateModify") Date startDateModify, @Param("endDateModify") Date endDateModify);

    int queryGroupCount(@Param("channelsCode") String channelsCode,
                        @Param("startDate") Date startDate, @Param("endDate") Date endDate,
                        @Param("promoType") String promoType,
                        @Param("orderStatusList") List<String> orderStatusList,
                        @Param("userOrderStatusList") List<String> userOrderStatusList,
                        @Param("startDateModify") Date startDateModify, @Param("endDateModify") Date endDateModify


    );

    List<GroupChannelsOrder> queryGroupModify(@Param("start") int start, @Param("rows") int rows,
                                              @Param("channelsCode") String channelsCode,
                                              @Param("startDate") Date startDate,
                                              @Param("endDate") Date endDate,
                                              @Param("promoType") String promoType,
                                              @Param("orderStatusList") List<String> orderStatusList,
                                              @Param("userOrderStatusList") List<String> userOrderStatusList,
                                              @Param("startDateModify") Date startDateModify, @Param("endDateModify") Date endDateModify);


    int queryGroupCountModify(@Param("channelsCode") String channelsCode,
                              @Param("startDate") Date startDate, @Param("endDate") Date endDate,
                              @Param("promoType") String promoType,
                              @Param("orderStatusList") List<String> orderStatusList,
                              @Param("userOrderStatusList") List<String> userOrderStatusList,
                              @Param("startDateModify") Date startDateModify, @Param("endDateModify") Date endDateModify);

}