package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Setter
@Getter
public class OrderQueryInfoRequest extends OrderInfoRequest {
    private static final long serialVersionUID = -2222225797966349206L;

    /**
     * 订单号
     */
    private String            orderSn;
    /**
     * gmt_create desc
     */
    private String            sortInfo;
    /**
     * userId
     */
    private String            userId;

    private String            helpStatus;

    /**
     * 开始时间
     */
    private Date              startGmtCreateTime;

    /**
     * 结束时间
     */
    private Date              endGmtCreateTime;
    /**
     * 订单类型
     */
    private String            orderType;

    private String            pId;
    /**
     * order_info.promo_type
     * 订单推广方式类型
     *
     * @mbg.generated 2019-01-16 17:34:06
     */
    private String            promoType;
    private Date              startOrderPayDate;
    private Date              endOrderPayDate;
    private String            channelsCode;

    private Date              orderPayDateExt;

    private Date              startDateModify;

    private Date              endDateModify;

    private Date              orderModifyAtExt;

}
