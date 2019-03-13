package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.Advert;

import java.util.List;


/**
 * @author Administrator
 */
public interface AdvertRepository {

    Advert selectByPrimaryKey(Integer id);

    int insert(Advert advert);

    List<Advert> selectByExample(Advert advert);

    int update(Advert advert);

    int del(Integer id);

}