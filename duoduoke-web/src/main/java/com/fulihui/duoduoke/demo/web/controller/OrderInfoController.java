package com.fulihui.duoduoke.demo.web.controller;


import com.fulihui.duoduoke.demo.api.dto.ExemptionGoodsDTO;
import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.RedPackageDBLConfigDTO;
import com.fulihui.duoduoke.demo.api.enums.OrderPromoTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.OrderTypeEnum;
import com.fulihui.duoduoke.demo.api.enums.RedPackageConfigStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum;
import com.fulihui.duoduoke.demo.api.request.ExemptionRequest;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.duoduoke.demo.api.util.Collections;
import com.fulihui.duoduoke.demo.web.integration.ExemptionServiceClient;
import com.fulihui.duoduoke.demo.web.integration.OrderInfoServiceClient;
import com.fulihui.duoduoke.demo.web.integration.RedPackageDBLConfigServiceClient;
import com.fulihui.duoduoke.demo.web.manager.OrderInfoManager;
import com.fulihui.duoduoke.demo.web.manager.UserRewardRecordManager;
import com.fulihui.duoduoke.demo.web.param.UserOrderParam;
import com.fulihui.duoduoke.demo.web.util.Principal;
import com.fulihui.duoduoke.demo.web.util.PrincipalUtil;
import com.fulihui.duoduoke.demo.web.vo.OrderStatusCountVO;
import com.fulihui.duoduoke.demo.web.vo.UserOrderVO;
import com.fulihui.duoduoke.demo.common.except.BizException;
import com.fulihui.duoduoke.demo.common.except.CommonErrors;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.near.webmvcsupport.view.PageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum.N_PAY;
import static com.fulihui.duoduoke.demo.api.enums.DuoDuoOrderStatusEnum.Y_PAY;
import static com.fulihui.duoduoke.demo.api.enums.UserOrderStatusEnum.*;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.toolkit.common.DateUtils.*;
import static org.near.toolkit.common.EnumUtil.queryByCode;
import static org.near.toolkit.common.StringUtil.isNotBlank;
import static org.near.webmvcsupport.view.JsonResultBuilder.succ;
import static org.near.webmvcsupport.view.PageViewBuilder.build;

/**
 * @author lizhi
 * @date 2018-7-11
 */
@RestController
@RequestMapping("/orderInfo")
@Api(description = "用户订单信息")
public class OrderInfoController {

    private static final Logger      LOGGER          = LoggerFactory
        .getLogger(OrderInfoController.class);
    @Autowired
    OrderInfoServiceClient orderInfoServiceClient;
    @Autowired
    ExemptionServiceClient exemptionServiceClient;

    @Autowired
    PrincipalUtil principalUtil;

    public final static String       START_SUFFIX    = " 00:00:00";

    public final static String       END_SUFFIX      = " 23:59:59";

    public final String              chineseDtFormat = "MM月dd日";

    @Autowired
    OrderInfoManager orderInfoManager;
    @Autowired
    UserRewardRecordManager userRewardRecordManager;
    @Autowired
    RedPackageDBLConfigServiceClient redPackageDBLConfigServiceClient;

    @PostMapping("shareTitle")
    @ApiOperation("查询分享图和分享标题")
    public JsonResult<RedPackageDBLConfigDTO> shareTitle() {
        TSingleResult<RedPackageDBLConfigDTO> result = redPackageDBLConfigServiceClient
            .getRedPackageDBLConfig();
        return JsonResultBuilder.succ(result.getValue());
    }

    @PostMapping("queryOrderCount")
    @ApiOperation("查询用户订单数量")
    public JsonResult<OrderStatusCountVO> queryOrderCount() {

        Principal principal = PrincipalUtil.getPrincipal();
        OrderStatusCountVO vo = new OrderStatusCountVO();
        long confirmedCount = orderInfoManager.confirmedCount(principal.getUserId(),
            Lists.newArrayList(TO_BE_CONFIRMED.getCode()), OrderPromoTypeEnum.ORDINARY.getCode());
        long settlementCount = orderInfoManager.settlementCount(principal.getUserId(),
            Lists.newArrayList(TO_BE_SETTLEMENT.getCode()),OrderPromoTypeEnum.ORDINARY.getCode());
        vo.setConfirmedCount(confirmedCount);
        vo.setSettlementCount(settlementCount);
        Date now = new Date();
        try {
            //查询
            Date startTime = parseNewFormat(formatWebFormat(addDays(now, -2)) + START_SUFFIX);
            Date endTime = parseNewFormat(formatWebFormat(now) + END_SUFFIX);
            long recentCount = orderInfoManager.recentCount(principal.getUserId(), null, startTime,
                endTime, Lists.newArrayList(Y_PAY.getCode()),OrderPromoTypeEnum.ORDINARY.getCode());
            vo.setRecentCount(recentCount);
        } catch (ParseException ignore) {
        }
        return JsonResultBuilder.succ(vo);
    }

