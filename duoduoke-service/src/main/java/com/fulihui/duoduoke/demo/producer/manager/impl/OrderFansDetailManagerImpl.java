package com.fulihui.duoduoke.demo.producer.manager.impl;


import com.alibaba.fastjson.JSONObject;
import com.fulihui.duoduoke.demo.api.api.AppConfigService;
import com.fulihui.duoduoke.demo.api.dto.*;
import com.fulihui.duoduoke.demo.api.enums.AppConfigEnum;
import com.fulihui.duoduoke.demo.api.enums.OrderFansTypeEnum;
import com.fulihui.duoduoke.demo.api.util.Collections;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.UserFormRecord;
import com.fulihui.duoduoke.demo.producer.manager.AppSendMessageManager;
import com.fulihui.duoduoke.demo.producer.manager.OrderFansDetailManager;
import com.fulihui.duoduoke.demo.producer.manager.UserFansManager;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderFansDetail;
import com.fulihui.duoduoke.demo.producer.dal.dataobj.OrderInfo;
import com.fulihui.duoduoke.demo.producer.repository.*;
import com.fulihui.duoduoke.demo.producer.repository.*;
import com.fulihui.duoduoke.demo.producer.util.Consts;
import com.fulihui.duoduoke.demo.producer.zubs.Const;
import com.fulihui.duoduoke.demo.common.util.RedisUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;
import org.near.servicesupport.result.TSingleResult;
import org.near.toolkit.common.ArrayUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.fulihui.duoduoke.demo.api.enums.OrderFansTypeEnum.SHARE;
import static com.fulihui.duoduoke.demo.api.enums.SwitchEnum.DISABLE;
import static com.fulihui.duoduoke.demo.api.enums.SwitchEnum.ENABLE;
import static org.near.toolkit.common.DateUtils.formatNewFormat;
import static org.near.toolkit.common.StringUtil.isBlank;
import static org.near.toolkit.common.StringUtil.isNotBlank;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 *
 */
enum Counter {
    Instance;

    ConcurrentHashMap<String, AtomicInteger> counterMap = new ConcurrentHashMap<>();

    Counter() {
    }

    /**
     * 最新值
     */
    public int incrementAndGet(String accountNo) {
        AtomicInteger counter = counterMap.putIfAbsent(accountNo, new AtomicInteger(0));
        if (counter == null) {
            counter = counterMap.get(accountNo);
        }
        return counter.incrementAndGet();
    }

    public int get(String accountNo) {
        AtomicInteger atomicInteger = counterMap.get(accountNo);
        return atomicInteger != null ? atomicInteger.get() : 0;
    }

    public void clear() {
        counterMap.clear();
    }
}

/**
 * The type Order fans detail manager.
 *
 * @author lizhi
 * @date 2018 -8-2
 */
@Component
public class OrderFansDetailManagerImpl implements OrderFansDetailManager {

