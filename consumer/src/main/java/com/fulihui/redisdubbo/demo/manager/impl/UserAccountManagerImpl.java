/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.*;
import com.fulihui.redisdubbo.demo.api.dto.UserAccountDTO;
import com.fulihui.redisdubbo.demo.api.dto.UserWithdrawDTO;
import com.fulihui.redisdubbo.demo.api.enums.*;
import com.fulihui.redisdubbo.demo.api.request.*;
import com.fulihui.redisdubbo.demo.enums.UserWithdrawStatusEnum;
import com.fulihui.redisdubbo.demo.factory.WeChatConfigFactory;
import com.fulihui.redisdubbo.demo.manager.UserAccountManager;
import com.fulihui.redisdubbo.demo.manager.WeChatManager;
import com.fulihui.redisdubbo.demo.util.WebErrors;
import com.fulihui.redisdubbo.demo.vo.UserBalanceVO;
import com.fulihui.redisdubbo.demo.vo.UserWithdrawVO;
import com.fulihui.redisdubbo.demo.weixin.common.config.DuoDuoKeConfig;
import com.fulihui.redisdubbo.demo.weixin.common.except.BizException;
import com.fulihui.redisdubbo.demo.weixin.common.except.CommonErrors;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.WeixinXMLResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer.TransfersWeixinResult;
import com.google.common.collect.Lists;
import org.near.servicesupport.request.RequestBuilder;
import org.near.servicesupport.request.TPageRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.PageView;
import org.near.webmvcsupport.view.PageViewBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.fulihui.redisdubbo.demo.api.enums.WithdrawalsErrorCodeEnum.AMOUNT_LIMIT;
import static com.fulihui.redisdubbo.demo.api.enums.WithdrawalsErrorCodeEnum.V2_ACCOUNT_SIMPLE_BAN;
import static org.near.toolkit.common.StringUtil.isBlank;

/**
 * The type User account manager.
 *
 * @author lizhi
 */
