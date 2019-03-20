package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.GoodsMark;

import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/19 0019 10:20
 */
public interface GoodsMarkRepository {


    GoodsMark selectByPrimaryKey(Integer id);

    GoodsMark selectByGoodsId(String goodsId);

    int insert(GoodsMark goodsMark);

    List<GoodsMark> selectByExample(GoodsMark goodsMark);

    int update(GoodsMark cornerMark);

    int updateGoodsMarkByMarkId(Integer markId, String markUrl);

    int del(Integer id);

    GoodsMark selectByIdTime(GoodsMark goodsMark);

    List<GoodsMark> queryUsingGoodsMark();
}