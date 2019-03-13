package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.PageRequest;

@Getter
@Setter
public class GetGoingStoreGoodsRequest extends PageRequest{
    private String id;
}
