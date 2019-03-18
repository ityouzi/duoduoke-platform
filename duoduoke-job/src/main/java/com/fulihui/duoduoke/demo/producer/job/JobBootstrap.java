
package com.fulihui.duoduoke.demo.producer.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wahaha
 */

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.fulihui.duoduoke"})
public class JobBootstrap {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(JobBootstrap.class);
    }


}
