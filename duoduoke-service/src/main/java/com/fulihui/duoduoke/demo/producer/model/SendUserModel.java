package com.fulihui.duoduoke.demo.producer.model;

import lombok.Data;

import java.util.Map;

/**
 * @author: JY
 * @date: 2018/10/18 16:56
 */
@Data
public class SendUserModel {

    private String userId;

    private String formId;

    private String openId;

    /**
     * 需要替换模板内容中固定的参数
     */
    private Map<String, String> templateParams;

    /**
     * 发送Url连接参数
     */
    private Map<String, Object> linkParams;
}
