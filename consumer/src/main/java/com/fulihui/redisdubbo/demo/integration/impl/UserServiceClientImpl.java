package com.fulihui.redisdubbo.demo.integration.impl;


import com.fulihui.redisdubbo.demo.api.api.UserService;
import com.fulihui.redisdubbo.demo.api.dto.UserDTO;
import com.fulihui.redisdubbo.demo.api.request.UserQueryRequest;
import com.fulihui.redisdubbo.demo.api.request.UserUpdateRequest;
import com.fulihui.redisdubbo.demo.api.request.UserWechatLoginRequest;
import com.fulihui.redisdubbo.demo.integration.UserServiceClient;
import org.apache.dubbo.config.annotation.Reference;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 * @author lizhi
 * @date 2018-9-7
 */
@Component
public class UserServiceClientImpl implements UserServiceClient {
    @Reference
    UserService userService;

    @Override
    public BaseResult update(UserUpdateRequest request) {
        BaseResult result = userService.update(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TPageResult<UserDTO> queryPage(UserQueryRequest request) {
        TPageResult<UserDTO> result = userService.queryPage(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<UserDTO> queryByUserId(String userId) {
        TSingleResult<UserDTO> result = userService.queryByUserId(userId);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    @Override
    public TSingleResult<UserDTO> wechatLogin(UserWechatLoginRequest request) {
        TSingleResult<UserDTO> result = userService.wechatLogin(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }
}
