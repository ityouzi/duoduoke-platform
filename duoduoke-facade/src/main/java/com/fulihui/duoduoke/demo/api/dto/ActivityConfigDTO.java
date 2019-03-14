package com.fulihui.duoduoke.demo.api.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.near.toolkit.model.ToString;

import java.util.Date;

/**
 * @author: JY
 * @date: 2018/10/15 12:33
 */
@Data
public class ActivityConfigDTO extends ToString {

    /**
     * 标识列
     */
    private Integer id;

    /**
     * 活动类型 [1:签到活动] [2:翻牌活动]
     */
    private Integer type;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

    /**
     * 活动状态 [1:有效][2:无效]
     */
    private Integer state;

    /**
     * 扩展字段
     */
    private String extend;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 获取扩展字段的泛型值
     *
     * @param <T>
     * @return
     */
    public <T> T getExtendObject(Class<T> classType) {
        if (classType == String.class) {
            return (T) extend;
        } else {
            return (T) JSONObject.parseObject(extend, classType);
        }
    }
}
