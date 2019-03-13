package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.UserFansDetailService;
import com.fulihui.redisdubbo.demo.api.dto.UserFansDetailDTO;
import com.fulihui.redisdubbo.demo.api.request.OrderFansDetailRequest;
import com.fulihui.redisdubbo.demo.api.request.UserFansDetailRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtOrderFansDetailMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderFansDetailExample;
import com.fulihui.redisdubbo.demo.producer.repository.OrderFansDetailRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserFansDetailRepository;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author lizhi
 * @date 2018-8-1
 */
@Service(version = "${demo.service.version}")

public class UserFansDetailServiceImpl implements UserFansDetailService {
    @Autowired
    UserFansDetailRepository userFansDetailRepository;
    @Autowired
    OrderFansDetailRepository orderFansDetailRepository;

    @Autowired
    ExtOrderFansDetailMapper extOrderFansDetailMapper;

    @Override
    public TMultiResult<UserFansDetailDTO> query(UserFansDetailRequest request) {


        List<UserFansDetailDTO> list = userFansDetailRepository.query(request.getUserId(), request.getStatisticsDate());
        return ResultBuilder.succTMulti(list);
    }

    @Override
    public TSingleResult<UserFansDetailDTO> querySumByUserId(UserFansDetailRequest request) {
        List<UserFansDetailDTO> list = userFansDetailRepository.querySumByUserId(request.getUserId(), request.getGmtCreate());
        if (!CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTSingle(list.get(0));
        }
        return ResultBuilder.succTSingle(null);
    }

    @Override
    public TSingleResult<Long> querySumAmount(OrderFansDetailRequest request) {

        long sumAmount = extOrderFansDetailMapper.querySum(request.getPUserId(), request.getOrderStatus().get(0));
        return ResultBuilder.succTSingle(sumAmount);
    }

    @Override
    public TSingleResult<Long> queryOrderNumCount(OrderFansDetailRequest request) {
        OrderFansDetailExample example = toExample(request);
        long count = orderFansDetailRepository.count(example);
        return ResultBuilder.succTSingle(count);
    }

    private OrderFansDetailExample toExample(OrderFansDetailRequest request) {
        OrderFansDetailExample example = new OrderFansDetailExample();
        OrderFansDetailExample.Criteria criteria = example.createCriteria();
        criteria.andPUserIdEqualTo(request.getPUserId());
        criteria.andOrderStatusIn(Lists.newArrayList(request.getOrderStatus()));
        return example;
    }

}
