package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Setter @Getter
public class OrderInfoRequest extends PageRequest {
    private static final long serialVersionUID = -3977055498626045338L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * user_order_info.user_order_status
     *
     * @see com.fulihui.duoduoke.demo.producer.facade.enums.UserOrderStatusEnum
     * 用户订单状态
     */
    private List<String> userOrderStatus;


    /**
     * user_order_info.user_order_status
     *
     * @see com.fulihui.duoduoke.demo.producer.facade.enums.DuoDuoOrderStatusEnum
     * 多多客订单状态
     */
    private List<String> orderStatus;

    /**
     * 下单开始时间
     */
    private Date startOrderCreateTime;

    /**
     * 下单结束时间
     */
    private Date endOrderCreateTime;

}
