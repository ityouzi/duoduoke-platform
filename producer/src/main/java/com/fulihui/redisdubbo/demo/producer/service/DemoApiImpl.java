package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.DemoApi;
import org.apache.dubbo.config.annotation.Service;


@Service(version = "${demo.service.version}")
public class DemoApiImpl implements DemoApi {
    public String say(String name) {
        return name;
    }
}
