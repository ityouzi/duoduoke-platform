/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.web.manager;


import com.fulihui.duoduoke.demo.web.vo.UserWithdrawVO;
import com.fulihui.duoduoke.demo.web.vo.UserBalanceVO;
import org.near.webmvcsupport.view.PageView;

import java.util.List;

/**
 * The interface User account manager.
 *
 * @author lizhi
 */
public interface UserAccountManager {

    /**
     * 用户提现到微信余额
     *
     * @param userId         用户唯一标识
     * @param openId         公众号 openid
     * @param withdrawAmount the withdraw amount
     */
    void withdrawToWxAccount(String userId, String openId, Long withdrawAmount);

    /**
     * 查询用户余额
     *
     * @param userId the user id
     * @return the user balance vo
     */
    UserBalanceVO balance(String userId);

    /**
     * 查询用户的累计收入
     *
     * @param userId   the user id
     * @param bizCodes the biz codes
     * @param optType  the opt type
     * @return long long
     */
    long accumulativeIncome(String userId, List<String> bizCodes, String optType);

    /**
     * Query user withdraw page view.
     *
     * @param userId the user id
     * @param page   the page
     * @param rows   the rows
     * @return the page view
     */
    PageView<UserWithdrawVO> queryUserWithdraw(String userId, int page, int rows);

    /**
     * Send.
     *
     * @param userId  the user id
     * @param balance the balance
     * @param text    the text
     */
    void send(String userId, int balance, String text);
}
