package com.fulihui.redisdubbo.demo.integration;


import com.fulihui.redisdubbo.demo.api.dto.WechatAuthDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 * @date 2018-7-14
 */
public interface WechatAuthServiceClient {

    TSingleResult<WechatAuthDTO> queryByOpenId(String openId, UserTypeEnum userType);

    TSingleResult<WechatAuthDTO> queryByUserId(String userId, UserTypeEnum userType);

}
