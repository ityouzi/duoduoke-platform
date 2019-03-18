package com.fulihui.duoduoke.demo.web.weixin.duoduoapi;

import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request.DuoRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.DuoResult;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/6 0006 16:04
 */
public interface DuoduoHttpClient {

    /**
     * 调用服务
     * @param request request
     * @return WeixinJsonResult
     */
    <T extends DuoResult> T invokeService(DuoRequest<T> request);

    /**
     * 获取请求地址
     * @param request request
     * @return String
     */
    String assembleURL(DuoRequest<String> request);

}
