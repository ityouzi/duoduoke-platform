package com.fulihui.duoduoke.demo.producer.model;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;
import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * @author lizhi
 * @date 2018-8-17
 */
@Setter
@Getter
public class OrderSendPushModel extends ToString {

    private static final long serialVersionUID = -7709625194970308530L;
    private OrderInfo info;
    private Long promoAmount;
}
