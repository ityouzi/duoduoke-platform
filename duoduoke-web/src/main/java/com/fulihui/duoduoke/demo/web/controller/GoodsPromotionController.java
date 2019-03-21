package com.fulihui.duoduoke.demo.web.controller;

import com.fulihui.duoduoke.demo.api.api.WechatTokenService;
import com.fulihui.duoduoke.demo.api.enums.OrderPromotionSourceEnum;
import com.fulihui.duoduoke.demo.api.request.WechatTokenQueryRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsPromotionUrlResponse;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.config.ExternalApiGoodsConfig;
import com.fulihui.duoduoke.demo.common.crypto.AESCoder;
import com.fulihui.duoduoke.demo.common.except.BizException;
import com.fulihui.duoduoke.demo.common.except.CommonErrors;
import com.fulihui.duoduoke.demo.web.config.AesKeyConfig;
import com.fulihui.duoduoke.demo.web.integration.GoodsPromotionServiceClient;
import com.fulihui.duoduoke.demo.web.manager.GoodsPromotionManager;
import com.fulihui.duoduoke.demo.web.model.CustomParameters;
import com.fulihui.duoduoke.demo.web.param.GoodsPromotionGenerateParam;
import com.fulihui.duoduoke.demo.web.util.Principal;
import com.fulihui.duoduoke.demo.web.util.PrincipalUtil;
import com.fulihui.duoduoke.demo.web.vo.GoodsPromotionUrlVO;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.ToString;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author lizhi
 * @date 2018-7-5
 */
@RestController
@RequestMapping("/goodPromotion")
@Api(description = "生成多多进宝商品推广链接")
public class GoodsPromotionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsPromotionController.class);

    @Autowired
    GoodsPromotionManager goodsPromotionManager;
    @Autowired
    AesKeyConfig aesKeyConfig;

    @Autowired
    GoodsPromotionServiceClient goodsPromotionServiceClient;

    @Autowired
    ExternalApiGoodsConfig externalApiGoodsConfig;

    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @org.apache.dubbo.config.annotation.Reference
    WechatTokenService wechatTokenService;

    @PostMapping("/promotion")
    @ApiOperation("生成多多进宝商品推广链接")
    JsonResult<GoodsPromotionUrlVO> promotion(@RequestBody GoodsPromotionGenerateParam param) {
        Principal principal = PrincipalUtil.getPrincipal();
        String pId = "1808329_56644863";
        LOGGER.info("GoodsPromotionController.param:{},pId:{}", param, pId);
        GoodsPromotionUrlVO vo = goodsPromotionManager.goodsGenerate(principal.getUserId(),
                param.getGoodsId(), pId, param.getShareId(), Boolean.TRUE);
        LOGGER.info("GoodsPromotionController.promotion:{}", vo);
        return JsonResultBuilder.succ(vo);
    }

    @PostMapping("/externalGoodsGenerateUrl")
    @ApiOperation("生成多多进宝商品推广链接")
    JsonResult<GoodsPromotionUrlVO> externalGoodsGenerateUrl(@RequestBody GoodsPromotionGenerateParam param) {
        if (StringUtil.isBlank(param.getGoodsId())) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }

        String pId = "240009_18781180";
        if (StringUtil.isNotBlank(param.getPid())) {
            pId = param.getPid();
        }
        LOGGER.info("GoodsPromotionController.param:{},pId:{}", param, pId);

        Principal principal = PrincipalUtil.getPrincipal();
        //自定义参数
        CustomParameters parameters = new CustomParameters();
        parameters.setUserId(principal.getUserId());
        if (StringUtil.isNotEmpty(param.getShareId())) {
            parameters.setOrderUserReferee(param.getShareId());
        }

        parameters.setOrderSource(OrderPromotionSourceEnum.MINI_APP.getCode());
        //加密
        AESCoder aesCoder = AESCoder.getInstance();
        String cus = aesCoder.encryptBase64(toJSONString(parameters), aesKeyConfig.getAesKey());

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("type", "pdd.ddk.oauth.goods.prom.url.generate");
        WechatTokenQueryRequest request = new WechatTokenQueryRequest();
        request.setAppid(duoDuoKeConfig.getClientId());
        TSingleResult<String> result = wechatTokenService.takeDuoAccessToken(request);
        paramsMap.put("token", result.getValue());
        GenerateParam generateParam = getGenerateParam(param, pId, cus);
        String jsonString = toJSONString(generateParam);
        paramsMap.put("param", jsonString);
        LOGGER.info("jsonString:{}", jsonString);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(externalApiGoodsConfig.getExternalApi());
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
                GoodsPromotionUrlVO convert = convert(json);
                return JsonResultBuilder.succ(convert);
            } else {
                LOGGER.error("Error Response: {}", response.getStatusLine().toString());
                return null;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return JsonResultBuilder.succ(null);
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

    private static GenerateParam getGenerateParam(@RequestBody GoodsPromotionGenerateParam param,
                                                  String pId, String cus) {
        GenerateParam generateParam = new GenerateParam();
        generateParam.setP_id(pId);
        generateParam.setCustom_parameters(cus);
        generateParam.setGoods_id_list("[" + param.getGoodsId() + "]");
        generateParam.setMulti_group(Boolean.FALSE.toString());
        generateParam.setGenerate_short_url(Boolean.TRUE.toString());
        generateParam.setGenerate_we_app(Boolean.TRUE.toString());
        generateParam.setGenerate_weapp_webview(Boolean.TRUE.toString());
        LOGGER.debug("generateParam:{}", generateParam);

        return generateParam;
    }

    private GoodsPromotionUrlVO getGoodsPromotionUrlVO(TMultiResult<GoodsPromotionUrlResponse> result) {
        List<GoodsPromotionUrlResponse> values = result.getValues();
        GoodsPromotionUrlVO vo = null;
        if (!CollectionUtils.isEmpty(values)) {
            vo = new GoodsPromotionUrlVO();
            GoodsPromotionUrlResponse item = values.get(0);
            vo.setAppId(item.getApp_id());
            vo.setPagePath(item.getPage_path());
        }
        return vo;
    }

    private GoodsPromotionUrlVO convert(String contentJson) {
        TMultiResult<GoodsPromotionUrlResponse> result = goodsPromotionServiceClient
                .convertResponse(contentJson);
        return getGoodsPromotionUrlVO(result);
    }
}

@Data
class GenerateParam extends ToString {

    private static final long serialVersionUID = 1373357580883482063L;
    private String p_id;
    /**
     * 自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。
     */
    private String custom_parameters;

    private String goods_id_list;

    private String multi_group;
    private String generate_short_url;
    private String generate_we_app;
    private String generate_weapp_webview;

}