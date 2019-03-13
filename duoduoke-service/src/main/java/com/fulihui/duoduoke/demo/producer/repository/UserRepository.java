/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.producer.repository;

import com.fulihui.duoduoke.demo.api.dto.UserDTO;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetail;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserDetailExample;

import java.util.List;


/**
 * @author LIZHI
 */
public interface UserRepository {

    void insert(UserDetail record, String operator);

    boolean update(UserDetail record, String operator);

    UserDTO queryByUserId(String userId);

    List<UserDTO> query(UserDetailExample example);

    long count(UserDetailExample example);

    List<UserDTO> queryByUserIds(List<String> userIds);
}
