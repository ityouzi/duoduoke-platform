package com.fulihui.redisdubbo.demo.integration;


import com.fulihui.redisdubbo.demo.api.dto.RedPackageDBLConfigDTO;
import org.near.servicesupport.result.TSingleResult;

/**
 * create by zpf  2018-9-4
 */
public interface RedPackageDBLConfigServiceClient {
    /**
     * 查询翻倍红包配置
     */
    TSingleResult<RedPackageDBLConfigDTO> getRedPackageDBLConfig();

}
