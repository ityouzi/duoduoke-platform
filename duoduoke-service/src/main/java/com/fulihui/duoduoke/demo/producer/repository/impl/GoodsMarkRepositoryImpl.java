package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.producer.repository.GoodsMarkRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.ExtGoodsMarkMapper;
import com.fulihui.duoduoke.demo.producer.dal.dao.GoodsMarkMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsMark;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsMarkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/19 0019 10:23
 */
@Repository
public class GoodsMarkRepositoryImpl implements GoodsMarkRepository {

    @Autowired
    ExtGoodsMarkMapper extGoodsMarkMapper;
    @Autowired
    private GoodsMarkMapper goodsMarkMapper;

    @Override
    public GoodsMark selectByPrimaryKey(Integer id) {
        return goodsMarkMapper.selectByPrimaryKey(id);
    }

    @Override
    public GoodsMark selectByGoodsId(Long goodsId) {
        GoodsMarkExample example = new GoodsMarkExample();
        GoodsMarkExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        List<GoodsMark> goodsMarks = goodsMarkMapper.selectByExample(example);

        if (goodsMarks != null && goodsMarks.size() > 0) {
            return goodsMarks.get(0);
        }

        return null;
    }

    @Override
    public int insert(GoodsMark goodsMark) {
        goodsMark.setGmtCreate(new Date());
        goodsMark.setGmtModified(new Date());
        return goodsMarkMapper.insert(goodsMark);
    }

    @Override
    public List<GoodsMark> selectByExample(GoodsMark goodsMark) {
        GoodsMarkExample example = new GoodsMarkExample();
        GoodsMarkExample.Criteria criteria = example.createCriteria();
        if (goodsMark.getGoodsId() != null) {
            criteria.andGoodsIdEqualTo(goodsMark.getGoodsId());
        }
        if (goodsMark.getStartTime() != null) {
            criteria.andStartTimeLessThanOrEqualTo(goodsMark.getStartTime());
        }
        if (goodsMark.getStopTime() != null) {
            criteria.andStopTimeGreaterThanOrEqualTo(goodsMark.getStopTime());
        }
        return goodsMarkMapper.selectByExample(example);
    }

    @Override
    public int update(GoodsMark goodsMark) {
        goodsMark.setGmtModified(new Date());
        return goodsMarkMapper.updateByPrimaryKeySelective(goodsMark);
    }

    @Override
    public int updateGoodsMarkByMarkId(Integer markId, String markUrl) {
        return extGoodsMarkMapper.updateGoodsMarkByMarkId(markId, markUrl);
    }

    @Override
    public int del(Integer id) {
        return goodsMarkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public GoodsMark selectByIdTime(GoodsMark goodsMark) {
        return extGoodsMarkMapper.selectByIdTime(goodsMark);
    }

    @Override
    public List<GoodsMark> queryUsingGoodsMark() {
        return extGoodsMarkMapper.queryUsingGoodsMark();
    }
}
