/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.api.dto.WechatAuthDTO;
import com.fulihui.redisdubbo.demo.api.enums.UserTypeEnum;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.WechatAuth;

/**
 * @author LIZHI
 */
public interface WechatAuthRepository {

    void insert(WechatAuth record, String operator);

    boolean update(WechatAuth record, String operator);

    boolean delete(String userId, UserTypeEnum userTypeEnum);

    WechatAuthDTO queryByOpenId(String openId, UserTypeEnum userTypeEnum);

    WechatAuthDTO queryByUserId(String userId, UserTypeEnum userTypeEnum);
}
