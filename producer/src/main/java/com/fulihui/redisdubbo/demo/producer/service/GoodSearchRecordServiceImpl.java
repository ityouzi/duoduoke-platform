package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.GoodSearchRecordService;
import com.fulihui.redisdubbo.demo.api.request.SearchRecordRequest;
import com.fulihui.redisdubbo.demo.api.response.SearchRecordStatisticsResponse;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtGoodSearchRecordMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GoodSearchRecordStatistics;
import com.fulihui.redisdubbo.demo.weixin.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author: JY
 * @date: 2018/7/30 11:27
 */
@Service(version = "${demo.service.version}")

public class GoodSearchRecordServiceImpl implements GoodSearchRecordService {

    @Autowired
    ExtGoodSearchRecordMapper extGoodSearchRecordMapper;

    /**
     * 搜索记录统计查询
     */
    @Override
    public TMultiResult<SearchRecordStatisticsResponse> listStatistics(SearchRecordRequest recordRequest) {

        Map<String, Object> queryParams = new HashMap<>();

        queryParams.put("startTime", recordRequest.getStartTime());
        queryParams.put("endTime", recordRequest.getEndTime());
        queryParams.put("offset", recordRequest.start4Mysql());
        queryParams.put("rows", recordRequest.getRows());

        List<GoodSearchRecordStatistics> goodSearchRecordStatistics = extGoodSearchRecordMapper
                .selectStatistics(queryParams);

        List<SearchRecordStatisticsResponse> responses = null;
        if (goodSearchRecordStatistics != null && goodSearchRecordStatistics.size() > 0) {
            responses = BeanConvUtil.copy(goodSearchRecordStatistics,
                    SearchRecordStatisticsResponse.class);
        }
        return ResultBuilder.succTMulti(responses);
    }

}
