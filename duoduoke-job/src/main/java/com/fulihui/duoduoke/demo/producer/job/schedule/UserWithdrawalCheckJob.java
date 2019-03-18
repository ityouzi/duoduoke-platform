package com.fulihui.duoduoke.demo.producer.job.schedule;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.fulihui.duoduoke.demo.api.api.AppSendMessageService;
import com.fulihui.duoduoke.demo.api.api.TradeService;
import com.fulihui.duoduoke.demo.api.dto.TradeDTO;
import com.fulihui.duoduoke.demo.api.dto.WechatConfigDTO;
import com.fulihui.duoduoke.demo.api.enums.TradeStateEnum;
import com.fulihui.duoduoke.demo.api.enums.UserAccountBizCode;
import com.fulihui.duoduoke.demo.api.enums.UserAccountOptTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.WithdrawalsErrorCodeEnum;
import com.fulihui.duoduoke.demo.api.request.TradeQueryRequest;
import com.fulihui.duoduoke.demo.api.request.TradeUpdateStateRequest;
import com.fulihui.duoduoke.demo.api.request.UserAccountOperatorRequest;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.producer.job.config.WeChatConfigFactory;
import com.fulihui.duoduoke.demo.web.weixin.weixin.WeixinClient;
import com.fulihui.duoduoke.demo.web.weixin.weixin.request.transfer.TransfersQueryWeixinRequest;
import com.fulihui.duoduoke.demo.web.weixin.weixin.result.WeixinXMLResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.result.transfer.TransfersQueryWeixinResult;
import com.fulihui.duoduoke.demo.web.weixin.weixin.util.CertInfo;
import com.fulihui.duoduoke.demo.web.weixin.weixin.util.CertUtil;
import org.near.servicesupport.result.TPageResult;
import org.near.toolkit.common.RandomCharset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static com.fulihui.duoduoke.demo.api.enums.WithdrawStatusEnum.withdrawFail;
import static com.fulihui.duoduoke.demo.api.enums.WithdrawStatusEnum.withdrawSuccess;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.springframework.util.CollectionUtils.isEmpty;


/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/20 0020 10:51
 */