    public static final String GROUP = "DUODUO_KE";
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrderFansDetailManagerImpl.class);
    private static final Logger ORDER_FANS_BIZ_LOGGER = LoggerFactory
            .getLogger(Consts.LoggerName.ORDER_FANS_BIZ);
    private static final String DUODUO_SHARE_USER = GROUP + ":SHARE_USER_";
    @Autowired
    RedisUtils redisUtils;
    /**
     * The Order info repository.
     */
    @Autowired
    OrderInfoRepository orderInfoRepository;

    /**
     * The App config repository.
     */
    @Autowired
    AppConfigRepository appConfigRepository;

    /**
     * The User fans manager.
     */
    @Autowired
    UserFansManager userFansManager;

    /**
     * The User fans detail repository.
     */
    @Autowired
    UserFansDetailRepository userFansDetailRepository;

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;
    /**
     * The Order fans detail repository.
     */
    @Autowired
    OrderFansDetailRepository orderFansDetailRepository;

    /**
     * The App config service.
     */
    @Autowired
    AppConfigService appConfigService;
    @Autowired
    UserFormRepository userFormRepository;
    @Autowired
    AppSendMessageManager appSendMessageManager;

    @Override
    public List<OrderFansDetailDTO> taskOrderFans(OrderInfo info, Long amount) {
        Assert.notNull(info, "order info is not null");

        ORDER_FANS_BIZ_LOGGER.debug("order :{},amount:{}", info, amount);

        List<OrderFansDetailDTO> arrayList = null;
        //如果有推荐人
        boolean b = check(info);

        //有分享商品 返利金额 先走分享
        if (b) {
            arrayList = takeFansOrderShare(info, amount);
        } else {
            Date now = new Date();
            if (!now.after(Const.CHECK_TIME)) {
                arrayList = takeFansOrderReference(info, amount);
            }
        }
        return arrayList;
    }

    /**
     * @param info
     * @param amount
     * @return
     */
    private List<OrderFansDetailDTO> takeFansOrderReference(OrderInfo info, Long amount) {
        // 检查订单购买者  是否有上级 或者上上级
        String customParameters = info.getCustomParameters();
        UserDTO dto = userRepository.queryByUserId(customParameters);
        //用户推荐人 如果用户没有推荐人 ,就直接返回 不给推荐费
        if (dto == null || isBlank(dto.getUserRefereeIds())) {
            LOGGER.info("该用户没有推荐人,不分销佣金,orderId:{},customParameters:{}", info.getOrderSn(),
                    customParameters);
            ORDER_FANS_BIZ_LOGGER.info("该用户没有推荐人,不分销佣金,orderId:{},customParameters:{}",
                    info.getOrderSn(), customParameters);
            return Lists.newArrayList();
        }
        String[] split = dto.getUserRefereeIds().split(",");
        if (ArrayUtils.isEmpty(split)) {
            return Lists.newArrayList();
        }

        List<String> collect = Arrays.stream(split).filter(StringUtil::isNotBlank)
                .collect(Collectors.toList());
        List<OrderFansDetailDTO> arrayList = Lists.newArrayList();
        for (int i = 0; i < collect.size(); i++) {
            String pUserId = collect.get(i);
            List<OrderFansDetailDTO> list = orderFansDetailRepository
                    .queryOrderSn(info.getOrderSn(), info.getCustomParameters(), pUserId);
            if (Collections.isEmpty(list)) {
                OrderFansDetail fansDetail = new OrderFansDetail();
                fansDetail.setOrderSn(info.getOrderSn());
                fansDetail.setUserId(customParameters);
                fansDetail.setPUserId(pUserId);
                fansDetail.setLevel(i + 1);
                fansDetail.setOrderStatus(info.getOrderStatus());
                fansDetail.setOrderStatusDesc(info.getOrderStatusDesc());
                fansDetail.setFansType(OrderFansTypeEnum.REFERENCE.getCode());
                if (i == 0) {
                    String[] strings = queryLevel(AppConfigEnum.ONE_PERCENTAGE);
                    xxx(amount, pUserId, fansDetail, strings);
                } else if (i == 1) {
                    String[] strings = queryLevel(AppConfigEnum.TWO_PERCENTAGE);
                    xxx(amount, pUserId, fansDetail, strings);
                } else {
                    //XXX 三级以上 忽略 不考虑 ,数据结构就只是存放
                    fansDetail.setFansAmount(0);
                }
                fansDetail.setOrderCreateTime(info.getOrderCreateTime());
                orderFansDetailRepository.insert(fansDetail);
                OrderFansDetailDTO detailDTO = new OrderFansDetailDTO();
                BeanUtils.copyProperties(fansDetail, detailDTO);
                arrayList.add(detailDTO);
                saveAmountOrderNum(info, fansDetail.getFansAmount(), pUserId);
            } else {
                OrderFansDetailDTO oldDetail = list.get(0);
                if (!StringUtil.equals(oldDetail.getOrderStatus(), info.getOrderStatus())) {
                    OrderFansDetail detail = new OrderFansDetail();
                    detail.setOrderStatus(info.getOrderStatus());
                    detail.setId(oldDetail.getId());
                    detail.setOrderStatusDesc(info.getOrderStatusDesc());
                    orderFansDetailRepository.update(detail);
                }
                arrayList.add(oldDetail);
            }
        }
        return arrayList;
    }

    private int xxx(Long amount, String pUserId, OrderFansDetail fansDetail, String[] strings) {

        if (!ArrayUtil.isEmpty(strings)) {
            //获取一级上级的直接下属人数
            List<UserFansDetailDTO> dtoList = userFansDetailRepository.querySumByUserId(pUserId,
                    null);
            LOGGER.info("用户粉丝信息:{}", dtoList);
            ORDER_FANS_BIZ_LOGGER.info("用户粉丝信息:{}", dtoList);
            if (!isEmpty(dtoList)) {
                UserFansDetailDTO fans = dtoList.get(0);
                //计算公式
                if (fans.getOneFansNum() < 3) {
                    LOGGER.info("用户:{},一级上级直接下属人数小于3人,返佣比例0", fans.getUserId());
                    ORDER_FANS_BIZ_LOGGER.info("用户:{},一级上级直接下属人数小于3人,返佣比例0", fans.getUserId());
                    fansDetail.setFansAmount(0);
                    fansDetail.setProportionSnapshot(0);
                } else if (fans.getOneFansNum() >= 3 && fans.getOneFansNum() < 20) {
                    Integer integer = Integer.valueOf(strings[0]);
                    int oneAmount = amount.intValue() * integer / 100;
                    fansDetail.setProportionSnapshot(integer);
                    LOGGER.info("用户:{},一级上级直接下属人数大于3人小于20人,返佣比例,integer:{}", fans.getUserId(),
                            integer);
                    ORDER_FANS_BIZ_LOGGER.info("用户:{},一级上级直接下属人数大于3人小于20人,返佣比例,integer:{}",
                            fans.getUserId(), integer);

                    fansDetail.setFansAmount(oneAmount);
                } else if (fans.getOneFansNum() >= 20) {
                    Integer integer = Integer.valueOf(strings[1]);
                    fansDetail.setProportionSnapshot(integer);
                    int oneAmount = amount.intValue() * integer / 100;
                    LOGGER.info("用户:{},一级上级直接下属人数大于等于20人,返佣比例,integer:{}", fans.getUserId(),
                            integer);
                    ORDER_FANS_BIZ_LOGGER.info("用户:{},一级上级直接下属人数大于等于20人,返佣比例,integer:{}",
                            fans.getUserId(), integer);
                    fansDetail.setFansAmount(oneAmount);
                }
            }
        }
        return fansDetail.getFansAmount();
    }

    /**
     * Query level string [ ].
     *
     * @param appConfigEnum the app config enum
     * @return the string [ ]
     */
    String[] queryLevel(AppConfigEnum appConfigEnum) {
        TSingleResult<AppConfigDTO> result = appConfigService.getModel(appConfigEnum);
        AppConfigDTO model = result.getValue();
        if (model != null) {
            String configVal = model.getConfigVal();
            if (isNotBlank(configVal)) {
                return configVal.split(":");
            }
        }
        return null;
    }

    private void saveAmountOrderNum(OrderInfo info, int amount, String pUserId) {
        try {
            userFansManager.saveAmountOrderNum(info.getOrderCreateTime(), 1, amount, pUserId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 分享
     *
     * @param info the info
     * @return boolean boolean
     */
    public boolean check(OrderInfo info) {
        //订单推荐人
        String orderUserReferee = info.getOrderUserReferee();
        //如果不等于空说明该订单是分享来的
        if (isNotBlank(orderUserReferee)) {
            /**
             * 如果订单人信息 userId 和订单推荐人 orderUserReferee 不是同一个人 有奖励
             */
            return !StringUtil.equals(info.getCustomParameters(), orderUserReferee);
        }
        return false;
    }

    private List<OrderFansDetailDTO> takeFansOrderShare(OrderInfo info, Long amount) {
        Date now = new Date();
        TSingleResult<AppConfigDTO> result = appConfigService
                .getModel(AppConfigEnum.SHARE_PERCENTAGE);
        //查询分享比例配置
        AppConfigDTO dto = result.getValue();
        Integer proportionSnapshot = (dto == null || dto.getConfigVal() == null) ? 30
                : Integer.valueOf(dto.getConfigVal());
        int shareAmount = (amount.intValue() * proportionSnapshot) / 100;
        if (now.after(Const.CHECK_TIME)) {
            shareAmount = amount.intValue();
        }
        List<OrderFansDetailDTO> list = orderFansDetailRepository.queryOrderSn(info.getOrderSn());
        if (!Collections.isEmpty(list)) {
            OrderFansDetailDTO oldDetail = list.get(0);
            if (!StringUtil.equals(oldDetail.getOrderStatus(), info.getOrderStatus())) {
                OrderFansDetail detail = new OrderFansDetail();
                detail.setOrderStatus(info.getOrderStatus());
                detail.setOrderStatusDesc(info.getOrderStatusDesc());
                detail.setId(oldDetail.getId());
                orderFansDetailRepository.update(detail);
            }
            return list;
        }
        OrderFansDetail fansDetail = new OrderFansDetail();
        fansDetail.setOrderSn(info.getOrderSn());
        fansDetail.setFansAmount(shareAmount);
        fansDetail.setUserId(info.getCustomParameters());
        fansDetail.setOrderStatus(info.getOrderStatus());
        fansDetail.setOrderStatusDesc(info.getOrderStatusDesc());
        fansDetail.setPUserId(info.getOrderUserReferee());
        fansDetail.setFansType(SHARE.getCode());
        fansDetail.setOrderCreateTime(info.getOrderCreateTime());
        fansDetail.setProportionSnapshot(proportionSnapshot);
        orderFansDetailRepository.insert(fansDetail);
        OrderFansDetailDTO detailDTO = new OrderFansDetailDTO();
        BeanUtils.copyProperties(fansDetail, detailDTO);
        saveAmountOrderNum(info, shareAmount, info.getOrderUserReferee());

        String webFormat = DateUtils.formatWebFormat(new Date());

        String shareKey = DUODUO_SHARE_USER + webFormat + info.getOrderUserReferee();
        //分享赚发送金额
        if (redisUtils.get(shareKey) == null) {
            redisUtils.set(shareKey, "ok");
            send(info, (long) shareAmount);
        }

        return Lists.newArrayList(detailDTO);
    }

    public void send(OrderInfo info, Long shareAmount) {
        if (info == null || shareAmount == null) {
            return;
        }
        String userId = info.getOrderUserReferee();
        ORDER_FANS_BIZ_LOGGER.info("分享赚推送模板消息开始,userId:{}", userId);
        Map<String, String> propertyMap = Maps.newHashMap();
        propertyMap.put("keyword1", info.getGoodsName());
        propertyMap.put("keyword2", formatNewFormat(info.getOrderCreateTime()));
        Money money = new Money();
        money.setCent(shareAmount);
        propertyMap.put("keyword3", money.getAmount().toString() + "元");
        propertyMap.put("keyword4", "分享赚");
        propertyMap.put("keyword5", "好友订单奖励结算后到账");
        String content = JSONObject.toJSONString(propertyMap);
        //查询有效的formId
        List<UserFormRecordDTO> recordList = userFormRepository.query(info.getOrderUserReferee(),
                ENABLE.getCode());
        if (!isEmpty(recordList)) {
            UserFormRecordDTO formRecord = recordList.get(0);
            boolean b = appSendMessageManager.sendMessage(SHARE.getCode(), userId, content,
                    formRecord.getFormId(), null);
            if (b) {
                UserFormRecord newRecord = new UserFormRecord();
                newRecord.setId(formRecord.getId());
                newRecord.setFormStatus(DISABLE.getCode());
                newRecord.setFormDesc("分享赚消息推送成功过期");
                userFormRepository.update(newRecord);
            } else {
                ORDER_FANS_BIZ_LOGGER.info("首次跟单分享赚信息抓取,发送模板消息失败,该用户userId:{}",
                        info.getCustomParameters());
            }
        } else {
            ORDER_FANS_BIZ_LOGGER.info("首次跟单分享赚信息抓取,发送模板消息未查询到可使用的formId,该用户userId:{}",
                    info.getCustomParameters());
        }
    }
}
