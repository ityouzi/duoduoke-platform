package com.fulihui.redisdubbo.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-7-9
 */
@Getter
@Setter
public class CustomParameters extends ToString {
    private static final long serialVersionUID = 8056086668572650799L;
    /**
     * 订单用户Id
     */
    private String            userId;
    /**
     * 订单推荐人
     */
    private String            OrderUserReferee;
    /**
     * 推广渠道
     */
    private String            channelsCode;
    /**
     * 订单来源
     */
    private String            orderSource;

}
