package com.fulihui.duoduoke.demo.producer.biz.processor;

import com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum;
import com.google.common.collect.Maps;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;

/**
 * 订单流程变更业务注册
 *
 * @author lizhi
 */
@Component
public class OrderStatusDispatcher extends ApplicationObjectSupport {

    private Map<UserOrderStatusEnum, UserOrderStatusProcessor> map = Maps.newConcurrentMap();

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        Map<String, UserOrderStatusProcessor> handles = getApplicationContext()
                .getBeansOfType(UserOrderStatusProcessor.class);
        for (UserOrderStatusProcessor handle : handles.values()) {
            map.put(handle.getType(), handle);
        }
    }

    /**
     * Clear.
     */
    @PreDestroy
    public void clear() {
        map.clear();
    }

    /**
     * @param type the type
     * @return the user order status handle
     */
    public UserOrderStatusProcessor get(UserOrderStatusEnum type) {
        return map.get(type);
    }

}
