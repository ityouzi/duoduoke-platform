package org.near.toolkit.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 废弃 使用 {@link Log} 替代
 * @author leeson 2016年3月17日 下午3:22:02
 *
 */
@Deprecated
public abstract class AbstractLogKit {
    public final transient Logger log = LoggerFactory.getLogger(getClass());
}