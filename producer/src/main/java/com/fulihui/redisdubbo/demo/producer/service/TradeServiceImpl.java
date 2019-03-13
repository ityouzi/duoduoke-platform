/*
 * Copyright (c) 2017.  Willard Hu. All rights reserved.
 */

package com.fulihui.redisdubbo.demo.producer.service;

import com.fulihui.redisdubbo.demo.api.api.TradeService;
import com.fulihui.redisdubbo.demo.api.api.WechatTokenService;
import com.fulihui.redisdubbo.demo.api.dto.TradeDTO;
import com.fulihui.redisdubbo.demo.api.dto.WechatConfigDTO;
import com.fulihui.redisdubbo.demo.api.enums.WithdrawStatusEnum;
import com.fulihui.redisdubbo.demo.api.request.*;
import com.fulihui.redisdubbo.demo.api.response.TransfersQueryWeixinResponse;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.TradeExample;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserWithdraw;
import com.fulihui.redisdubbo.demo.producer.manager.TakeAccountAmountManager;
import com.fulihui.redisdubbo.demo.producer.manager.WithdrawTradeManager;
import com.fulihui.redisdubbo.demo.producer.repository.TradeRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserWithdrawRepository;
import com.fulihui.redisdubbo.demo.weixin.common.except.BizException;
import com.fulihui.redisdubbo.demo.weixin.common.except.CommonErrors;
import com.fulihui.redisdubbo.demo.weixin.common.sequence.ConcurrentSequence;
import com.fulihui.redisdubbo.demo.weixin.weixin.WeixinClient;
import com.fulihui.redisdubbo.demo.weixin.weixin.request.transfer.TransfersQueryWeixinRequest;
import com.fulihui.redisdubbo.demo.weixin.weixin.result.transfer.TransfersQueryWeixinResult;
import com.fulihui.redisdubbo.demo.weixin.weixin.util.CertInfo;
import com.fulihui.redisdubbo.demo.weixin.weixin.util.CertUtil;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.RandomCharset;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 */
@Service(version = "${demo.service.version}")


