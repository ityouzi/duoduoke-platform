package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.UserShareRecordDTO;
import com.fulihui.redisdubbo.demo.api.request.UserShareRecordRequest;
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
