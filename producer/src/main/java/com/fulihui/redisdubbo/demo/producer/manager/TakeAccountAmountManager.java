package com.fulihui.redisdubbo.demo.producer.manager;


import com.fulihui.redisdubbo.demo.api.dto.UserAccountDTO;
import com.fulihui.redisdubbo.demo.api.request.UserAccountCreateRequest;
import com.fulihui.redisdubbo.demo.api.request.UserAccountOperatorRequest;

/**
 * 关联用户账户余额管理
 *
 * @author lizhi
 * @date 2018 -7-12
 */
public interface TakeAccountAmountManager {

    /**
     * Add balance user account dto.
     *
     * @param request the request
     * @return the user account dto
     */
    UserAccountDTO addBalance(UserAccountOperatorRequest request);

    /**
     * Minus balance user account dto.
     *
     * @param request the request
     * @return the user account dto
     */
    UserAccountDTO minusBalance(UserAccountOperatorRequest request);

    /**
     * Create.创建用户账户信息
     *
     * @param request the request
     */
    void create(UserAccountCreateRequest request);

}
