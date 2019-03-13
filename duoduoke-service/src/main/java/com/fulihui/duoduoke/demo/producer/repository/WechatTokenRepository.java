/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.producer.repository;


import com.fulihui.duoduoke.demo.api.dto.WechatTokenDTO;
import com.fulihui.duoduoke.demo.api.enums.WechatTokenTypeEnum;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatToken;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.WechatTokenExample;

import java.util.List;


/**
 * @author lizhi
 */
public interface WechatTokenRepository {

    void insert(WechatToken record, String operator);

    boolean update(WechatToken record, String operator);

    WechatToken queryByType(String appid, WechatTokenTypeEnum tokenType);

    int updateByExampleSelective(WechatToken record, WechatTokenExample example);

    long countByExample(WechatTokenExample example);

    List<WechatTokenDTO> selectByExample(WechatTokenExample example);


}
