package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.WechatConfigDTO;
import com.fulihui.redisdubbo.demo.api.dto.WechatTokenDTO;
import com.fulihui.redisdubbo.demo.api.request.WechatConfigRequest;
import com.fulihui.redisdubbo.demo.api.request.WechatTokenQueryRequest;
import com.fulihui.redisdubbo.demo.api.request.WechatTokenRefreshRequest;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * @author lizhi
 */
public interface WechatTokenService {

    /**
     * 获取微信小程序普通接口票据
     *
     * @param request {@link WechatTokenQueryRequest}
     * @return 票据
     */
    TSingleResult<String> takeAccessToken(WechatTokenQueryRequest request);

    /**
     * WechatConfigDTO
     *
     * @param request
     * @return
     */
    TMultiResult<WechatConfigDTO> query(WechatConfigRequest request);


    /**
     * 分页查询 信息
     *
     * @param request the request
     * @return t page result
     */
    TPageResult<WechatTokenDTO> queryPage(WechatTokenQueryRequest request);

    /**
     * 只查询库中数据 不更新Token
     *
     * @param request
     * @return
     */
    TSingleResult<WechatTokenDTO> queryToken(WechatTokenQueryRequest request);

    /**
     * 获取微信公众号 普通接口票据
     *
     * @param request {@link WechatTokenQueryRequest}
     * @return 票据
     */
    TSingleResult<String> takeWxPnAccessToken(WechatTokenQueryRequest request);

    /**
     * 获取微信公众号 JS-SDK 票据
     * @param request {@link WechatTokenQueryRequest}
     * @return 票据
     */
    TSingleResult<String> takeWxPnJsapiTicket(WechatTokenQueryRequest request);

    /**
     * 获取多多客授权 普通接口 票据
     * @param request {@link WechatTokenQueryRequest}
     * @return 票据
     */
    TSingleResult<String> takeDuoAccessToken(WechatTokenQueryRequest request);


    TSingleResult<String> updateAccessToken(WechatTokenRefreshRequest request);

}
