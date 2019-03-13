package com.fulihui.redisdubbo.demo.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.redisdubbo.demo.weixin.duoduoapi.result.DuoduoGoodsDetailResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.http.HttpMethodEnum;

/**
 * @Description: pdd.ddk.goods.search（多多进宝商品查询）
 * @Author: xiaoming
 * @version: v 0.1 2018/7/7 0007 13:54
 */
public class DuoduoGoodsDetailRequest extends DuoduoJsonRequest<DuoduoGoodsDetailResult> {

    private String goods_id_list;


    @Override
    protected void childParam() {
        addParam("goods_id_list", goods_id_list);
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
    public DuoduoGoodsDetailResult parseResult(String respStr) {
        DuoduoGoodsDetailResult result;
        JSONObject jsonObject = JSONObject.parseObject(respStr);
        JSONObject personObject = jsonObject.getJSONObject("goods_detail_response");
        if (personObject == null) {
            JSONObject errorObject = jsonObject.getJSONObject("error_response");
            result = JSON.parseObject(errorObject.toString(), DuoduoGoodsDetailResult.class);
            return result;
        } else {
            result = JSON.parseObject(personObject.toString(), DuoduoGoodsDetailResult.class);
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

    public String getGoods_id_list() {
        return goods_id_list;
    }

    public void setGoods_id_list(String goods_id_list) {
        this.goods_id_list = goods_id_list;
    }
}
