package com.fulihui.duoduoke.demo.web.manager;


import com.fulihui.duoduoke.demo.api.enums.AppConfigEnum;
import com.fulihui.duoduoke.demo.api.request.AppConfigRequest;
import com.fulihui.duoduoke.demo.web.vo.AppConfigVO;

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
