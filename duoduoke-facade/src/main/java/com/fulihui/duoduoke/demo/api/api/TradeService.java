/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.duoduoke.demo.api.api;


import com.fulihui.duoduoke.demo.api.request.TradeCreateRequest;
import com.fulihui.duoduoke.demo.api.request.TradeQueryRequest;
import com.fulihui.duoduoke.demo.api.request.TradeUpdateStateRequest;
import com.fulihui.duoduoke.demo.api.request.UserAccountOperatorRequest;
import com.fulihui.duoduoke.demo.api.response.TransfersQueryWeixinResponse;
import com.fulihui.duoduoke.demo.api.dto.TradeDTO;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * The interface Trade service.
 *
 * @author lizhi
 */
public interface TradeService {

    /**
     * 创建交易并且审核
     *
     * @param request      {@link TradeCreateRequest}
     * @param openId       the open id
     * @param withdrawType the withdraw type
     * @return 交易单号 string
     */
    String create(TradeCreateRequest request, String openId, String withdrawType);

    /**
     * 更新交易状态并且审核
     *
     * @param request        {@link TradeUpdateStateRequest}
     * @param withdrawStatus the withdraw status
     * @param auditRemark    the audit remark
     */
    void updateState(TradeUpdateStateRequest request, String withdrawStatus, String auditRemark);

    /**
     * Update state and balance.
     *
     * @param request         the request
     * @param operatorRequest the operator request
     * @param withdrawStatus  the withdraw status
     * @param auditRemark     the audit remark
     */
    void updateStateAndBalance(TradeUpdateStateRequest request,

                               UserAccountOperatorRequest operatorRequest, String withdrawStatus,
                               String auditRemark);

    TSingleResult<TransfersQueryWeixinResponse> transferQuery(String appId, String tradeNO, String configCode);

    /**
     * 生成交易号
     *
     * @return string string
     */
    String createTradeNo();

    /**
     * 查询交易信息
     *
     * @param request the request
     * @return t page result
     */
    TPageResult<TradeDTO> queryPage(TradeQueryRequest request);

}
