package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExemptionGoods;

import java.util.List;


/**
 * @author Administrator
 */
public interface ExemptionGoodsRepository {


    ExemptionGoods selectByPrimaryKey(Integer id);

    int insert(ExemptionGoods advert);

    List<ExemptionGoods> selectByExample(ExemptionGoods advert);

    int update(ExemptionGoods advert);

    int del(Integer id);

    int modifyNum(ExemptionGoods exemptionGoods);

    int addReceiveNum(ExemptionGoods exemptionGoods);

    int subReceiveNum(ExemptionGoods exemptionGoods);


}