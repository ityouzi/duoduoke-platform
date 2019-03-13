/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.util;


import com.fulihui.redisdubbo.demo.api.api.WechatAuthService;
import com.fulihui.redisdubbo.demo.api.dto.WechatAuthDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import com.fulihui.redisdubbo.demo.security.TokenHelper;
import com.fulihui.redisdubbo.demo.security.common.AuthUserModel;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;

/**
 * 主体信息获取帮助类
 *
 * @author Administrator
 */
@Component
public class PrincipalUtil {
    /**
     * The Token helper.
     */
    @Autowired
    TokenHelper tokenHelper;

    /**
     * The Wechat auth service.
     */
    @org.apache.dubbo.config.annotation.Reference
    WechatAuthService wechatAuthService;

    /**
     * 根据header请提头 token参数信息查询用户主体信息
     * openId
     * userId
     *
     * @param request the request
     * @return the principal
     */
    public Principal getPrincipal(HttpServletRequest request) {
        Principal principal = new Principal();
        String authToken = tokenHelper.getToken(request);
        //账号就是userId
        String accountNo = tokenHelper.getAccountNoFromToken(authToken);
        TSingleResult<WechatAuthDTO> result = wechatAuthService.queryByUserId(accountNo, UserTypeEnum.MINI_USER);
        checkResult(result);
        WechatAuthDTO value = result.getValue();
        if (value != null) {
            principal.setOpenId(value.getOpenId());
            principal.setUserId(value.getUserId());
        }
        return principal;
    }

    /**
     * 根据上下文环境获取当前主体信息
     *
     * @return the Principal
     */
    public static Principal getPrincipal() {
        Principal principal = new Principal();
        //上下文
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthUserModel userModel = (AuthUserModel) authentication.getPrincipal();
        principal.setUserId(userModel.getUserId());
        principal.setOpenId(userModel.getOpenId());
        return principal;
    }
}