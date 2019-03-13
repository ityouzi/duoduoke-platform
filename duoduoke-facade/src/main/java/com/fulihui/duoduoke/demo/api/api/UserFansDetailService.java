package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.OrderFansDetailRequest;
import com.fulihui.duoduoke.demo.api.request.UserFansDetailRequest;
import com.fulihui.duoduoke.demo.api.dto.UserFansDetailDTO;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 * @date 2018-8-1
 */
public interface UserFansDetailService {


    TMultiResult<UserFansDetailDTO> query(UserFansDetailRequest request);


    TSingleResult<UserFansDetailDTO> querySumByUserId(UserFansDetailRequest request);


    TSingleResult<Long> querySumAmount(OrderFansDetailRequest request);

    TSingleResult<Long> queryOrderNumCount(OrderFansDetailRequest request);

}
