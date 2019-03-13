package com.fulihui.redisdubbo.demo.integration.impl;


import com.fulihui.redisdubbo.demo.api.api.sign.SignUserConfigService;
import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserConfigDTO;
import com.fulihui.redisdubbo.demo.integration.SignUserConfigServiceClient;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 * The interface Sign user config service.
 *
 * @author lizhi
 * @date 2018 -10-11
 */
@Component
public class SignUserConfigServiceClientImpl implements SignUserConfigServiceClient {

    @org.apache.dubbo.config.annotation.Reference
    SignUserConfigService signUserConfigService;

    /**
     * Take user config t single result.
     *
     * @param userId the user id
     * @return the t single result
     */
    @Override
    public TSingleResult<SignUserConfigDTO> takeUserConfig(String userId) {
        TSingleResult<SignUserConfigDTO> result = signUserConfigService.takeUserConfig(userId);
        ServiceResultUtil.checkResult(result);
        return result;
    }

    /**
     * Update user config t single result.
     *
     * @param userId the user id
     * @param state  the state
     * @see com.fulihui.duoduoke.facade.enums.SwitchEnum
     * @return the t single result
     */
    @Override
    public TSingleResult<SignUserConfigDTO> updateUserConfig(String userId, String state) {
        TSingleResult<SignUserConfigDTO> result = signUserConfigService.updateUserConfig(userId,
            state);
        ServiceResultUtil.checkResult(result);
        return result;
    }

}
