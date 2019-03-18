package com.fulihui.duoduoke.demo.producer.service;


import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.api.api.GoodsPromotionService;
import com.fulihui.duoduoke.demo.api.request.GoodsPromotionGenerateRequest;
import com.fulihui.duoduoke.demo.api.response.GoodsPromotionUrlResponse;
import com.fulihui.duoduoke.demo.producer.util.ClassFieldsUtil;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.DuoduoHttpClient;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request.DuoGoodsGenerateRequest;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.GoodsPromotionUrlGenerateResult;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.fulihui.duoduoke.demo.producer.util.SignUtil.genServiceSign;
import static org.near.servicesupport.error.Errors.Commons.REQUEST_PARAMETER_ERROR;
import static org.near.servicesupport.util.ServiceAssert.notBlank;
import static org.near.servicesupport.util.ServiceAssert.notNull;


/**
 * @author lizhi
 * @date 2018-7-8
 */
@Service(version = "${demo.service.version}")

public class GoodsPromotionServiceImpl implements GoodsPromotionService {

    @Autowired
    DuoduoHttpClient duoduoHttpClient;
    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @Override
    public TMultiResult<GoodsPromotionUrlResponse> goodsPromotionGenerate(GoodsPromotionGenerateRequest request) {
        notNull(request, REQUEST_PARAMETER_ERROR);
        notBlank(request.getGoods_id_list(), REQUEST_PARAMETER_ERROR);
        notBlank(request.getP_id(), REQUEST_PARAMETER_ERROR);
        notBlank(request.getCustom_parameters(), REQUEST_PARAMETER_ERROR);

        DuoGoodsGenerateRequest generate = new DuoGoodsGenerateRequest();
        generate.setType("pdd.ddk.goods.promotion.url.generate");
        generate.setClient_id(duoDuoKeConfig.getClientId());
        generate.setTimestamp(System.currentTimeMillis() + "");
        generate.setP_id(request.getP_id());
        generate.setGoods_id_list("[" + request.getGoods_id_list() + "]");
        generate.setCustom_parameters(request.getCustom_parameters());
        //是否生成小程序推广
        generate.setGenerate_we_app(request.isGenerate_we_app());
        generate.setMulti_group(request.isMulti_group());
        generate.setGenerate_weapp_webview(request.getGenerate_weapp_webview());
        generate.setGenerate_short_url(request.isGenerate_short_url());
        Map<String, Object> strValMap = ClassFieldsUtil.obj2StrValMap(generate);

        String sign = genServiceSign(ClassFieldsUtil.obj2StrVal(generate), strValMap,
                duoDuoKeConfig.getClientSecret());
        generate.setSign(sign);
        GoodsPromotionUrlGenerateResult result = duoduoHttpClient.invokeService(generate);
        List<GoodsPromotionUrlResponse> urlResponses = getGoodsPromotionUrlResponses(result);
        return ResultBuilder.succTMulti(urlResponses);
    }

    private List<GoodsPromotionUrlResponse> getGoodsPromotionUrlResponses(GoodsPromotionUrlGenerateResult result) {
        List<GoodsPromotionUrlResponse> urlResponses = null;
        if (result != null) {
            GoodsPromotionUrlGenerateResult.GoodsPromotionUrlGenerateResponseBean responseBean = result
                    .getGoods_promotion_url_generate_response();
            if (responseBean != null) {
                List<GoodsPromotionUrlGenerateResult.GoodsPromotionUrlGenerateResponseBean.GoodsPromotionUrlListBean> beanList = responseBean
                        .getGoods_promotion_url_list();
                if (!CollectionUtils.isEmpty(beanList)) {
                    urlResponses = beanList.stream().map(i -> {
                        GoodsPromotionUrlResponse urlResponse = new GoodsPromotionUrlResponse();
                        GoodsPromotionUrlGenerateResult.GoodsPromotionUrlGenerateResponseBean.GoodsPromotionUrlWeAPPBean we_app_info = i
                                .getWe_app_info();
                        if (we_app_info != null) {
                            urlResponse.setApp_id(we_app_info.getApp_id());
                            urlResponse.setPage_path(we_app_info.getPage_path());
                        }
                        urlResponse.setShort_url(i.getShort_url());
                        urlResponse.setUrl(i.getUrl());
                        return urlResponse;
                    }).collect(Collectors.toList());
                }
            }
        }
        return urlResponses;
    }

    @Override
    public TMultiResult<GoodsPromotionUrlResponse> convertResponse(String contentJson) {
        notBlank(contentJson, REQUEST_PARAMETER_ERROR);
        GoodsPromotionUrlGenerateResult result = JSONObject.parseObject(contentJson,
                GoodsPromotionUrlGenerateResult.class);
        List<GoodsPromotionUrlResponse> urlResponses = getGoodsPromotionUrlResponses(result);
        return ResultBuilder.succTMulti(urlResponses);
    }
}
