package com.fulihui.redisdubbo.demo.producer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lizhi
 * @date 2018-11-14
 */
@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "app")
public class AppServiceConfig {

    private String freePid;
}
