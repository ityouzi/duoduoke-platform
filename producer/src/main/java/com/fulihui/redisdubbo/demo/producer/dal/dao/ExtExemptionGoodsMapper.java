package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.ExemptionGoods;

public interface ExtExemptionGoodsMapper {

    int modifyNum(ExemptionGoods record);

    int addReceiveNum(ExemptionGoods record);

    int subReceiveNum(ExemptionGoods record);
}