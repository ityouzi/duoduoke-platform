package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.dto.StoreDTO;
import com.fulihui.duoduoke.demo.api.dto.StoreGoodsDTO;
import com.fulihui.duoduoke.demo.api.request.AddStoreGoodsRequest;
import com.fulihui.duoduoke.demo.api.request.AddStoreRequest;
import com.fulihui.duoduoke.demo.api.request.StoreListRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TPageResult;

import java.util.List;

/**
 * @author wahaha
 */
public interface StoreService {
    TPageResult<StoreDTO> list(StoreListRequest request);

    BaseResult addStore(AddStoreRequest request);

    BaseResult editStore(AddStoreRequest request);

    StoreDTO get(String id);

    List<StoreDTO> getGoingStoreList();

    List<StoreGoodsDTO> getStoreGoodsList(String id);

    BaseResult addStoreGoods(AddStoreGoodsRequest request);

    StoreGoodsDTO getGoods(String id);

    BaseResult updateStoreGoods(StoreGoodsDTO storeGoodsDTO);
}
