package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;

@Setter @Getter
public class DuoduoGoodsInfoUpdateRequest extends PageRequest {
    private static final long serialVersionUID = -4254698836990658501L;

    /**
     * coupon_end_time <=
     */
    private Date couponEndTimeLessThanOrEqualTo;

    /**
     * coupon_start_time <=
     */
    private Date CouponStartTimeLessThanOrEqualTo;

    /**
    *
    *
    * duoduo_goods_info.state
     * 上下架状态
     *
     * @mbg.generated GoodsStateEnum
     */
    private String state;

    private String stateOld;




}