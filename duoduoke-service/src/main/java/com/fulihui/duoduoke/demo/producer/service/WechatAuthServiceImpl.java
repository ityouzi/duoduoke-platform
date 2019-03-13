package com.fulihui.duoduoke.demo.producer.service;

import com.fulihui.duoduoke.demo.api.api.WechatAuthService;
import com.fulihui.duoduoke.demo.api.dto.WechatAuthDTO;
import com.fulihui.duoduoke.demo.api.enums.UserTypeEnum;
import com.fulihui.duoduoke.demo.producer.repository.WechatAuthRepository;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lizhi
 * @date 2018-7-14
 */
@Service(version = "${demo.service.version}")

public class WechatAuthServiceImpl implements WechatAuthService {
    @Autowired
    WechatAuthRepository wechatAuthRepository;

    @Override
    public TSingleResult<WechatAuthDTO> queryByOpenId(String openId, UserTypeEnum userType) {
        WechatAuthDTO wechatAuthDTO = wechatAuthRepository.queryByOpenId(openId, userType);
        return ResultBuilder.succTSingle(wechatAuthDTO);
    }

    @Override
    public TSingleResult<WechatAuthDTO> queryByUserId(String userId, UserTypeEnum userType) {
        WechatAuthDTO wechatAuthDTO = wechatAuthRepository.queryByUserId(userId, userType);
        return ResultBuilder.succTSingle(wechatAuthDTO);
    }
}
