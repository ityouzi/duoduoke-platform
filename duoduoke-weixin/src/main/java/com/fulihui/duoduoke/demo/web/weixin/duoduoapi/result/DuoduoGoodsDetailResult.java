package com.fulihui.duoduoke.demo.web.weixin.duoduoapi.result;

import java.util.List;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoduoGoodsDetailResult extends DuoduoJsonResult{


    private List<DuoduoGoodsDetailApiResult> goods_details;

    private String total_count;

    public List<DuoduoGoodsDetailApiResult> getGoods_details() {
        return goods_details;
    }

    public void setGoods_details(List<DuoduoGoodsDetailApiResult> goods_details) {
        this.goods_details = goods_details;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }
}
