/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.producer.repository;


import com.fulihui.duoduoke.demo.api.dto.UserAccountDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccount;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccountTotal;

import java.util.List;


/**
 * @author lizhi
 */
public interface UserAccountRepository {

    void insert(UserAccount record, String operator);

    UserAccountDTO queryByUserId(String userId);

    List<UserAccountDTO> queryAll();

    boolean modifyBalance(String userId, long balance, String operator);

    /**
     * 查询用户累计总额
     *
     * @param userId
     * @return
     */
    UserAccountTotal queryAccountTotal(String userId);

    long querySum(String userId, List<String> bizCodes, String optType);
}
