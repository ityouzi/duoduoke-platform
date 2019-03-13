package com.fulihui.redisdubbo.demo.integration.impl;


import com.fulihui.redisdubbo.demo.api.api.RedPackageDBLConfigService;
import com.fulihui.redisdubbo.demo.api.dto.RedPackageDBLConfigDTO;
import com.fulihui.redisdubbo.demo.integration.RedPackageDBLConfigServiceClient;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizhi
 * @date 2018-9-13
 */
@Component
public class RedPackageDBLConfigServiceClientImpl implements RedPackageDBLConfigServiceClient {
    @org.apache.dubbo.config.annotation.Reference
    RedPackageDBLConfigService redPackageDBLConfigService;
    @Override
    public TSingleResult<RedPackageDBLConfigDTO> getRedPackageDBLConfig() {
        TSingleResult<RedPackageDBLConfigDTO> result = redPackageDBLConfigService.getRedPackageDBLConfig();
        ServiceResultUtil.checkResult(result);
        return result;
    }

}
