package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.AppConfigDTO;
import com.fulihui.redisdubbo.demo.api.enums.AppConfigEnum;
import com.fulihui.redisdubbo.demo.api.request.AppConfigRequest;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author: JY
 * @date: 2018/7/26 13:43
 */
public interface AppConfigService {

    /**
     * 获取单个Model
     *
     * @param configEnum
     * @return
     */
    TSingleResult<AppConfigDTO> getModel(AppConfigEnum configEnum);

    /**
     * 修改
     *
     * @param appConfigDTO
     * @return
     */
    TSingleResult<Boolean> modify(AppConfigDTO appConfigDTO);

    /**
     * 查询
     *
     * @param request
     * @return
     */
    TMultiResult<AppConfigDTO> getList(AppConfigRequest request);

    /**
     * 获取佣金比率-缓存数据
     *
     * @return
     */
    TSingleResult<Long> getCacheCommision();

}
