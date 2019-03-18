package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import java.util.List;

/**
 *
 * @author lizhi
 * @date 2018/7/6 0006
 */
public class DuoCatResult extends DuoJsonResult {


    private static final long serialVersionUID = -1639418036432904906L;
    private List<DuoCatApiResult> goods_cats_list;

    public List<DuoCatApiResult> getGoods_cats_list() {
        return goods_cats_list;
    }

    public void setGoods_cats_list(List<DuoCatApiResult> goods_cats_list) {
        this.goods_cats_list = goods_cats_list;
    }
}
