package com.fulihui.duoduoke.demo.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.near.toolkit.model.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: JY
 * @date: 2018/8/13 13:35
 */
@Setter @Getter
public class WxTemplateDTO extends ToString {

    private String  templateId;

    private String title;

    private String content;

    private String example;

    /**
     * 解析content
     * @return
     */
    public Map<String,String> getKeywords(){

        if(StringUtils.isEmpty(example)){
            return null;
        }

        String[] nameValues = example.split("\n");

        Map<String,String> map = new LinkedHashMap<>();

        for (String item : nameValues) {
            int index = item.indexOf("：");
            if(index!=-1) {
                map.put(item.substring(0, index), item.substring(index+1));
            }
        }
        return map;
    }

}
