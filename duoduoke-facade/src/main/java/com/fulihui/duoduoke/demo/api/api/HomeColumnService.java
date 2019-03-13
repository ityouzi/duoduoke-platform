package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.HomeColumnRequest;
import com.fulihui.duoduoke.demo.api.dto.HomeColumnDTO;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:30
 */
public interface HomeColumnService {


    /**
     * @param request
     * @return
     */
    TMultiResult<HomeColumnDTO> queryPage(HomeColumnRequest request);


    /**
     * 修改数据
     *
     * @param
     * @return
     */
    TSingleResult<Boolean> update(HomeColumnDTO homeColumnDTO);


    TSingleResult<HomeColumnDTO> querySingle(HomeColumnRequest request);
}
