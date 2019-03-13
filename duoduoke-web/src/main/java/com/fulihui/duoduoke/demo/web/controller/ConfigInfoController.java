package com.fulihui.duoduoke.demo.web.controller;


import com.fulihui.duoduoke.demo.api.enums.AppConfigEnum;
import com.fulihui.duoduoke.demo.api.request.AppConfigRequest;
import com.fulihui.duoduoke.demo.web.manager.AppConfigManager;
import com.fulihui.duoduoke.demo.web.vo.AppConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/24 0024 17:39
 */
@RestController
@RequestMapping("config")
@Api(description = "配置信息")
public class ConfigInfoController {

    @Autowired
    AppConfigManager appConfigManager;

    private Map<String, String> appConfigVOs;

    @GetMapping("/customerDisplay/{pageName}")
    @ApiOperation("页面客服按钮配置")
    public JsonResult<Boolean> getCustomerDisplayConfig(@ApiParam(value = "页面名称 可选值 home|search|detail") @PathVariable("pageName") String pageName) {

        AppConfigVO configVO = null;

        switch (pageName) {
            case "home":
                configVO = appConfigManager.getModel(AppConfigEnum.UI_CUSTOMER_HOME_PAGE);
                break;
            case "search":
                configVO = appConfigManager.getModel(AppConfigEnum.UI_CUSTOMER_SEARCH_PAGE);
                break;
            case "detail":
                configVO = appConfigManager.getModel(AppConfigEnum.UI_CUSTOMER_DETAIL_PAGE);
                break;
            case "order":
                configVO = appConfigManager.getModel(AppConfigEnum.UI_CUSTOMER_ORDER_PAGE);
                break;
            case "exemption":
                configVO = appConfigManager.getModel(AppConfigEnum.UI_EXEMPTION_PAGE);
                break;
            default:
        }

        if (configVO != null) {
            return JsonResultBuilder.succ("true".equals(configVO.getConfigVal()));
        }

        return JsonResultBuilder.succ(true);
    }

    @PostConstruct
    @Scheduled(cron = "0 0/10 * * * *")
    Map<String, String> getVOList() {
        AppConfigRequest request = new AppConfigRequest();
        appConfigVOs = appConfigManager.getList(request);
        return appConfigVOs;
    }

    @GetMapping("/custom")
    @ApiOperation("页面客服信息")
    public JsonResult<Map<String, String>> getCustomerConfig() {
        if (appConfigVOs != null) {
            return JsonResultBuilder.succ(appConfigVOs);
        }
        return JsonResultBuilder.succ();
    }

    /**
     * Getter method for property <tt>appConfigVOs</tt>
     *
     * @return property value of appConfigVOs
     */
    public Map<String, String> getAppConfigVOs() {
        return appConfigVOs;
    }

    /**
     * Setter method for property <tt>appConfigVOs</tt>.
     *
     * @param appConfigVOs value to be assigned to property appConfigVOs
     */
    public void setAppConfigVOs(Map<String, String> appConfigVOs) {
        this.appConfigVOs = appConfigVOs;
    }
}
