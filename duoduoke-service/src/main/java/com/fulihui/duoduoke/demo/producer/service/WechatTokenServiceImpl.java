package com.fulihui.duoduoke.demo.producer.service;

import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.api.api.WechatTokenService;
import com.fulihui.duoduoke.demo.api.dto.WechatConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.WechatTokenDTO;
import com.fulihui.duoduoke.demo.api.enums.WechatTokenTypeEnum;
import com.fulihui.duoduoke.demo.api.request.WechatConfigRequest;
import com.fulihui.duoduoke.demo.api.request.WechatTokenQueryRequest;
import com.fulihui.duoduoke.demo.api.request.WechatTokenRefreshRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatConfig;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatConfigExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatToken;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatTokenExample;
import com.fulihui.duoduoke.demo.producer.repository.WechatTokenRepository;
import com.fulihui.duoduoke.demo.producer.biz.model.WechatTokenModel;
import com.fulihui.duoduoke.demo.producer.dal.dao.WechatConfigMapper;
import com.fulihui.duoduoke.demo.producer.util.ApplicationUtil;
import com.fulihui.duoduoke.demo.producer.util.Consts;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.config.ExternalApiGoodsConfig;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import com.fulihui.duoduoke.demo.web.weixin.weixin.WeixinClient;
import com.fulihui.duoduoke.demo.web.weixin.weixin.request.AccessTokenWeixinRequest;
import com.fulihui.duoduoke.demo.web.weixin.weixin.request.JsapiTicketWeixinRequest;
import com.fulihui.duoduoke.demo.web.weixin.weixin.result.AccessTokenWeixinResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.result.JsapiTicketWeixinResult;
import com.google.common.collect.Maps;
import org.apache.dubbo.config.annotation.Service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.error.InvokeServiceException;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lizhi
 */

