/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.UserAccountService;
import com.fulihui.redisdubbo.demo.api.dto.UserAccountDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserAccountDetailDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserAccountTotalDTO;
import com.fulihui.redisdubbo.demo.api.request.UserAccountCreateRequest;
import com.fulihui.redisdubbo.demo.api.request.UserAccountOperatorRequest;
import com.fulihui.redisdubbo.demo.api.request.UserAccountQueryRequest;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetailExample;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountTotal;
import com.fulihui.redisdubbo.demo.producer.manager.TakeAccountAmountManager;
import com.fulihui.redisdubbo.demo.producer.repository.UserAccountDetailRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserAccountRepository;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author lizhi
 */
@Service(version = "${demo.service.version}")

public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    TakeAccountAmountManager takeAccountAmountManager;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private UserAccountDetailRepository userAccountDetailRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(UserAccountCreateRequest request) {
        takeAccountAmountManager.create(request);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserAccountDTO addBalance(UserAccountOperatorRequest request) {
        return takeAccountAmountManager.addBalance(request);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserAccountDTO minusBalance(UserAccountOperatorRequest request) {
        return takeAccountAmountManager.minusBalance(request);
    }

    @Override
    public UserAccountDTO userAccount(String userId) {
        return userAccountRepository.queryByUserId(userId);
    }

    @Override
    public TPageResult<UserAccountDetailDTO> queryRecordPage(UserAccountQueryRequest request) {
        UserAccountDetailExample example = toExample(request);

        List<UserAccountDetailDTO> list = userAccountDetailRepository.query(example);
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTPage(Lists.newArrayList(), request.getPage(),
                    request.getRows(), 0);
        }

        long totalCount = userAccountDetailRepository.count(example);

        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(),
                (int) totalCount);
    }

    /**
     * 查询用户总额
     *
     * @param userId
     * @return
     */
    @Override
    public UserAccountTotalDTO queryUserTotal(String userId) {

        //查询
        UserAccountTotal accountTotal = userAccountRepository.queryAccountTotal(userId);

        UserAccountTotalDTO accountDTO = new UserAccountTotalDTO();

        //对象转换
        if (accountTotal != null) {
            BeanUtils.copyProperties(accountTotal, accountDTO);
        }

        return accountDTO;
    }

    @Override
    public TSingleResult<Long> querySumAmount(UserAccountQueryRequest request) {
        long sumAmount = userAccountRepository.querySum(request.getUserId(), request.getBizCodes(),
                request.getOptType());
        return ResultBuilder.succTSingle(sumAmount);
    }

    private UserAccountDetailExample toExample(UserAccountQueryRequest request) {
        UserAccountDetailExample example = new UserAccountDetailExample();
        UserAccountDetailExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(request.getUserId())) {
            criteria.andUserIdEqualTo(request.getUserId());
        }
        if (request.getLastId() != null) {
            criteria.andIdLessThan(request.getLastId());
        }
        if (request.getAmount() != null) {
            criteria.andAmountNotEqualTo(request.getAmount());
        }

        example.setLimit(request.getRows());
        example.setOffset(request.start4Mysql());
        example.setOrderByClause("id desc");
        return example;
    }
}
