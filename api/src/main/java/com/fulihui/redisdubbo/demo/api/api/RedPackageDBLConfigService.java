package com.fulihui.redisdubbo.demo.api.api;

import com.fulihui.redisdubbo.demo.api.dto.RedPackageDBLConfigDTO;
import com.fulihui.redisdubbo.demo.api.request.RedPackageDBLConfigRequest;
import org.near.servicesupport.result.TSingleResult;

/**
 * create by zpf  2018-9-4
 */
public interface RedPackageDBLConfigService {
    /**
     * 查询翻倍红包配置
     */
    TSingleResult<RedPackageDBLConfigDTO> getRedPackageDBLConfig();

    Boolean saveRedPackageDBLConfig(RedPackageDBLConfigRequest redPackageDBLConfigRequest);

}
