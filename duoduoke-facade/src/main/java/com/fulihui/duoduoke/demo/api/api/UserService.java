/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.enums.TemplateSendTaskBehaviorsEnum;
import com.fulihui.duoduoke.demo.api.enums.UserTypeEnum;
import com.fulihui.duoduoke.demo.api.request.UserDetailAdminRequest;
import com.fulihui.duoduoke.demo.api.request.UserQueryRequest;
import com.fulihui.duoduoke.demo.api.request.UserUpdateRequest;
import com.fulihui.duoduoke.demo.api.request.UserWechatLoginRequest;
import com.fulihui.duoduoke.demo.api.dto.UserDTO;
import com.fulihui.duoduoke.demo.api.dto.UserDetailAdminDTO;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * The interface User service.
 *
 * @author lizhi
 */
public interface UserService {

    /**
     * 微信登录，已存在信息则直接返回用户信息，否则执行注册后返回用户信息
     *
     * @param request {@link UserWechatLoginRequest}
     * @return {@link UserDTO}
     */
    TSingleResult<UserDTO> wechatLogin(UserWechatLoginRequest request);

    /**
     * 用户唯一标识查询用户
     *
     * @param userId 用户唯一标识
     * @return {@link UserDTO}
     */
    TSingleResult<UserDTO> queryByUserId(String userId);

    /**
     * Update base result.
     *
     * @param request the request
     * @return the base result
     */
    BaseResult update(UserUpdateRequest request);

    /**
     * 分页查询
     *
     * @param request 分页查询
     * @return {@link UserDTO}
     */
    TPageResult<UserDTO> queryPage(UserQueryRequest request);

    /**
     * Query t multi result.
     *
     * @param request the request
     * @return the t multi result
     */
    TMultiResult<UserDTO> query(UserQueryRequest request);

    /**
     * 管理页面查询
     *
     * @param adminRequest the admin request
     * @return t page result
     */
    TPageResult<UserDetailAdminDTO> queryAdminList(UserDetailAdminRequest adminRequest);

    /**
     * 记录用户行为
     *
     * @param userDTO       the user dto
     * @param behaviorsEnum the behaviors enum
     * @param userType      the user type
     */
    void recordUserBehaviors(UserDTO userDTO, TemplateSendTaskBehaviorsEnum behaviorsEnum,
                             UserTypeEnum userType);
}