public class TradeServiceImpl implements TradeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeServiceImpl.class);
    @Autowired
    TradeRepository tradeRepository;
    @Autowired
    ConcurrentSequence concurrentSequence;
    @Autowired
    TakeAccountAmountManager takeAccountAmountManager;
    @Autowired
    WithdrawTradeManager withdrawTradeManager;
    @Autowired
    UserWithdrawRepository userWithdrawRepository;
    @Autowired
    Environment environment;
    @Autowired
    WechatTokenService wechatTokenService;
    @Autowired
    WeixinClient weixinClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String create(TradeCreateRequest request, String openId, String withdrawType) {

        //判断该用户是否有未完成的提现订单
        List<String> statusArray = Lists.newArrayList();
        statusArray.add(WithdrawStatusEnum.waitAudit.getCode());
        statusArray.add(WithdrawStatusEnum.auditPass.getCode());
        statusArray.add(WithdrawStatusEnum.withdrawing.getCode());
        //审核
        boolean hasWithdrawing = userWithdrawRepository.hasWithdrawing(request.getPayee(),
                statusArray);
        //如果有
        if (hasWithdrawing) {
            LOGGER.error("该用户已有提现中的交易,userId:{}", request.getPayee());
            throw new BizException(CommonErrors.USER_TRADE_ERROR);
        }

        String tradeNo = withdrawTradeManager.createTrade(request);
        LOGGER.info("提现交易号,tradeNo:{},userId:{}", tradeNo, request.getPayee());
        UserWithdrawCreateRequest withdrawCreate = new UserWithdrawCreateRequest();
        //收款人
        withdrawCreate.setUserId(request.getPayee());
        withdrawCreate.setOpenId(openId);
        withdrawCreate.setWithdrawType(withdrawType);
        withdrawCreate.setOutTradeNo(tradeNo);
        withdrawCreate.setWithdrawAmount(request.getAmount());
        withdrawCreate.setAuditor("admin");
        withdrawCreate.setAuditTime(new Date());
        withdrawCreate.setAuditRemark("");
        //待审核
        withdrawCreate.setStatus(WithdrawStatusEnum.waitAudit.getCode());
        //关联审核
        withdrawTradeManager.createWithdraw(withdrawCreate);
        return tradeNo;
    }

    /**
     * 生成订单号
     *
     * @return
     */
    @Override
    public String createTradeNo() {
        return DateUtils.formatShortFormat(new Date()) + concurrentSequence.nextId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateState(TradeUpdateStateRequest request, String withdrawStatus,
                            String auditRemark) {
        update(request, withdrawStatus, auditRemark);
    }

    private void update(TradeUpdateStateRequest request, String withdrawStatus,
                        String auditRemark) {
        boolean trade = withdrawTradeManager.updateTrade(request);
        if (!trade) {
            throw new BizException(CommonErrors.SYSTEM_ERROR);
        }
        //根据交易号查询审核信息
        String tradeNo = request.getTradeNo();
        UserWithdraw userWithdraw = userWithdrawRepository.queryByTrade(tradeNo);
        if (userWithdraw == null) {
            LOGGER.error("根据交易号查询不到审核信息:{}", tradeNo);
            throw new BizException(CommonErrors.SYSTEM_ERROR);
        }
        //更新审核表的状态
        boolean updateWithdraw = withdrawTradeManager.updateWithdraw(userWithdraw.getId(),
                withdrawStatus, auditRemark);

        if (!updateWithdraw) {
            throw new BizException(CommonErrors.SYSTEM_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStateAndBalance(TradeUpdateStateRequest request,
                                      UserAccountOperatorRequest operatorRequest,
                                      String withdrawStatus, String auditRemark) {
        update(request, withdrawStatus, auditRemark);
        takeAccountAmountManager.addBalance(operatorRequest);
    }

    @Override
    public TSingleResult<TransfersQueryWeixinResponse> transferQuery(String appId, String tradeNO, String configCode) {

        String profile = environment.getProperty("spring.profiles.active");
        WechatConfigRequest request = new WechatConfigRequest();
        request.setEnvType(profile);
        request.setConfigCode(configCode);
        TMultiResult<WechatConfigDTO> result = wechatTokenService.query(request);
        ServiceResultUtil.checkResult(result);
        if (!CollectionUtils.isEmpty(result.getValues())) {
            WechatConfigDTO config = result.getValues().get(0);
            TransfersQueryWeixinRequest queryRequest = new TransfersQueryWeixinRequest();
            queryRequest.setAppid(appId);
            request.setMchId(config.getMchId());
            queryRequest.setNonceStr(RandomCharset.randomMixture(32));
            queryRequest.setPartnerTradeNo(tradeNO);
            queryRequest.genSign(config.getSignKey());

            CertInfo certInfo = new CertInfo();
            certInfo.setCertFile(config.getCertFile());
            certInfo.setCertPwd(config.getMchId());
            CertUtil.setCertInfo(certInfo);
            TransfersQueryWeixinResult weiResult = weixinClient.invokeService(queryRequest);
            if (weiResult == null) {
                return ResultBuilder.succTSingle(null);
            }
            TransfersQueryWeixinResponse response = new TransfersQueryWeixinResponse();
            BeanUtils.copyProperties(weiResult, response);
            return ResultBuilder.succTSingle(response);

        } else {
            throw new BizException(CommonErrors.SYSTEM_ERROR);
        }
    }


    @Override
    public TPageResult<TradeDTO> queryPage(TradeQueryRequest request) {
        TradeExample example = toExample(request);
        List<TradeDTO> list = tradeRepository.query(example);
        long count = tradeRepository.count(example);
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    private TradeExample toExample(TradeQueryRequest request) {
        TradeExample example = new TradeExample();
        TradeExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(request.getTradeNo())) {
            criteria.andTradeNoEqualTo(request.getTradeNo());
        }
        if (StringUtil.isNotBlank(request.getThirdTradeNo())) {
            criteria.andThirdTradeNoEqualTo(request.getThirdTradeNo());
        }
        if (request.getState() != null) {
            criteria.andStateEqualTo(request.getState());
        }
        if (StringUtil.isNotBlank(request.getPayType())) {
            criteria.andPayTypeEqualTo(request.getPayType());
        }
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());
        example.setOrderByClause("GMT_MODIFIED desc");
        return example;
    }
}
