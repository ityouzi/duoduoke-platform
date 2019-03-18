package com.fulihui.duoduoke.demo.web.manager.impl;


import com.fulihui.duoduoke.demo.api.api.GoodsInfoService;
import com.fulihui.duoduoke.demo.api.api.StoreGoodsService;
import com.fulihui.duoduoke.demo.api.api.StoreService;
import com.fulihui.duoduoke.demo.api.dto.GoodsInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.StoreDTO;
import com.fulihui.duoduoke.demo.api.dto.StoreGoodsDTO;
import com.fulihui.duoduoke.demo.api.request.GetGoingStoreGoodsRequest;
import com.fulihui.duoduoke.demo.api.request.GetStoreGoodsRequest;
import com.fulihui.duoduoke.demo.web.manager.GoodsInfoManager;
import com.fulihui.duoduoke.demo.web.manager.StoreManager;
import com.fulihui.duoduoke.demo.web.vo.GoodsInfo;
import com.fulihui.duoduoke.demo.web.vo.StoreInfoVo;
import com.fulihui.duoduoke.demo.web.vo.StoreVo;
import org.near.servicesupport.result.TPageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreManagerImpl implements StoreManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreManagerImpl.class);

    @org.apache.dubbo.config.annotation.Reference
    StoreService storeService;
    @org.apache.dubbo.config.annotation.Reference
    StoreGoodsService storeGoodsService;
    @org.apache.dubbo.config.annotation.Reference
    GoodsInfoService goodsInfoService;
    @Autowired
    GoodsInfoManager goodsInfoManager;

    @Override
    public List<StoreVo> getList(){
        List<StoreDTO> list=storeService.getGoingStoreList();
        List<StoreVo> array=new ArrayList<>();
        for (StoreDTO storeDTO : list) {
            StoreVo storeVo=new StoreVo();
            storeVo.setId(storeDTO.getId());
            storeVo.setPreferenceNumber(storeDTO.getPreferenceNumber());
            //给优选图
            storeVo.setStoreUrl(storeDTO.getPreferenceUrl());
            array.add(storeVo);
        }
        return array;
    }

    @Override
    public StoreInfoVo getInfo(GetGoingStoreGoodsRequest storeGoodsParam) {
        StoreDTO storeDTO=storeService.get(storeGoodsParam.getId());
        if(storeDTO==null) {
            return null;
        }
        //获得商品列表信息
        TPageResult<StoreGoodsDTO> tPageResult =storeGoodsService.getGoingStoreGoods(storeGoodsParam);

        List<Long> goodsIds=new ArrayList<>();
        for (StoreGoodsDTO storeGoodsDTO : tPageResult.getValues()) {
            goodsIds.add(storeGoodsDTO.getGoodsId());
        }
        GetStoreGoodsRequest getStoreGoodsRequest=new GetStoreGoodsRequest();

        getStoreGoodsRequest.setGoodsIds(goodsIds);
        List<GoodsInfoDTO> goodsInfoDTOS=goodsInfoService.getList(getStoreGoodsRequest);
        List<GoodsInfo> voList = goodsInfoManager.toVOList(goodsInfoDTOS);
        List<GoodsInfo> list=new ArrayList<>();
        //排序
        for(int i=0;i<=tPageResult.getValues().size()-1;i++){
            StoreGoodsDTO storeGoodsDTO=tPageResult.getValues().get(i);
            for (GoodsInfo goodsInfo : voList) {
                if(storeGoodsDTO.getGoodsId().equals(goodsInfo.getGoodsId())){
                    list.add(goodsInfo);
                    break;
                }
            }
        }
        StoreInfoVo storeInfoVo=new StoreInfoVo();
        BeanUtils.copyProperties(storeDTO,storeInfoVo);
        storeInfoVo.setGoodsInfoList(list);
        storeInfoVo.setRows(tPageResult.getRows());
        storeInfoVo.setTotalRows(tPageResult.getTotalRows());
        storeInfoVo.setPage(tPageResult.getPage());
        return storeInfoVo;
    }

}
