package org.near.servicesupport.util;

import java.util.List;

import org.near.servicesupport.error.InvokeServiceException;
import org.near.servicesupport.error.ServiceError;
import org.near.toolkit.common.StringUtil;

/**
 * 服务断言工具
 * Created by Willard.Hu on 2016/3/5.
 */
public class ServiceAssert {

    public static void isTrue(boolean b, ServiceError error) {
        if (!b) {
            throw new InvokeServiceException(error.getErrcode(), error.getErrmsg());
        }
    }

    public static void notNull(Object o, ServiceError error) {
        if (o == null) {
            throw new InvokeServiceException(error.getErrcode(), error.getErrmsg());
        }
    }

    public static void notBlank(String s, ServiceError error) {
        if (StringUtil.isBlank(s)) {
            throw new InvokeServiceException(error.getErrcode(), error.getErrmsg());
        }
    }

    public static void notEmpty(List<?> list, ServiceError error) {
        if (list == null || list.isEmpty()) {
            throw new InvokeServiceException(error.getErrcode(), error.getErrmsg());
        }
    }

}
