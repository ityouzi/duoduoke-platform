package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfoExample;

import java.util.Date;
import java.util.List;


/**
 * The interface Order info repository.
 *
 * @author lizhi
 * @date 2018 -7-10
 */
public interface OrderInfoRepository {

    /**
     * Query group list.
     *
     * @param start               the start
     * @param rows                the rows
     * @param startDate           the start date
     * @param endDate             the end date
     * @param promoType           the promo type
     * @param orderStatusList     the order status list
     * @param userOrderStatusList the user order status list
     * @return the list
     */
    List<GroupChannelsOrderDTO> queryGroup(int start, int rows, Date startDate, Date endDate,
                                           String promoType, List<String> orderStatusList,
                                           List<String> userOrderStatusList);

    /**
     * Query group count int.
     *
     * @param startDate           the start date
     * @param endDate             the end date
     * @param promoType           the promo type
     * @param orderStatusList     the order status list
     * @param userOrderStatusList the user order status list
     * @return the int
     */
    int queryGroupCount(Date startDate, Date endDate, String promoType,
                        List<String> orderStatusList, List<String> userOrderStatusList);

    /**
     * Query group count ext list.
     *
     * @param startDate           the start date
     * @param endDate             the end date
     * @param promoType           the promo type
     * @param orderStatusList     the order status list
     * @param userOrderStatusList the user order status list
     * @return the list
     */
    List<GroupChannelsOrderDTO> queryGroupExt(Date startDate, Date endDate, String promoType,
                                              List<String> orderStatusList,
                                              List<String> userOrderStatusList);

    List<Integer> queryGroupCountExt(Date startDate, Date endDate, String promoType,
                                     List<String> orderStatusList,
                                     List<String> userOrderStatusList);

    /**
     * Insert int.
     *
     * @param info the info
     * @return the int
     */
    int insert(OrderInfo info);

    /**
     * 查询订单
     *
     * @param orderSn     the order sn
     * @param orderStatus the order status
     * @return the order info
     */
    List<OrderInfo> query(String orderSn, String orderStatus);

    /**
     * Update boolean.
     *
     * @param record the record
     * @return the boolean
     */
    boolean update(OrderInfo record);

    /**
     * Update by example selective int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(OrderInfo record,
                                 OrderInfoExample example);

    /**
     * Query by order sn list.
     *
     * @param orderSn the order sn
     * @return the list
     */
    List<OrderInfo> queryByOrderSn(String orderSn);

    /**
     * Query by order sn list.
     *
     * @param orderSn the order sn
     * @param userId  the user id
     * @return the list
     */
    List<OrderInfo> queryByOrderSn(String orderSn, String userId);

    /**
     * 按条件查询活动
     *
     * @return {@link OrderInfoDTO} 列表
     */
    List<OrderInfoDTO> query(OrderInfoExample example);

    /**
     * Count long.
     *
     * @param example the example
     * @return the long
     */
    long count(OrderInfoExample example);

    List<OrderInfoDTO> queryOrderExceedDay(String orderStatus, String userOrderStatus,
                                           String promoType, int start, int rows);

    int queryOrderExceedDayCount(String orderStatus, String userOrderStatus, String promoType);

}
