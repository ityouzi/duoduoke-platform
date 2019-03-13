/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.integration;


import com.fulihui.redisdubbo.demo.api.dto.UserAccountDetailDTO;
import com.fulihui.redisdubbo.demo.api.request.UserAccountQueryRequest;
import org.near.servicesupport.result.TPageResult;

/**
 * @author lizhi
 */
public interface UserAccountServiceClient {

    /**
     * 分页查询交易记录
     *
     * @param request {@link UserAccountQueryRequest}
     * @return {@link TPageResult} 包装的 {@link UserAccountDetailDTO} 列表
     */
    TPageResult<UserAccountDetailDTO> queryRecordPage(UserAccountQueryRequest request);



}
