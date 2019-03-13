package com.fulihui.duoduoke.demo.producer.dal.dataobj;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: JY
 * @date: 2018/7/30 13:53
 */
@Setter
@Getter
public class GoodSearchRecordStatistics {

    /**
     * 搜索内容
     */
    private String searchContent;

    /**
     * 搜索结果 Y/N
     */
    private String isResult;

    /**
     * 用户搜索次数
     */
    private Integer userSearchCount;

    /**
     * 搜索次数
     */
    private Integer searchCount;

}
