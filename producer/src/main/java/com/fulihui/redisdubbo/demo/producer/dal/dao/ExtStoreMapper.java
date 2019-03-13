package com.fulihui.redisdubbo.demo.producer.dal.dao;


import com.fulihui.redisdubbo.demo.api.dto.StoreDTO;
import com.fulihui.redisdubbo.demo.api.request.StoreListRequest;

import java.util.Date;
import java.util.List;

public interface ExtStoreMapper {

    List<StoreDTO> list(StoreListRequest storeListRequest);

    Integer listSum(StoreListRequest storeListRequest1);

    StoreDTO get(String id);

    List<StoreDTO> getGoingStoreList(Date now);
}