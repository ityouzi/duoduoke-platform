package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.OrderInfoService;
import com.fulihui.redisdubbo.demo.api.dto.OrderInfoDTO;
import com.fulihui.redisdubbo.demo.api.enums.OrderTypeEnum;
import com.fulihui.redisdubbo.demo.api.enums.RedPackageConfigStatusEnum;
import com.fulihui.redisdubbo.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.redisdubbo.demo.manager.OrderInfoManager;
import com.fulihui.redisdubbo.demo.manager.UserRewardRecordManager;
import com.google.common.collect.Lists;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 *
 * @author lizhi
 * @date 2018-7-12
 */
@Component
public class OrderInfoManagerImpl implements OrderInfoManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoManagerImpl.class);
    @org.apache.dubbo.config.annotation.Reference
    OrderInfoService orderInfoService;

    @Autowired
    UserRewardRecordManager userRewardRecordManager;

    @Override
    public long auditIncome(String userId, List<String> userOrderStatus, String orderType,
                            String helpStatus,String promoType) {
        List<OrderInfoDTO> all = Lists.newArrayList();

        OrderQueryInfoRequest request = new OrderQueryInfoRequest();
        request.setUserId(userId);
        request.setOrderType(orderType);
        request.setUserOrderStatus(userOrderStatus);
        request.setHelpStatus(helpStatus);
        request.setPromoType(promoType);
        request.setPage(1);
        request.setRows(10);
        TPageResult<OrderInfoDTO> result = orderInfoService.queryPage(request);
        checkResult(result);

        all.addAll(result.getValues());

        int totalPage = result.getTotalPage();

        for (int i = 2; i <= totalPage; i++) {
            request.setPage(i);
            request.setRows(10);
            TPageResult<OrderInfoDTO> pageResult = orderInfoService.queryPage(request);
            checkResult(pageResult);
            all.addAll(pageResult.getValues());
        }

        List<OrderInfoDTO> onList = Lists.newArrayList();
        List<OrderInfoDTO> offList = Lists.newArrayList();
        if (!isEmpty(all)) {
            for (OrderInfoDTO value : all) {
                //开启
                if (StringUtil.isNotBlank(value.getHelpStatus()) && StringUtil
                    .equals(value.getHelpStatus(), RedPackageConfigStatusEnum.ON.getCode())) {
                    onList.add(value);
                } else {
                    offList.add(value);
                }
            }
        }
        //常规订单 加倍订单
        long offListAuditIncome = getOffListAuditIncome(offList);

        //翻倍订单
        long onListAuditIncome = getOnListAuditIncome(onList);

        LOGGER.info("常规订单||加倍订单:{},翻倍订单:{}", offListAuditIncome, onListAuditIncome);
        return offListAuditIncome + onListAuditIncome;
    }

    private long getOnListAuditIncome(List<OrderInfoDTO> list) {
        long auditIncome = 0;
        if (!isEmpty(list)) {
            for (OrderInfoDTO infoDTO : list) {
                //返利金额
                Integer promotionAmount = infoDTO.getPromotionAmount();
                //返利佣金比率
                Integer snapshot = infoDTO.getOrderCommissionSnapshot();
                if (promotionAmount != null && snapshot != null) {
                    int amount = (promotionAmount * snapshot) / 100;
                    Double sumPercent = userRewardRecordManager.sumPercent(infoDTO.getOrderSn(),
                        infoDTO.getCustomParameters());
                    long v = (long) (amount * (sumPercent == null ? 0 : sumPercent) / 100);
                    auditIncome = amount + v + auditIncome;
                }
            }
        }
        return auditIncome;
    }

    private long getOffListAuditIncome(List<OrderInfoDTO> list) {
        long auditIncome = 0;
        if (!isEmpty(list)) {

            for (OrderInfoDTO infoDTO : list) {

                //返利金额
                Integer promotionAmount = infoDTO.getPromotionAmount();
                if (promotionAmount != null) {
                    long amount;
                    if (StringUtil.isNotBlank(infoDTO.getOrderType())
                        //商品订单加倍
                        && StringUtil.equals(infoDTO.getOrderType(), OrderTypeEnum.D.getCode())) {

                        //返利佣金比率 基本
                        Integer snapshot = infoDTO.getOrderCommissionSnapshot();
                        int snapshotAmount = (promotionAmount * snapshot) / 100;
                        Double doublePercent = infoDTO.getDoublePercent();
                        amount = (int) ((promotionAmount * doublePercent) / 100) + snapshotAmount;
                        LOGGER.info("加倍商品订单:{},{},{}", amount, promotionAmount, doublePercent);
                    } else {
                        //返利佣金比率 基本
                        Integer snapshot = infoDTO.getOrderCommissionSnapshot();
                        amount = (promotionAmount * snapshot) / 100;
                        LOGGER.info("基本商品订单:{},{},{}", amount, promotionAmount, snapshot);
                    }
                    auditIncome = amount + +auditIncome;
                }

            }
        }
        return auditIncome;
    }

    @Override
    public long confirmedCount(String userId, List<String> userOrderStatus,String promoType) {
        TSingleResult<Long> result = getResult(userId, userOrderStatus,promoType);
        return result.getValue() == null ? 0 : result.getValue();
    }

    private TSingleResult<Long> getResult(String userId, List<String> userOrderStatus, String promoType) {
        OrderQueryInfoRequest request = new OrderQueryInfoRequest();
        request.setUserId(userId);
        request.setUserOrderStatus(userOrderStatus);
        request.setPromoType(promoType);
        TSingleResult<Long> result = orderInfoService.queryCount(request);
        checkResult(result);
        return result;
    }

    @Override
    public long settlementCount(String userId, List<String> userOrderStatus,String promoType) {
        TSingleResult<Long> result = getResult(userId, userOrderStatus,promoType);
        return result.getValue() == null ? 0 : result.getValue();
    }

    @Override
    public long recentCount(String userId, List<String> userOrderStatus, Date startTime,
                            Date endTime, List<String> orderStatus,String promoType) {

        OrderQueryInfoRequest request = new OrderQueryInfoRequest();
        request.setUserId(userId);
        request.setUserOrderStatus(userOrderStatus);
        request.setOrderStatus(orderStatus);
        request.setStartOrderCreateTime(startTime);
        request.setEndOrderCreateTime(endTime);
        request.setPromoType(promoType);
        TSingleResult<Long> result = orderInfoService.queryCount(request);
        checkResult(result);
        return result.getValue() == null ? 0 : result.getValue();
    }

}
