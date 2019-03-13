package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.AddStoreGoodsRequest;
import com.fulihui.duoduoke.demo.api.request.AddStoreRequest;
import com.fulihui.duoduoke.demo.api.request.StoreListRequest;
import com.fulihui.duoduoke.demo.api.dto.StoreDTO;
import com.fulihui.duoduoke.demo.api.dto.StoreGoodsDTO;
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
