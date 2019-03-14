package com.fulihui.duoduoke.demo.web.security;


import com.fulihui.duoduoke.demo.api.dto.UserDTO;
import com.fulihui.duoduoke.demo.api.dto.WechatAuthDTO;
import com.fulihui.duoduoke.demo.api.enums.UserTypeEnum;
import com.fulihui.duoduoke.demo.web.integration.UserServiceClient;
import com.fulihui.duoduoke.demo.web.integration.WechatAuthServiceClient;
import com.fulihui.duoduoke.demo.web.security.common.AuthUserModel;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;

/**
 * @author lizhi
 */
@Service
@Order(1)
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserServiceClient userServiceClient;
    @Autowired
    WechatAuthServiceClient wechatAuthServiceClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        //查询主体信息
        UserDTO user = userServiceClient.queryByUserId(username).getValue();
        if (user == null) {
            throw new UsernameNotFoundException(
                    String.format("No user found with username '%s'.", username));
        }
        AuthUserModel model = new AuthUserModel();
        //密码也是userId
        model.setPassword(user.getUserId());
        model.setUserId(user.getUserId());
        try {
            //查询授权信息
            TSingleResult<WechatAuthDTO> result = wechatAuthServiceClient.queryByUserId(user.getUserId(),
                    UserTypeEnum.MINI_USER);
            checkResult(result);
            if (result.getValue() != null) {
                model.setOpenId(result.getValue().getOpenId());
            }
        } catch (Exception ignored) {

        }
        return model;

    }

}
