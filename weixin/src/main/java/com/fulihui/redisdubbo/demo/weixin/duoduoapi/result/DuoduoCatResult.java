package com.fulihui.redisdubbo.demo.weixin.duoduoapi.result;

import java.util.List;

/**
 *
 * @author lizhi
 * @date 2018/7/6 0006
 */
public class DuoduoCatResult extends DuoduoJsonResult{


    private static final long serialVersionUID = -1639418036432904906L;
    private List<DuoduoCatApiResult> goods_cats_list;

    public List<DuoduoCatApiResult> getGoods_cats_list() {
        return goods_cats_list;
    }

    public void setGoods_cats_list(List<DuoduoCatApiResult> goods_cats_list) {
        this.goods_cats_list = goods_cats_list;
    }
}