    @PostMapping("queryOrderSn")
    @ApiOperation("查询用户单条订单信息")
    public JsonResult<UserOrderVO> queryOrderSn(@RequestBody UserOrderParam param) {

        if (param == null || StringUtil.isBlank(param.getOrderSn())) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        OrderQueryInfoRequest request = new OrderQueryInfoRequest();
        Principal principal = PrincipalUtil.getPrincipal();
        request.setOrderSn(param.getOrderSn());
        request.setUserId(principal.getUserId());
        TSingleResult<OrderInfoDTO> result = orderInfoServiceClient.queryByOrderSn(request);
        if (result.getValue() == null) {
            throw new BizException(CommonErrors.ILLIGEAL_REQUEST_ERROR);
        }
        return JsonResultBuilder.succ(apply(result.getValue()));
    }

    @PostMapping("queryOrder")
    @ApiOperation("查询用户订单信息")
    public JsonResult<PageView<UserOrderVO>> queryOrder(@RequestBody UserOrderParam param) {

        OrderQueryInfoRequest request = new OrderQueryInfoRequest();

        Principal principal = PrincipalUtil.getPrincipal();

        request.setUserId(principal.getUserId());
        request.setPage(param.getPage());
        request.setRows(param.getRows());
        if (isNotBlank(param.getOrderStatus()) && !StringUtil.equals("0", param.getOrderStatus())) {
            request.setUserOrderStatus(Lists.newArrayList(param.getOrderStatus()));
        }
        request.setSortInfo("order_create_time desc");
        request.setPromoType(OrderPromoTypeEnum.ORDINARY.getCode());
        TPageResult<OrderInfoDTO> result = orderInfoServiceClient.queryPage(request);
        checkResult(result);
        List<OrderInfoDTO> values = result.getValues();
        List<UserOrderVO> collect = values.stream().map(this::apply).collect(Collectors.toList());
        PageView<UserOrderVO> build = build(collect, result.getPage(), result.getRows(),
            result.getTotalRows());
        return succ(build);

    }

    /**
     * @param item
     * @return UserOrderVO
     */

