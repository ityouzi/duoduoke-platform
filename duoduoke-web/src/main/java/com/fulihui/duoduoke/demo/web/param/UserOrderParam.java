package com.fulihui.duoduoke.demo.web.param;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@Getter
@Setter
public class UserOrderParam extends FormIdParam {

    private static final long serialVersionUID = 1836964971192762164L;
    /**
     * user_order_info.user_order_status
     *
     * @see com.fulihui.duoduoke.demo.producer.facade.enums.UserOrderStatusEnum
     * 用户订单状态
     */
    private String orderStatus;

    private String orderSn;
}
