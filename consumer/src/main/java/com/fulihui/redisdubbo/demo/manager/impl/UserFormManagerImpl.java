package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.UserFormService;
import com.fulihui.redisdubbo.demo.api.request.UserFormInsertRequest;
import com.fulihui.redisdubbo.demo.manager.UserFormManager;
import com.fulihui.redisdubbo.demo.weixin.common.config.DuoDuoKeConfig;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Component
public class UserFormManagerImpl implements UserFormManager {
    @org.apache.dubbo.config.annotation.Reference(version = "1.0.0")
    UserFormService userFormService;

    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @Override
    public void add(String openId, String userId, String fromId) {

        UserFormInsertRequest request = new UserFormInsertRequest();
        request.setOpenId(openId);
        request.setAppId(duoDuoKeConfig.getMiniAppid());
        request.setUserId(userId);
        request.setFormId(fromId);
        TSingleResult<Integer> result = userFormService.insert(request);
        try {
            checkResult(result);
        } catch (Exception ignored) {

        }
    }
}
