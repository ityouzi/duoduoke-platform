package com.fulihui.redisdubbo.demo.producer.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.api.api.WechatTokenService;
import com.fulihui.redisdubbo.demo.api.dto.WechatAuthDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import com.fulihui.redisdubbo.demo.api.request.WechatTokenQueryRequest;
import com.fulihui.redisdubbo.demo.producer.biz.model.CglibBean;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatPushTemplateContent;
import com.fulihui.redisdubbo.demo.producer.manager.AppSendMessageManager;
import com.fulihui.redisdubbo.demo.producer.manager.enums.MiniPushSuccessEnum;
import com.fulihui.redisdubbo.demo.producer.repository.WechatAuthRepository;
import com.fulihui.redisdubbo.demo.producer.repository.WechatPushTemplateRepository;
import com.fulihui.redisdubbo.demo.producer.repository.WechatTokenRepository;
import com.fulihui.redisdubbo.demo.producer.util.ImageUtil;
import com.fulihui.redisdubbo.demo.weixin.common.config.DuoDuoKeConfig;
import com.fulihui.redisdubbo.demo.weixin.weixin.WeixinClient;
import com.fulihui.redisdubbo.demo.weixin.weixin.request.TemplateSendRequest;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.TemplateSendResult;
import com.google.common.collect.Maps;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/12 0012 14:48
 */
@Component
public class AppSendMessageManagerImpl implements AppSendMessageManager {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AppSendMessageManagerImpl.class);
    @Autowired
    WechatTokenService wechatTokenService;
    @Autowired
    WechatAuthRepository wechatAuthRepository;
    @Autowired
    private WeixinClient weixinClient;
    @Autowired
    private WechatPushTemplateRepository wechatPushTemplateRepository;
    @Autowired
    private WechatTokenRepository wechatTokenRepository;
    @Autowired
    private DuoDuoKeConfig duoDuoKeConfig;

    @Override
    public boolean sendMessage(String type, String userId, String content, String formId,
                               String page) {
        WechatAuthDTO wechatAuthDTO = wechatAuthRepository.queryByUserId(userId,
                UserTypeEnum.MINI_USER);
        if (wechatAuthDTO == null) {
            LOGGER.info("发送模板消息,根据用户id查询不到openId,userId:{}", userId);
            return false;
        }
        String token = getToken();
        if (StringUtil.isBlank(token)) {
            LOGGER.info("发送模板消息,token已经失效或者未查询到");
            return false;
        }
        TemplateSendRequest request = new TemplateSendRequest();
        WechatPushTemplateContent template = wechatPushTemplateRepository.selectByType(type);
        if (template != null) {
            request.setTouser(wechatAuthDTO.getOpenId());
            request.setTemplate_id(template.getTemplateId());
            request.setPage(StringUtil.isNotBlank(page) ? page : template.getPage());
            request.setAccess_token(token);
            //这是固定模板内容
            Object o;
            if (StringUtil.isNotBlank(content)) {
                o = convertContent(content);
            } else {
                o = convertContent(template.getTemplateContent());
            }
            if (o != null) {
                request.setData(o);
            }
            request.setForm_id(formId);

            TemplateSendResult sendResult = weixinClient.invokeService(request);
            MiniPushSuccessEnum anEnum = EnumUtil.queryByCode(sendResult.getErrcode(),
                    MiniPushSuccessEnum.class);
            if (anEnum != null) {
                LOGGER.info("sendMessage.result:{},userId:{},code:{},templateId:{},desc:{}",
                        sendResult, userId, anEnum.getCode(), template.getTemplateId(),
                        anEnum.getDesc());
            }
            return sendResult.isSuccess();
        }
        return false;
    }

    @Override
    public Object convertContent(String content) {
        JSONObject jsonObject = JSONObject.parseObject(content);
        if (jsonObject != null) {
            Map<String, Class> propertyMap = Maps.newHashMap();
            Map<String, Class> pushMap = Maps.newHashMap();
            jsonObject.forEach((s, o1) -> {
                try {
                    propertyMap.put(s, Class.forName("java.lang.String"));
                    pushMap.put(s, Class.forName("java.util.Map"));
                } catch (ClassNotFoundException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            });
            CglibBean bean = new CglibBean(propertyMap);
            jsonObject.forEach(bean::setValue);
            CglibBean pushBean = new CglibBean(pushMap);
            jsonObject.forEach((k, v) -> {
                HashMap<String, String> valueMap = Maps.newHashMap();
                valueMap.put("value", v.toString());
                pushBean.setValue(k, valueMap);
            });
            return pushBean.getObject();
        }
        return null;
    }

    @Override
    public BufferedImage getWeixinCode(String scene) {
        try {
            InputStream inputStream = weixinCode(scene, "home");
            if (inputStream != null) {
                BufferedImage bufferedImage = ImageIO.read(inputStream);
                BufferedImage thumbnail = ImageUtil.thumbnail(bufferedImage, 180, 180);
                return thumbnail;
            } else {
                LOGGER.info("response inputStream is null");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public InputStream weixinCode(String scene, String type) {
        String token = getToken();
        if (StringUtil.isBlank(token)) {
            LOGGER.info("token已经失效或者未查询到");
            return null;
        }
        Map<String, Object> params = Maps.newHashMap();
        //参数
        params.put("scene", scene);
        if ("home".equals(type)) {
            params.put("page", duoDuoKeConfig.getMinipage());
        } else {
            params.put("page", duoDuoKeConfig.getMiniProductPage());
        }
        params.put("width", 180);
        LOGGER.info("params:{}", params.toString());
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 接口
        HttpPost httpPost = new HttpPost(
                "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + token);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        String body = JSON.toJSONString(params);
        StringEntity entity;
        try {
            entity = new StringEntity(body);
            entity.setContentType("image/png");
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            InputStream inputStream = response.getEntity().getContent();
            return inputStream;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取token
     *
     * @return
     */
    private String getToken() {
        WechatTokenQueryRequest tokenQueryRequest = new WechatTokenQueryRequest();
        tokenQueryRequest.setAppid(duoDuoKeConfig.getMiniAppid());
        tokenQueryRequest.setAppSecret(duoDuoKeConfig.getMiniAppSecret());
        TSingleResult<String> result = wechatTokenService.takeAccessToken(tokenQueryRequest);
        ServiceResultUtil.checkResult(result);
        return result.getValue();
    }

}