@Component
public class UserAccountManagerImpl implements UserAccountManager {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserAccountManagerImpl.class);

    private static final String WITHDRAW_DESCRIPTION = "提现购物奖励";

    private static final String BIZ_CODE = UserAccountBizCode.WITHDRAW.getCode();
    /**
     * mock 微信企业付款
     */
    @Value("${web.mock.transfers}")
    private boolean mockTransfers;
    /**
     * mock 微信企业付款 转账成功状态 或失败
     */
    @Value("${web.mock.status}")
    private boolean mockStatus;

    /**
     * The Duo duo ke config.
     */
    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;
    /**
     * The We chat config factory.
     */
    @Autowired
    WeChatConfigFactory weChatConfigFactory;
    /**
     * The Wechat token service.
     */
    @org.apache.dubbo.config.annotation.Reference(check = false)
    WechatTokenService wechatTokenService;
    /**
     * The User account service.
     */
    @org.apache.dubbo.config.annotation.Reference(check = false)

    UserAccountService userAccountService;
    /**
     * The Trade service.
     */
    @org.apache.dubbo.config.annotation.Reference(check = false)
    TradeService tradeService;
    /**
     * The Wechat manager.
     */
    @Autowired
    WeChatManager weChatManager;

    @org.apache.dubbo.config.annotation.Reference
    AppSendMessageService appSendMessageService;

    /**
     * The User form repository.
     */
    @org.apache.dubbo.config.annotation.Reference
    UserFormService userFormService;
    /**
     * The User withdraw service.
     */
    @org.apache.dubbo.config.annotation.Reference
    UserWithdrawService userWithdrawService;

    private static UserWithdrawVO apply(UserWithdrawDTO item) {
        UserWithdrawVO vo = new UserWithdrawVO();
        vo.setTime(DateUtils.formatNewFormat(item.getGmtCreate()));
        vo.setAuditRemark(item.getAuditRemark());
        Money money = new Money();
        money.setCent(item.getWithdrawAmount());
        vo.setWithdrawAmount(money.toString());
        WithdrawStatusEnum code = EnumUtil.queryByCode(item.getStatus(), WithdrawStatusEnum.class);
        switch (code) {
            /** 待审核 */
            case waitAudit:
                vo.setStatus(UserWithdrawStatusEnum.AUDIT_ING.getCode());
                vo.setStatusDesc(UserWithdrawStatusEnum.AUDIT_ING.getDesc());
                break;
            /** 待打款 */
            case auditPass:
                vo.setStatus(UserWithdrawStatusEnum.AUDIT_ING.getCode());
                vo.setStatusDesc(UserWithdrawStatusEnum.AUDIT_ING.getDesc());
                break;

            /** 打款中 */
            case withdrawing:
                vo.setStatus(UserWithdrawStatusEnum.AUDIT_ING.getCode());
                vo.setStatusDesc(UserWithdrawStatusEnum.AUDIT_ING.getDesc());
                break;
            /** 打款失败 */
            case withdrawFail:
                vo.setStatus(UserWithdrawStatusEnum.AUDIT_FAIL.getCode());
                vo.setStatusDesc(UserWithdrawStatusEnum.AUDIT_FAIL.getDesc());
                break;

            /** 提现驳回 */
            case auditReject:
                vo.setStatus(UserWithdrawStatusEnum.AUDIT_FAIL.getCode());
                vo.setStatusDesc(UserWithdrawStatusEnum.AUDIT_FAIL.getDesc());
                break;

            /** 打款成功 */
            case withdrawSuccess:
                vo.setStatus(UserWithdrawStatusEnum.AUDIT_SUCCESS.getCode());
                vo.setStatusDesc(UserWithdrawStatusEnum.AUDIT_SUCCESS.getCode());
                break;
            default:
        }
        return vo;
    }

    /**
     * 提失败
     *
     * @param tradeNo
     * @param thirdTradeNo
     * @param remark
     */
    private void tradeFailed(String tradeNo, String thirdTradeNo, String remark) {
        TradeUpdateStateRequest request = new TradeUpdateStateRequest();
        request.setTradeNo(tradeNo);
        request.setThirdTradeNo(thirdTradeNo);
        request.setRemark(remark);
        request.setState(TradeStateEnum.FAILED.getCode());
        String code = WithdrawStatusEnum.withdrawFail.getCode();
        tradeService.updateState(request, code, remark);
    }

    private void tradeFailed(String tradeNo, String thirdTradeNo, String remark, String state,
                             String withdrawStatus) {
        TradeUpdateStateRequest request = new TradeUpdateStateRequest();
        request.setTradeNo(tradeNo);
        request.setThirdTradeNo(thirdTradeNo);
        request.setRemark(remark);
        request.setState(state);
        tradeService.updateState(request, withdrawStatus, remark);
    }

    @Override
    public void withdrawToWxAccount(String userId, String openId, Long withdrawAmount) {
        // 查询账户余额
        UserAccountDTO userAccount = userAccountService.userAccount(userId);
        Long balance = userAccount.getBalance();
        // 提现金额大于余额
        if (balance == null || balance == 0 || withdrawAmount > balance) {
            LOGGER.error("用户的账户的余额小于提现余额,userId:{},balance:{},withdrawAmount:{}",
                    userAccount.getUserId(), balance, withdrawAmount);
            throw new BizException(CommonErrors.ACCOUNT_SYSTEM_ERROR);
        }

        // 获取一个交易号
        String tradeNo = tradeService.createTradeNo();
        // 创建交易  关联审核单
        String trade = createTrade(userId, openId, withdrawAmount, TradeWithDrawTypeEnum.WX_BALANCE,
                tradeNo);
        LOGGER.info("withdrawToWxAccount,userId:{},交易号trade:{}", userId, trade);
        try {
            minusBalance(userId, withdrawAmount, tradeNo);
        } catch (BizException e) {
            LOGGER.error("{}, {}", e.getErrcode(), e.getErrmsg());
            throw e;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
        try {
            TransfersWeixinResult res;
            if (mockTransfers) {
                if (mockStatus) {
                    res = mockTransfersSuccess();
                } else {
                    res = mockTransfersFail();
                }
            } else {
                // APPID需要为申请商户号时的APPID，或者与商户号有绑定关系。
                // 目前这个是小程序appId ,不是商户号的appId
                res = weChatManager.transfers(openId, duoDuoKeConfig.getMiniAppid(), tradeNo,
                        withdrawAmount.intValue(), WITHDRAW_DESCRIPTION);
            }
            // 微信明确成功的返回结果
            if (res.isSuccess()) {
                tradeFinish(tradeNo, res.getPaymentNo());
                // 发送模板消息
                send(userId, withdrawAmount.intValue(), "提现成功，已打款，请到微信-钱包零钱查看");
            } else {
                LOGGER.error(res.getReturnCode() + " | " + res.getReturnMsg() + " | "
                        + res.getErrCode() + " | " + res.getErrCodeDes());
                String errMsg = isBlank(res.getErrCodeDes()) ? res.getErrCodeDes()
                        : res.getReturnMsg();
                String errCode = res.getErrCode();
                // 非实名用户账号不可发放
                // 付款金额超出限制  // 用户余额 钱要 还回去
                if (V2_ACCOUNT_SIMPLE_BAN.getCode().equals(errCode)
                        || V2_ACCOUNT_SIMPLE_BAN.getDesc().equals(errCode)
                        || AMOUNT_LIMIT.getCode().equals(errCode)) {
                    LOGGER.error("用户提现异常，非实名用户账号不可发放 或付款金额超出限制,userId:{},res:{}", userId, res);
                    UserAccountOperatorRequest request = new UserAccountOperatorRequest();
                    request.setRemark("提现失败退款");
                    request.setOptType(UserAccountOptTypeEnum.INCOME.getCode());
                    request.setAmount(withdrawAmount);
                    request.setUserId(userId);
                    request.setBizCode(UserAccountBizCode.REFUND.getCode());
                    // TODO: 2018-7-21  来源code  异常处理
                    userAccountService.addBalance(request);
                    tradeFailed(tradeNo, res.getPaymentNo(), errMsg);
                    send(userId, withdrawAmount.intValue(), "提现被驳回，已退回余额，请点击查看原因");
                } else {
                    // fixme  不明确的 ,系统不修改状态
                    tradeFailed(tradeNo, res.getPaymentNo(), errMsg, TradeStateEnum.INPAY.getCode(),
                            // 审核状态打款中
                            WithdrawStatusEnum.withdrawing.getCode());
                }
                // FIXME 所有微信调用不成功，前端提示受理中，后台管理判断最终情况决定是否退还余额
                throw new BizException(WebErrors.WECHAT_TRANS_UNKNOW);
            }
        } catch (NullPointerException e) {
            LOGGER.error("{}, {}", e.getMessage(), e);
            throw new BizException(WebErrors.WECHAT_TRANS_UNKNOW);
        } catch (BizException e) {
            LOGGER.error("{}, {}", e.getErrcode(), e.getErrmsg());
            throw e;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            // 所有微信调用不成功，前端提示受理中，后台管理判断最终情况决定是否退还余额
            throw new BizException(WebErrors.WECHAT_TRANS_UNKNOW);
        }

        LOGGER.info("提现到微信用户余额信息,userId:{} amount:{}", userId, withdrawAmount);
    }

    @Override
    public UserBalanceVO balance(String userId) {
        UserBalanceVO vo = new UserBalanceVO();
        UserAccountDTO userAccount = userAccountService.userAccount(userId);
        if (userAccount == null || userAccount.getBalance() == 0) {
            vo.setBalance("0");
        } else {
            Money money = new Money();
            money.setCent(userAccount.getBalance());
            vo.setBalance(money.toString());
        }
        try {
            UserWithdrawRequest withdrawRequest = new UserWithdrawRequest();
            withdrawRequest.setUserId(userId);
            withdrawRequest.setStatus(Lists.newArrayList(WithdrawStatusEnum.waitAudit.getCode(),
                    WithdrawStatusEnum.auditPass.getCode(), WithdrawStatusEnum.withdrawing.getCode()));
            TSingleResult<Long> result = userWithdrawService.queryCount(withdrawRequest);
            ServiceResultUtil.checkResult(result);
            vo.setHasWithdraw(result.getValue() > 0L);
        } catch (Exception ignored) {
        }
        return vo;
    }

    @Override
    public long accumulativeIncome(String userId, List<String> bizCodes, String optType) {
        UserAccountQueryRequest request = new UserAccountQueryRequest();
        request.setUserId(userId);
        request.setOptType(optType);
        request.setBizCodes(bizCodes);
        TSingleResult<Long> result = userAccountService.querySumAmount(request);
        ServiceResultUtil.checkResult(result);
        return result.getValue();
    }

    @Override
    public PageView<UserWithdrawVO> queryUserWithdraw(String userId, int page, int rows) {
        UserWithdrawDTO condition = new UserWithdrawDTO();
        condition.setUserId(userId);
        TPageRequest<UserWithdrawDTO> request = RequestBuilder.buildPageT(condition, page, rows);
        TPageResult<UserWithdrawDTO> result = userWithdrawService.queryPage(request);
        ServiceResultUtil.checkResult(result);
        List<UserWithdrawDTO> values = result.getValues();
        List<UserWithdrawVO> collect = values.stream().map(UserAccountManagerImpl::apply)
                .collect(Collectors.toList());
        return PageViewBuilder.build(collect, page, rows, result.getTotalRows());
    }

    private TransfersWeixinResult mockTransfers() {
        TransfersWeixinResult res = new TransfersWeixinResult();
        res.setReturnCode(WeixinXMLResult.SUCCESS);
        res.setResultCode(WeixinXMLResult.SUCCESS);
        res.setPaymentNo(String.valueOf(System.currentTimeMillis()));
        return res;
    }

    private TransfersWeixinResult mockTransfersSuccess() {
        TransfersWeixinResult res = new TransfersWeixinResult();
        res.setReturnCode(WeixinXMLResult.SUCCESS);
        res.setResultCode(WeixinXMLResult.SUCCESS);
        res.setPaymentNo(String.valueOf(System.currentTimeMillis()));
        return res;
    }

    private TransfersWeixinResult mockTransfersFail() {
        TransfersWeixinResult res = new TransfersWeixinResult();
        res.setReturnCode(WeixinXMLResult.FAIL);
        res.setResultCode(WeixinXMLResult.FAIL);
        failError(res);
        return res;
    }

    private void systemError(TransfersWeixinResult res) {
        res.setErrCode("SYSTEMERROR");
        res.setReturnMsg("系统繁忙,请稍后再试.");
        res.setErrCodeDes("系统繁忙,请稍后再试.");
    }

    private void failError(TransfersWeixinResult res) {
        res.setErrCode("V2_ACCOUNT_SIMPLE_BAN");
        res.setReturnMsg("无法给非实名用户付款");
        res.setErrCodeDes("无法给非实名用户付款");
    }

    /**
     * 减去用户余额
     *
     * @param userId
     * @param balance
     * @param tradeNo
     * @return UserAccountDTO
     */
    private UserAccountDTO minusBalance(String userId, long balance, String tradeNo) {
        UserAccountOperatorRequest request = new UserAccountOperatorRequest();
        request.setUserId(userId);
        request.setAmount(balance);
        request.setBizCode(BIZ_CODE);
        request.setRemark(WITHDRAW_DESCRIPTION);
        request.setSourceCode(tradeNo);
        request.setOptType(UserAccountOptTypeEnum.OUTLAY.getCode());
        return userAccountService.minusBalance(request);
    }

    private String createTrade(String userId, String openId, Long balance,
                               TradeWithDrawTypeEnum withDrawType, String tradeNo) {
        TradeCreateRequest request = new TradeCreateRequest();
        // 付款人类型
        request.setPayerType(TraderTypeEnum.PLATFORM.getCode());
        // 付款人
        request.setPayer(TraderTypeEnum.PLATFORM.getCode());
        // 收款人类型
        request.setPayeeType(TraderTypeEnum.USER.getCode());
        // 收款人账户
        request.setPayee(userId);
        // 收款金额
        request.setAmount(balance);
        // 处理中
        request.setState(TradeStateEnum.PROCESS.getCode());
        // 提现
        request.setCategory(TradeCategoryEnum.WITH_DRAW.getCode());
        // 提现到微信余额
        request.setPayType(withDrawType.getCode());
        // 用户提现
        request.setDescription(WITHDRAW_DESCRIPTION);
        // 交易号
        request.setTradeNo(tradeNo);
        return tradeService.create(request, openId, withDrawType.getCode());
    }

    /**
     * 提成功
     *
     * @param tradeNo
     * @param thirdTradeNo
     */
    private void tradeFinish(String tradeNo, String thirdTradeNo) {
        TradeUpdateStateRequest request = new TradeUpdateStateRequest();
        request.setTradeNo(tradeNo);
        // 第三方交易号 thirdTradeNo 是微信企业付款到个人，微信产生的订单号
        request.setThirdTradeNo(thirdTradeNo);
        request.setState(TradeStateEnum.FINISH.getCode());
        String code = WithdrawStatusEnum.withdrawSuccess.getCode();
        tradeService.updateState(request, code, null);
    }

    @Override
    public void send(String userId, int balance, String text) {

        try {
            appSendMessageService.userWithdrawSend(userId, balance, text);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
