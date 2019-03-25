package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Data;

import java.util.List;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
@Data
public class DuoGoodsResult extends DuoJsonResult {


    private List<DuoGoodsApiResult> goods_list;

    private String total_count;

}
