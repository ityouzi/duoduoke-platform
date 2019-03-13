package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.HomeColumn;

import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/8/15 0015 14:21
 */
public interface HomeColumnRepository {


    HomeColumn selectByPrimaryKey(Integer id);


    List<HomeColumn> selectByExample(HomeColumn homeColumn);

    int update(HomeColumn homeColumn);
}