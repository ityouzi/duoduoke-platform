package com.fulihui.duoduoke.demo.producer.repository;

/**
 * @author lizhi
 * @date 2018-7-11
 */
public interface AppConfigRepository {
    /**
     * 查询配置信息
     *
     * @return
     */
    String queryConfig(Integer code);
}
