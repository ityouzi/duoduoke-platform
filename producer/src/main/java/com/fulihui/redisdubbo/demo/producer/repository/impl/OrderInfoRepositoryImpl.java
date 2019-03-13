package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.api.dto.OrderInfoDTO;
import com.fulihui.redisdubbo.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtOrderInfoMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dao.OrderInfoMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.GroupChannelsOrder;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfoExample;
import com.fulihui.redisdubbo.demo.producer.repository.OrderInfoRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lizhi on 2018-7-10.
 */
@Repository
public class OrderInfoRepositoryImpl implements OrderInfoRepository {
    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    ExtOrderInfoMapper extOrderInfoMapper;

    @Override
    public List<GroupChannelsOrderDTO> queryGroup(int start, int rows, Date startDate, Date endDate,
                                                  String promoType, List<String> orderStatusList,
                                                  List<String> userOrderStatusList) {

        List<GroupChannelsOrder> list = extOrderInfoMapper.queryGroup(start, rows, startDate,
                endDate, promoType, orderStatusList, userOrderStatusList);

        return xxx(list);
    }

    private List<GroupChannelsOrderDTO> xxx(List<GroupChannelsOrder> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }

        return list.stream().map(item -> {
            GroupChannelsOrderDTO dto = new GroupChannelsOrderDTO();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public int queryGroupCount(Date startDate, Date endDate, String promoType,
                               List<String> orderStatusList, List<String> userOrderStatusList) {
        return extOrderInfoMapper.queryGroupCount(startDate, endDate, promoType, orderStatusList,
                userOrderStatusList);
    }

    @Override
    public List<Integer> queryGroupCountExt(Date startDate, Date endDate, String promoType,
                                            List<String> orderStatusList,
                                            List<String> userOrderStatusList) {
        return extOrderInfoMapper.queryGroupCountExt(startDate, endDate, promoType, orderStatusList,
                userOrderStatusList);
    }

    @Override
    public List<GroupChannelsOrderDTO> queryGroupExt(Date startDate, Date endDate, String promoType,
                                                     List<String> orderStatusList,
                                                     List<String> userOrderStatusList) {
        List<GroupChannelsOrder> list = extOrderInfoMapper.queryGroupExt(startDate, endDate,
                promoType, orderStatusList, userOrderStatusList);
        return xxx(list);
    }

    @Override
    public int insert(OrderInfo info) {
        Assert.notNull(info, "info is not null");
        info.setGmtCreate(new Date());
        info.setGmtModified(new Date());
        return orderInfoMapper.insertSelective(info);
    }

    @Override
    public List<OrderInfo> query(String orderSn, String orderStatus) {
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andOrderSnEqualTo(orderSn).andOrderStatusEqualTo(orderStatus);
        return orderInfoMapper.selectByExample(example);
    }

    @Override
    public boolean update(OrderInfo record) {
        Assert.notNull(record, "info is not null");
        record.setGmtModified(new Date());
        return orderInfoMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public int updateByExampleSelective(OrderInfo record, OrderInfoExample example) {
        return orderInfoMapper.updateByExampleSelective(record, example);

    }

    @Override
    public List<OrderInfo> queryByOrderSn(String orderSn) {

        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andOrderSnEqualTo(orderSn);
        return orderInfoMapper.selectByExample(example);

    }

    @Override
    public List<OrderInfo> queryByOrderSn(String orderSn, String userId) {
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andOrderSnEqualTo(orderSn).andCustomParametersEqualTo(userId);
        return orderInfoMapper.selectByExample(example);
    }

    @Override
    public List<OrderInfoDTO> query(OrderInfoExample example) {
        List<OrderInfo> list = orderInfoMapper.selectByExample(example);

        return convert(list);
    }

    private List<OrderInfoDTO> convert(List<OrderInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(item -> {
            OrderInfoDTO infoDTO = new OrderInfoDTO();
            BeanUtils.copyProperties(item, infoDTO);
            return infoDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public long count(OrderInfoExample example) {
        return orderInfoMapper.countByExample(example);
    }

    @Override
    public List<OrderInfoDTO> queryOrderExceedDay(String orderStatus, String userOrderStatus,
                                                  String promoType, int start, int rows) {
        List<OrderInfo> list = extOrderInfoMapper.queryOrderExceedDay(orderStatus, userOrderStatus,
                promoType, start, rows);
        return convert(list);
    }

    @Override
    public int queryOrderExceedDayCount(String orderStatus, String userOrderStatus,
                                        String promoType) {
        return extOrderInfoMapper.queryOrderExceedDayCount(orderStatus, userOrderStatus, promoType);
    }

}
