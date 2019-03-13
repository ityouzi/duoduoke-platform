package com.fulihui.duoduoke.demo.web.weixin.weixin;


import com.fulihui.duoduoke.demo.web.weixin.weixin.request.WeixinRequest;
import com.fulihui.duoduoke.demo.web.weixin.weixin.result.WeixinResult;

/**
 * 微信客户端
 * Created by Willard on 2015/9/8.
 */
public interface WeixinClient {

    /**
     * 调用服务
     * @param request request
     * @return WeixinJsonResult
     */
    <T extends WeixinResult> T invokeService(WeixinRequest<T> request);

    /**
     * 获取请求地址
     * @param request request
     * @return String
     */
    String assembleURL(WeixinRequest<String> request);

}
