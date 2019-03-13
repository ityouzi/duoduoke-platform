package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.producer.dal.dataobj.Advert;

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