package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.producer.repository.AdvertRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.AdvertMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.Advert;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.AdvertExample;
import org.near.toolkit.common.StringUtil;
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
public class AdvertRepositoryImpl implements AdvertRepository {

    @Autowired
    private AdvertMapper advertMapper;

    @Override
    public Advert selectByPrimaryKey(Integer id) {
        return advertMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Advert advert) {
        advert.setGmtCreate(new Date());
        advert.setGmtModified(new Date());
        return advertMapper.insert(advert);
    }

    @Override
    public int update(Advert advert) {
        advert.setGmtModified(new Date());
        return advertMapper.updateByPrimaryKeySelective(advert);
    }

    @Override
    public int del(Integer id) {
        return advertMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<Advert> selectByExample(Advert advert) {
        AdvertExample example = new AdvertExample();
        example.setOrderByClause("gmt_modified DESC");
        AdvertExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(advert.getState())) {
            criteria.andStateEqualTo(advert.getState());
        }
        if (advert.getStartTime() != null) {
            criteria.andStartTimeLessThanOrEqualTo(advert.getStartTime());
        }

        if (advert.getStopTime() != null) {
            criteria.andStopTimeGreaterThanOrEqualTo(advert.getStopTime());
        }
        if (advert.getType() != null) {
            criteria.andTypeEqualTo(advert.getType());
        }
        return advertMapper.selectByExample(example);
    }


}
