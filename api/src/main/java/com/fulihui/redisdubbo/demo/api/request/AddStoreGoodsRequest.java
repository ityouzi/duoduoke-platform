package com.fulihui.redisdubbo.demo.api.request;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

@Setter
@Getter
public class AddStoreGoodsRequest extends ToString {
    private String goodsIds;
    private String storeId;
    private String[] goodsArr;
}