    private UserOrderVO apply(OrderInfoDTO item) {
        UserOrderVO vo = new UserOrderVO();
        vo.setGoodsName(item.getGoodsName());
        vo.setOrderSn(item.getOrderSn());
        vo.setGoodsThumbnailUrl(item.getGoodsThumbnailUrl());
        vo.setExtOrderStatus(item.getOrderStatus());
        vo.setExtOrderStatusDesc(item.getOrderStatusDesc());
        vo.setOrderCreateTime(formatWebFormat(item.getOrderCreateTime()));
        vo.setOrderType(item.getOrderType());
        //订单翻倍时间过期时间  24小时之后过期
        Date gmtExpired = addDays(item.getGmtCreate(), 1);
        //查询助力信息
        Double sumPercent = getSumPercent(item);
        if (isNotBlank(item.getHelpStatus())) {
            boolean b = StringUtil.equals(item.getHelpStatus(),
                RedPackageConfigStatusEnum.ON.getCode());
            if (b) {
                //如果过期了 || 或者订单结算了, 
                if (new Date().after(gmtExpired)
                    || StringUtil.equals(item.getUserOrderStatus(), ALREADY_TO_ACCOUNT.getCode())) {
                    vo.setHelpStatus("end");
                } else {
                    vo.setHelpStatus(RedPackageConfigStatusEnum.ON.getCode());
                }
            } else {
                vo.setHelpStatus(item.getHelpStatus());
            }
        } else {
            vo.setHelpStatus(item.getHelpStatus());
        }

        //订单状态描述
        UserOrderStatusEnum status = queryByCode(item.getUserOrderStatus(),
            UserOrderStatusEnum.class);
        if (status != null) {
            vo.setOrderStatusDesc(status.getDesc());
            vo.setOrderStatus(status.getCode());
            String orderType = item.getOrderType();

            OrderTypeEnum orderTypeEnum = queryByCode(orderType, OrderTypeEnum.class);
            //订单类型为免单返现
            boolean b = orderTypeEnum != null && orderTypeEnum == OrderTypeEnum.Y;

            //待结算
            if (status == TO_BE_SETTLEMENT) {
                //订单确认收货时间
                Date orderReceiveTime = item.getOrderReceiveTime();
                if (orderReceiveTime != null) {
                    Date date = addDays(orderReceiveTime, b ? 7 : 16);
                    String orderDesc = status.getOrderDesc();
                    String format = String.format(orderDesc, format(date, chineseDtFormat));
                    LOGGER.debug("待结算,订单描述格式,format:{}", format);
                    vo.setOrderDesc(format);
                }
            } else if (status == TO_BE_CONFIRMED) {
                boolean bl = StringUtil.equals(N_PAY.getCode(), item.getOrderStatus())
                             && StringUtil.equals("待支付", item.getOrderStatusDesc());
                if (bl) {
                    vo.setOrderDesc("去付款");
                } else {
                    String format;
                    if (b) {
                        format = String.format(status.getOrderDesc(), "7");
                    } else {
                        format = String.format(status.getOrderDesc(), "16");
                    }
                    vo.setOrderDesc(format);
                }
            } else {
                String format = String.format(status.getOrderDesc(),
                    formatWebFormat(item.getGmtModified()));
                LOGGER.debug("待确认,订单描述格式,format:{}", format);
                vo.setOrderDesc(format);
            }
        }
        if (item.getOrderAmount() != null) {
            Money money = new Money();
            money.setCent(item.getOrderAmount());
            vo.setOrderTotal(money.getAmount().toString());
        }
        //日志
        log(item, gmtExpired);
        //自购比例金额
        long amount = (item.getPromotionAmount() * item.getOrderCommissionSnapshot()) / 100;
        Money m = new Money();
        m.setCent(amount);
        vo.setRebateAmount(m.toString());

        if (item.getDoublePercent() != null) {
            //订单商品加倍金额
            Money d = new Money();
            long v = (long) (item.getPromotionAmount() * item.getDoublePercent() / 100);
            d.setCent(v);
            //加倍金额
            vo.setDoubleAmount(d.toString());
            //基础金额
            vo.setBasisAmount(m.toString());
            //返利金额
            vo.setRebateAmount(m.add(d).toString());
        }
        //订单助力翻倍金额
        if (sumPercent != null) {
            long v = (long) (amount * sumPercent / 100);
            Money f = new Money();
            f.setCent(v);
            vo.setHelpMoney(f.toString());
        }

        if (item.getExemptionAmount() != null) {
            Money exe = new Money();
            exe.setCent(item.getExemptionAmount());
            vo.setCashBackAmount(exe.toString());
            ExemptionRequest request = new ExemptionRequest();
            request.setGoodsId(Long.valueOf(item.getGoodsId()));
            TMultiResult<ExemptionGoodsDTO> result = exemptionServiceClient.query(request);
            if (!Collections.isEmpty(result.getValues())) {
                vo.setExemptionGoodsName(result.getValues().get(0).getExemptionGoodsName());
            }
        }

        return vo;
    }

    private boolean isaBoolean(Double sumPercent) {
        return sumPercent != null && sumPercent >= 100;
    }

    private Double getSumPercent(OrderInfoDTO item) {
        try {
            return userRewardRecordManager.sumPercent(item.getOrderSn(),
                item.getCustomParameters());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    private void log(OrderInfoDTO item, Date gmtExpired) {
        //返利金额 快照比例
        LOGGER.debug("订单号:{},配置用户百分比:{},拼多多订单返利金额:{},翻倍失效时间:{}", item.getOrderSn(),
            item.getOrderCommissionSnapshot(), item.getPromotionAmount(),
            formatNewFormat(gmtExpired));
    }
}