public class UserWithdrawalCheckJob implements SimpleJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserWithdrawalCheckJob.class);

    @org.apache.dubbo.config.annotation.Reference
    TradeService tradeService;

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

    private volatile boolean running = false;


    @Autowired
    DuoDuoKeConfig duoDuoKeConfig;

    @org.apache.dubbo.config.annotation.Reference
    AppSendMessageService appSendMessageService;


    @Autowired
    WeixinClient weixinClient;

    @Autowired
    WeChatConfigFactory weChatConfigFactory;

    @Override
    public void execute(ShardingContext shardingContext) {
        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }
        running = true;

        try {

            execute();

        } catch (Exception e) {
            LOGGER.error("UserWithdrawalCheckJob error!", e);
        }

        running = false;
        LOGGER.info("running改值成功");
    }

    private TransfersQueryWeixinResult queryMockTransfersSuccess() {
        TransfersQueryWeixinResult res = new TransfersQueryWeixinResult();
        res.setReturnCode(WeixinXMLResult.SUCCESS);
        res.setResultCode(WeixinXMLResult.SUCCESS);
        res.setStatus("SUCCESS");
        res.setDetailId("12345");
        return res;
    }

    private TransfersQueryWeixinResult queryMockTransfersFail() {
        TransfersQueryWeixinResult res = new TransfersQueryWeixinResult();
        res.setReturnCode(WeixinXMLResult.SUCCESS);
        res.setResultCode(WeixinXMLResult.SUCCESS);
        res.setStatus("FAILED");
        res.setReason("余额不足");
        return res;
    }

    private void setCertInfo() {
        WechatConfigDTO config = weChatConfigFactory.get();
        CertInfo certInfo = new CertInfo();
        certInfo.setCertFile(config.getCertFile());
        certInfo.setCertPwd(config.getMchId());
        CertUtil.setCertInfo(certInfo);
    }

    public TransfersQueryWeixinResult transferQuery(String userId,
                                                    String appId,
                                                    String tradeNO) {
        try {
            WechatConfigDTO config = weChatConfigFactory.get();
            // 设置请求参数
            TransfersQueryWeixinRequest request = new TransfersQueryWeixinRequest();
            request.setAppid(appId);
            request.setMchId(config.getMchId());
            request.setNonceStr(RandomCharset.randomMixture(32));
            request.setPartnerTradeNo(tradeNO);
            request.genSign(config.getSignKey());
            setCertInfo();
            return weixinClient.invokeService(request);
        } catch (Exception e) {
            LOGGER.error("企业微信转账查询(公众号->个人)失败", e);
        }
        return null;
    }

    private void execute() {
        TradeQueryRequest request = new TradeQueryRequest();
        request.setState(TradeStateEnum.INPAY.getCode());
        TPageResult<TradeDTO> result = tradeService.queryPage(request);
        checkResult(result);

        int totalPage = result.getTotalPage();
        for (int i = 1; i <= totalPage; i++) {
            request.setPage(i);
            TPageResult<TradeDTO> tradeRes = tradeService.queryPage(request);
            checkResult(tradeRes);
            List<TradeDTO> list = tradeRes.getValues();
            if (!isEmpty(list)) {
                for (TradeDTO dto : list) {
                    TransfersQueryWeixinResult res;
                    if (mockTransfers) {
                        //是否mock成功
                        if (mockStatus) {
                            res = queryMockTransfersSuccess();
                        } else {
                            res = queryMockTransfersFail();
                        }
                    } else {
                        res = transferQuery(dto.getPayee(),
                                duoDuoKeConfig.getMiniAppid(), dto.getTradeNo());
                    }
                    if (res != null) {
                        TradeUpdateStateRequest updateRequest = new TradeUpdateStateRequest();
                        updateRequest.setTradeNo(dto.getTradeNo());
                        if (WeixinXMLResult.SUCCESS.equals(res.getReturnCode())
                                && WeixinXMLResult.SUCCESS.equals(res.getResultCode())) {
                            String status = res.getStatus();
                            if (WeixinXMLResult.SUCCESS.equals(status)) {
                                //明确成功
                                updateRequest.setState(TradeStateEnum.FINISH.getCode());
                                updateRequest.setThirdTradeNo(res.getDetailId());
                                updateRequest.setStatusEnum(withdrawSuccess);
                                tradeService.updateState(updateRequest, withdrawSuccess.getCode(),
                                        null);
                                //微信转账失败
                            } else if (WithdrawalsErrorCodeEnum.FAILED.getCode().equals(status)) {
                                //退款
                                UserAccountOperatorRequest operatorRequest = new UserAccountOperatorRequest();
                                operatorRequest.setUserId(dto.getPayee());
                                operatorRequest.setAmount(dto.getAmount());
                                operatorRequest.setRemark("提现失败退款");
                                operatorRequest.setOptType(UserAccountOptTypeEnum.INCOME.getCode());
                                operatorRequest.setBizCode(UserAccountBizCode.REFUND.getCode());

                                updateRequest.setState(TradeStateEnum.FAILED.getCode());
                                updateRequest.setThirdTradeNo(res.getDetailId());
                                updateRequest.setStatusEnum(withdrawFail);
                                updateRequest.setRefund(true);

                                tradeService.updateStateAndBalance(updateRequest, operatorRequest,
                                        withdrawFail.getCode(), res.getReason());
                                appSendMessageService.userWithdrawSend(dto.getPayee(), dto.getAmount().intValue(),
                                        "提现被驳回，已退回余额，请点击查看原因");

                            }
                        }
                    }
                }
            }
        }
    }
}
