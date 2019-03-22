package com.fulihui.duoduoke.demo.api.response;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-9
 */
@Setter
@Getter
public class GoodsSearchInfoResponse extends ToString {

    private static final long serialVersionUID = -508087926394729238L;
    private String goodsId;


    private String goodsName;


    private String goodsDesc;


    private String goodsThumbnailUrl;

    private String goodsImageUrl;

    private String goodsGalleryUrls;

    private Integer soldQuantity;

    private Integer minGroupPrice;

    private Integer minNormalPrice;

    private String mallName;

    private Integer categoryId;

    private String categoryName;

    private boolean hasCoupon;

    private Integer couponMinOrderAmount;

    private Integer couponDiscount;

    private Integer couponTotalQuantity;

    private Integer couponRemainQuantity;

    private String couponStartTime;

    private String couponEndTime;

    private Integer promotionRate;

    private Integer goodsEvalScore;

    private Integer goodsEvalCount;

    private Integer catId;

    private Integer avgDesc;

    private Integer avgLgst;

    private Integer avgServ;

}
