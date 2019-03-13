package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.api.dto.StoreGoodsDTO;
import com.fulihui.redisdubbo.demo.api.request.GetGoingStoreGoodsRequest;

import java.util.List;

public interface ExtStoreGoodsMapper {


    List<StoreGoodsDTO> getGoingStoreGoods(GetGoingStoreGoodsRequest getGoingStoreGoodsRequest);

    Integer getGoingStoreGoodsSum(GetGoingStoreGoodsRequest getGoingStoreGoodsRequest1);

    List<StoreGoodsDTO> getStoreGoodsList(String id);
}
