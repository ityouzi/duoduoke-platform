package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.StoreService;
import com.fulihui.duoduoke.demo.api.dto.StoreDTO;
import com.fulihui.duoduoke.demo.api.dto.StoreGoodsDTO;
import com.fulihui.duoduoke.demo.api.request.AddStoreGoodsRequest;
import com.fulihui.duoduoke.demo.api.request.AddStoreRequest;
import com.fulihui.duoduoke.demo.api.request.StoreListRequest;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtStoreMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.StoreMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.Store;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.StoreExample;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service(version = "${demo.service.version}")
public class StoreServiceImpl implements StoreService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    StoreMapper storeMapper;

    @Autowired
    ExtStoreMapper extStoreMapper;

    @Override
    public TPageResult<StoreDTO> list(StoreListRequest request) {
        StoreExample example = new StoreExample();
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());
        StoreExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(request.getStoreName())) {
            criteria.andStoreNameLike(request.getStoreName());
        }
        List<StoreDTO> list = getStores(example);
        int count = 0;
        if (!CollectionUtils.isEmpty(list)) {
            count = (int) storeMapper.countByExample(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), count);
    }

    private List<StoreDTO> getStores(StoreExample example) {
        List<Store> stores = storeMapper.selectByExample(example);

        return convert(stores);
    }

    private List<StoreDTO> convert(List<Store> stores) {
        if (CollectionUtils.isEmpty(stores)) {
            return Collections.emptyList();
        }

        return stores.stream().map(item -> {
            StoreDTO dto = new StoreDTO();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public BaseResult addStore(AddStoreRequest addStoreRequest) {
        return null;
    }

    @Override
    public BaseResult editStore(AddStoreRequest addStoreRequest) {
        return null;
    }

    @Override
    public StoreDTO get(String id) {
        return null;
    }

    @Override
    public List<StoreDTO> getGoingStoreList() {
        List<Store> storeList = extStoreMapper.getGoingStoreList(new Date());
        return convert(storeList);
    }

    @Override
    public List<StoreGoodsDTO> getStoreGoodsList(String id) {
        return null;
    }

    @Override
    public BaseResult addStoreGoods(AddStoreGoodsRequest addStoreRequest) {
        return null;
    }

    @Override
    public StoreGoodsDTO getGoods(String id) {
        return null;
    }

    @Override
    public BaseResult updateStoreGoods(StoreGoodsDTO storeGoodsDTO) {
        return null;
    }
}
