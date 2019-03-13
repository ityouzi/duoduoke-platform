package com.fulihui.redisdubbo.demo.security;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: JY
 * @date: 2018/10/19 9:46
 */
@Component
public class ApplicationUtil implements ApplicationContextAware {

    /**
     * 保存ApplicationContext;
     */
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationUtil.applicationContext = applicationContext;
    }


}
