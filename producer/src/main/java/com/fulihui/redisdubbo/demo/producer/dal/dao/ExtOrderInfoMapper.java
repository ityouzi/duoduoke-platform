package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GroupChannelsOrder;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author wahaha
 */
public interface ExtOrderInfoMapper {

    List<GroupChannelsOrder> queryGroup(@Param("start") int start, @Param("rows") int rows,
                                        @Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate,
                                        @Param("promoType") String promoType,
                                        @Param("orderStatusList") List<String> orderStatusList,
                                        @Param("userOrderStatusList") List<String> userOrderStatusList);

    int queryGroupCount(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
                        @Param("promoType") String promoType,
                        @Param("orderStatusList") List<String> orderStatusList,
                        @Param("userOrderStatusList") List<String> userOrderStatusList);

    List<GroupChannelsOrder> queryGroupExt(@Param("startDate") Date startDate,
                                           @Param("endDate") Date endDate,
                                           @Param("promoType") String promoType,
                                           @Param("orderStatusList") List<String> orderStatusList,
                                           @Param("userOrderStatusList") List<String> userOrderStatusList);

    List<Integer> queryGroupCountExt(@Param("startDate") Date startDate,
                                     @Param("endDate") Date endDate,
                                     @Param("promoType") String promoType,
                                     @Param("orderStatusList") List<String> orderStatusList,
                                     @Param("userOrderStatusList") List<String> userOrderStatusList);

    List<OrderInfo> queryOrderExceedDay(@Param("orderStatus") String orderStatus,
                                        @Param("userOrderStatus") String userOrderStatus,
                                        @Param("promoType") String promoType,
                                        @Param("start") int start, @Param("rows") int rows);

    int queryOrderExceedDayCount(@Param("orderStatus") String orderStatus,
                                 @Param("userOrderStatus") String userOrderStatus,
                                 @Param("promoType") String promoType);
}
