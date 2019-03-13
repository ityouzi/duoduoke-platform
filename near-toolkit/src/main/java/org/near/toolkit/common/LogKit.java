package org.near.toolkit.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用 {@link AbstractLogKit} 替换
 * @author leeson 2016年3月17日 下午3:22:02
 */
@Deprecated
public class LogKit {
    private static final Logger log = LoggerFactory.getLogger(LogKit.class);

    public static Logger log() {
        return log;
    }
}