package com.fulihui.duoduoke.demo.web.weixin.duoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsRecommendResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import lombok.Data;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/14 0014 17:11
 */
@Data
public class DuoGoodsRecommendRequest extends DuoJsonRequest<DuoGoodsRecommendResult> {

    private int offset;

    private int limit;

    private int channel_type;


    @Override
    protected void childParam() {
        addParam("offset", offset + "");
        addParam("limit", limit + "");
        addParam("channel_type", channel_type + "");
    }

    @Override
    public String service() {
        return "http://gw-api.pinduoduo.com/api/router";
    }

    @Override
    public String urlEndStr() {
        return null;
    }

    @Override
    public DuoGoodsRecommendResult parseResult(String respStr) {
        DuoGoodsRecommendResult result;
        JSONObject jsonObject = JSONObject.parseObject(respStr);
        JSONObject personObject = jsonObject.getJSONObject("goods_basic_detail_response");
        if (personObject == null) {
            JSONObject errorObject = jsonObject.getJSONObject("error_response");
            result = JSON.parseObject(errorObject.toString(), DuoGoodsRecommendResult.class);
            return result;
        } else {
            result = JSON.parseObject(personObject.toString(), DuoGoodsRecommendResult.class);
            checkResult(result);
            return result;
        }
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }

    @Override
    public String requestData() {
        return null;
    }
}
