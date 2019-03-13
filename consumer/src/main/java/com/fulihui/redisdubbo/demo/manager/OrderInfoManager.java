package com.fulihui.redisdubbo.demo.manager;

import java.util.Date;
import java.util.List;

/**
 * The interface Order info manager.
 *
 * @author lizhi
 * @date 2018 -7-12
 */
public interface OrderInfoManager {

    /**
     * 指尚未进入到您的账户余额的金额，包含待确认待结算状态的订单预估奖励总和，将在过审核周期后发放到您的账户余额
     *
     * @param userId          the user id userId
     * @param userOrderStatus the user order status 订单状态
     * @param orderType       the order type
     * @return the long 审核中收入
     */
    long auditIncome(String userId, List<String> userOrderStatus, String orderType, String helpStatus, String promoType);

    /**
     * 查询待确认的订单数量
     *
     * @param userId          the user id
     * @param userOrderStatus the user order status
     * @return the long
     */
    long confirmedCount(String userId, List<String> userOrderStatus, String promoType);

    /**
     * 查询待结算的订单数量
     *
     * @param userId          the user id
     * @param userOrderStatus the user order status
     * @return the count
     */
    long settlementCount(String userId, List<String> userOrderStatus, String promoType);

    /**
     * 查询最近的下单订单数量
     *
     * @param userId          the user id
     * @param userOrderStatus the user order status
     * @param startTime       the start time
     * @param endTime         the end time
     * @param orderStatus     the order status
     * @return the long
     */
    long recentCount(String userId, List<String> userOrderStatus, Date startTime, Date endTime,
                     List<String> orderStatus, String promoType);
}
