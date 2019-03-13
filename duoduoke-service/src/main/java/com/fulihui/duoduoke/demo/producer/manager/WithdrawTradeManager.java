package com.fulihui.duoduoke.demo.producer.manager;


import com.fulihui.duoduoke.demo.api.request.TradeCreateRequest;
import com.fulihui.duoduoke.demo.api.request.TradeUpdateStateRequest;
import com.fulihui.duoduoke.demo.api.request.UserWithdrawCreateRequest;


/**
 * 交易管理
 *
 * @author lizhi
 * @date 2018 -7-21
 */
public interface WithdrawTradeManager {
    /**
     * 交易
     *
     * @param request the request
     * @return string
     */
    String createTrade(TradeCreateRequest request);

    /**
     * 审核
     *
     * @param request the request
     */
    void createWithdraw(UserWithdrawCreateRequest request);

    /**
     * 根据交易号修改状态
     *
     * @param request the request
     * @return string
     */
    boolean updateTrade(TradeUpdateStateRequest request);

    /**
     * 根据 审核信息表的审核id 修改状态
     *
     * @param id     the id
     * @param status the status
     */
    boolean updateWithdraw(Long id, String status, String auditRemark);
}
