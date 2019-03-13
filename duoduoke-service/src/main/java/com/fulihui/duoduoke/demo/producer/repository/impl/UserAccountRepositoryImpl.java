/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.api.dto.UserAccountDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccount;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccountExample;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccountTotal;
import com.fulihui.duoduoke.demo.producer.repository.UserAccountRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtUserAccountMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhi
 */
@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private ExtUserAccountMapper extUserAccountMapper;

    @Override
    public void insert(UserAccount record, String operator) {
        Date now = new Date();
        record.setGmtCreate(now);
        record.setCreateBy(operator);
        record.setGmtModified(now);
        record.setModifiedBy(operator);
        userAccountMapper.insertSelective(record);
    }

    @Override
    public UserAccountDTO queryByUserId(String userId) {
        UserAccountExample example = new UserAccountExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserAccount> list = userAccountMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return convert(list.get(0));
    }

    @Override
    public List<UserAccountDTO> queryAll() {
        List<UserAccount> list = userAccountMapper.selectByExample(new UserAccountExample());
        return list.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public boolean modifyBalance(String userId, long balance, String operator) {
        return extUserAccountMapper.updateBalance(userId, balance, operator);
    }

    @Override
    public UserAccountTotal queryAccountTotal(String userId) {
        return extUserAccountMapper.queryAccountTotal(userId);
    }

    @Override
    public long querySum(String userId, List<String> bizCodes, String optType) {
        return extUserAccountMapper.querySum(userId, bizCodes, optType);
    }

    private UserAccountDTO convert(UserAccount src) {
        if (src == null) {
            return null;
        }
        UserAccountDTO target = new UserAccountDTO();
        target.setUserId(src.getUserId());
        target.setBalance(src.getBalance());
        target.setState(src.getState());
        target.setGmtCreate(src.getGmtCreate());
        target.setCreateBy(src.getCreateBy());
        target.setGmtModified(src.getGmtModified());
        target.setModifiedBy(src.getModifiedBy());
        target.setUserAccountType(src.getUserAccountType());
        return target;
    }
}
