package com.fulihui.redisdubbo.demo.producer.service;


import com.fulihui.redisdubbo.demo.api.api.ActivityConfigService;
import com.fulihui.redisdubbo.demo.api.api.AppConfigService;
import com.fulihui.redisdubbo.demo.api.api.OrderInfoService;
import com.fulihui.redisdubbo.demo.api.api.RedPackageDBLConfigService;
import com.fulihui.redisdubbo.demo.api.dto.*;
import com.fulihui.redisdubbo.demo.api.dto.promotion.GroupChannelsOrderDTO;
import com.fulihui.redisdubbo.demo.api.dto.promotion.PromotionChannelsDTO;
import com.fulihui.redisdubbo.demo.api.enums.*;
import com.fulihui.redisdubbo.demo.api.request.GoodsDoublesRewardRequest;
import com.fulihui.redisdubbo.demo.api.request.OrderInfoTakeAmountRequest;
import com.fulihui.redisdubbo.demo.api.request.OrderInfoUpdateRequest;
import com.fulihui.redisdubbo.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.redisdubbo.demo.producer.biz.processor.OrderStatusDispatcher;
import com.fulihui.redisdubbo.demo.producer.biz.processor.UserOrderStatusProcessor;
import com.fulihui.redisdubbo.demo.producer.config.AppServiceConfig;
import com.fulihui.redisdubbo.demo.producer.config.H5ServiceConfig;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.OrderInfoExample;
import com.fulihui.redisdubbo.demo.producer.dal.dataobj.UserExemptionGoods;
import com.fulihui.redisdubbo.demo.producer.lock.DistributedLock;
import com.fulihui.redisdubbo.demo.producer.model.OrderSendPushModel;
import com.fulihui.redisdubbo.demo.producer.repository.OrderInfoRepository;
import com.fulihui.redisdubbo.demo.producer.repository.PromotionChannelsOrderRepository;
import com.fulihui.redisdubbo.demo.producer.repository.PromotionChannelsRepository;
import com.fulihui.redisdubbo.demo.producer.repository.UserExemptionGoodsRepository;
import com.fulihui.redisdubbo.demo.producer.util.Consts;
import com.fulihui.redisdubbo.demo.producer.zubs.Const;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.error.Errors;
import org.near.servicesupport.result.*;
import org.near.servicesupport.util.ServiceAssert;
import org.near.toolkit.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


import static com.fulihui.redisdubbo.demo.api.enums.ActivityTypeEnum.H5Exemption;
import static com.fulihui.redisdubbo.demo.api.enums.OrderPromotionSourceEnum.H5;
import static java.lang.Integer.valueOf;
import static org.near.servicesupport.util.ServiceAssert.notBlank;
import static org.near.servicesupport.util.ServiceAssert.notNull;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.toolkit.common.DateUtils.addMinutes;
import static org.near.toolkit.common.DateUtils.formatNewFormat;
import static org.near.toolkit.common.EnumUtil.queryByCode;
import static org.near.toolkit.common.StringUtil.isBlank;
import static org.near.toolkit.common.StringUtil.isNotBlank;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * @author lizhi
 * @date 2018-7-10
 */
@Service(version = "${demo.service.version}")
public class OrderInfoServiceImpl implements OrderInfoService {

