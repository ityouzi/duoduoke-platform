/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 */
package com.fulihui.redisdubbo.demo.producer.biz.processor.sign;

import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公共业务抽象处理器
 *
 * @author lizhi
 */
public abstract class AbstractDuoDuoOrderStatusProcessor implements DuoDuoOrderStatusProcessor {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractDuoDuoOrderStatusProcessor.class);

    protected boolean check(String orderSn, String userId) {

        return StringUtil.isNotBlank(orderSn) && StringUtil.isNotBlank(userId);
    }
}
