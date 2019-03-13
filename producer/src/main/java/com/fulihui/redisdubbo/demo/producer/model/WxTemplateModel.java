package com.fulihui.redisdubbo.demo.producer.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author: JY
 * @date: 2018/8/13 13:37
 */
@Setter
@Getter
public class WxTemplateModel extends ToString {

    @JSONField(name = "template_id")
    private String templateId;

    private String title;

    private String content;

    private String example;

}
