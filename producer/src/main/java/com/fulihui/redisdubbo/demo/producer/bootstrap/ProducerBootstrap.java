
package com.fulihui.redisdubbo.demo.producer.bootstrap;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.List;
import java.util.stream.Collectors;

@EnableAutoConfiguration
public class ProducerBootstrap {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    public static void main(String[] args) {

        new SpringApplicationBuilder(ProducerBootstrap.class).run(args);

        List<Object> transform = Lists.newArrayList().stream().map(input -> null).collect(Collectors.toList());
    }


}
