package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.AdvertDTO;
import com.fulihui.redisdubbo.demo.api.request.AdvertIdRequest;
import com.fulihui.redisdubbo.demo.api.request.AdvertRequest;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 14:30
 */
public interface AdvertService {



    /**
     * @param request
     * @return
     */
    TMultiResult<AdvertDTO> queryAdvert(AdvertRequest request);

    /**
     * 插入数据
     * @param advertDTO
     * @return
     */
    TSingleResult<Boolean> insert(AdvertDTO advertDTO);

    /**
     * 修改数据
     * @param advertDTO
     * @return
     */
    TSingleResult<Boolean> update(AdvertDTO advertDTO);

    /**
     * 删除
     * @param request
     * @return
     */
    TSingleResult<Boolean> del(AdvertIdRequest request);
}
