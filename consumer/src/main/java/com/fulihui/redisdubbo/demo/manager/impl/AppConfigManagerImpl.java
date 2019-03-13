package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.AppConfigService;
import com.fulihui.redisdubbo.demo.api.dto.AppConfigDTO;
import com.fulihui.redisdubbo.demo.api.enums.AppConfigEnum;
import com.fulihui.redisdubbo.demo.api.request.AppConfigRequest;
import com.fulihui.redisdubbo.demo.manager.AppConfigManager;
import com.fulihui.redisdubbo.demo.vo.AppConfigVO;
import com.google.common.collect.Maps;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;



/**
 * @author: JY
 * @date: 2018/7/26 14:16
 */
@Service
public class AppConfigManagerImpl implements AppConfigManager {

    @org.apache.dubbo.config.annotation.Reference(version = "1.0.0")
    AppConfigService appConfigService;

    /**
     * 查询单个model
     *
     * @param configEnum
     * @return
     */
    @Override
    public AppConfigVO getModel(AppConfigEnum configEnum) {
        TSingleResult<AppConfigDTO> result = appConfigService.getModel(configEnum);
        AppConfigDTO model = result.getValue();

        AppConfigVO configVO = null;

        //数据转换
        if (model != null) {
            configVO = new AppConfigVO();
            BeanUtils.copyProperties(model, configVO);
        }
        return configVO;
    }

    @Override
    public Map<String, String> getList(AppConfigRequest request) {
        Map<String, String> map = Maps.newHashMap();
        try {
            TMultiResult<AppConfigDTO> result = appConfigService.getList(request);
            List<AppConfigDTO> list = result.getValues();
            if (!CollectionUtils.isEmpty(list)) {
                list.forEach((item) -> {
                    String id = item.getId().toString();
                    if (id.equals(AppConfigEnum.WECHAT_NO.getCode())) {
                        map.put("WECHAT_NO", item.getConfigVal());
                    } else if (id.equals(AppConfigEnum.WECHAT_NO_TWO.getCode())) {
                        map.put("WECHAT_NO_TWO", item.getConfigVal());
                    }

                });
            }
        } catch (Exception e) {

        }

        return map;

    }

}
