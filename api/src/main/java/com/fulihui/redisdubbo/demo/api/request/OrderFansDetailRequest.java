package com.fulihui.redisdubbo.demo.api.request;


import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-8-1
 */
@Setter
@Getter
public class OrderFansDetailRequest extends PageRequest {
    private static final long serialVersionUID = 3579647290233975594L;


    private String pUserId;


    private List<String> orderStatus;

    private String fansType;

    private Integer level;
    /**
     * 排序字段
     */
    private String sortInfo;
    /**
     * 返利金额
     */
    private Integer fansAmount;
}
