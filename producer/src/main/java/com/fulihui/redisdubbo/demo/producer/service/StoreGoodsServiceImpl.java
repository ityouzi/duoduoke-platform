package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.StoreGoodsService;
import com.fulihui.redisdubbo.demo.api.dto.StoreGoodsDTO;
import com.fulihui.redisdubbo.demo.api.request.GetGoingStoreGoodsRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtStoreGoodsMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dao.StoreGoodsMapper;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service(version = "${demo.service.version}")

public class StoreGoodsServiceImpl implements StoreGoodsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreGoodsServiceImpl.class);

    @Autowired
    StoreGoodsMapper storeGoodsMapper;
    @Autowired
    ExtStoreGoodsMapper extStoreGoodsMapper;

    @Override
    public TPageResult<StoreGoodsDTO> getGoingStoreGoods(GetGoingStoreGoodsRequest getGoingStoreGoodsRequest) {
        GetGoingStoreGoodsRequest getGoingStoreGoodsRequest1 = new GetGoingStoreGoodsRequest();
        BeanUtils.copyProperties(getGoingStoreGoodsRequest, getGoingStoreGoodsRequest1);
        getGoingStoreGoodsRequest1.setPage((getGoingStoreGoodsRequest.getPage() - 1)
                * getGoingStoreGoodsRequest.getRows());
        getGoingStoreGoodsRequest1.setRows(
                getGoingStoreGoodsRequest.getRows());
        List<StoreGoodsDTO> list = extStoreGoodsMapper.getGoingStoreGoods(getGoingStoreGoodsRequest1);
        int sum = extStoreGoodsMapper.getGoingStoreGoodsSum(getGoingStoreGoodsRequest1);
        return ResultBuilder.succTPage(list, getGoingStoreGoodsRequest.getPage(), getGoingStoreGoodsRequest.getRows(), sum);
    }
}
