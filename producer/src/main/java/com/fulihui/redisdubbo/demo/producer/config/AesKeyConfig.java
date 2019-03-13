package com.fulihui.redisdubbo.demo.producer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author lizhi
 * @date 2018-7-5
 */
@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "aes")
public class AesKeyConfig implements Serializable {

    private static final long serialVersionUID = 3180772229513818514L;


    /**
     * aesKey
     */
    private String aesKey;


}
