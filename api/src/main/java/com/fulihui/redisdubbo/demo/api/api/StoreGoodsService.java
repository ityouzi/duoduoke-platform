package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.StoreGoodsDTO;
import com.fulihui.redisdubbo.demo.api.request.GetGoingStoreGoodsRequest;
import org.near.servicesupport.result.TPageResult;

public interface StoreGoodsService {

    TPageResult<StoreGoodsDTO> getGoingStoreGoods(GetGoingStoreGoodsRequest getGoingStoreGoodsRequest);
}
