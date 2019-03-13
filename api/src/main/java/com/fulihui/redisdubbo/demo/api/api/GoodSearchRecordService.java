package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.request.SearchRecordRequest;
import com.fulihui.redisdubbo.demo.api.response.SearchRecordStatisticsResponse;
import org.near.servicesupport.result.TMultiResult;

/**
 * @author: JY
 * @date: 2018/7/30 11:28
 */
public interface GoodSearchRecordService {

    /**
     *  搜索记录统计查询
     */
    TMultiResult<SearchRecordStatisticsResponse> listStatistics(SearchRecordRequest recordRequest);

}
