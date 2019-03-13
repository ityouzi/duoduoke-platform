package com.fulihui.redisdubbo.demo.weixin.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizhi
 * @date 2018-12-17
 */

@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "external")
public class ExternalApiGoodsConfig {
    /**
     *外部商品生产推广链接接口地址
     */
    private String externalGoodsUrl;
    /**
     *调取拼多多接口数据
     */
    private String externalApi;
    /**
     * 外部token
     */
    private String externalToken;
    /**
     * 外部刷新token
     */
    private String refreshToken;
    /**
     * 外部刷新token接口
     */
    private String externalRefreshApi;
}
