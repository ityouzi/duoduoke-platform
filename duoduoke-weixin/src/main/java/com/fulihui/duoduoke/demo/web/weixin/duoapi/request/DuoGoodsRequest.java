package com.fulihui.duoduoke.demo.web.weixin.duoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoapi.result.DuoGoodsResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;
import lombok.Data;

/**
 * @Description: pdd.ddk.goods.search（多多进宝商品查询）
 * @Author: xiaoming
 * @version: v 0.1 2018/7/7 0007 13:54
 */
@Data
public class DuoGoodsRequest extends DuoJsonRequest<DuoGoodsResult> {

    private String keyword;

    private String cat_id;

    private Integer page;

    private Integer page_size;

    private int sort_type = 0;

    private boolean with_coupon;

    private String range_list;

    private String goods_id_list;


    @Override
    protected void childParam() {

        addParam("keyword", keyword);
        addParam("cat_id", cat_id);
        if (page != null) {
            addParam("page", page + "");
        }
        if (page_size != null) {
            addParam("page_size", page_size + "");
        }
        addParam("sort_type", sort_type + "");
        addParam("with_coupon", with_coupon + "");
        addParam("range_list", range_list);
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
    public DuoGoodsResult parseResult(String respStr) {
        DuoGoodsResult result;
        JSONObject jsonObject = JSONObject.parseObject(respStr);
        JSONObject personObject = jsonObject.getJSONObject("goods_search_response");
        if (personObject == null) {
            JSONObject errorObject = jsonObject.getJSONObject("error_response");
            result = JSON.parseObject(errorObject.toString(), DuoGoodsResult.class);
            return result;
        } else {
            result = JSON.parseObject(personObject.toString(), DuoGoodsResult.class);
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
