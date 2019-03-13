package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

/**
 * @author lizhi
 * @date 2018-8-27
 */
@Getter
@Setter
public class OrderInfoUpdateRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = 4533110621536950157L;

    private String userOrderStatus;

    private String userOrderStatusDesc;


    private String orderStatus;
    private String orderStatusDesc;
    private String userOrderStatusCondition;
    private String userOrderStatusDescCondition;

}
