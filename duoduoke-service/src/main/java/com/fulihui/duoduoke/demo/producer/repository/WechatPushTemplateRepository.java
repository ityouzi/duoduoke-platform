package com.fulihui.duoduoke.demo.producer.repository;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatPushTemplateContent;

/**
 * Created by lizhi on 2018-7-11.
 */
public interface WechatPushTemplateRepository {

    WechatPushTemplateContent selectByType(String type);
}
