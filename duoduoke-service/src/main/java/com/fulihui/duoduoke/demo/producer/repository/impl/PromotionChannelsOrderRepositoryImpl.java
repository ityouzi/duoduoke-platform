package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsOrderExample;
import com.fulihui.duoduoke.demo.producer.repository.PromotionChannelsOrderRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtPromotionChannelsOrderMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.PromotionChannelsOrderMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GroupChannelsOrder;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsOrder;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.fulihui.duoduoke.demo.api.util.Collections.isEmpty;
import static java.util.Collections.emptyList;

/**
 * Created by lizhi on 2018-12-04.
 */
@Repository
public class PromotionChannelsOrderRepositoryImpl implements PromotionChannelsOrderRepository {
    @Autowired
    PromotionChannelsOrderMapper promotionChannelsOrderMapper;
    @Autowired
    ExtPromotionChannelsOrderMapper extPromotionChannelsOrderMapper;

    @Override
    public long countByExample(PromotionChannelsOrderExample example) {
        return promotionChannelsOrderMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insertSelective(PromotionChannelsOrder record) {
        record.setGmtModified(new Date());
        record.setGmtCreate(new Date());
        return promotionChannelsOrderMapper.insertSelective(record);
    }

    @Override
    public List<OrderInfoDTO> selectByExample(PromotionChannelsOrderExample example) {
        List<PromotionChannelsOrder> list = promotionChannelsOrderMapper.selectByExample(example);
        return convert(list);
    }

    @Override
    public OrderInfoDTO query(String orderSn, String channelsCode) {
        PromotionChannelsOrderExample example = new PromotionChannelsOrderExample();
        example.createCriteria().andChannelsCodeEqualTo(channelsCode).andOrderSnEqualTo(orderSn);
        List<PromotionChannelsOrder> list = promotionChannelsOrderMapper.selectByExample(example);
        if (isEmpty(list)) {
            return null;
        }
        return convert(list).get(0);
    }

    @Override
    public OrderInfoDTO query(String orderSn) {
        PromotionChannelsOrderExample example = new PromotionChannelsOrderExample();
        example.createCriteria().andOrderSnEqualTo(orderSn);
        List<PromotionChannelsOrder> list = promotionChannelsOrderMapper.selectByExample(example);
        if (isEmpty(list)) {
            return null;
        }
        return convert(list).get(0);
    }

    private List<OrderInfoDTO> convert(List<PromotionChannelsOrder> list) {
        if (CollectionUtils.isEmpty(list)) {
            return emptyList();
        }
        return list.stream().map(this::convert).collect(Collectors.toList());
    }

    private OrderInfoDTO convert(PromotionChannelsOrder item) {
        if (item == null) {
            return null;
        }
        OrderInfoDTO dto = new OrderInfoDTO();
        BeanUtils.copyProperties(item, dto);
        return dto;
    }

    @Override
    public PromotionChannelsOrder selectByPrimaryKey(Integer id) {
        return promotionChannelsOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(PromotionChannelsOrder record) {
        record.setGmtModified(new Date());
        return promotionChannelsOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<GroupChannelsOrderDTO> queryGroup(int start, int rows, String channelsCode,
                                                  Date startDate, Date endDate, String promoType,
                                                  List<String> orderStatusList,
                                                  List<String> userOrderStatusList,
                                                  Date startDateModify, Date endDateModify) {
        List<GroupChannelsOrder> list = extPromotionChannelsOrderMapper.queryGroup(start, rows, channelsCode,
                startDate, endDate, promoType, orderStatusList, userOrderStatusList, startDateModify, endDateModify);
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
    public int queryGroupCount(String channelsCode, Date startDate, Date endDate, String promoType,
                               List<String> orderStatusList, List<String> userOrderStatusList
            , Date startDateModify, Date endDateModify) {
        return extPromotionChannelsOrderMapper.queryGroupCount(channelsCode, startDate, endDate, promoType,
                orderStatusList, userOrderStatusList, startDateModify, endDateModify);
    }

    @Override
    public List<GroupChannelsOrderDTO> queryGroupModify(int start, int rows, String channelsCode, Date startDate, Date endDate, String promoType, List<String> orderStatusList, List<String> userOrderStatusList, Date startDateModify, Date endDateModify) {
        List<GroupChannelsOrder> list = extPromotionChannelsOrderMapper.queryGroupModify(start, rows, channelsCode,
                startDate, endDate, promoType, orderStatusList, userOrderStatusList, startDateModify, endDateModify);
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
    public int queryGroupCountModify(String channelsCode, Date startDate, Date endDate, String promoType, List<String> orderStatusList, List<String> userOrderStatusList, Date startDateModify, Date endDateModify) {
        return extPromotionChannelsOrderMapper.queryGroupCountModify(channelsCode, startDate, endDate, promoType,
                orderStatusList, userOrderStatusList, startDateModify, endDateModify);
    }
}
