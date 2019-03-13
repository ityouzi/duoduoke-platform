package com.fulihui.duoduoke.demo.producer.model;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: JY
 * @date: 2018/8/16 15:21
 */
@Setter
@Getter
public class WxTemplateSendModel extends ToString {

    private String touser;

    private String templateId;

    private String page;

    private String formId;

    /**
     * 加粗的字段 列如：keyword1.DATA
     */
    private String emphasisKeyword;

    /**
     * page简介参数
     */
    private Map<String, Object> params;

    private Map<String, Value> data;

    /**
     * 添加data节点
     *
     * @param key
     * @param val
     */
    public void addDataItem(String key, String val) {

        Value valueModel = this.new Value();
        valueModel.setValue(val);
        if (data == null) {
            data = new LinkedHashMap<>();
        }
        data.put(key, valueModel);
    }

    class Value {
        @Getter
        @Setter
        private String value;
    }

}
