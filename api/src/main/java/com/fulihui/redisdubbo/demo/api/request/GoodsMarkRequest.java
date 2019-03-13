package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

import java.util.Date;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/19 0019 14:15
 */
@Getter
@Setter
public class GoodsMarkRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = 2173208572370352221L;

    private Integer id;

    private Long goodsId;


    private Date startTimeLessThanOrEqualTo;

    private Date stopTimeGreaterThanOrEqualTo;
}
