package com.fulihui.redisdubbo.demo.producer.repository.impl;

import com.fulihui.redisdubbo.demo.producer.dal.dao.ExemptionGoodsMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dao.ExtExemptionGoodsMapper;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExemptionGoodsExample;
import com.fulihui.redisdubbo.demo.producer.repository.ExemptionGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:45
 */
@Repository
public class ExemptionRepositoryImpl implements ExemptionGoodsRepository {

    @Autowired
    private ExemptionGoodsMapper exemptionGoodsMapper;
    @Autowired
    private ExtExemptionGoodsMapper extExemptionGoodsMapper;

    @Override
    public ExemptionGoods selectByPrimaryKey(Integer id) {
        return exemptionGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(ExemptionGoods exemptionGoods) {
        exemptionGoods.setGmtCreate(new Date());
        exemptionGoods.setGmtModified(new Date());
        return exemptionGoodsMapper.insert(exemptionGoods);
    }


    @Override
    public int update(ExemptionGoods exemptionGoods) {
        exemptionGoods.setGmtModified(new Date());
        return exemptionGoodsMapper.updateByPrimaryKeySelective(exemptionGoods);
    }

    @Override
    public int del(Integer id) {
        return exemptionGoodsMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<ExemptionGoods> selectByExample(ExemptionGoods exemptionGoods) {
        ExemptionGoodsExample example = new ExemptionGoodsExample();
        example.setOrderByClause("sort DESC");
        ExemptionGoodsExample.Criteria criteria = example.createCriteria();
        if (exemptionGoods.getState() != null) {
            criteria.andStateEqualTo(exemptionGoods.getState());
        }
        if (exemptionGoods.getActivityId() != null) {
            criteria.andActivityIdEqualTo(exemptionGoods.getActivityId());
        }
        return exemptionGoodsMapper.selectByExample(example);
    }

    @Override
    public int modifyNum(ExemptionGoods exemptionGoods) {
        return extExemptionGoodsMapper.modifyNum(exemptionGoods);
    }

    @Override
    public int addReceiveNum(ExemptionGoods exemptionGoods) {
        return extExemptionGoodsMapper.addReceiveNum(exemptionGoods);
    }


    @Override
    public int subReceiveNum(ExemptionGoods exemptionGoods) {
        return extExemptionGoodsMapper.subReceiveNum(exemptionGoods);
    }


}
