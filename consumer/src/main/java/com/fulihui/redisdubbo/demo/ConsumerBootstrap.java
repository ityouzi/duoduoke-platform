
package com.fulihui.redisdubbo.demo;

import com.fulihui.redisdubbo.demo.api.DemoApi;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wahaha
 */
@EnableAutoConfiguration
@ComponentScan("com.fulihui.redisdubbo.demo")
public class ConsumerBootstrap {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Reference(version = "${demo.service.version}")
    DemoApi demoApi;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstrap.class);
    }


}
