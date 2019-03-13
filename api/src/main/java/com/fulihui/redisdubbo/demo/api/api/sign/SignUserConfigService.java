package com.fulihui.redisdubbo.demo.api.api.sign;


import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserConfigDTO;
import org.near.servicesupport.result.TSingleResult;

/**
 * The interface Sign user config service.
 *
 * @author lizhi
 * @date 2018 -10-11
 */
public interface SignUserConfigService {
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
      * @return the t single result
     */
    TSingleResult<SignUserConfigDTO> updateUserConfig(String userId, String state);

}
