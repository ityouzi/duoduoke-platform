package com.fulihui.duoduoke.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.servicesupport.request.AbstractServiceRequest;

import java.util.List;

@Getter
@Setter
public class GetStoreGoodsRequest extends AbstractServiceRequest {

    private List<Long> goodsIds;

}