    private static final Logger ORDER_FANS_BIZ_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);
    private static final Logger JOB_MONITOR_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.JOB_MONITOR);
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrderInfoServiceImpl.class);

    @Autowired
    PromotionChannelsOrderRepository promotionChannelsOrderRepository;

    @Autowired
    PromotionChannelsRepository promotionChannelsRepository;

    @Autowired
    OrderInfoRepository orderInfoRepository;

    @Autowired
    OrderStatusDispatcher orderStatusDispatcher;

    @Autowired
    AppConfigService appConfigService;

    @Autowired
    RedPackageDBLConfigService redPackageDBLConfigService;

    ScheduledExecutorService executorService;

    @Autowired
    AppServiceConfig appServiceConfig;

    @Autowired
    H5ServiceConfig h5ServiceConfig;


    @Autowired
    UserExemptionGoodsRepository userExemptionGoodsRepository;
    @Autowired
    ActivityConfigService activityConfigService;

    @Resource
    DistributedLock zookeeperDistributedLock;

    @PostConstruct
    void init() {
        executorService = new ScheduledThreadPoolExecutor(5, new BasicThreadFactory.Builder()
                .namingPattern("OrderInfoServiceImpl-schedule-pool-%d").daemon(true).build());
    }

    @PreDestroy
    void destroy() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override
    public TPageResult<OrderInfoDTO> queryOrderExceedDay(OrderQueryInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<OrderInfoDTO> dtoList = orderInfoRepository.queryOrderExceedDay(
                request.getOrderStatus().get(0), request.getUserOrderStatus().get(0),
                request.getPromoType(), request.start4Mysql(), request.getRows());

        int count = 0;
        if (!CollectionUtils.isEmpty(dtoList)) {
            count = orderInfoRepository.queryOrderExceedDayCount(request.getOrderStatus().get(0),
                    request.getUserOrderStatus().get(0), request.getPromoType());
        }
        return ResultBuilder.succTPage(dtoList, request.getPage(), request.getRows(), count);
    }

    @Override
    public TPageResult<GroupChannelsOrderDTO> queryGroupPage(OrderQueryInfoRequest request) {
        ServiceAssert.notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<GroupChannelsOrderDTO> dtoList = orderInfoRepository.queryGroup(request.start4Mysql(),
                request.getRows(), request.getStartOrderPayDate(), request.getEndOrderPayDate(),
                request.getPromoType(), request.getOrderStatus(), request.getUserOrderStatus());
        int count = 0;
        if (!CollectionUtils.isEmpty(dtoList)) {
            List<Integer> queryGroup = orderInfoRepository.queryGroupCountExt(
                    request.getStartOrderPayDate(), request.getEndOrderPayDate(),
                    request.getPromoType(), request.getOrderStatus(), request.getUserOrderStatus());
            if (!CollectionUtils.isEmpty(queryGroup)) {
                count = queryGroup.size();
            }
        }
        return ResultBuilder.succTPage(dtoList, request.getPage(), request.getRows(), count);
    }

    @Override
    public TPageResult<OrderInfoDTO> queryPage(OrderQueryInfoRequest request) {

        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        OrderInfoExample example = toExample(request);
        List<OrderInfoDTO> list = orderInfoRepository.query(example);
        long count = 0;
        if (!isEmpty(list)) {
            count = orderInfoRepository.count(example);
        }
        return ResultBuilder.succTPage(list, request.getPage(), request.getRows(), (int) count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmReceiptAddBalance(OrderQueryInfoRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getUserId(), Errors.Commons.REQUEST_PARAMETER_ERROR);
        notBlank(request.getOrderSn(), Errors.Commons.REQUEST_PARAMETER_ERROR);

        String key = "order_sn_userInfo_" + request.getOrderSn();
        boolean lockResult = zookeeperDistributedLock.lock(key, 3000);
        LOGGER.info(lockResult ? "order_sn_userInfo_.get lock success : " + key
                : "get lock failed : " + key);
        if (lockResult) {
            try {
                List<OrderInfo> list = orderInfoRepository.queryByOrderSn(request.getOrderSn(),
                        request.getUserId());
                if (CollectionUtils.isEmpty(list)) {
                    return;
                }
                OrderInfo oldOrder = list.get(0);
                //如果审核成功 直接返回
                if (StringUtil.equals(oldOrder.getOrderStatus(),
                        DuoDuoOrderStatusEnum.AUDIT_SUCCESS.getCode())) {
                    return;
                }
                //必须是确认收货状态 并且 确认收货+15天后 返利
                if (StringUtil.equals(oldOrder.getOrderStatus(),
                        DuoDuoOrderStatusEnum.C_RECEIPT.getCode())) {
                    oldOrder.setOrderStatus(DuoDuoOrderStatusEnum.AUDIT_SUCCESS.getCode());
                    oldOrder.setOrderStatusDesc(DuoDuoOrderStatusEnum.AUDIT_SUCCESS.getDesc());
                    oldOrder.setUserOrderStatus(UserOrderStatusEnum.ALREADY_TO_ACCOUNT.getCode());
                    oldOrder.setUserOrderStatusDesc(UserOrderStatusEnum.ALREADY_TO_ACCOUNT.getDesc());
                    orderInfoRepository.update(oldOrder);
                    UserOrderStatusProcessor processor = orderStatusDispatcher
                            .get(UserOrderStatusEnum.ALREADY_TO_ACCOUNT);
                    processor.execute(oldOrder);
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            } finally {
                zookeeperDistributedLock.releaseLock(key);
                LOGGER.info("order_sn_userInfo_.release lock : " + key);
            }
        }

    }

    @Override
    public TSingleResult<OrderInfoDTO> queryByOrderSn(OrderQueryInfoRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        List<OrderInfo> list = orderInfoRepository.queryByOrderSn(request.getOrderSn(),
                request.getUserId());
        if (CollectionUtils.isEmpty(list)) {
            return ResultBuilder.succTSingle(null);
        }
        List<OrderInfoDTO> collect = list.stream().map(item -> {
            OrderInfoDTO infoDTO = new OrderInfoDTO();
            BeanUtils.copyProperties(item, infoDTO);
            return infoDTO;
        }).collect(Collectors.toList());
        return ResultBuilder.succTSingle(collect.get(0));
    }

    @Override
    public TMultiResult<OrderInfoDTO> queryTMultiResult(OrderQueryInfoRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);

        OrderInfoExample example = getOrderInfoExample(request);

        List<OrderInfoDTO> list = orderInfoRepository.query(example);
        return ResultBuilder.succTMulti(list);
    }

    private OrderInfoExample getOrderInfoExample(OrderQueryInfoRequest request) {
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        if (isNotBlank(request.getUserId())) {
            criteria.andCustomParametersEqualTo(request.getUserId());
        }
        List<String> userOrderStatus = request.getUserOrderStatus();
        if (!isEmpty(userOrderStatus)) {
            criteria.andUserOrderStatusIn(request.getUserOrderStatus());
        }

        List<String> orderStatus = request.getOrderStatus();
        if (!isEmpty(orderStatus)) {
            criteria.andOrderStatusIn(request.getOrderStatus());
        }

        Date startOrderCreateTime = request.getStartOrderCreateTime();
        if (startOrderCreateTime != null) {
            criteria.andOrderCreateTimeGreaterThanOrEqualTo(startOrderCreateTime);
        }
        Date endOrderCreateTime = request.getEndOrderCreateTime();

        if (endOrderCreateTime != null) {
            criteria.andOrderCreateTimeLessThanOrEqualTo(endOrderCreateTime);
        }
        Date startGmtCreateTime = request.getStartGmtCreateTime();
        if (startGmtCreateTime != null) {
            criteria.andGmtCreateGreaterThanOrEqualTo(startGmtCreateTime);
        }
        Date endGmtCreateTime = request.getEndGmtCreateTime();
        if (endGmtCreateTime != null) {
            criteria.andGmtCreateLessThanOrEqualTo(endGmtCreateTime);
        }

        if (request.getOrderSn() != null) {
            criteria.andOrderSnEqualTo(request.getOrderSn());
        }
        if (isNotBlank(request.getHelpStatus())) {
            criteria.andHelpStatusEqualTo(request.getHelpStatus());
        }

        if (isNotBlank(request.getOrderType())) {
            criteria.andOrderTypeEqualTo(request.getOrderType());
        }

        if (StringUtil.isNotBlank(request.getPromoType())) {
            criteria.andPromoTypeEqualTo(request.getPromoType());
        }
        if (StringUtil.isNotBlank(request.getPId())) {
            criteria.andPIdEqualTo(request.getPId());
        }

        if (request.getOrderPayDateExt() != null) {
            criteria.andOrderPayTimeExtEqualTo(request.getOrderPayDateExt());
        }
        if (request.getStartOrderPayDate() != null) {
            criteria.andOrderPayTimeBetween(request.getStartOrderPayDate(),
                    request.getEndOrderPayDate());
        }
        if (StringUtil.isNotBlank(request.getPromoType())) {
            criteria.andPromoTypeEqualTo(request.getPromoType());
        }
        return example;
    }

    @Override
    public TSingleResult<Long> queryCount(OrderQueryInfoRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        OrderInfoExample example = getOrderInfoExample(request);
        long count = orderInfoRepository.count(example);
        return ResultBuilder.succTSingle(count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult takeOrderInfoAmount(OrderInfoTakeAmountRequest request) {
        notNull(request, Errors.Commons.REQUEST_PARAMETER_ERROR);
        //订单数据转换
        // FIXME: 2019-01-02 拼多多列表接口数据不稳定.，起两个定时任务去拉，一个列表，一个详情，锁订单号解决并发问题
        String key = "order_sn_userInfo_" + request.getOrderSn();
        boolean lockResult = zookeeperDistributedLock.lock(key, 3000);
        LOGGER.info(lockResult ? "order_sn_userInfo_.get lock success : " + key
                : "get lock failed : " + key);

        if (lockResult) {
            try {
                OrderInfo info = convertOrderInfo(request);
                List<PromotionChannelsDTO> itemList = promotionChannelsRepository
                        .queryByPid(info.getPId(), SwitchEnum.ENABLE.getCode());
                if (!CollectionUtils.isEmpty(itemList)) {
                    info.setChannelsCode(itemList.get(0).getChannelsCode());
                    info.setOrderPromotionSource(H5.getCode());
                }
                String channelsCode = info.getChannelsCode();
                String orderPromotionSource = info.getOrderPromotionSource();
                LOGGER.info("channelsCode:{}", channelsCode);
                boolean b = StringUtil.isNotBlank(channelsCode)
                        && StringUtil.isNotBlank(orderPromotionSource) && StringUtil.equals(
                        orderPromotionSource, H5.getCode());
                if (b) {
                    PromotionChannelsDTO item = promotionChannelsRepository
                            .queryByCode(channelsCode);
                    if (item != null) {

                        OrderInfoDTO oldOrder = promotionChannelsOrderRepository
                                .query(info.getOrderSn(), channelsCode);
                        if (oldOrder == null) {
                            //如果开启
                            boolean equals = StringUtil.equals(item.getChannelsStatus(),
                                    SwitchEnum.ENABLE.getCode());
                            Double channelsProportion = equals ? item.getChannelsProportion() : 0;
                            info.setOrderPromotionCommission(channelsProportion);
                            promotionChannelsOrderRepository.insertSelective(info);
                            //转换对应订单状态
                            UserOrderStatusEnum userOrderStatus = queryByCode(
                                    info.getUserOrderStatus(), UserOrderStatusEnum.class);
                            UserOrderStatusProcessor processor = orderStatusDispatcher
                                    .get(userOrderStatus);
                            processor.onEvent(info);
                        } else {
                            //如果远程接口拉取的订单数据状态不一样
                            if (!StringUtil.equals(oldOrder.getOrderStatus(),
                                    info.getOrderStatus())) {
                                DuoDuoOrderStatusEnum orderEnum = queryByCode(info.getOrderStatus(),
                                        DuoDuoOrderStatusEnum.class);
                                //如果拉取多多客订单状态是已结算，不修改订单用户状态,只修改订单状态
                                if (DuoDuoOrderStatusEnum.A_SETTLED == orderEnum) {
                                    OrderInfo newInfo = new OrderInfo();
                                    newInfo.setId(oldOrder.getId());
                                    newInfo.setOrderStatus(orderEnum.getCode());
                                    newInfo.setOrderStatusDesc(orderEnum.getDesc());
                                    promotionChannelsOrderRepository.update(newInfo);
                                    return ResultBuilder.succ();
                                }

                                LOGGER.debug("远程接口拉取的订单数据状态不一样执行update操作开始");
                                UserOrderStatusEnum userEnum = queryByCode(
                                        info.getUserOrderStatus(), UserOrderStatusEnum.class);

                                OrderInfo target = new OrderInfo();

                                BeanUtils.copyProperties(oldOrder, target);
                                OrderInfo newInfo = convertNewInfo(info, target, orderEnum,
                                        userEnum);
                                promotionChannelsOrderRepository.update(newInfo);
                                UserOrderStatusProcessor processor = orderStatusDispatcher
                                        .get(userEnum);
                                processor.onEvent(newInfo);
                            }
                        }
                    }
                    return ResultBuilder.succ();
                    //只落地
                } else if ((request.getLanding() != null && request.getLanding())

                        ||

                        (request.getOrderPromotionSource() != null
                                && request.getOrderPromotionSource()
                                .equals(H5.getCode())
                                && StringUtil.isBlank(request.getCustomParameters()))
                        || (StringUtil.isNotBlank(request.getCustomParameters()) &&

                        StringUtil.equals("-1", request.getCustomParameters()))) {

                    OrderInfoDTO oldOrder = promotionChannelsOrderRepository
                            .query(info.getOrderSn());
                    if (oldOrder == null) {
                        //如果开启
                        info.setOrderPromotionCommission(0.0);
                        promotionChannelsOrderRepository.insertSelective(info);

                    } else {
                        //如果远程接口拉取的订单数据状态不一样
                        if (!StringUtil.equals(oldOrder.getOrderStatus(), info.getOrderStatus())) {
                            DuoDuoOrderStatusEnum orderEnum = queryByCode(info.getOrderStatus(),
                                    DuoDuoOrderStatusEnum.class);
                            //如果拉取多多客订单状态是已结算，不修改订单用户状态,只修改订单状态
                            if (DuoDuoOrderStatusEnum.A_SETTLED == orderEnum) {
                                OrderInfo newInfo = new OrderInfo();
                                newInfo.setId(oldOrder.getId());
                                newInfo.setOrderStatus(orderEnum.getCode());
                                newInfo.setOrderStatusDesc(orderEnum.getDesc());
                                promotionChannelsOrderRepository.update(newInfo);
                                return ResultBuilder.succ();
                            }

                            LOGGER.debug("远程接口拉取的订单数据状态不一样执行update操作开始");
                            UserOrderStatusEnum userEnum = queryByCode(info.getUserOrderStatus(),
                                    UserOrderStatusEnum.class);
                            OrderInfo target = new OrderInfo();
                            BeanUtils.copyProperties(oldOrder, target);
                            OrderInfo newInfo = convertNewInfo(info, target, orderEnum, userEnum);
                            promotionChannelsOrderRepository.update(newInfo);

                        }
                    }
                    return ResultBuilder.succ();
                }
                if (StringUtil.isBlank(request.getCustomParameters())) {

                }
                //根据外部订单号查询本地订单信息
                List<OrderInfo> list = orderInfoRepository.queryByOrderSn(info.getOrderSn(),
                        request.getCustomParameters());
                if (isEmpty(list)) {
                    info.setOrderCommissionSnapshot(configVal());
                    boolean bl = false;
                    if (!StringUtils.equals(info.getPId(), appServiceConfig.getFreePid())) {
                        bl = isBl(info);
                    } else {
                        //活动
                        String userId = info.getCustomParameters();
                        UserExemptionGoods record = new UserExemptionGoods();
                        record.setUserId(userId);
                        record.setGoodsId(Long.valueOf(info.getGoodsId()));
                        List<UserExemptionGoods> goods = userExemptionGoodsRepository
                                .selectByExample(record);
                        if (CollectionUtils.isEmpty(goods)) {
                            bl = isBl(info);
                        } else {
                            TSingleResult<ActivityConfigPrizeDTO> result = activityConfigService
                                    .getUsingActivity(ActivityTypeEnum.Exemption);
                            if (result == null || result.getValue() == null) {
                                bl = isBl(info);
                            } else {
                                ActivityConfigPrizeDTO value = result.getValue();
                                //订单创建时间
                                Date orderCreateTime = info.getOrderCreateTime();
                                if (!(orderCreateTime.getTime() >= value.getStartTime().getTime()
                                        && orderCreateTime.getTime() <= value.getEndTime()
                                        .getTime())) {
                                    bl = isBl(info);
                                } else {
                                    UserExemptionGoods exemptionGoods = goods.get(0);
                                    if (!info.getOrderAmount()
                                            .equals(exemptionGoods.getPayAmount())) {
                                        bl = isBl(info);
                                    }
                                }
                            }
                        }
                    }
                    orderInfoRepository.insert(info);
                    //如果是染色类型 不做业务处理
                    if (StringUtil.equals(OrderPromoTypeEnum.DYEING.getCode(),
                            info.getPromoType())) {
                        LOGGER.info("用户Id:{},订单号:{},为染色订单,不做业务处理", info.getCustomParameters(),
                                info.getOrderSn());
                        return ResultBuilder.succ();
                    }
                    //转换对应订单状态

                    UserOrderStatusEnum userOrderStatus = queryByCode(info.getUserOrderStatus(),
                            UserOrderStatusEnum.class);
                    UserOrderStatusProcessor processor = orderStatusDispatcher.get(userOrderStatus);

                    Long promoAmount = processor.execute(info);
                    //只有首次跟单发送消息 待确认才能发
                    if (userOrderStatus == UserOrderStatusEnum.TO_BE_CONFIRMED
                            && promoAmount != null) {
                        try {
                            //订单跟单发送
                            send(Const.DUODUOKE_ORDER_PUSH, Const.DUODUOKE_ORDER_PUSH, info,
                                    promoAmount);
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage(), e);
                        }

                        if (bl) {
                            //延迟5分钟
                            executorService.schedule(() -> {
                                try {
                                    LOGGER.debug("执行订单翻倍消息发送");
                                    send(Const.DUODUOKE_DOUBLE_ORDER_PUSH,
                                            Const.DUODUOKE_DOUBLE_ORDER_PUSH, info, promoAmount);
                                } catch (Exception e) {
                                    LOGGER.error(e.getMessage(), e);
                                }
                            }, 5, TimeUnit.MINUTES);

                        }
                    }

                    //update
                } else {
                    OrderInfo oldOrder = list.get(0);
                    LOGGER.debug("订单数据,远程接口状态:{},本地状态:{}", info.getOrderStatus(),
                            oldOrder.getOrderStatus());
                    //如果订单是-1 并且状态描述是 未支付,已取消
                    if (StringUtil.equals(DuoDuoOrderStatusEnum.N_PAY.getCode(),
                            info.getOrderStatus())
                            && StringUtil.equals("未支付,已取消", info.getOrderStatusDesc())) {
                        update(info);
                    }
                    //如果远程接口拉取的订单数据状态不一样
                    if (!StringUtil.equals(oldOrder.getOrderStatus(), info.getOrderStatus())) {
                        DuoDuoOrderStatusEnum orderEnum = queryByCode(info.getOrderStatus(),
                                DuoDuoOrderStatusEnum.class);
                        if (orderEnum != null) {
                            //如果拉取多多客订单状态是已结算，不修改订单用户状态,只修改订单状态
                            if (DuoDuoOrderStatusEnum.A_SETTLED == orderEnum) {
                                OrderInfo newInfo = new OrderInfo();
                                newInfo.setId(oldOrder.getId());
                                newInfo.setOrderStatus(orderEnum.getCode());
                                newInfo.setOrderSn(oldOrder.getOrderSn());
                                newInfo.setOrderStatusDesc(orderEnum.getDesc());
                                newInfo.setCustomParameters(oldOrder.getCustomParameters());
                                orderInfoRepository.update(newInfo);
                                return ResultBuilder.succ();
                            }

                            UserOrderStatusEnum userEnum = queryByCode(info.getUserOrderStatus(),
                                    UserOrderStatusEnum.class);
                            LOGGER.debug("远程接口拉取的订单数据状态不一样执行update操作开始");
                            OrderInfo newInfo = convertNewInfo(info, oldOrder, orderEnum, userEnum);
                            orderInfoRepository.update(newInfo);

                            //如果是染色类型 不做业务处理
                            if (StringUtil.equals(OrderPromoTypeEnum.DYEING.getCode(),
                                    info.getPromoType())) {
                                LOGGER.info("用户Id:{},订单号:{},为染色订单,不做业务处理",
                                        info.getCustomParameters(), info.getOrderSn());
                                return ResultBuilder.succ();
                            }
                            UserOrderStatusProcessor processor = orderStatusDispatcher
                                    .get(userEnum);
                            processor.execute(newInfo);
                            LOGGER.debug("远程接口拉取的订单数据状态不一样执行update操作结束");
                        }
                    } else {
                        LOGGER.debug("远程接口拉取的订单数据状态和本地数据状态一样,不需要同步更新");
                    }
                }

            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            } finally {
                zookeeperDistributedLock.releaseLock(key);
                LOGGER.info("order_sn_userInfo_.release lock : " + key);
            }
        }
        return ResultBuilder.succ();
    }

    /**
     * h5 用户体系流程
     *
     * @param request
     * @param info
     * @return
     */
    private BaseResult getH5BaseResult(OrderInfoTakeAmountRequest request, OrderInfo info) {
        String userId = request.getCustomParameters();
        //根据外部订单号查询本地订单信息
        List<OrderInfo> list = orderInfoRepository.queryByOrderSn(info.getOrderSn(), userId);
        if (isEmpty(list)) {
            info.setOrderCommissionSnapshot(0);
            //如果不是h5  配置的 免单 pid
            if (!StringUtils.equals(info.getPId(), h5ServiceConfig.getFreePid())) {
                h5ChannelsTakeOrder(info);
                return ResultBuilder.succ();
            } else {
                //活动
                UserExemptionGoods record = new UserExemptionGoods();
                record.setUserId(userId);
                record.setGoodsId(Long.valueOf(info.getGoodsId()));
                List<UserExemptionGoods> goods = userExemptionGoodsRepository
                        .selectByExample(record);
                if (CollectionUtils.isEmpty(goods)) {
                    h5ChannelsTakeOrder(info);
                    return ResultBuilder.succ();
                } else {
                    TSingleResult<ActivityConfigPrizeDTO> result = activityConfigService
                            .getUsingActivity(H5Exemption);
                    if (result == null || result.getValue() == null) {
                        h5ChannelsTakeOrder(info);
                        return ResultBuilder.succ();
                    } else {
                        ActivityConfigPrizeDTO value = result.getValue();
                        //订单创建时间
                        Date orderCreateTime = info.getOrderCreateTime();
                        if (!(orderCreateTime.getTime() >= value.getStartTime().getTime()
                                && orderCreateTime.getTime() <= value.getEndTime().getTime())) {
                            h5ChannelsTakeOrder(info);
                            return ResultBuilder.succ();
                        } else {
                            UserExemptionGoods exemptionGoods = goods.get(0);
                            if (!info.getOrderAmount().equals(exemptionGoods.getPayAmount())) {
                                h5ChannelsTakeOrder(info);
                                return ResultBuilder.succ();
                            }
                        }
                    }
                }
            }
            orderInfoRepository.insert(info);
            //转换对应订单状态
            UserOrderStatusEnum userOrderStatus = queryByCode(info.getUserOrderStatus(),
                    UserOrderStatusEnum.class);
            UserOrderStatusProcessor processor = orderStatusDispatcher.get(userOrderStatus);
            processor.execute(info);
            //update
        } else {
            OrderInfo oldOrder = list.get(0);
            LOGGER.debug("订单,远程接口状态:{},本地状态:{}", info.getOrderStatus(), oldOrder.getOrderStatus());
            //如果订单是-1 并且状态描述是 未支付,已取消
            if (StringUtil.equals(DuoDuoOrderStatusEnum.N_PAY.getCode(), info.getOrderStatus())
                    && StringUtil.equals("未支付,已取消", info.getOrderStatusDesc())) {
                update(info);
            }
            //如果远程接口拉取的订单数据状态不一样
            if (!StringUtil.equals(oldOrder.getOrderStatus(), info.getOrderStatus())) {
                DuoDuoOrderStatusEnum orderEnum = queryByCode(info.getOrderStatus(),
                        DuoDuoOrderStatusEnum.class);
                if (orderEnum != null) {
                    //如果拉取多多客订单状态是已结算，不修改订单用户状态,只修改订单状态
                    if (DuoDuoOrderStatusEnum.A_SETTLED == orderEnum) {
                        OrderInfo newInfo = new OrderInfo();
                        newInfo.setId(oldOrder.getId());
                        newInfo.setOrderStatus(orderEnum.getCode());
                        newInfo.setOrderSn(oldOrder.getOrderSn());
                        newInfo.setOrderStatusDesc(orderEnum.getDesc());
                        newInfo.setCustomParameters(oldOrder.getCustomParameters());
                        orderInfoRepository.update(newInfo);
                        return ResultBuilder.succ();
                    }

                    UserOrderStatusEnum userEnum = queryByCode(info.getUserOrderStatus(),
                            UserOrderStatusEnum.class);
                    LOGGER.debug("远程接口拉取的订单数据状态不一样执行update操作开始");
                    OrderInfo newInfo = convertNewInfo(info, oldOrder, orderEnum, userEnum);
                    orderInfoRepository.update(newInfo);
                    UserOrderStatusProcessor processor = orderStatusDispatcher.get(userEnum);
                    processor.execute(newInfo);
                    LOGGER.debug("远程接口拉取的订单数据状态不一样执行update操作结束");
                }
            } else {
                LOGGER.debug("远程接口拉取的订单数据状态和本地数据状态一样,不需要同步更新");
            }

        }
        return ResultBuilder.succ();
    }

    /**
     * h5 渠道管理订单
     *
     * @param info
     * @return
     */
    private boolean h5ChannelsTakeOrder(OrderInfo info) {
        List<PromotionChannelsDTO> itemList = promotionChannelsRepository.queryByPid(info.getPId(),
                SwitchEnum.ENABLE.getCode());
        if (!CollectionUtils.isEmpty(itemList)) {
            info.setChannelsCode(itemList.get(0).getChannelsCode());
        }
        String channelsCode = info.getChannelsCode();
        String orderPromotionSource = info.getOrderPromotionSource();
        LOGGER.info("channelsCode:{}", channelsCode);
        boolean b = StringUtil.isNotBlank(channelsCode)
                && StringUtil.isNotBlank(orderPromotionSource)
                && StringUtil.equals(orderPromotionSource, H5.getCode());
        if (b) {
            PromotionChannelsDTO item = promotionChannelsRepository.queryByCode(channelsCode);
            if (item != null) {
                OrderInfoDTO oldOrder = promotionChannelsOrderRepository.query(info.getOrderSn(),
                        channelsCode);
                if (oldOrder == null) {
                    //如果开启
                    boolean equals = StringUtil.equals(item.getChannelsStatus(),
                            SwitchEnum.ENABLE.getCode());
                    Double channelsProportion = equals ? item.getChannelsProportion() : 0;

                    info.setOrderPromotionCommission(channelsProportion);
                    promotionChannelsOrderRepository.insertSelective(info);
                    //转换对应订单状态
                    UserOrderStatusEnum userOrderStatus = queryByCode(info.getUserOrderStatus(),
                            UserOrderStatusEnum.class);
                    UserOrderStatusProcessor processor = orderStatusDispatcher.get(userOrderStatus);
                    processor.onEvent(info);
                } else {
                    //如果远程接口拉取的订单数据状态不一样
                    if (!StringUtil.equals(oldOrder.getOrderStatus(), info.getOrderStatus())) {
                        DuoDuoOrderStatusEnum orderEnum = queryByCode(info.getOrderStatus(),
                                DuoDuoOrderStatusEnum.class);
                        //如果拉取多多客订单状态是已结算，不修改订单用户状态,只修改订单状态
                        if (DuoDuoOrderStatusEnum.A_SETTLED == orderEnum) {
                            OrderInfo newInfo = new OrderInfo();
                            newInfo.setId(oldOrder.getId());
                            newInfo.setOrderStatus(orderEnum.getCode());
                            newInfo.setOrderStatusDesc(orderEnum.getDesc());
                            promotionChannelsOrderRepository.update(newInfo);
                            return true;
                        }

                        LOGGER.debug("远程接口拉取的订单数据状态不一样执行update操作开始");
                        UserOrderStatusEnum userEnum = queryByCode(info.getUserOrderStatus(),
                                UserOrderStatusEnum.class);

                        OrderInfo target = new OrderInfo();

                        BeanUtils.copyProperties(oldOrder, target);
                        OrderInfo newInfo = convertNewInfo(info, target, orderEnum, userEnum);
                        promotionChannelsOrderRepository.update(newInfo);
                        UserOrderStatusProcessor processor = orderStatusDispatcher.get(userEnum);
                        processor.onEvent(newInfo);
                    }
                }
            }
            return true;
        }
        return false;
    }

    private OrderInfo convertNewInfo(OrderInfo info, OrderInfo oldOrder,
                                     DuoDuoOrderStatusEnum orderEnum,
                                     UserOrderStatusEnum userEnum) {
        OrderInfo newInfo = new OrderInfo();
        newInfo.setId(oldOrder.getId());
        //状态是新的
        newInfo.setUserOrderStatus(userEnum.getCode());
        newInfo.setUserOrderStatusDesc(userEnum.getDesc());
        newInfo.setOrderStatus(orderEnum.getCode());
        newInfo.setOrderStatusDesc(orderEnum.getDesc());
        //交易快照金额 都是首次的 也就是老的信息
        newInfo.setOrderCommissionSnapshot(oldOrder.getOrderCommissionSnapshot());
        //推广返利比例 都是首次的 也就是老的信息
        newInfo.setOrderPromotionCommission(oldOrder.getOrderPromotionCommission());
        //返利也是老的金额
        newInfo.setPromotionAmount(oldOrder.getPromotionAmount());
        newInfo.setOrderSn(oldOrder.getOrderSn());
        newInfo.setCustomParameters(oldOrder.getCustomParameters());
        //分享人
        newInfo.setOrderUserReferee(oldOrder.getOrderUserReferee());
        newInfo.setOrderSn(oldOrder.getOrderSn());
        newInfo.setOrderType(oldOrder.getOrderType());
        newInfo.setDoublePercent(oldOrder.getDoublePercent());
        newInfo.setHelpStatus(oldOrder.getHelpStatus());

        //创建时间
        newInfo.setOrderCreateTime(oldOrder.getOrderCreateTime());
        //确认收货时间
        newInfo.setOrderReceiveTime(info.getOrderReceiveTime());
        //订单确认时间
        newInfo.setOrderVerifyTime(info.getOrderVerifyTime());
        //订单最后更新时间
        newInfo.setOrderModifyAt(info.getOrderModifyAt());
        //订单最后更新时间扩展
        newInfo.setOrderModifyAtExt(info.getOrderModifyAt());
        //订单成团时间
        newInfo.setOrderGroupSuccessTime(info.getOrderGroupSuccessTime());
        //订单支付时间
        newInfo.setOrderPayTime(info.getOrderPayTime());
        //订单支付时间扩展
        newInfo.setOrderPayTimeExt(info.getOrderPayTime());
        //订单实际支付金额
        newInfo.setOrderAmount(oldOrder.getOrderAmount());
        //pid
        newInfo.setPId(oldOrder.getPId());
        newInfo.setGoodsId(oldOrder.getGoodsId());
        newInfo.setChannelsCode(oldOrder.getChannelsCode());
        newInfo.setOrderPromotionSource(oldOrder.getOrderPromotionSource());
        newInfo.setPromoType(info.getPromoType());
        return newInfo;
    }

    private int configVal() {
        TSingleResult<AppConfigDTO> result = appConfigService
                .getModel(AppConfigEnum.COMMISSION_PERCENTAGE);
        checkResult(result);
        AppConfigDTO model = result.getValue();

        //订单佣金返利快照  默认37%
        return (model == null || isBlank(model.getConfigVal())) ? 37
                : valueOf(model.getConfigVal());
    }

    private boolean isBl(OrderInfo info) {
        //商品id
        String goodsId = info.getGoodsId();
        GoodsDoublesRewardRequest rewardRequest = new GoodsDoublesRewardRequest();
        rewardRequest.setGoodsId(Long.valueOf(goodsId));
        rewardRequest.setDoubleDate(info.getOrderCreateTime());
        List<GoodsDoublesRewardDTO> dtoList = Lists.newArrayList();
        LOGGER.info("商品奖励加倍信息,商品id:{},加倍时间:{},dtoList:{}", goodsId,
                formatNewFormat(info.getOrderCreateTime()), dtoList);

        boolean bl = false;
        if (CollectionUtils.isEmpty(dtoList)) {
            //是否订单翻倍
            bl = isBlOrderDouble(info);
        } else {
            //加倍
            //startTime=Wed Sep 26 00:00:00 CST 2018, stopTime=Wed Sep 26 16:00:00 CST 2018
            GoodsDoublesRewardDTO rewardDTO = dtoList.get(0);
            Date orderCreateTime = info.getOrderCreateTime();
            Date stopTime = rewardDTO.getStopTime();
            Date startTime = rewardDTO.getStartTime();
            LOGGER.info("商品奖励加倍信息,订单创建时间:{},商品加倍开始时间:{},商品加倍结束时间", formatNewFormat(orderCreateTime),
                    formatNewFormat(startTime), formatNewFormat(stopTime));
            if (info.getOrderCreateTime().getTime() >= startTime.getTime()
                    && info.getOrderCreateTime().getTime() <= stopTime.getTime()) {
                LOGGER.info("商品奖励加倍信息,进入加倍区间,执行订单加倍操作,比率:{}",
                        rewardDTO.getRewardPercent().doubleValue());
                info.setDoublePercent(rewardDTO.getRewardPercent().doubleValue());
                info.setOrderType(OrderTypeEnum.D.getCode());
            } else {
                LOGGER.info("商品奖励加倍信息未进入到加倍时间区间,不执行加倍,订单号:{},userId:{}", info.getOrderSn(),
                        info.getCustomParameters());
                //是否订单翻倍
                bl = isBlOrderDouble(info);
            }
        }
        return bl;
    }

    private boolean isBlOrderDouble(OrderInfo info) {
        TSingleResult<RedPackageDBLConfigDTO> configResult = redPackageDBLConfigService
                .getRedPackageDBLConfig();
        checkResult(configResult);
        RedPackageDBLConfigDTO value = configResult.getValue();
        boolean bl = false;
        if (value == null || isBlank(value.getStatus())) {
            info.setHelpStatus(RedPackageConfigStatusEnum.OFF.getCode());
        } else {
            info.setHelpStatus(value.getStatus());
            info.setOrderType(OrderTypeEnum.T.getCode());
            Float scale = value.getScale() == null ? 0f : value.getScale();
            info.setHelpPercent(scale.doubleValue());
            info.setSendTime(addMinutes(new Date(), 5));
            bl = true;
        }
        return bl;
    }

    private void update(OrderInfo info) {

        OrderInfo newInfo = new OrderInfo();
        newInfo.setGmtModified(new Date());
        newInfo.setOrderStatusDesc("未支付,已取消");
        newInfo.setOrderSn(info.getOrderSn());
        newInfo.setCustomParameters(info.getCustomParameters());
        orderInfoRepository.update(newInfo);
    }

    public void send(String topic, String key, OrderInfo info, Long promoAmount) {
        OrderSendPushModel push = new OrderSendPushModel();
        push.setInfo(info);
        push.setPromoAmount(promoAmount);

    }

    @Override
    public BaseResult update(OrderInfoUpdateRequest request) {
        OrderInfo info = new OrderInfo();
        info.setUserOrderStatus(UserOrderStatusEnum.INVALID.getCode());
        info.setUserOrderStatusDesc(UserOrderStatusEnum.INVALID.getDesc());
        info.setGmtModified(new Date());
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andOrderStatusEqualTo(DuoDuoOrderStatusEnum.N_PAY.getCode());
        criteria.andOrderStatusDescEqualTo("未支付,已取消");
        criteria.andUserOrderStatusEqualTo(UserOrderStatusEnum.TO_BE_CONFIRMED.getCode());
        criteria.andUserOrderStatusDescEqualTo(UserOrderStatusEnum.TO_BE_CONFIRMED.getDesc());
        orderInfoRepository.updateByExampleSelective(info, example);
        return ResultBuilder.succ();
    }

    /**
     * OrderInfoTakeAmountRequest to OrderInfo
     *
     * @param request
     * @return
     */
    private OrderInfo convertOrderInfo(OrderInfoTakeAmountRequest request) {
        OrderInfo info = new OrderInfo();
        info.setOrderSn(request.getOrderSn());
        info.setOrderAmount(request.getOrderAmount());
        info.setOrderCreateTime(request.getOrderCreateTime());
        info.setOrderReceiveTime(request.getOrderReceiveTime());
        info.setOrderVerifyTime(request.getOrderVerifyTime());
        info.setOrderModifyAt(request.getOrderModifyAt());
        info.setOrderModifyAtExt(request.getOrderModifyAt());
        info.setOrderGroupSuccessTime(request.getOrderGroupSuccessTime());
        info.setOrderPayTime(request.getOrderPayTime());
        info.setOrderPayTimeExt(request.getOrderPayTime());
        info.setAuthDuoId(request.getAuthDuoId());
        info.setBatchNo(request.getBatchNo());
        info.setCustomParameters(request.getCustomParameters());
        info.setGoodsId(request.getGoodsId());
        info.setGoodsName(request.getGoodsName());
        info.setStatus(request.getStatus());
        info.setGoodsPrice(request.getGoodsPrice());
        info.setGoodsQuantity(request.getGoodsQuantity());
        info.setGoodsThumbnailUrl(request.getGoodsThumbnailUrl());
        info.setType(request.getType());
        info.setPId(request.getPId());
        info.setGroupId(request.getGroupId());
        info.setOrderStatus(request.getOrderStatus());
        info.setOrderStatusDesc(request.getOrderStatusDesc());
        info.setPromotionAmount(request.getPromotionAmount());
        info.setPromotionRate(request.getPromotionRate());
        info.setUserOrderStatus(request.getUserOrderStatus());
        info.setUserOrderStatusDesc(request.getUserOrderStatusDesc());
        info.setOrderUserReferee(request.getOrderUserReferee());
        info.setChannelsCode(request.getChannelsCode());
        info.setOrderPromotionSource(request.getOrderPromotionSource());
        info.setPromoType(request.getPromoType());
        return info;
    }

    private OrderInfoExample toExample(OrderQueryInfoRequest request) {
        OrderInfoExample example = getOrderInfoExample(request);
        example.setOffset(request.start4Mysql());
        example.setLimit(request.getRows());
        if (isNotBlank(request.getSortInfo())) {
            example.setOrderByClause(request.getSortInfo());
        }
        return example;
    }
}
