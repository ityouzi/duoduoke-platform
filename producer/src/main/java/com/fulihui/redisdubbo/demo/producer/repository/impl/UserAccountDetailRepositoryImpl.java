/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.api.dto.UserAccountDetailDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dao.UserAccountDetailMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetail;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetailExample;
import com.fulihui.redisdubbo.demo.producer.repository.UserAccountDetailRepository;
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
public class UserAccountDetailRepositoryImpl implements UserAccountDetailRepository {


    @Autowired
    private UserAccountDetailMapper userAccountDetailMapper;

    @Override
    public void insert(UserAccountDetail record) {
        Date now = new Date();
        record.setGmtCreate(now);
        record.setGmtModified(now);
        userAccountDetailMapper.insertSelective(record);
    }

    @Override
    public List<UserAccountDetailDTO> query(UserAccountDetailExample example) {
        return conv(userAccountDetailMapper.selectByExample(example));
    }

    @Override
    public long count(UserAccountDetailExample example) {
        return userAccountDetailMapper.countByExample(example);
    }

    private UserAccountDetailDTO conv(UserAccountDetail src) {
        if (src == null) {
            return null;
        }
        UserAccountDetailDTO target = new UserAccountDetailDTO();
        target.setId(src.getId());
        target.setUserId(src.getUserId());
        target.setAmount(src.getAmount());
        target.setOptType(src.getOptType());
        target.setRemark(src.getRemark());
        target.setOutTradeNo(src.getOutTradeNo());
        target.setBizCode(src.getBizCode());
        target.setSourceCode(src.getSourceCode());
        target.setGmtCreate(src.getGmtCreate());
        target.setGmtModified(src.getGmtModified());
        return target;
    }

    private List<UserAccountDetailDTO> conv(List<UserAccountDetail> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(this::conv).collect(Collectors.toList());
    }
}
