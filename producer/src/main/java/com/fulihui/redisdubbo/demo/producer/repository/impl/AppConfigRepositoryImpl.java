package com.fulihui.redisdubbo.demo.producer.repository.impl;


import com.fulihui.redisdubbo.demo.producer.dal.dao.AppConfigMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.AppConfig;
import com.fulihui.redisdubbo.demo.producer.repository.AppConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Repository
public class AppConfigRepositoryImpl implements AppConfigRepository {


    @Autowired
    private AppConfigMapper appConfigMapper;

    @Override
    public String queryConfig(Integer code) {
        AppConfig appConfig = appConfigMapper.selectByPrimaryKey(code);
        if (appConfig == null) {
            return null;
        }
        return appConfig.getConfigVal();
    }
}
