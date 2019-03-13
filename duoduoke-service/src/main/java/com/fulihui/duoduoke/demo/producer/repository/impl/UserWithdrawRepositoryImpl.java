package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdraw;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdrawExample;
import com.fulihui.duoduoke.demo.producer.repository.UserWithdrawRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserWithdrawMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: JY
 * @date: 2018/7/13 11:03
 */
@Service
public class UserWithdrawRepositoryImpl implements UserWithdrawRepository {

    @Autowired
    UserWithdrawMapper userWithdrawMapper;

    @Override
    public boolean hasWithdrawing(String userId, List<String> status) {

        UserWithdrawExample example = new UserWithdrawExample();
        UserWithdrawExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        //包含提现中状态的数据
        criteria.andStatusIn(status);
        return userWithdrawMapper.countByExample(example) > 0;
    }

    @Override
    public boolean insert(UserWithdraw userWithdraw) {
        userWithdraw.setGmtModified(new Date());
        userWithdraw.setGmtCreate(new Date());
        return userWithdrawMapper.insertSelective(userWithdraw) > 0;

    }

    @Override
    public boolean update(UserWithdraw userWithdraw) {
        return userWithdrawMapper.updateByPrimaryKeySelective(userWithdraw) > 0;
    }

    @Override
    public UserWithdraw queryByTrade(String trade) {
        UserWithdrawExample example = new UserWithdrawExample();
        UserWithdrawExample.Criteria criteria = example.createCriteria();
        criteria.andOutTradeNoEqualTo(trade);
        List<UserWithdraw> userWithdraws = userWithdrawMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(userWithdraws)) {
            return userWithdraws.get(0);
        }
        return null;
    }

    @Override
    public UserWithdraw queryByPk(Long id) {
        return userWithdrawMapper.selectByPrimaryKey(id);
    }
}
