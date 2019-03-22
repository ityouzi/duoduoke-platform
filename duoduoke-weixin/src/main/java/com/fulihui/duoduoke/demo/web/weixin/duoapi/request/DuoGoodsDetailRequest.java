package com.fulihui.duoduoke.demo.web.weixin.duoapi.request;

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
        DuoGoodsDetailResult result = JSONObject.parseObject(respStr,
                DuoGoodsDetailResult.class);
        checkResult(result);
        return result;
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
