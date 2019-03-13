package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserExemptionGoods;

import java.util.List;


/**
 * @author Administrator
 */
public interface UserExemptionGoodsRepository {

    UserExemptionGoods selectByPrimaryKey(Integer id);

    int insert(UserExemptionGoods userExemptionGoods);

    List<UserExemptionGoods> selectByExample(UserExemptionGoods userExemptionGoods);

    int updateById(UserExemptionGoods userExemptionGoods);

    int del(Integer id);

    long queryExceedDayCount(String state, String bindOrderStatus);

    List<UserExemptionGoods> queryExceedDay(String state, String bindOrderStatus, int page,
                                            int size);

}