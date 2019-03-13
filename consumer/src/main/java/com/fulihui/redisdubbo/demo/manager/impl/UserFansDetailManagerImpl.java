package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.UserFansDetailService;
import com.fulihui.redisdubbo.demo.api.dto.UserFansDetailDTO;
import com.fulihui.redisdubbo.demo.api.enums.DuoDuoOrderStatusEnum;
import com.fulihui.redisdubbo.demo.api.request.OrderFansDetailRequest;
import com.fulihui.redisdubbo.demo.api.request.UserFansDetailRequest;
import com.fulihui.redisdubbo.demo.manager.UserFansDetailManager;
import com.fulihui.redisdubbo.demo.vo.UserInvitationVO;
import com.fulihui.redisdubbo.demo.vo.UserShareFansVO;
import com.google.common.collect.Lists;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.model.Money;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-8-1
 */
@Component
public class UserFansDetailManagerImpl implements UserFansDetailManager {

    @org.apache.dubbo.config.annotation.Reference
    UserFansDetailService userFansDetailService;

    /**
     * 邀请总览明细
     *
     * @param userId the user id
     * @return
     */
    @Override
    public UserInvitationVO invitation(String userId) {
        UserInvitationVO vo = new UserInvitationVO();

        Date now = new Date();
        UserFansDetailRequest request = new UserFansDetailRequest();
        request.setUserId(userId);
        //今日
        UserFansDetailDTO day = query(now, request);
        if (day == null) {
            vo.setDayFansNum(0);
            vo.setDayOrder(0);
            vo.setDaySubsidyAmount("0.00");
        } else {
            int fansNum = (day.getOneFansNum() == null ? 0 : day.getOneFansNum())
                          + (day.getTwoFansNum() == null ? 0 : day.getTwoFansNum());
            vo.setDayFansNum(fansNum);
            vo.setDayOrder(day.getOrderNum() == null ? 0 : day.getOrderNum());
            vo.setDaySubsidyAmount(convert(day.getSubsidyAmount()));
        }
        //昨日
        UserFansDetailDTO yesterday = query(DateUtils.addDays(now, -1), request);
        if (yesterday == null) {
            vo.setYesterdayFansNum(0);
            vo.setYesterdayOrder(0);
            vo.setYesterdaySubsidyAmount("0.00");
        } else {
            int fansNum = (yesterday.getOneFansNum() == null ? 0 : yesterday.getOneFansNum())
                          + (yesterday.getTwoFansNum() == null ? 0 : yesterday.getTwoFansNum());
            vo.setYesterdayFansNum(fansNum);
            vo.setYesterdayOrder(yesterday.getOrderNum() == null ? 0 : yesterday.getOrderNum());
            vo.setYesterdaySubsidyAmount(
                convert(yesterday.getSubsidyAmount() == null ? 0 : yesterday.getSubsidyAmount()));
        }
        //本月
        request.setGmtCreate(now);
        TSingleResult<UserFansDetailDTO> result = userFansDetailService.querySumByUserId(request);
        checkResult(result);
        UserFansDetailDTO value = result.getValue();
        if (value != null) {
            int fansNum = (value.getOneFansNum() == null ? 0 : value.getOneFansNum())
                          + (value.getTwoFansNum() == null ? 0 : value.getTwoFansNum());
            vo.setMonthFansNum(fansNum);
            vo.setMonthOrder(value.getOrderNum() == null ? 0 : value.getOrderNum());
            vo.setMonthSubsidyAmount(
                convert(value.getSubsidyAmount() == null ? 0 : value.getSubsidyAmount()));
        }
        //累计
        vo.setShareFans(accumulative(userId));
        return vo;
    }

    /**
     * 邀请总览统计
     *
     * @param userId the user id
     * @return
     */
    @Override
    public UserShareFansVO accumulative(String userId) {
        UserShareFansVO vo = new UserShareFansVO();
        UserFansDetailRequest request = new UserFansDetailRequest();
        request.setUserId(userId);
        TSingleResult<UserFansDetailDTO> result = userFansDetailService.querySumByUserId(request);
        checkResult(result);
        UserFansDetailDTO value = result.getValue();
        int fansNum = value.getTwoFansNum() + value.getOneFansNum();
        vo.setAccumulativeFans(fansNum);

        OrderFansDetailRequest detail = new OrderFansDetailRequest();
        detail.setPUserId(userId);
        detail.setOrderStatus(Lists.newArrayList(DuoDuoOrderStatusEnum.AUDIT_SUCCESS.getCode()));

        TSingleResult<Long> orderNumCount = userFansDetailService.queryOrderNumCount(detail);
        checkResult(orderNumCount);

        vo.setAccumulativeOrderNum(
            orderNumCount.getValue() == null ? 0 : orderNumCount.getValue().intValue());

        TSingleResult<Long> querySumAmount = userFansDetailService.querySumAmount(detail);
        checkResult(querySumAmount);
        vo.setAccumulativeIncome(convert(querySumAmount.getValue().intValue()));
        return vo;
    }

    String convert(Integer amount) {
        Money money = new Money();
        money.setCent(amount == null ? 0 : amount);
        return money.toString();
    }

    private UserFansDetailDTO query(Date now, UserFansDetailRequest request) {
        request.setStatisticsDate(now);
        TMultiResult<UserFansDetailDTO> result = userFansDetailService.query(request);
        checkResult(result);
        List<UserFansDetailDTO> list = result.getValues();
        return isEmpty(list) ? null : list.get(0);

    }
}
