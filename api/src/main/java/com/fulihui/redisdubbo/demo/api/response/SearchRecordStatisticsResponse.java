package com.fulihui.redisdubbo.demo.api.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: JY
 * @date: 2018/7/30 11:17
 */
@Setter @Getter
public class SearchRecordStatisticsResponse {

    /**
     * 搜索内容
     */
    private String searchContent;

    /**
     * 是否有结果 Y/N
     */
    private String isResult;

    /**
     * 搜索次数
     */
    private Integer searchCount;

    /**
     * 用户搜索次数
     */
    private Integer userSearchCount;

}
