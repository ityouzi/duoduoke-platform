package com.fulihui.duoduoke.demo.web.integration.impl;


import com.fulihui.duoduoke.demo.api.api.WechatAuthService;
import com.fulihui.duoduoke.demo.api.dto.WechatAuthDTO;
import com.fulihui.duoduoke.demo.api.enums.UserTypeEnum;
import com.fulihui.duoduoke.demo.web.integration.WechatAuthServiceClient;
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
