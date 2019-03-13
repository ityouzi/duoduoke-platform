package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GoodsDoubleRewardJobRequest extends AbstractServiceRequest {
    private String state;
    private Date now;
    private List<String> ids;
}
