package com.fulihui.duoduoke.demo.web.factory;


import com.fulihui.duoduoke.demo.api.api.WechatTokenService;
import com.fulihui.duoduoke.demo.api.dto.WechatConfigDTO;
import com.fulihui.duoduoke.demo.api.request.WechatConfigRequest;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;


/**
 * 微信配置工厂
 *
 * @author lizhi
 */
@Component
public class WeChatConfigFactory {
    private static final String DUODUO_CODE = "DUODUO_CODE";

    private final transient Logger LOG = LoggerFactory.getLogger(WeChatConfigFactory.class);

    private WechatConfigDTO wechatConfig;

    @org.apache.dubbo.config.annotation.Reference
    WechatTokenService wechatTokenService;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    Environment environment;

    @PostConstruct
    void init() {
        threadPoolTaskExecutor.execute(() -> {
            try {
                String profile = environment.getProperty("spring.profiles.active");
                WechatConfigRequest request = new WechatConfigRequest();
                request.setEnvType(profile);
                request.setConfigCode(DUODUO_CODE);
                TMultiResult<WechatConfigDTO> result = wechatTokenService.query(request);
                ServiceResultUtil.checkResult(result);
                if (!CollectionUtils.isEmpty(result.getValues())) {
                    wechatConfig = result.getValues().get(0);
                    LOG.info("微信配置信息wechatConfig:{}", wechatConfig);
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        });
    }

    public WechatConfigDTO get() {
        return wechatConfig;
    }

}
