package com.fulihui.duoduoke.demo.web.weixin.duoapi.result;

import lombok.Data;

import java.util.List;

/**
 * Created by lizhi on 2018/7/6 0006.
 */
@Data
public class DuoGoodsRecommendResult extends DuoJsonResult {


    private List<DuoGoodsApiResult> list;

    private String total;


}
