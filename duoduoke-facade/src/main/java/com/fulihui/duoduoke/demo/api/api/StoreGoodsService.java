package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.GetGoingStoreGoodsRequest;
import com.fulihui.duoduoke.demo.api.dto.StoreGoodsDTO;
import org.near.servicesupport.result.TPageResult;

public interface StoreGoodsService {

    TPageResult<StoreGoodsDTO> getGoingStoreGoods(GetGoingStoreGoodsRequest getGoingStoreGoodsRequest);
}
