/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.UserAccountCreateRequest;
import com.fulihui.duoduoke.demo.api.request.UserAccountOperatorRequest;
import com.fulihui.duoduoke.demo.api.request.UserAccountQueryRequest;
import com.fulihui.duoduoke.demo.api.dto.UserAccountDTO;
import com.fulihui.duoduoke.demo.api.dto.UserAccountDetailDTO;
import com.fulihui.duoduoke.demo.api.dto.UserAccountTotalDTO;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 */
public interface UserAccountService {

    /**
     * 创建账户
     *
     * @param request {@link UserAccountCreateRequest}
     */
    void create(UserAccountCreateRequest request);

    /**
     * 增加余额
     *
     * @param request {@link UserAccountOperatorRequest}
     * @return {@link UserAccountDTO} 余额修改后的账户信息
     */
    UserAccountDTO addBalance(UserAccountOperatorRequest request);

    /**
     * 减少余额
     *
     * @param request {@link UserAccountOperatorRequest}
     * @return {@link UserAccountDTO} 余额修改后的账户信息
     */
    UserAccountDTO minusBalance(UserAccountOperatorRequest request);

    /**
     * 用户账户信息
     *
     * @param userId 用户唯一标识
     * @return {@link UserAccountDTO}
     */
    UserAccountDTO userAccount(String userId);

    /**
     * 分页查询交易记录
     *
     * @param request {@link UserAccountQueryRequest}
     * @return {@link TPageResult} 包装的 {@link UserAccountDetailDTO} 列表
     */
    TPageResult<UserAccountDetailDTO> queryRecordPage(UserAccountQueryRequest request);

    /**
     * 查询用户总额
     *
     * @param userId
     * @return
     */
    UserAccountTotalDTO queryUserTotal(String userId);

    TSingleResult<Long> querySumAmount(UserAccountQueryRequest request);

}
