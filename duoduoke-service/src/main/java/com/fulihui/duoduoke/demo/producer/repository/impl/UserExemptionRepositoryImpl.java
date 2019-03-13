package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserExemptionGoodsExample;
import com.fulihui.duoduoke.demo.producer.repository.UserExemptionGoodsRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtUserExemptionGoodsMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.UserExemptionGoodsMapper;
import org.near.toolkit.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:45
 */
@Repository
public class UserExemptionRepositoryImpl implements UserExemptionGoodsRepository {

    @Autowired
    private UserExemptionGoodsMapper userExemptionGoodsMapper;

    @Autowired
    private ExtUserExemptionGoodsMapper extUserExemptionGoodsMapper;

    @Override
    public UserExemptionGoods selectByPrimaryKey(Integer id) {
        return userExemptionGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(UserExemptionGoods userExemptionGoods) {
        userExemptionGoods.setGmtCreate(new Date());
        userExemptionGoods.setGmtModified(new Date());
        return userExemptionGoodsMapper.insert(userExemptionGoods);
    }

    @Override
    public List<UserExemptionGoods> selectByExample(UserExemptionGoods userExemptionGoods) {
        UserExemptionGoodsExample example = new UserExemptionGoodsExample();
        example.setOrderByClause("gmt_modified DESC");
        UserExemptionGoodsExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(userExemptionGoods.getUserId())) {
            criteria.andUserIdEqualTo(userExemptionGoods.getUserId());
        }
        if (userExemptionGoods.getActivityId() != null) {
            criteria.andActivityIdEqualTo(userExemptionGoods.getActivityId());
        }
        if (userExemptionGoods.getGoodsId() != null) {
            criteria.andGoodsIdEqualTo(userExemptionGoods.getGoodsId());
        }
        if (StringUtil.isNotEmpty(userExemptionGoods.getOrderSn())) {
            criteria.andOrderSnEqualTo(userExemptionGoods.getOrderSn());
        }

        if (!CollectionUtils.isEmpty(userExemptionGoods.getStates())) {
            criteria.andStateIn(userExemptionGoods.getStates());
        }
        if (userExemptionGoods.getGmtCreate() != null) {
            criteria.andGmtCreateLessThanOrEqualTo(userExemptionGoods.getGmtCreate());
        }

        return userExemptionGoodsMapper.selectByExample(example);
    }

    @Override
    public int updateById(UserExemptionGoods userExemptionGoods) {
        userExemptionGoods.setGmtModified(new Date());
        return userExemptionGoodsMapper.updateByPrimaryKeySelective(userExemptionGoods);
    }

    @Override
    public int del(Integer id) {
        return userExemptionGoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long queryExceedDayCount(String state, String bindOrderStatus) {

        return extUserExemptionGoodsMapper.queryExceedDayCount(state, bindOrderStatus);
    }

    @Override
    public List<UserExemptionGoods> queryExceedDay(String state, String bindOrderStatus, int page,
                                                   int size) {
        return extUserExemptionGoodsMapper.queryExceedDay(state, bindOrderStatus, page, size);
    }
}
