/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.api.dto.UserAccountDetailDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetail;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountDetailExample;

import java.util.List;


/**
 * @author lizhi
 */
public interface UserAccountDetailRepository {

    void insert(UserAccountDetail record);

    List<UserAccountDetailDTO> query(UserAccountDetailExample example);

    long count(UserAccountDetailExample example);
}
