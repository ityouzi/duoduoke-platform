package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result.DuoGoodsResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.http.HttpMethodEnum;

/**
     * @Description: pdd.ddk.goods.search（多多进宝商品查询）
 * @Author: xiaoming
 * @version: v 0.1 2018/7/7 0007 13:54
 */
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
        if(page != null) {
            addParam("page", page + "");
        }
        if(page_size != null) {
            addParam("page_size", page_size + "");
        }
        addParam("sort_type", sort_type+"");
        addParam("with_coupon",with_coupon+"");
        addParam("range_list",range_list);
        addParam("goods_id_list",goods_id_list);
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
        if(personObject == null){
            JSONObject errorObject = jsonObject.getJSONObject("error_response");
            result = JSON.parseObject(errorObject.toString(), DuoGoodsResult.class);
            return result;
        }else {
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public int getSort_type() {
        return sort_type;
    }

    public void setSort_type(int sort_type) {
        this.sort_type = sort_type;
    }

    public boolean isWith_coupon() {
        return with_coupon;
    }

    public void setWith_coupon(boolean with_coupon) {
        this.with_coupon = with_coupon;
    }

    /**
     * Getter method for property <tt>range_list</tt>
     *
     * @return property value of range_list
     */
    public String getRange_list() {
        return range_list;
    }

    /**
     * Setter method for property <tt>range_list</tt>.
     *
     * @param range_list value to be assigned to property range_list
     */
    public void setRange_list(String range_list) {
        this.range_list = range_list;
    }

    /**
     * Getter method for property <tt>goods_id_list</tt>
     *
     * @return property value of goods_id_list
     */
    public String getGoods_id_list() {
        return goods_id_list;
    }

    /**
     * Setter method for property <tt>goods_id_list</tt>.
     *
     * @param goods_id_list value to be assigned to property goods_id_list
     */
    public void setGoods_id_list(String goods_id_list) {
        this.goods_id_list = goods_id_list;
    }
}
