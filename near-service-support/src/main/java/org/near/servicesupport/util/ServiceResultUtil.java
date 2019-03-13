package org.near.servicesupport.util;

import org.near.servicesupport.error.InvokeServiceException;
import org.near.servicesupport.result.BaseResult;

/**
 * 服务返回对象校验工具
 * Created by Willard.Hu on 2016/3/2.
 */
public class ServiceResultUtil {

    public static void checkResult(BaseResult result) {
        if (result.getErrcode() != BaseResult.SUCCESS) {
            throw new InvokeServiceException(result.getErrcode(), result.getErrmsg());
        }
    }

    public static boolean isSuccess(BaseResult result) {
        return result.getErrcode() == BaseResult.SUCCESS;
    }

}
