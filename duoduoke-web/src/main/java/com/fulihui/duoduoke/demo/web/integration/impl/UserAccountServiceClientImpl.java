package com.fulihui.duoduoke.demo.web.integration.impl;

import com.fulihui.duoduoke.demo.api.api.UserAccountService;
import com.fulihui.duoduoke.demo.api.dto.UserAccountDetailDTO;
import com.fulihui.duoduoke.demo.api.request.UserAccountQueryRequest;
import com.fulihui.duoduoke.demo.web.integration.UserAccountServiceClient;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizhi
 * @date 2018-9-13
 */
@Component
public class UserAccountServiceClientImpl implements UserAccountServiceClient {
    @org.apache.dubbo.config.annotation.Reference
    UserAccountService userAccountService;
    @Override
    public TPageResult<UserAccountDetailDTO> queryRecordPage(UserAccountQueryRequest request) {
        TPageResult<UserAccountDetailDTO> result = userAccountService.queryRecordPage(request);
        ServiceResultUtil.checkResult(result);
        return result;
    }
}
