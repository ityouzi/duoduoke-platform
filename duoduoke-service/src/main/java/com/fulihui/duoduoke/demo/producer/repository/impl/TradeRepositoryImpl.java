/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.TradeDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.Trade;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.TradeExample;
import com.fulihui.duoduoke.demo.producer.repository.TradeRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author lizhi
 */
@Repository
public class TradeRepositoryImpl implements TradeRepository {
    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public String insert(Trade record, String operator) {
        tradeMapper.insertSelective(record);
        return record.getTradeNo();
    }

    @Override
    public boolean update(Trade record, String operator) {
        record.setGmtModified(new Date());
        record.setModifiedBy(operator);
        return tradeMapper.updateByPrimaryKeySelective(record) > 0;
    }

    @Override
    public TradeDTO queryByPK(String tradeNo) {
        return conv(tradeMapper.selectByPrimaryKey(tradeNo));
    }

    @Override
    public List<TradeDTO> query(TradeExample example) {
        return conv(tradeMapper.selectByExample(example));
    }

    @Override
    public long count(TradeExample example) {
        return tradeMapper.countByExample(example);
    }


    private TradeDTO conv(Trade src) {
        if (src == null) {
            return null;
        }
        TradeDTO target = new TradeDTO();
        target.setTradeNo(src.getTradeNo());

        target.setPayerType(src.getPayerType());
        target.setPayer(src.getPayer());


        target.setPayeeType(src.getPayeeType());
        target.setPayee(src.getPayee());
        target.setAmount(src.getAmount());


        target.setState(src.getState());

        target.setCategory(src.getCategory());
        target.setPayType(src.getPayType());
        target.setThirdTradeNo(src.getThirdTradeNo());
        target.setDescription(src.getDescription());
        target.setRemark(src.getRemark());
        target.setGmtCreate(src.getGmtCreate());
        target.setCreateBy(src.getCreateBy());
        target.setGmtModified(src.getGmtModified());
        target.setModifiedBy(src.getModifiedBy());
        return target;
    }

    private List<TradeDTO> conv(List<Trade> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(this::conv).collect(Collectors.toList());
    }
}
