package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.UserRewardRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.UserRewardRecordRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/3 0003 16:58
 */
public interface UserRewardRecordService {


    BaseResult insert(UserRewardRecordRequest request);

    TPageResult<UserRewardRecordDTO> query(UserRewardRecordRequest request);

    TSingleResult<Double> sumPercent(UserRewardRecordRequest request);
}
