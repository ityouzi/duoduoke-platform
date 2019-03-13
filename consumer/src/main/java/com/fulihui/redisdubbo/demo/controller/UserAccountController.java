/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.controller;


import com.fulihui.redisdubbo.demo.api.dto.UserAccountDetailDTO;
import com.fulihui.redisdubbo.demo.api.enums.*;
import com.fulihui.redisdubbo.demo.api.request.UserAccountQueryRequest;
import com.fulihui.redisdubbo.demo.factory.AppConfigFactory;
import com.fulihui.redisdubbo.demo.integration.UserAccountServiceClient;
import com.fulihui.redisdubbo.demo.manager.OrderInfoManager;
import com.fulihui.redisdubbo.demo.manager.UserAccountManager;
import com.fulihui.redisdubbo.demo.param.UserAccountDetailParam;
import com.fulihui.redisdubbo.demo.param.WithDrawParam;
import com.fulihui.redisdubbo.demo.util.Principal;
import com.fulihui.redisdubbo.demo.util.PrincipalUtil;
import com.fulihui.redisdubbo.demo.util.WebErrors;
import com.fulihui.redisdubbo.demo.vo.UserAccountDetailVO;
import com.fulihui.redisdubbo.demo.vo.UserAccountIncomeVO;
import com.fulihui.redisdubbo.demo.vo.UserBalanceVO;
import com.fulihui.redisdubbo.demo.vo.UserWithdrawVO;
import com.fulihui.redisdubbo.demo.weixin.common.except.BizException;
import com.fulihui.redisdubbo.demo.weixin.common.except.CommonErrors;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.EnumUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.PageView;
import org.near.webmvcsupport.view.PageViewBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.fulihui.redisdubbo.demo.api.enums.UserAccountBizCode.*;
import static com.google.common.collect.Lists.transform;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.webmvcsupport.view.JsonResultBuilder.succ;

/**
 * @author lizhi
 */
@RestController
@RequestMapping("/userAccount")
@Api(description = "用户余额")
public class UserAccountController {

    private static final Logger LOGGER      = LoggerFactory.getLogger(UserAccountController.class);
    private static final String SUCCESS_MSG = "success";

    @Autowired
    UserAccountManager userAccountManager;

    @Autowired
    OrderInfoManager orderInfoManager;

    @Autowired
    UserAccountServiceClient userAccountServiceClient;

    @Autowired
    AppConfigFactory appConfigFactory;

    /**
     * 查询用户我的余额
     */
    @PostMapping("/balance")
    @ApiOperation(value = "查询用户我的余额")
    JsonResult<UserBalanceVO> balance(HttpServletRequest request) {
        Principal principal = PrincipalUtil.getPrincipal();
        UserBalanceVO balance = userAccountManager.balance(principal.getUserId());
        String withdrawalType = appConfigFactory.getWithdrawalType();
        balance.setWithdrawalType(withdrawalType);
        return succ(balance);
    }

    @PostMapping("/income")
    @ApiOperation(value = "查询用户我的收入")
    JsonResult<UserAccountIncomeVO> income() {
        UserAccountIncomeVO vo = new UserAccountIncomeVO();
        Principal principal = PrincipalUtil.getPrincipal();
        //
        //待确认 待结算 审核中收入
        long auditIncome = orderInfoManager.auditIncome(principal.getUserId(),
            Lists.newArrayList(UserOrderStatusEnum.TO_BE_CONFIRMED.getCode(),
                UserOrderStatusEnum.TO_BE_SETTLEMENT.getCode()),
            null, null, OrderPromoTypeEnum.ORDINARY.getCode());

        Money auditIncomeMoney = new Money();
        auditIncomeMoney.setCent(auditIncome);
        vo.setAuditIncome(auditIncomeMoney.getAmount().toString());

        //已到账  累计收入
        List<String> list = Lists.newArrayList(UserAccountBizCode.ORDER_REBATE.getCode(),
            UserAccountBizCode.SHARE_ORDER.getCode(), UserAccountBizCode.ORDER_DOUBLE.getCode(),
            UserAccountBizCode.FANS_ORDER.getCode(),
            UserAccountBizCode.ORDER_PRODUCT_DOUBLE.getCode(), SIGN_USER_FLOP.getCode(),
            ORDER_SIGN_REWARD.getCode(), ORDER_FREE_REWARD.getCode());
        long accumulativeIncome = userAccountManager.accumulativeIncome(principal.getUserId(), list,
            UserAccountOptTypeEnum.INCOME.getCode());
        Money accumulativeIncomeMoney = new Money();
        accumulativeIncomeMoney.setCent(accumulativeIncome);
        vo.setAccumulativeIncome(accumulativeIncomeMoney.getAmount().toString());
        LOGGER.info("用户信息:{},审核中的收入:{},累计收入:{}", principal.getUserId(), auditIncome,
            accumulativeIncome);
        return succ(vo);
    }

