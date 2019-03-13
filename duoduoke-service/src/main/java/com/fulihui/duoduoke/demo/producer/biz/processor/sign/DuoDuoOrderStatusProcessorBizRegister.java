package com.fulihui.duoduoke.demo.producer.biz.processor.sign;

import com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum;
import com.google.common.collect.Maps;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;

/**
 * @author lizhi
 * @date 2018-10-17
 */
@Component
public class DuoDuoOrderStatusProcessorBizRegister extends ApplicationObjectSupport {

    private Map<DuoDuoOrderStatusEnum, DuoDuoOrderStatusProcessor> map = Maps.newConcurrentMap();

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        Map<String, DuoDuoOrderStatusProcessor> handles = getApplicationContext()
                .getBeansOfType(DuoDuoOrderStatusProcessor.class);
        for (DuoDuoOrderStatusProcessor handle : handles.values()) {
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
    public DuoDuoOrderStatusProcessor get(DuoDuoOrderStatusEnum type) {
        return map.get(type);
    }

}
