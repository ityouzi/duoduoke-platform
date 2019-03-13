package com.fulihui.redisdubbo.demo.integration;


import com.fulihui.redisdubbo.demo.api.dto.UserDTO;
import com.fulihui.redisdubbo.demo.api.request.UserQueryRequest;
import com.fulihui.redisdubbo.demo.api.request.UserUpdateRequest;
import com.fulihui.redisdubbo.demo.api.request.UserWechatLoginRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * Created by lizhi on 2018-9-7.
 */

public interface UserServiceClient {

    BaseResult update(UserUpdateRequest request);

    TPageResult<UserDTO> queryPage(UserQueryRequest request);

    TSingleResult<UserDTO> queryByUserId(String userId);
    TSingleResult<UserDTO> wechatLogin(UserWechatLoginRequest request);
}
