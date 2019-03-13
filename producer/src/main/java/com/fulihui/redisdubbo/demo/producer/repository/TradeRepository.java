/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.producer.repository;

import com.fulihui.redisdubbo.demo.api.dto.TradeDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.Trade;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.TradeExample;

import java.util.List;


/**
 * @author lizhi
 */
public interface TradeRepository {

    String insert(Trade record, String operator);

    boolean update(Trade record, String operator);

    TradeDTO queryByPK(String tradeNo);

    List<TradeDTO> query(TradeExample example);

    long count(TradeExample example);
}
