package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatPushTemplateContent;

/**
 * Created by lizhi on 2018-7-11.
 */
public interface WechatPushTemplateRepository {

    WechatPushTemplateContent selectByType(String type);
}
