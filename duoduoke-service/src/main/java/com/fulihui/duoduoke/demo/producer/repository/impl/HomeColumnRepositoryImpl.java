package com.fulihui.duoduoke.demo.producer.repository.impl;

import com.fulihui.duoduoke.demo.producer.repository.HomeColumnRepository;
import com.fulihui.duoduoke.demo.producer.dal.dao.HomeColumnMapper;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.HomeColumn;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.HomeColumnExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/2 0002 15:45
 */
@Repository
public class HomeColumnRepositoryImpl implements HomeColumnRepository {

    @Autowired
    private HomeColumnMapper homeColumnMapper;


    @Override
    public HomeColumn selectByPrimaryKey(Integer id) {
        return homeColumnMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HomeColumn> selectByExample(HomeColumn homeColumn) {
        HomeColumnExample example = new HomeColumnExample();
        HomeColumnExample.Criteria criteria = example.createCriteria();
        return homeColumnMapper.selectByExample(example);
    }

    @Override
    public int update(HomeColumn homeColumn) {
        return homeColumnMapper.updateByPrimaryKeySelective(homeColumn);
    }
}
