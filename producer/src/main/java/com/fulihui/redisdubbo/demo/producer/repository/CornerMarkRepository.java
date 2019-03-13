package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.CornerMark;

import java.util.List;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/19 0019 10:20
 */
public interface CornerMarkRepository {


    CornerMark selectByPrimaryKey(Integer id);

    int insert(CornerMark cornerMark);

    List<CornerMark> selectByExample(CornerMark cornerMark);

    int update(CornerMark cornerMark);

    int del(Integer id);
}