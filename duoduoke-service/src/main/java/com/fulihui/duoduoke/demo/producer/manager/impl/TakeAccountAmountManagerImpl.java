package com.fulihui.duoduoke.demo.producer.manager.impl;

import com.fulihui.duoduoke.demo.api.dto.UserAccountDTO;
import com.fulihui.duoduoke.demo.api.enums.SwitchEnum;
import com.fulihui.duoduoke.demo.api.request.UserAccountCreateRequest;
import com.fulihui.duoduoke.demo.api.request.UserAccountOperatorRequest;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccount;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserAccountDetail;
import com.fulihui.duoduoke.demo.producer.manager.TakeAccountAmountManager;
import com.fulihui.duoduoke.demo.producer.repository.UserAccountDetailRepository;
import com.fulihui.duoduoke.demo.producer.repository.UserAccountRepository;
import com.fulihui.duoduoke.demo.common.except.BizException;
import com.fulihui.duoduoke.demo.common.except.CommonErrors;
import org.near.servicesupport.error.Errors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 用户关联余额
 *
 * @author lizhi
 * @date 2018-7-12
 */
@Component
public class TakeAccountAmountManagerImpl implements TakeAccountAmountManager {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(TakeAccountAmountManagerImpl.class);

    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    UserAccountDetailRepository userAccountDetailRepository;

    @Override
    public UserAccountDTO addBalance(UserAccountOperatorRequest request) {
        UserAccountDTO acc = userAccountRepository.queryByUserId(request.getUserId());
        if (acc == null) {
            create(request.getUserId(), request.getAmount(), "SYSTEM",
                    request.getUserAccountType());
        } else {
            long amount = request.getAmount();
            boolean b = userAccountRepository.modifyBalance(request.getUserId(), amount, "SYSTEM");
            if (!b) {
                throw new RuntimeException(Errors.Commons.SYSTEM_ERROR.getErrmsg());
            }
        }
        insertRecord(request.getUserId(), request.getAmount(), request.getBizCode(),
                request.getRemark(), request.getSourceCode(), "SYSTEM", request.getOptType());
        return userAccountRepository.queryByUserId(request.getUserId());
    }

    @Override
    public UserAccountDTO minusBalance(UserAccountOperatorRequest request) {
        UserAccountDTO acc = userAccountRepository.queryByUserId(request.getUserId());
        // 没有账户不能减余额
        if (acc == null) {
            LOGGER.error("账户余额为空,userId:{}", request.getUserId());
            throw new BizException(CommonErrors.ACCOUNT_ERROR);
        }

        // 减去的余额不能大于账户已有余额
        if (request.getAmount() > acc.getBalance()) {
            LOGGER.error("减去的余额不能大于账户已有余额,request.amount(){}, balance:{}", request.getAmount(),
                    acc.getBalance());
            throw new BizException(CommonErrors.ACCOUNT_SYSTEM_ERROR);
        }

        // 置为负数
        long amount = -request.getAmount();
        boolean b = userAccountRepository.modifyBalance(request.getUserId(), amount, "SYSTEM");
        if (!b) {
            throw new RuntimeException(Errors.Commons.SYSTEM_ERROR.getErrmsg());
        }
        insertRecord(request.getUserId(), amount, request.getBizCode(), request.getRemark(),
                request.getSourceCode(), "SYSTEM", request.getOptType());
        return userAccountRepository.queryByUserId(request.getUserId());
    }

    @Override
    public void create(UserAccountCreateRequest request) {
        create(request.getUserId(), 0, "SYSTEM", request.getUserAccountType());
    }

    /**
     * 创建账号
     *
     * @param userId
     * @param balance
     * @param operator
     */
    private void create(String userId, long balance, String operator, String userAccountType) {
        UserAccount account = new UserAccount();
        account.setUserId(userId);
        account.setBalance(balance);
        account.setState(SwitchEnum.ENABLE.getCode());
        account.setUserAccountType(userAccountType);
        userAccountRepository.insert(account, operator);
    }

    /**
     * 插入详细流水
     *
     * @param userId
     * @param amount
     * @param bizCode
     * @param remark
     * @param sourceCode
     * @param operator
     * @param optType
     */
    private void insertRecord(String userId, Long amount, String bizCode, String remark,
                              String sourceCode, String operator, String optType) {

        UserAccountDetail detail = new UserAccountDetail();
        detail.setUserId(userId);
        detail.setAmount(amount);
        detail.setBizCode(bizCode);
        detail.setRemark(remark);
        detail.setSourceCode(sourceCode);
        detail.setOperator(operator);
        detail.setOptType(optType);
        userAccountDetailRepository.insert(detail);
    }

}
