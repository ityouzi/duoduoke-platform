package com.fulihui.redisdubbo.demo.integration.impl;


import com.fulihui.redisdubbo.demo.api.api.WechatAuthService;
import com.fulihui.redisdubbo.demo.api.dto.WechatAuthDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import com.fulihui.redisdubbo.demo.integration.WechatAuthServiceClient;
import org.apache.dubbo.config.annotation.Reference;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.stereotype.Component;

@Component
public class WechatAuthServiceClientImpl implements WechatAuthServiceClient {
    @Reference
    WechatAuthService wechatAuthService;

    @Override
    public TSingleResult<WechatAuthDTO> queryByOpenId(String openId, UserTypeEnum userType) {
        return wechatAuthService.queryByOpenId(openId, userType);
    }

    @Override
    public TSingleResult<WechatAuthDTO> queryByUserId(String userId, UserTypeEnum userType) {
        return wechatAuthService.queryByUserId(userId, userType);
    }
}