@Service(version = "${demo.service.version}")
public class WechatTokenServiceImpl implements WechatTokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatTokenServiceImpl.class);

    @Autowired
    WechatTokenRepository wechatTokenRepository;

    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @Autowired
    WechatConfigMapper wechatConfigMapper;

    @Autowired
    WeixinClient weixinClient;

    @Autowired
    ApplicationUtil applicationUtil;

    @Autowired
    ExternalApiGoodsConfig externalApiGoodsConfig;

    @Value("${web.token.mock:false}")
    private Boolean tokenMock;

    public static void main(String[] args) throws URISyntaxException {
        String s = "https://gw-api.pinduoduo.com/api/router"
                + "?type=pdd.ddk.goods.search&data_type=JSON" + "&timestamp=1531975497767"
                + "&client_id=04077b8a720947c9a33c68bbb06bae8e" + "&keyword=裤子"
                + "&sign=444AC84F5AE46BF22593829AE6AA8C3D";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder("https://gw-api.pinduoduo.com/api/router");
        builder.addParameter("type", "pdd.ddk.goods.search");
        builder.addParameter("data_type", "JSON");
        builder.addParameter("timestamp", "1531975497767");
        builder.addParameter("client_id", "04077b8a720947c9a33c68bbb06bae8e");
        builder.addParameter("keyword", "裤子");
        builder.addParameter("sign", "444AC84F5AE46BF22593829AE6AA8C3D");

        HttpPost post = new HttpPost(builder.build());
        try {
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);
            LOGGER.info("success Response: {}", string);

        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);

        }

    }

    @Override
    public TSingleResult<String> takeAccessToken(WechatTokenQueryRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        WechatTokenTypeEnum tokenType = WechatTokenTypeEnum.ACCESS_TOKEN;
        WechatToken tokenDO = wechatTokenRepository.queryByType(request.getAppid(), tokenType);

        if (tokenMock) {
            return ResultBuilder.succTSingle(tokenDO.getTokenValue());
        }

        boolean isNew = (tokenDO == null);
        long nowSec = System.currentTimeMillis() / 1000;
        // 未存储过数据，或者 token 已超时，从接口获取 token 数据，多算1分钟，提前重新获取token
        if (isNew || (nowSec + 60) >= tokenDO.getExpiresSec()) {
            if (isNew) {
                tokenDO = new WechatToken();
            }
            tokenDO.setAppid(request.getAppid());
            tokenDO.setTokenType(tokenType.getCode());
            try {
                //生成环境才拉取Token
                if ("prod".equals(applicationUtil.getActiveProfile())) {
                    String accessToken = getAccessToken(duoDuoKeConfig.getTokenUrl(),
                            request.getAppid(), request.getAppSecret());
                    WechatTokenModel tokenModel = JSONObject.parseObject(accessToken,
                            WechatTokenModel.class);
                    if (tokenModel == null) {
                        throw new RuntimeException(accessToken + "token模型转换错误");
                    }
                    tokenDO.setTokenValue(tokenModel.getAccess_token());
                    tokenDO.setExpiresSec(nowSec + tokenModel.getExpires_in());
                }
            } catch (URISyntaxException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        if (isNew) {
            wechatTokenRepository.insert(tokenDO, Consts.SYSTEM_NAME);
        } else {
            boolean b = wechatTokenRepository.update(tokenDO, Consts.SYSTEM_NAME);
            if (!b) {
                return ResultBuilder.failTSingle(1, "takeAccessToken method error");
            }
        }
        return ResultBuilder.succTSingle(tokenDO.getTokenValue());
    }

    @Override
    public TSingleResult<String> takeWxPnAccessToken(WechatTokenQueryRequest request) {

        WechatTokenTypeEnum tokenType = WechatTokenTypeEnum.WX_PN_ACCESS_TOKEN;
        WechatToken tokenDO = wechatTokenRepository.queryByType(request.getAppid(), tokenType);
        boolean isNew = (tokenDO == null);
        long nowSec = System.currentTimeMillis() / 1000;
        // 未存储过数据，或者 token 已超时，从接口获取 token 数据，多算1分钟，提前重新获取token
        if (isNew || (nowSec + 60) >= tokenDO.getExpiresSec()) {
            if (isNew) {
                tokenDO = new WechatToken();
            }
            tokenDO.setAppid(request.getAppid());
            tokenDO.setTokenType(tokenType.getCode());

            AccessTokenWeixinRequest accessTokenRequest = new AccessTokenWeixinRequest();
            accessTokenRequest.setAppid(request.getAppid());
            accessTokenRequest.setSecret(request.getAppSecret());
            AccessTokenWeixinResult accessTokenRes = weixinClient.invokeService(accessTokenRequest);
            if (!accessTokenRes.isSuccess()) {
                throw new RuntimeException(accessTokenRes.getErrcode() + ","
                        + accessTokenRes.getErrmsg());
            }
            tokenDO.setTokenValue(accessTokenRes.getAccess_token());
            tokenDO.setExpiresSec(nowSec + accessTokenRes.getExpires_in());
        }
        if (isNew) {
            wechatTokenRepository.insert(tokenDO, Consts.SYSTEM_NAME);
        } else {
            boolean b = wechatTokenRepository.update(tokenDO, Consts.SYSTEM_NAME);
            if (!b) {
                throw new InvokeServiceException(Errors.Commons.SYSTEM_ERROR);
            }
        }
        return ResultBuilder.succTSingle(tokenDO.getTokenValue());

    }

    @Override
    public TSingleResult<String> takeWxPnJsapiTicket(WechatTokenQueryRequest request) {
        WechatTokenTypeEnum tokenType = WechatTokenTypeEnum.WX_PN_JSAPI_TICKET;
        WechatToken tokenDO = wechatTokenRepository.queryByType(request.getAppid(), tokenType);
        boolean isNew = (tokenDO == null);
        long nowSec = System.currentTimeMillis() / 1000;
        // 未存储过数据，或者 token 已超时，从接口获取 token 数据，多算1分钟，提前重新获取token
        if (isNew || (nowSec + 60) >= tokenDO.getExpiresSec()) {
            TSingleResult<String> accessToken = takeWxPnAccessToken(request);
            if (isNew) {
                tokenDO = new WechatToken();
            }
            tokenDO.setAppid(request.getAppid());
            tokenDO.setTokenType(tokenType.getCode());
            JsapiTicketWeixinRequest jsapiTicketRequest = new JsapiTicketWeixinRequest();
            jsapiTicketRequest.setAccess_token(accessToken.getValue());
            JsapiTicketWeixinResult jsapiTicketRes = weixinClient.invokeService(jsapiTicketRequest);
            if (!jsapiTicketRes.isSuccess()) {
                throw new RuntimeException(jsapiTicketRes.getErrcode() + ","
                        + jsapiTicketRes.getErrmsg());
            }
            tokenDO.setTokenValue(jsapiTicketRes.getTicket());
            tokenDO.setExpiresSec(nowSec + jsapiTicketRes.getExpires_in());
        }
        if (isNew) {
            wechatTokenRepository.insert(tokenDO, Consts.SYSTEM_NAME);
        } else {
            boolean b = wechatTokenRepository.update(tokenDO, Consts.SYSTEM_NAME);
            if (!b) {
                throw new InvokeServiceException(Errors.Commons.SYSTEM_ERROR);
            }
        }

        return ResultBuilder.succTSingle(tokenDO.getTokenValue());
    }

    @Override
    public TSingleResult<String> takeDuoAccessToken(WechatTokenQueryRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        //查询刷新token
        WechatTokenTypeEnum tokenType = WechatTokenTypeEnum.DUO_REFRESH_ACCESS_TOKEN;
        WechatToken tokenDO = wechatTokenRepository.queryByType(request.getAppid(), tokenType);
        if (tokenDO == null) {
            throw new InvokeServiceException(Errors.Commons.SYSTEM_ERROR);
        }

        WechatToken wechatToken = wechatTokenRepository.queryByType(request.getAppid(),
                WechatTokenTypeEnum.DUO_ACCESS_TOKEN);
        if (wechatToken == null) {
            throw new InvokeServiceException(Errors.Commons.SYSTEM_ERROR);
        }

        long nowSec = System.currentTimeMillis() / 1000;
        // 已超时
        if ((nowSec + 60) >= tokenDO.getExpiresSec()) {

            tokenDO.setAppid(request.getAppid());
            tokenDO.setTokenType(tokenType.getCode());

            wechatToken.setAppid(request.getAppid());
            wechatToken.setTokenType(wechatToken.getTokenType());

            HashMap<String, Object> hashMap = Maps.newHashMap();
            hashMap.put("refresh_token", tokenDO.getTokenValue());
            String json = getDuoToken(hashMap);
            DuoToken duoToken = JSONObject.parseObject(json, DuoToken.class);
            //如果调用成功

            if (duoToken != null && duoToken.getCode() == HttpStatus.OK.value()) {
                tokenDO.setTokenValue(duoToken.getRefresh_token());
                long l = nowSec + duoToken.getExpires_in();
                tokenDO.setExpiresSec(l);

                wechatToken.setTokenValue(duoToken.getAccess_token());
                wechatToken.setExpiresSec(l);
            }

        }
        boolean b = wechatTokenRepository.update(tokenDO, Consts.SYSTEM_NAME);
        if (!b) {
            throw new InvokeServiceException(Errors.Commons.SYSTEM_ERROR);
        }

        b = wechatTokenRepository.update(wechatToken, Consts.SYSTEM_NAME);
        if (!b) {
            throw new InvokeServiceException(Errors.Commons.SYSTEM_ERROR);
        }

        return ResultBuilder.succTSingle(wechatToken.getTokenValue());
    }

    @Override
    public TSingleResult<String> updateAccessToken(WechatTokenRefreshRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        WechatToken record = new WechatToken();
        record.setTokenValue(request.getTokenValue());
        record.setLastGmtModified(request.getLastGmtModified());
        record.setExpiresSec(1L);
        record.setExpiresIn(request.getExpiresIn());
        WechatTokenExample example = new WechatTokenExample();
        example.createCriteria().andTokenTypeEqualTo(WechatTokenTypeEnum.DUO_ACCESS_TOKEN.getCode());
        wechatTokenRepository.updateByExampleSelective(record, example);

        WechatToken recordRefresh = new WechatToken();
        recordRefresh.setTokenValue(request.getTokenRefreshValue());
        recordRefresh.setLastGmtModified(request.getLastGmtModified());
        recordRefresh.setExpiresSec(1L);
        recordRefresh.setExpiresIn(request.getExpiresIn());
        WechatTokenExample exampleRefresh = new WechatTokenExample();
        exampleRefresh.createCriteria().andTokenTypeEqualTo(WechatTokenTypeEnum.DUO_REFRESH_ACCESS_TOKEN.getCode());
        wechatTokenRepository.updateByExampleSelective(recordRefresh, exampleRefresh);

        return ResultBuilder.succTSingle(request.getTokenRefreshValue());
    }

    /**
     * 查询Token 只查询不更新
     *
     * @param request
     * @return
     */
    @Override
    public TSingleResult<WechatTokenDTO> queryToken(WechatTokenQueryRequest request) {
        WechatToken tokenDO = wechatTokenRepository.queryByType(request.getAppid(),
                WechatTokenTypeEnum.ACCESS_TOKEN);

        WechatTokenDTO tokenDTO = null;
        if (tokenDO != null) {
            tokenDTO = BeanConvUtil.copy(tokenDO, WechatTokenDTO.class);
        }

        return ResultBuilder.succTSingle(tokenDTO);
    }

    private String getAccessToken(String url, String appid, String secret)
            throws URISyntaxException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(url);
        builder.setParameter("grant_type", "client_credential").setParameter("appid", appid)
                .setParameter("secret", secret);

        HttpPost post = new HttpPost(builder.build());
        try {
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);
            LOGGER.info("success Response: {}", string);
            return string;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    private String getDuoToken(Map<String, Object> paramsMap) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(externalApiGoodsConfig.getExternalRefreshApi());
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5 * 1000)
                .setConnectionRequestTimeout(5 * 1000).setSocketTimeout(5 * 1000)
                .setRedirectsEnabled(true).build();
        httpPost.setConfig(requestConfig);

        List<NameValuePair> list = new ArrayList<>();
        for (String key : paramsMap.keySet()) {
            list.add(new BasicNameValuePair(key, String.valueOf(paramsMap.get(key))));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                String json = EntityUtils.toString(response.getEntity());
                LOGGER.info("success Response: {}", json);
                return json;
            } else {
                LOGGER.error("Error Response: {}", response.getStatusLine().toString());
                return null;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        } finally {
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    @Override
    public TMultiResult<WechatConfigDTO> query(WechatConfigRequest request) {
        String configCode = request.getConfigCode();
        String envType = request.getEnvType();

        WechatConfigExample example = new WechatConfigExample();
        example.createCriteria().andEnvTypeEqualTo(envType).andConfigCodeEqualTo(configCode);
        List<WechatConfig> list = wechatConfigMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTMulti(Collections.emptyList());
        }
        List<WechatConfigDTO> collect = list.stream().map(itm -> {
            WechatConfigDTO configDTO = new WechatConfigDTO();
            BeanUtils.copyProperties(itm, configDTO);
            return configDTO;
        }).collect(Collectors.toList());
        return ResultBuilder.succTMulti(collect);

    }

    @Override
    public TPageResult<WechatTokenDTO> queryPage(WechatTokenQueryRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        WechatTokenExample example = new WechatTokenExample();
        example.setLimit(request.getRows());
        example.setOffset(request.start4Mysql());
        WechatTokenExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(request.getTokenType())) {
            criteria.andTokenTypeEqualTo(request.getTokenType());
        }
        List<WechatTokenDTO> list = wechatTokenRepository.selectByExample(example);
        long count = 0;
        if (!CollectionUtils.isEmpty(list)) {
            count = wechatTokenRepository.countByExample(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }
}

class DuoToken extends ToString {

    private static final long serialVersionUID = 6931936702886277708L;

    /**
     * code : 200
     * msg : 调用成功
     * scope : ["pdd.ddk.direct.goods.query","pdd.ddk.oauth.cms.prom.url.generate","pdd.ddk.order.detail.get","pdd.util.divide.image","pdd.ddk.all.order.list.increment.get","pdd.ddk.lottery.url.gen","pdd.ddk.oauth.zs.unit.goods.query","pdd.ddk.oauth.weapp.qrcode.url.gen","pdd.ddk.app.new.bill.list.get","pdd.ddk.oauth.lottery.url.gen","pdd.goods.opt.get","pdd.ddk.goods.zs.unit.url.gen","pdd.ddk.goods.promotion.url.generate","pdd.ddk.goods.search","pdd.ddk.register.sms.vcode.send","pdd.ddk.oauth.order.detail.get","pdd.ddk.oauth.theme.prom.url.generate","pdd.ddk.goods.pid.generate","pdd.ddk.oauth.check.in.bill.incr.get","pdd.ddk.oauth.rp.prom.url.generate","pdd.ddk.goods.basic.info.get","pdd.ddk.oauth.order.list.increment.get","pdd.ddk.zs.unit.goods.query","pdd.ddk.goods.detail","pdd.ddk.oauth.goods.prom.url.generate","pdd.ddk.theme.list.get","pdd.ddk.merchant.list.get","pdd.ddk.ddjb.user.register","pdd.ddk.oauth.lottery.new.list.get","pdd.ddk.cms.prom.url.generate","pdd.ddk.oauth.direct.goods.query","pdd.ddk.goods.pid.query","pdd.ddk.goods.recommend.get","pdd.ddk.theme.prom.url.generate","pdd.ddk.oauth.app.new.bill.list.get","pdd.time.get","pdd.ddk.oauth.goods.pid.query","pdd.ddk.order.list.range.get","pdd.ddk.order.list.increment.get","pdd.ddk.mall.goods.list.get","pdd.ddk.oauth.resource.url.gen","pdd.ddk.resource.url.gen","pdd.ddk.check.in.prom.bill.incr.get","pdd.ddk.theme.goods.search","pdd.ddk.rp.prom.url.generate","pdd.ddk.mall.url.gen","pdd.ddk.weapp.qrcode.url.gen","pdd.goods.cats.get","pdd.ddk.oauth.goods.zs.unit.url.gen","pdd.ddk.lottery.new.list.get","pdd.ddk.oauth.mall.url.gen","pdd.ddk.oauth.order.list.range.get","pdd.ddk.oauth.goods.pid.generate"]
     * access_token : 5506946714eb48db92d2d4225ef30f15d52cf43b
     * expires_in : 86399
     * refresh_token : 7cd2feeff7674717849b7a19f550ef7c545fbf6a
     * owner_id : 240009
     * owner_name : 13817659193
     */

    private int code;
    private String msg;
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String owner_id;
    private String owner_name;
    private List<String> scope;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public List<String> getScope() {
        return scope;
    }

    public void setScope(List<String> scope) {
        this.scope = scope;
    }
}
