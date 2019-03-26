package com.fulihui.duoduoke.demo.web.integration;


import com.fulihui.duoduoke.demo.api.dto.sign.SignUserConfigDTO;
import org.near.servicesupport.result.TSingleResult;

/**
 * The interface SIGN user config service.
 *
 * @author lizhi
 * @date 2018 -10-11
 */
public interface SignUserConfigServiceClient {
    /**
     * Take user config t single result.
     *
     * @param userId the user id
     * @return the t single result
     */
    TSingleResult<SignUserConfigDTO> takeUserConfig(String userId);

    /**
     * Update user config t single result.
     *
     * @param userId the user id
     * @param state  the state
     * @see com.fulihui.duoduoke.demo.producer.facade.enums.SwitchEnum
     * @return the t single result
     */
    TSingleResult<SignUserConfigDTO> updateUserConfig(String userId, String state);

}
