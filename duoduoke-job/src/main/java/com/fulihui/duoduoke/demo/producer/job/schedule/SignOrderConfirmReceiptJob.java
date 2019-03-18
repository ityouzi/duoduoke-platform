package com.fulihui.duoduoke.demo.producer.job.schedule;


import static com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum.C_RECEIPT;
import static com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum.TO_BE_SETTLEMENT;
import static com.google.common.collect.Lists.newArrayList;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.toolkit.common.DateUtils.formatNewFormat;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.fulihui.duoduoke.demo.api.api.OrderInfoService;
import com.fulihui.duoduoke.demo.api.api.UserExemptionService;
import com.fulihui.duoduoke.demo.api.api.sign.SignAwardService;
import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.UserExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.enums.OrderPromoTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.SignPrizeStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.UserExemptionStateEnum;
import com.fulihui.duoduoke.demo.api.request.IdRequest;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.near.servicesupport.result.TPageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import com.fulihui.duoduoke.demo.producer.job.Consts;

/**
 * @author lizhi
 * @date 2018-11-13
 */
@Component
public class SignOrderConfirmReceiptJob implements SimpleJob {

    private volatile boolean    running            = false;
    @org.apache.dubbo.config.annotation.Reference
    SignAwardService signAwardService;

    @org.apache.dubbo.config.annotation.Reference
    UserExemptionService userExemptionService;
    @org.apache.dubbo.config.annotation.Reference
    OrderInfoService orderInfoService;

    private static final Logger LOGGER             = LoggerFactory
        .getLogger(SignOrderConfirmReceiptJob.class);

    private static final Logger JOB_MONITOR_LOGGER = LoggerFactory
        .getLogger(Consts.LoggerName.JOB_MONITOR);

    ScheduledExecutorService    executorService;

    @PostConstruct
    void init() {
        executorService = new ScheduledThreadPoolExecutor(3, new BasicThreadFactory.Builder()
            .namingPattern("SignOrderConfirmReceiptJob-schedule-pool-%d").daemon(true).build());
    }

    @PreDestroy
    void destroy() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override
    public void execute(ShardingContext shardingContext) {
        Date date = new Date();
        LOGGER.info("用户确认收货签到周期结算:{}", formatNewFormat(date));
        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }
        running = true;
        new OrderQueryRunnable().doRun();
        try {
            SignAwardRequest request = new SignAwardRequest();
            request.setPrizeStatus(newArrayList(SignPrizeStatusEnum.BIND.getCode()));
            request.setBindOrderStatus(C_RECEIPT.getCode());
            TPageResult<SignAwardDTO> result = signAwardService.queryReceipt(request);
            checkResult(result);
            int totalPage = result.getTotalPage();
            for (int i = 1; i <= totalPage; i++) {
                request.setPage(i);
                TPageResult<SignAwardDTO> pageResult = signAwardService.queryReceipt(request);
                checkResult(pageResult);
                List<SignAwardDTO> list = pageResult.getValues();
                if (!isEmpty(list)) {
                    for (SignAwardDTO item : list) {
                        SignAwardRequest awardRequest = new SignAwardRequest();
                        awardRequest.setId(item.getId());
                        signAwardService.confirmReceiptAddBalance(awardRequest);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        try {
            IdRequest idRequest = new IdRequest();
            idRequest.setState(UserExemptionStateEnum.USED.getCode());
            idRequest.setBindOrderStatus(C_RECEIPT.getCode());
            TPageResult<UserExemptionGoodsDTO> result = userExemptionService
                .queryReceipt(idRequest);
            checkResult(result);
            int totalPage = result.getTotalPage();
            for (int i = 1; i <= totalPage; i++) {
                idRequest.setPage(i);
                TPageResult<UserExemptionGoodsDTO> pageResult = userExemptionService
                    .queryReceipt(idRequest);
                checkResult(pageResult);
                List<UserExemptionGoodsDTO> list = pageResult.getValues();
                if (!isEmpty(list)) {
                    for (UserExemptionGoodsDTO item : list) {
                        IdRequest awardRequest = new IdRequest();
                        awardRequest.setId(item.getId());
                        userExemptionService.confirmReceipt(awardRequest);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        running = false;
        LOGGER.info("running改值成功");

    }

    class OrderQueryRunnable implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

        }

        void doRun() {
            try {
                // FIXME: 2019-02-14 解决分页改状态
                OrderQueryInfoRequest infoRequest = new OrderQueryInfoRequest();
                infoRequest.setPromoType(OrderPromoTypeEnum.ORDINARY.getCode());
                infoRequest.setOrderStatus(newArrayList(C_RECEIPT.getCode()));
                infoRequest.setUserOrderStatus(newArrayList(TO_BE_SETTLEMENT.getCode()));
                infoRequest.setRows(50);
                infoRequest.setPage(1);
                TPageResult<OrderInfoDTO> result = orderInfoService
                    .queryOrderExceedDay(infoRequest);
                checkResult(result);
                List<OrderInfoDTO> list = result.getValues();
                if (!isEmpty(list)) {
                    for (OrderInfoDTO item : list) {
                        OrderQueryInfoRequest request = new OrderQueryInfoRequest();
                        request.setUserId(item.getCustomParameters());
                        request.setOrderSn(item.getOrderSn());
                        orderInfoService.confirmReceiptAddBalance(request);
                    }
                } else {
                    JOB_MONITOR_LOGGER.info("订单确认收货15天后结算,未查询到数据,不做结算");
                }

            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    public static void main(String[] args) {

    }
}
