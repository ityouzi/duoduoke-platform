package com.fulihui.duoduoke.demo.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = {"com.fulihui.duoduoke.demo.producer.dal.dao"})
@ComponentScan("com.fulihui.duoduoke.demo")
@EnableAutoConfiguration
public class ProducerBootstrap {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    public static void main(String[] args) {

        new SpringApplicationBuilder(ProducerBootstrap.class).run(args);

    }


}
