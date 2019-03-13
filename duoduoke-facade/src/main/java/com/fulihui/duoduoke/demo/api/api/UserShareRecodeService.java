package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.UserShareRecordRequest;
import com.fulihui.duoduoke.demo.api.dto.UserShareRecordDTO;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:30
 */
public interface UserShareRecodeService {


    /**
     * @param
     * @return
     */
    TSingleResult<UserShareRecordDTO> queryById(UserShareRecordRequest request);


}
