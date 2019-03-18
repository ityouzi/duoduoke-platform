package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import java.util.List;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoGoodsResult extends DuoJsonResult {


    private List<DuoGoodsApiResult> goods_list;

    private String total_count;

    public List<DuoGoodsApiResult> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<DuoGoodsApiResult> goods_list) {
        this.goods_list = goods_list;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }
}
