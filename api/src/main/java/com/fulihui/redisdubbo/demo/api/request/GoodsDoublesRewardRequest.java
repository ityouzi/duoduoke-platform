package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

import java.util.Date;

@Getter
@Setter
public class GoodsDoublesRewardRequest  extends AbstractServiceRequest {
    private Long goodsId;
    private Date doubleDate;
    private String state;


}
