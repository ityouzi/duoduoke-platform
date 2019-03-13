package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.WechatTokenService;
import com.fulihui.redisdubbo.demo.api.dto.WechatConfigDTO;
import com.fulihui.redisdubbo.demo.api.request.WechatTokenQueryRequest;
import com.fulihui.redisdubbo.demo.factory.WeChatConfigFactory;
import com.fulihui.redisdubbo.demo.manager.WeChatManager;
import com.fulihui.redisdubbo.demo.weixin.common.config.DuoDuoKeConfig;
import com.fulihui.redisdubbo.demo.weixin.common.util.CloseableHttpUtil;
import com.fulihui.redisdubbo.demo.weixin.weixin.WeixinClient;
import com.fulihui.redisdubbo.demo.weixin.weixin.request.transfer.TransfersQueryWeixinRequest;
import com.fulihui.redisdubbo.demo.weixin.weixin.request.transfer.TransfersWeixinRequest;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer.TransfersQueryWeixinResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer.TransfersWeixinResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.util.CertInfo;
import com.fulihui.redisdubbo.demo.weixin.weixin.util.CertUtil;
import com.google.common.collect.Maps;
import org.apache.dubbo.config.annotation.Reference;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.RandomCharset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * @author lizhi
 * @date 2018-7-7
 */
@Component
public class WeChatManagerImpl implements WeChatManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatManagerImpl.class);

    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @Autowired
    WeixinClient weixinClient;

    @Reference
    WechatTokenService wechatTokenService;

    @Autowired
    WeChatConfigFactory weChatConfigFactory;

    @Override
    public String getOpenIdByCode(String code) {
        Assert.notNull(code, "code is not null");
        String authUrl = duoDuoKeConfig.getAuthUrl();
        Map<String, Object> map = Maps.newHashMap();
        map.put("appid", duoDuoKeConfig.getMiniAppid());
        map.put("secret", duoDuoKeConfig.getMiniAppSecret());
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        return CloseableHttpUtil.doPost(authUrl, map);
    }

    @Override
    public TransfersWeixinResult transfers(String openId, String appId, String tradeNo, int amount,
                                           String desc) {
        WechatConfigDTO config = weChatConfigFactory.get();
        TransfersWeixinRequest request = new TransfersWeixinRequest();
        //appid
        request.setMchAppid(appId);
        //商户号
        request.setMchid(config.getMchId());
        request.setPartnerTradeNo(tradeNo);
        request.setOpenid(openId);
        request.setCheckName("NO_CHECK");
        request.setAmount(amount);
        request.setDesc(desc);
        request.genSign(config.getSignKey());
        setCertInfo();
        TransfersWeixinResult transfersWeixinResult = weixinClient.invokeService(request);
        return transfersWeixinResult;
    }

    /**
     * 企业微信转账查询(公众号->个人)
     *
     * @param tradeNO 商户订单号
     * @return
     */
    @Override
    public TransfersQueryWeixinResult transferQuery(String userId, String appId, String tradeNO) {
        try {
            WechatConfigDTO config = weChatConfigFactory.get();
            // 设置请求参数
            TransfersQueryWeixinRequest request = new TransfersQueryWeixinRequest();
            request.setAppid(appId);
            request.setMchId(config.getMchId());
            request.setNonceStr(RandomCharset.randomMixture(32));
            request.setPartnerTradeNo(tradeNO);
            request.genSign(config.getSignKey());
            setCertInfo();
            return weixinClient.invokeService(request);
        } catch (Exception e) {
            LOGGER.error("企业微信转账查询(公众号->个人)失败", e);
        }
        return null;
    }

    /**
     * 微信商户平台认证文件
     */
    private void setCertInfo() {
        WechatConfigDTO config = weChatConfigFactory.get();
        CertInfo certInfo = new CertInfo();
        certInfo.setCertFile(config.getCertFile());
        certInfo.setCertPwd(config.getMchId());
        CertUtil.setCertInfo(certInfo);
    }

    @Override
    public String takeAccessToken() {
        WechatTokenQueryRequest request = new WechatTokenQueryRequest();
        request.setAppid(duoDuoKeConfig.getMiniAppid());
        request.setAppSecret(duoDuoKeConfig.getMiniAppSecret());
        TSingleResult<String> result = wechatTokenService.takeAccessToken(request);
        ServiceResultUtil.checkResult(result);
        return result.getValue();
    }

}
