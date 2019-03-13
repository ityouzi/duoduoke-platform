package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.promotion.PromotionChannelsDTO;
import com.fulihui.duoduoke.demo.api.util.Collections;
import com.fulihui.duoduoke.demo.producer.repository.PromotionChannelsRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtPromotionChannelsMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.PromotionChannelsMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannels;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.PromotionChannelsExample;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lizhi on 2018-11-29.
 */
@Repository
public class PromotionChannelsRepositoryImpl implements PromotionChannelsRepository {

    @Autowired
    PromotionChannelsMapper promotionChannelsMapper;

    @Autowired
    ExtPromotionChannelsMapper extPromotionChannelsMapper;

    @Override
    public long count(PromotionChannelsExample example) {
        return promotionChannelsMapper.countByExample(example);
    }

    @Override
    public int insert(PromotionChannels record) {
        record.setGmtModified(new Date());
        record.setGmtCreate(new Date());
        return promotionChannelsMapper.insertSelective(record);
    }

    @Override
    public List<PromotionChannelsDTO> query(PromotionChannelsExample example) {
        List<PromotionChannels> list = promotionChannelsMapper.selectByExample(example);
        return convert(list);
    }

    List<PromotionChannelsDTO> convert(List<PromotionChannels> list) {

        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return list.stream().map(this::convert).collect(Collectors.toList());
    }

    private PromotionChannelsDTO convert(PromotionChannels item) {
        if (item == null) {
            return null;
        }
        PromotionChannelsDTO dto = new PromotionChannelsDTO();
        BeanUtils.copyProperties(item, dto);
        return dto;
    }

    @Override
    public PromotionChannelsDTO queryByPk(Integer id) {
        PromotionChannels item = promotionChannelsMapper.selectByPrimaryKey(id);
        return convert(item);
    }

    @Override
    public PromotionChannelsDTO queryByCode(String channelsCode) {
        PromotionChannelsExample example = new PromotionChannelsExample();
        example.createCriteria().andChannelsCodeEqualTo(channelsCode);
        List<PromotionChannels> list = promotionChannelsMapper.selectByExample(example);
        if (Collections.isEmpty(list)) {
            return null;
        }
        return convert(list).get(0);
    }

    @Override
    public List<PromotionChannelsDTO> queryByPid(String pId, String channelsStatus) {
        List<PromotionChannels> list = extPromotionChannelsMapper.queryByPid(pId, channelsStatus);
        return convert(list);
    }

    @Override
    public boolean modifyIncomeBalance(String channelsCode, long income, long balance) {
        return extPromotionChannelsMapper.updateIncomeBalance(channelsCode, income, balance);
    }

    @Override
    public int update(PromotionChannels record) {
        record.setGmtModified(new Date());
        return promotionChannelsMapper.updateByPrimaryKeySelective(record);
    }
}
