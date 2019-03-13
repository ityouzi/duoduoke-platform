package com.fulihui.duoduoke.demo.web;


import com.fulihui.duoduoke.demo.web.manager.UserFormManager;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lizhi
 * @date 2018-7-13
 */
@Aspect
@Component
public class RequestMapAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(RequestMapAspect.class);

    @Pointcut(value = "execution(* com.fulihui.duoduoke.demo.controller..*(..))")
    public void controllerLog() {
    }

    @Autowired
    UserFormManager userFormManager;

    @Before("controllerLog()")
    public void before(JoinPoint point) {
        LOGGER.info("controller aspect begging");
        Object[] args = point.getArgs();
        for (Object arg : args) {
            LOGGER.debug("arg: {}",
                    ToStringBuilder.reflectionToString(arg, ToStringStyle.SHORT_PREFIX_STYLE));
        }
        String method = point.getSignature().getDeclaringTypeName() + '.'
                + point.getSignature().getName();
        LOGGER.info("aspect finishing");
        LOGGER.info("calling " + method);
    }

}
