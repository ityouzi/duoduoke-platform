package com.fulihui.duoduoke.demo.web.weixin.duoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsDetailResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: pdd.ddk.goods.search（多多进宝商品查询）
 * @Author: xiaoming
 * @version: v 0.1 2018/7/7 0007 13:54
 */
@Setter
@Getter
public class DuoGoodsDetailRequest extends DuoJsonRequest<DuoGoodsDetailResult> {

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
    public DuoGoodsDetailResult parseResult(String respStr) {
        DuoGoodsDetailResult result;
        JSONObject jsonObject = JSONObject.parseObject(respStr);
        JSONObject personObject = jsonObject.getJSONObject("goods_detail_response");
        if (personObject == null) {
            JSONObject errorObject = jsonObject.getJSONObject("error_response");
            result = JSON.parseObject(errorObject.toString(), DuoGoodsDetailResult.class);
            return result;
        } else {
            result = JSON.parseObject(personObject.toString(), DuoGoodsDetailResult.class);
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
