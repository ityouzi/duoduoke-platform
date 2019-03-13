package com.fulihui.duoduoke.demo.api.api;

import com.fulihui.duoduoke.demo.api.enums.UserTypeEnum;
import com.fulihui.duoduoke.demo.api.dto.WechatAuthDTO;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 * @date 2018-7-14
 */
public interface WechatAuthService {

    TSingleResult<WechatAuthDTO> queryByOpenId(String openId, UserTypeEnum userType);

    TSingleResult<WechatAuthDTO> queryByUserId(String userId, UserTypeEnum userType);

}
