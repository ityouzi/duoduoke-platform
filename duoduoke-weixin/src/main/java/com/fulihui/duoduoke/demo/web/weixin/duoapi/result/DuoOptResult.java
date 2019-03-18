package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import java.util.List;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoOptResult extends DuoJsonResult {


    private List<DuoOptApiResult> goods_opt_list;

    public List<DuoOptApiResult> getGoods_opt_list() {
        return goods_opt_list;
    }

    public void setGoods_opt_list(List<DuoOptApiResult> goods_opt_list) {
        this.goods_opt_list = goods_opt_list;
    }
}
