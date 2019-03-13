package com.fulihui.duoduoke.demo.web.param;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lizhi
 * @date 2018-7-8
 */
@Setter
@Getter
public class GoodsPromotionGenerateParam extends FormIdParam {
    private static final long serialVersionUID = -5011869784209847386L;
    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 推广位id
     */
    private String pid;
    /**
     * 分享者id
     */
    private String shareId;
}
