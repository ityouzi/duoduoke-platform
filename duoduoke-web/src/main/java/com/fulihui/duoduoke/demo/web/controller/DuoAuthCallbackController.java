/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.web.weixin.weixin.WeixinClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.near.toolkit.model.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 多多授权预授权回调控制层
 * @author Willard Hu on 2017/11/1.
 */
@Controller
@RequestMapping("/duoAuth")
@Api(description = "多多授权api")
public class DuoAuthCallbackController {
    private final transient Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    WeixinClient weixinClient;

    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @GetMapping("/auth")
    @ApiOperation(value = "多多授权")
    String oauth(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authUrl = "http://jinbao.pinduoduo.com/open.html?";
        String successURL = authUrl + "client_id=" + duoDuoKeConfig.getClientId()
                            + "&response_type=code&redirect_uri="
                            + duoDuoKeConfig.getDuoAuthCallBackUrl();
        logger.info("successURL:{}", successURL);
        return "redirect:" + successURL;

    }

    @GetMapping("/callback")
    @ApiOperation(value = "多多授权回调")
    @ResponseBody
    String oauthCallback(@RequestParam("code") String code,
                         @RequestParam(value = "state", required = false) String state,
                         HttpServletRequest request) throws Exception {

        logger.info("code:{},state:{}", code, state);

        DuoTokenRequest tokenRequest = new DuoTokenRequest();
        tokenRequest.setClient_id(duoDuoKeConfig.getClientId());
        tokenRequest.setClient_secret(duoDuoKeConfig.getClientSecret());
        tokenRequest.setGrant_type("authorization_code");
        tokenRequest.setCode(code);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(duoDuoKeConfig.getDuoTokenUrl());
        HttpPost post = new HttpPost(builder.build());
        post.addHeader("Content-Type", "application/json");
        try {
            StringEntity postingString = new StringEntity(JSONObject.toJSONString(tokenRequest));
            post.setEntity(postingString);
            HttpResponse response = httpClient.execute(post);
            String string = EntityUtils.toString(response.getEntity());
            logger.info("success Response: {}", string);
            return string;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @GetMapping("/refreshToken")
    @ApiOperation(value = "多多授权回调")
    @ResponseBody
    String refreshToken(@RequestParam("refreshToken") String refreshToken,
                        @RequestParam(value = "state", required = false) String state,
                        HttpServletRequest request) throws URISyntaxException {
        logger.info("code:{},state:{}", refreshToken, state);
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest();
        refreshTokenRequest.setClient_id(duoDuoKeConfig.getClientId());
        refreshTokenRequest.setClient_secret(duoDuoKeConfig.getClientSecret());
        refreshTokenRequest.setGrant_type("refresh_token");
        refreshTokenRequest.setRefresh_token(refreshToken);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(duoDuoKeConfig.getDuoTokenUrl());
        HttpPost post = new HttpPost(builder.build());
        post.addHeader("Content-Type", "application/json");
        try {
            StringEntity postingString = new StringEntity(
                JSONObject.toJSONString(refreshTokenRequest));
            post.setEntity(postingString);
            HttpResponse response = httpClient.execute(post);
            String string = EntityUtils.toString(response.getEntity());
            logger.info("success Response: {}", string);
            return string;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

    }

}

/**
 *
 curl-X POST -H"Content-Type: application/json" -d'{

 "client_id": "f75ffb6976dbe80c0da3bc2b0ffbc7c9",

 "code": "f80c147d96a144e88eb2e2006cccdffe3ba69215",

 "grant_type": "authorization_code",

 "client_secret": "fd82ceb7b86d92d209d44af0b6ab64e2076b4751"

 }'"http://open-api.pinduoduo.com/oauth/token"
 */

@Data
class DuoTokenRequest extends ToString {

    private static final long serialVersionUID = 8172970994153330648L;

    private String            client_id;
    private String            code;
    private String            grant_type;
    private String            client_secret;
}

@Data
class RefreshTokenRequest extends ToString {

    private static final long serialVersionUID = 8172970994153330648L;

    private String            client_id;
    private String            refresh_token;
    private String            grant_type;
    private String            client_secret;
}