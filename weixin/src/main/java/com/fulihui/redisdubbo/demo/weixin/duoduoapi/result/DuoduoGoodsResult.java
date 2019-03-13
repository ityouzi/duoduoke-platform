package com.fulihui.redisdubbo.demo.weixin.duoduoapi.result;

import java.util.List;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoduoGoodsResult extends DuoduoJsonResult{


    private List<DuoduoGoodsApiResult> goods_list;

    private String total_count;

    public List<DuoduoGoodsApiResult> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<DuoduoGoodsApiResult> goods_list) {
        this.goods_list = goods_list;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }
}