    /**
     * 提现
     */
    @PostMapping("/withdraw")
    @ApiOperation(value = "用户提现")
    JsonResult withdraw(@RequestBody WithDrawParam param) {
        Principal principal = PrincipalUtil.getPrincipal();
        if (TradeWithDrawTypeEnum.WX_BALANCE.getCode().equals(param.getWithDrawTo())) {
            Money money = new Money(param.getWithdrawAmount());
            //XXX 提现最低1元 check
            int amountCheck = appConfigFactory.getAmountCheck() == null ? 100
                : appConfigFactory.getAmountCheck().intValue();
            LOGGER.info("提现最低金额check,amountCheck:{},userId:{}", amountCheck, principal.getUserId());
            if (money.getCent() < amountCheck) {
                LOGGER.error("提现最低1元起提,userId:{},money:{}", principal.getUserId(), money.getCent());
                throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
            }
            try {
                userAccountManager.withdrawToWxAccount(principal.getUserId(), principal.getOpenId(),
                    money.getCent());
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                return succ(WebErrors.WECHAT_TRANS_UNKNOW.errmsg());
            }
        } else {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        return succ(SUCCESS_MSG);
    }

    @PostMapping("/queryWithdrawPage")
    @ApiOperation(value = "查询用户提现记录")
    JsonResult<PageView<UserWithdrawVO>> queryWithdrawPage(@RequestBody UserAccountDetailParam param) {
        Principal principal = PrincipalUtil.getPrincipal();
        PageView<UserWithdrawVO> pageView = userAccountManager
            .queryUserWithdraw(principal.getUserId(), param.getPage(), param.getRows());
        return succ(pageView);
    }

    @PostMapping("/queryRecordPage")
    @ApiOperation(value = "查询用户收支明细")
    JsonResult<PageView<UserAccountDetailVO>> queryRecordPage(@RequestBody UserAccountDetailParam param) {
        Principal principal = PrincipalUtil.getPrincipal();

        String userId = principal.getUserId();

        UserAccountQueryRequest request = new UserAccountQueryRequest();
        request.setPage(param.getPage());
        request.setRows(param.getRows());
        request.setUserId(userId);
        request.setAmount(0L);
        TPageResult<UserAccountDetailDTO> result = userAccountServiceClient
            .queryRecordPage(request);

        checkResult(result);
        List<UserAccountDetailVO> list = transform(result.getValues(), item -> {
            UserAccountDetailVO vo = new UserAccountDetailVO();
            vo.setRemark(item.getRemark());
            UserAccountOptTypeEnum optTypeEnum = EnumUtil.queryByCode(item.getOptType(),
                UserAccountOptTypeEnum.class);
            vo.setOptType(item.getOptType());
            vo.setOptTypeDesc(optTypeEnum.getDesc());
            vo.setTime(DateUtils.formatNewFormat(item.getGmtCreate()));
            Long amount = item.getAmount();
            Money money = new Money();
            money.setCent(amount);
            vo.setAmount(money.getAmount().toString());
            return vo;
        });

        PageView<UserAccountDetailVO> build = PageViewBuilder.build(list, result.getPage(),
            result.getRows(), result.getTotalRows());
        return succ(build);
    }
}