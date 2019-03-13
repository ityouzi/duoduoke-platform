package com.fulihui.redisdubbo.demo.weixin.duoduoapi.result;

import java.util.List;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
public class DuoduoOptResult extends DuoduoJsonResult{


    private List<DuoduoOptApiResult> goods_opt_list;

    public List<DuoduoOptApiResult> getGoods_opt_list() {
        return goods_opt_list;
    }

    public void setGoods_opt_list(List<DuoduoOptApiResult> goods_opt_list) {
        this.goods_opt_list = goods_opt_list;
    }
}
