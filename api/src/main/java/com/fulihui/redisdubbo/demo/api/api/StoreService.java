package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.dto.StoreDTO;
import com.fulihui.redisdubbo.demo.api.dto.StoreGoodsDTO;
import com.fulihui.redisdubbo.demo.api.request.AddStoreGoodsRequest;
import com.fulihui.redisdubbo.demo.api.request.AddStoreRequest;
import com.fulihui.redisdubbo.demo.api.request.StoreListRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TPageResult;

import java.util.List;

public interface StoreService {
    TPageResult<StoreDTO> list(StoreListRequest storeListRequest);

    BaseResult addStore(AddStoreRequest addStoreRequest);

    BaseResult editStore(AddStoreRequest addStoreRequest);

    StoreDTO get(String id);

    List<StoreDTO> getGoingStoreList();

    List<StoreGoodsDTO> getStoreGoodsList(String id);

    BaseResult addStoreGoods(AddStoreGoodsRequest addStoreRequest);

    StoreGoodsDTO getGoods(String id);

    BaseResult updateStoreGoods(StoreGoodsDTO storeGoodsDTO);
}
