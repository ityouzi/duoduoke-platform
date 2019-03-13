package com.fulihui.duoduoke.demo.producer.manager.impl;

import com.fulihui.duoduoke.demo.api.enums.TradeStateEnum;
import com.fulihui.duoduoke.demo.api.enums.WithdrawStatusEnum;
import com.fulihui.duoduoke.demo.api.request.TradeCreateRequest;
import com.fulihui.duoduoke.demo.api.request.TradeUpdateStateRequest;
import com.fulihui.duoduoke.demo.api.request.UserWithdrawCreateRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.Trade;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdraw;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserWithdrawStatus;
import com.fulihui.duoduoke.demo.producer.manager.WithdrawTradeManager;
import com.fulihui.duoduoke.demo.producer.repository.TradeRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserWithdrawRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserWithdrawStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lizhi on 2018-7-21.
 */
@Component
public class WithdrawTradeManagerImpl implements WithdrawTradeManager {
    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    UserWithdrawRepository userWithdrawRepository;
    @Autowired
    UserWithdrawStatusRepository userWithdrawStatusRepository;

    @Override
    public String createTrade(TradeCreateRequest request) {
        Trade record = new Trade();
        record.setPayerType(request.getPayerType());
        record.setPayer(request.getPayer());
        record.setPayeeType(request.getPayeeType());
        record.setPayee(request.getPayee());
        record.setAmount(request.getAmount());
        if (request.getState() != null) {
            record.setState(request.getState());
        } else {
            record.setState(TradeStateEnum.UNPAID.getCode());
        }
        record.setCategory(request.getCategory());
        record.setPayType(request.getPayType());
        record.setThirdTradeNo(request.getThirdTradeNo());
        record.setTradeNo(request.getTradeNo());
        record.setDescription(request.getDescription());
        record.setRemark(request.getRemark());
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        //返回交易号
        return tradeRepository.insert(record, "SYSTEM");
    }

    @Override
    public void createWithdraw(UserWithdrawCreateRequest request) {
        UserWithdraw userWithdraw = new UserWithdraw();
        userWithdraw.setUserId(request.getUserId());
        userWithdraw.setWithdrawType(request.getWithdrawType());
        userWithdraw.setWithdrawAmount(request.getWithdrawAmount());
        userWithdraw.setOpenId(request.getOpenId());
        userWithdraw.setOutTradeNo(request.getOutTradeNo());
        if (request.getStatus() != null) {
            userWithdraw.setStatus(request.getStatus());
        } else {
            //插入待审核的状态
            userWithdraw.setStatus(WithdrawStatusEnum.waitAudit.getCode());
        }
        userWithdraw.setAuditor(request.getAuditor());
        //审核时间
        userWithdraw.setAuditTime(request.getAuditTime());
        //审核人
        userWithdraw.setAuditRemark(request.getAuditRemark());
        boolean success = userWithdrawRepository.insert(userWithdraw);
        if (success) {
            UserWithdrawStatus withdrawStatus = new UserWithdrawStatus();
            withdrawStatus.setStatus(userWithdraw.getStatus());
            withdrawStatus.setWithdrawId(userWithdraw.getId());
            userWithdrawStatusRepository.insert(withdrawStatus);
        }
    }

    @Override
    public boolean updateTrade(TradeUpdateStateRequest request) {
        Trade record = new Trade();
        record.setTradeNo(request.getTradeNo());
        record.setState(request.getState());
        record.setRemark(request.getRemark());
        record.setThirdTradeNo(request.getThirdTradeNo());
        return tradeRepository.update(record, "SYSTEM");
    }

    @Override
    public boolean updateWithdraw(Long id, String status, String auditRemark) {
        UserWithdraw withdraw = new UserWithdraw();
        withdraw.setId(id);
        withdraw.setStatus(status);
        withdraw.setAuditRemark(auditRemark);
        boolean bl = userWithdrawRepository.update(withdraw);
        UserWithdrawStatus record = new UserWithdrawStatus();
        record.setStatus(status);
        record.setWithdrawId(id);
        userWithdrawStatusRepository.insert(record);
        return bl;

    }
}
