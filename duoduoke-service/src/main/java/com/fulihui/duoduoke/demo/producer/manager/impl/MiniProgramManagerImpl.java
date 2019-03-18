package com.fulihui.duoduoke.demo.producer.manager.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.producer.manager.MiniProgramManager;
import com.fulihui.duoduoke.demo.producer.model.WxTemplateModel;
import com.fulihui.duoduoke.demo.producer.model.WxTemplateSendModel;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: JY
 * @date: 2018/8/13 10:41
 */
@Component
public class MiniProgramManagerImpl implements MiniProgramManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MiniProgramManagerImpl.class);

    /**
     * 查询下程序绑定的模板
     */
    @Override
    public List<WxTemplateModel> queryWxTemplate(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("offset", 0);
        params.put("count", 20);

        String result = httpclient("https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token=" + token, params);

        if (result != null) {
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.getInteger("errcode") == 0) {
                return JSONArray.parseArray(jsonObject.getString("list"), WxTemplateModel.class);
            }
        }
        return null;
    }

    /**
     * 发送模板消息
     *
     * @return
     */
    @Override
    public boolean sendTemplateMsg(WxTemplateSendModel templateSendModel, String token) {

        Map<String, Object> params = new HashMap<>();
        params.put("touser", templateSendModel.getTouser());
        params.put("template_id", templateSendModel.getTemplateId());

        //跳转参数
        String page = templateSendModel.getPage();
        if (templateSendModel.getParams() != null) {
            page += page.indexOf('?') == -1 ? "?" : "&";
            page += "templateParams=" + JSONObject.toJSONString(templateSendModel.getParams());
        }
        params.put("page", page);
        params.put("form_id", templateSendModel.getFormId());
        params.put("data", templateSendModel.getData());

        //加粗字段
        if (StringUtil.isNotEmpty(templateSendModel.getEmphasisKeyword())) {
            params.put("emphasis_keyword", templateSendModel.getEmphasisKeyword());
        }

        String result = httpclient("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + token, params);

        if (result != null) {
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.getInteger("errcode") == 0) {
                return true;
            }
        }

        LOGGER.error("发送模板消息失败请求参数：{} 返回：{}", params, result);
        return false;
    }


    private String httpclient(String url, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost(url);
            if (params != null) {
                StringEntity paramsEntity = new StringEntity(JSONObject.toJSONString(params), "utf-8");
                post.setEntity(paramsEntity);
            }
            post.setHeader("Content-Type", "application/json;encoding=utf-8");
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity, "utf-8");
            return string;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            LOGGER.info("调用接口失败：{}", e);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info("调用接口失败：{}", e);
        }

        return null;
    }
}
