package com.fulihui.redisdubbo.demo.manager;


import com.fulihui.redisdubbo.demo.api.enums.AppConfigEnum;
import com.fulihui.redisdubbo.demo.api.request.AppConfigRequest;
import com.fulihui.redisdubbo.demo.vo.AppConfigVO;

import java.util.Map;

/**
 * @author: JY
 * @date: 2018/7/26 14:16
 */
public interface AppConfigManager {

    /**
     * 查询单个configModel
     * @param configEnum
     * @return
     */
    AppConfigVO getModel(AppConfigEnum configEnum);

    Map<String,String> getList(AppConfigRequest request);

}
