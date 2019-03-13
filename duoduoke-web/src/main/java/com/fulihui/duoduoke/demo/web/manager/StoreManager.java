package com.fulihui.duoduoke.demo.web.manager;


import com.fulihui.duoduoke.demo.api.request.GetGoingStoreGoodsRequest;
import com.fulihui.duoduoke.demo.web.vo.StoreInfoVo;
import com.fulihui.duoduoke.demo.web.vo.StoreVo;

import java.util.List;

public interface StoreManager {
    List<StoreVo> getList();

    StoreInfoVo getInfo(GetGoingStoreGoodsRequest storeGoodsParam);
}
