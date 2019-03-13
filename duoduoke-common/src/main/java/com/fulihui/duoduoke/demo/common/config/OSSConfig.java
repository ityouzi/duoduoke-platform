package com.fulihui.duoduoke.demo.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/30 0030 19:32
 */
@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "oss")
public class OSSConfig implements Serializable {


    private String accessKeyId;


    private String accessKeySecret;


    private String endpoint;

    private String bucketName;

    private String floder;

    private String key;


}
