/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.producer.repository;


import com.fulihui.redisdubbo.demo.api.dto.UserFansDetailDTO;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserFansDetail;

import java.util.Date;
import java.util.List;


/**
 * @author LIZHI
 */
public interface UserFansDetailRepository {

    void insert(UserFansDetail record);

    boolean update(UserFansDetail record);

    boolean delete(String userId);

    List<UserFansDetailDTO> query(String userId, Date statisticsDate);

    List<UserFansDetailDTO> querySumByUserId(String userId, Date gmtCreate);


}
