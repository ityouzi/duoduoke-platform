package com.fulihui.duoduoke.demo.web.integration;


import com.fulihui.duoduoke.demo.api.dto.WechatAuthDTO;
import com.fulihui.duoduoke.demo.api.enums.UserTypeEnum;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 * @date 2018-7-14
 */
public interface WechatAuthServiceClient {

    TSingleResult<WechatAuthDTO> queryByOpenId(String openId, UserTypeEnum userType);

    TSingleResult<WechatAuthDTO> queryByUserId(String userId, UserTypeEnum userType);

}
