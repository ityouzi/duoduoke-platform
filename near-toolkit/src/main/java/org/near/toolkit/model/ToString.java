/*
 * Copyright 2014 www.wecheer-tech.com
 */
package org.near.toolkit.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 模型对象帮助类。实现toString重载
 *
 * Created by Willard on 2015/7/25.
 */
public class ToString implements java.io.Serializable {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
