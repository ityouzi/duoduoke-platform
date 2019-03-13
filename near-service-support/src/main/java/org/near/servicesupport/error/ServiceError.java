package org.near.servicesupport.error;

/**
 * 服务异常接口规范，服务端异常枚举继承该类
 * Created by Willard on 2016/3/3.
 */
public interface ServiceError {

    int getErrcode();

    String getErrmsg();

}
