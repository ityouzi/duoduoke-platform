
package com.fulihui.redisdubbo.demo;

import com.fulihui.redisdubbo.demo.api.DemoApi;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class ConsumerBootstrap {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Reference(version = "${demo.service.version}")
    DemoApi demoApi;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstrap.class);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            String mercyblitz = demoApi.say("mercyblitz");
            logger.info(mercyblitz);
        };
    }

}
