package com.fulihui.duoduoke.demo.producer.repository.impl;


import com.fulihui.duoduoke.demo.producer.repository.CornerMarkRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.CornerMarkMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.CornerMark;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.CornerMarkExample;
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
public class CornerMarkRepositoryImpl implements CornerMarkRepository {

    @Autowired
    private CornerMarkMapper cornerMarkMapper;


    @Override
    public CornerMark selectByPrimaryKey(Integer id) {
        return cornerMarkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(CornerMark cornerMark) {
        cornerMark.setGmtCreate(new Date());
        cornerMark.setGmtModified(new Date());
        return cornerMarkMapper.insert(cornerMark);
    }

    @Override
    public List<CornerMark> selectByExample(CornerMark cornerMark) {
        CornerMarkExample example = new CornerMarkExample();
        CornerMarkExample.Criteria criteria = example.createCriteria();
        return cornerMarkMapper.selectByExample(example);
    }

    @Override
    public int update(CornerMark cornerMark) {
        cornerMark.setGmtModified(new Date());
        return cornerMarkMapper.updateByPrimaryKeySelective(cornerMark);
    }

    @Override
    public int del(Integer id) {
        return cornerMarkMapper.deleteByPrimaryKey(id);
    }
}
