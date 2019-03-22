package com.fulihui.duoduoke.demo.web.manager.impl;


import com.fulihui.duoduoke.demo.api.api.StoreService;
import com.fulihui.duoduoke.demo.api.dto.StoreDTO;
import com.fulihui.duoduoke.demo.web.manager.StoreManager;
import com.fulihui.duoduoke.demo.web.vo.StoreVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreManagerImpl implements StoreManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreManagerImpl.class);

    @org.apache.dubbo.config.annotation.Reference
    StoreService storeService;


    @Override
    public List<StoreVo> getList() {
        List<StoreDTO> list = storeService.getGoingStoreList();
        List<StoreVo> array = new ArrayList<>();
        for (StoreDTO storeDTO : list) {
            StoreVo storeVo = new StoreVo();
            storeVo.setId(storeDTO.getId());
            storeVo.setPreferenceNumber(storeDTO.getPreferenceNumber());
            //给优选图
            storeVo.setStoreUrl(storeDTO.getPreferenceUrl());
            array.add(storeVo);
        }
        return array;
    }


}
