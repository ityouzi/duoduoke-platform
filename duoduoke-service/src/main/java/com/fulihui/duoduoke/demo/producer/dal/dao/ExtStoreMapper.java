package com.fulihui.duoduoke.demo.producer.dal.dao;


import com.fulihui.duoduoke.demo.producer.dal.dataobj.Store;

import java.util.Date;
import java.util.List;

/**
 * @author wahaha
 */
public interface ExtStoreMapper {

    /**
     * @param now
     * @return
     */
    List<Store> getGoingStoreList(Date now);
}