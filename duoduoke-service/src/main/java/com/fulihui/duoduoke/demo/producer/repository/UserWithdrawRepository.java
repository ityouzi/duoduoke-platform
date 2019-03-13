package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdraw;

import java.util.List;


/**
 * @author: JY
 * @date: 2018/7/13 11:01
 */
public interface UserWithdrawRepository {

    /**
     * 该用户是否有真正提现的申请
     *
     * @param userId
     * @return
     */
    boolean hasWithdrawing(String userId, List<String> status);

    boolean insert(UserWithdraw userWithdraw);

    boolean update(UserWithdraw userWithdraw);

    UserWithdraw queryByTrade(String trade);

    UserWithdraw queryByPk(Long id);
}
