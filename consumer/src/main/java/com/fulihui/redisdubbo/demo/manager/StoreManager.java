package com.fulihui.redisdubbo.demo.manager;


import com.fulihui.redisdubbo.demo.api.request.GetGoingStoreGoodsRequest;
import com.fulihui.redisdubbo.demo.vo.StoreInfoVo;
import com.fulihui.redisdubbo.demo.vo.StoreVo;

import java.util.List;

public interface StoreManager {
    List<StoreVo> getList();

    StoreInfoVo getInfo(GetGoingStoreGoodsRequest storeGoodsParam);
}
