/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.producer.dal.dao;

import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserAccountTotal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lizhi
 */
public interface ExtUserAccountMapper {

    boolean updateBalance(@Param("userId") String userId,
                          @Param("balance") long balance,
                          @Param("operator") String operator);


    long querySum(@Param("userId") String userId,
                  @Param("bizCodes") List<String> bizCodes,
                  @Param("optType") String optType);

    /**
     * 查询用户总额
     *
     * @param userId
     * @return
     */
    UserAccountTotal queryAccountTotal(@Param("userId") String userId);
}
