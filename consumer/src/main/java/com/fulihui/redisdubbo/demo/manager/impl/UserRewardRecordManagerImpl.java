package com.fulihui.redisdubbo.demo.manager.impl;


import com.fulihui.redisdubbo.demo.api.api.*;
import com.fulihui.redisdubbo.demo.api.dto.*;
import com.fulihui.redisdubbo.demo.api.enums.MessageChannelEnum;
import com.fulihui.redisdubbo.demo.api.enums.RedPackageConfigStatusEnum;
import com.fulihui.redisdubbo.demo.api.enums.RewardHelpStateEnum;
import com.fulihui.redisdubbo.demo.api.enums.SwitchEnum;
import com.fulihui.redisdubbo.demo.api.request.AppSendMessageRequest;
import com.fulihui.redisdubbo.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.redisdubbo.demo.api.request.UserRewardRecordRequest;
import com.fulihui.redisdubbo.demo.manager.UserRewardRecordManager;
import com.fulihui.redisdubbo.demo.vo.UserRewardInfoVO;
import com.fulihui.redisdubbo.demo.vo.UserRewardRecordVO;
import com.fulihui.redisdubbo.demo.vo.UserRewardVO;
import com.google.common.collect.Maps;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.common.StringUtil;
import org.near.toolkit.model.Money;
import org.near.webmvcsupport.view.JsonResult;
import org.near.webmvcsupport.view.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/9/3 0003 17:27
 */
@Service
public class UserRewardRecordManagerImpl implements UserRewardRecordManager {

    @org.apache.dubbo.config.annotation.Reference
    private UserRewardRecordService userRewardRecordService;

    @org.apache.dubbo.config.annotation.Reference
    private OrderInfoService orderInfoService;

    @org.apache.dubbo.config.annotation.Reference
    private UserService userService;

    @org.apache.dubbo.config.annotation.Reference
    private RedPackageDBLConfigService redPackageDBLConfigService;

    @org.apache.dubbo.config.annotation.Reference
    private AppSendMessageService appSendMessageService;

    @org.apache.dubbo.config.annotation.Reference
    private UserFormService userFormService;

    @Autowired
    CuratorFramework curatorFramework;

    private static final Logger logger = LoggerFactory
            .getLogger(UserRewardRecordManagerImpl.class);

    @Override
    public JsonResult<UserRewardVO> insert(String rewardUserId, String orderSn, String userId) {
        UserRewardVO vo = new UserRewardVO();
        Date now = new Date();
        boolean isSend = false;
        boolean isSuccess = false;
        String key = "/duoduokeLock/userHelp" + userId + orderSn;
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, key);
        try {
            boolean acquire = lock.acquire(50, TimeUnit.SECONDS);
            logger.info(acquire ? "get lock success : " + key : "get lock failed : " + key);
            OrderInfoDTO dto = queryOrderInfo(orderSn, userId);
            if (dto != null && dto.getHelpStatus().equals(RedPackageConfigStatusEnum.ON.getCode())) {

                Double sumPercent = sumPercent(orderSn, userId);
                if (sumPercent < 100) {
                    Date orderGroupSuccessTime = dto.getGmtCreate();
                    Date date = DateUtils.addDays(orderGroupSuccessTime, 1);
                    if (now.getTime() < date.getTime()) {
                        //未结束
                        //判断用户是否助力过次订单
                        UserRewardRecordRequest request = new UserRewardRecordRequest();
                        request.setOrderSn(orderSn);
                        request.setUserId(userId);
                        request.setHelpUserId(rewardUserId);
                        List<UserRewardRecordDTO> userRewardRecordDTOS = queryReward(request);
                        if (CollectionUtils.isEmpty(userRewardRecordDTOS)) {
                            //未参与此订单助力
                            //判断当天助力用户是否给此用户助力过
                            List<UserRewardRecordDTO> list = queryUserRecordList(now, rewardUserId,
                                    userId);
                            if (!CollectionUtils.isEmpty(list)) {
                                if (list.size() >= 1) {
                                    vo.setErrorCode("1001");
                                    vo.setErrorMessage("助力已超限");
                                    return JsonResultBuilder.succ(vo);
                                }
                            }
                            //判断当天助力用户是否超限3次
                            List<UserRewardRecordDTO> dtoList = queryUserRecordList(now,
                                    rewardUserId, null);
                            if (!CollectionUtils.isEmpty(dtoList)) {
                                if (dtoList.size() >= 3) {
                                    vo.setErrorCode("1001");
                                    vo.setErrorMessage("助力已超限");
                                    return JsonResultBuilder.succ(vo);
                                }
                            }
                            UserRewardRecordRequest rewardRecordRequest = new UserRewardRecordRequest();
                            rewardRecordRequest.setUserId(userId);
                            rewardRecordRequest.setHelpUserId(rewardUserId);
                            rewardRecordRequest.setOrderSn(orderSn);
                            Double scale = dto.getHelpPercent();
                            Double i = new BigDecimal(100)
                                    .subtract(new BigDecimal(Double.toString(sumPercent)))
                                    .doubleValue();
                            Double multiply = new BigDecimal(scale).multiply(new BigDecimal(2))
                                    .doubleValue();
                            if (i > scale) {
                                rewardRecordRequest.setHelpPercent(scale);
                                if (sumPercent <= multiply) {
                                    isSend = true;
                                }
                            } else {
                                isSend = true;
                                isSuccess = true;
                                rewardRecordRequest.setHelpPercent(i);
                            }
                            vo.setHelpPercent(rewardRecordRequest.getHelpPercent());
                            BaseResult result = userRewardRecordService.insert(rewardRecordRequest);
                            if (result.getErrcode() == BaseResult.SUCCESS) {
                                vo.setSuccess(true);
                                if (isSend) {
                                    //发送模板消息
                                    Double helpSum = add(sumPercent, vo.getHelpPercent());
                                    Double surplus = sub(100d, helpSum);
                                    send(dto, isSuccess, helpSum, surplus);
                                }
                            } else {
                                vo.setErrorCode("105");
                                vo.setErrorMessage("助力失败");
                                vo.setSuccess(false);
                            }
                            return JsonResultBuilder.succ(vo);
                        } else {
                            vo.setErrorCode("1002");
                            vo.setErrorMessage("已助力过");
                            return JsonResultBuilder.succ(vo);
                        }
                    } else {
                        //已过期
                        vo.setErrorCode("1003");
                        vo.setErrorMessage("助力已过期");
                        return JsonResultBuilder.succ(vo);
                    }

                } else {
                    //已过期
                    vo.setErrorCode("1004");
                    vo.setErrorMessage("已助力完成");
                    return JsonResultBuilder.succ(vo);
                }
            } else {
                vo.setErrorCode("1005");
                vo.setErrorMessage("活动已结束");
                return JsonResultBuilder.succ(vo);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                logger.error("lock.release error={}", e.getMessage(), e);
            }
        }
        return JsonResultBuilder.fail("105", "助力失败");

    }

    @Override
    public List<UserRewardRecordVO> query(String orderSn) {
        List<UserRewardRecordVO> voList = new ArrayList<>();
        UserRewardRecordRequest request = new UserRewardRecordRequest();
        request.setOrderSn(orderSn);
        request.setOrderBy("update_time DESC");
        TPageResult<UserRewardRecordDTO> result = userRewardRecordService.query(request);
        ServiceResultUtil.checkResult(result);
        List<UserRewardRecordDTO> list = result.getValues();
        for (UserRewardRecordDTO dto : list) {
            UserRewardRecordVO vo = new UserRewardRecordVO();
            BeanUtils.copyProperties(dto, vo);
            UserDTO userDTO = userService.queryByUserId(dto.getHelpUserId()).getValue();
            vo.setHelpUserImg(userDTO.getAvatarUrl());
            vo.setHelpNickName(userDTO.getNickname());
            vo.setCreateTime(DateUtils.format(dto.getCreateTime(), "MM.dd HH:mm"));
            voList.add(vo);
        }

        return voList;
    }

    @Override
    public Double sumPercent(String orderSn, String userId) {
        UserRewardRecordRequest request = new UserRewardRecordRequest();
        request.setOrderSn(orderSn);
        request.setUserId(userId);
        TSingleResult<Double> result = userRewardRecordService.sumPercent(request);
        return result.getValue();
    }

    public RedPackageDBLConfigDTO queryRedPackageConfig() {
        TSingleResult<RedPackageDBLConfigDTO> result = redPackageDBLConfigService
                .getRedPackageDBLConfig();
        ServiceResultUtil.checkResult(result);
        return result.getValue();
    }

    public List<UserRewardRecordDTO> queryReward(UserRewardRecordRequest request) {

        request.setOrderBy("update_time DESC");
        TPageResult<UserRewardRecordDTO> result = userRewardRecordService.query(request);
        ServiceResultUtil.checkResult(result);
        return result.getValues();
    }

    @Override
    public UserRewardInfoVO queryInfo(String rewardUserId, String orderSn, String userId) {
        UserRewardInfoVO vo = new UserRewardInfoVO();
        OrderInfoDTO orderInfoDTO = queryOrderInfo(orderSn, userId);
        String customParameters = orderInfoDTO.getCustomParameters();
        vo.setUserId(userId);
        UserDTO userDTO = userService.queryByUserId(userId).getValue();
        vo.setUserImg(userDTO.getAvatarUrl());
        vo.setNickName(userDTO.getNickname());
        Double integer = sumPercent(orderSn, userId);
        RedPackageDBLConfigDTO redPackageDBLConfigDTO = queryRedPackageConfig();
        vo.setUserPercent(integer);
        BigDecimal subtract = new BigDecimal(100)
                .subtract(new BigDecimal(Double.toString(integer)));
        vo.setUserSurplusPercent(subtract.doubleValue());
        Date gmtCreate = orderInfoDTO.getGmtCreate();
        Date date = DateUtils.addDays(gmtCreate, 1);
        vo.setStopTime(date);
        Date now = new Date();
        vo.setNowTime(now);
        if (integer < 100) {
            //未助力完成
            if (now.getTime() < date.getTime()) {
                //未结束
                vo.setHelpState(RewardHelpStateEnum.ONGOING.getCode());
            } else {
                //已过期
                vo.setHelpState(RewardHelpStateEnum.EXPIRED.getCode());
            }
        } else {
            //助力完成
            vo.setHelpState(RewardHelpStateEnum.SUCCEED.getCode());
        }
        UserRewardRecordRequest request = new UserRewardRecordRequest();
        request.setOrderSn(orderSn);
        request.setUserId(customParameters);
        request.setHelpUserId(rewardUserId);
        List<UserRewardRecordDTO> userRewardRecordDTOS = queryReward(request);
        if (CollectionUtils.isEmpty(userRewardRecordDTOS)) {
            //未助力
            vo.setHelp(false);
            if (vo.getHelpState().equals(RewardHelpStateEnum.SUCCEED.getCode())) {
                vo.setRedPackageId(redPackageDBLConfigDTO.getSucceed());
            } else if (vo.getHelpState().equals(RewardHelpStateEnum.EXPIRED.getCode())) {
                vo.setRedPackageId(redPackageDBLConfigDTO.getExpired());
            }
            List<UserRewardRecordDTO> list = queryUserRecordList(now, rewardUserId, userId);
            if (!CollectionUtils.isEmpty(list)) {
                if (list.size() >= 1) {
                    vo.setRedPackageId(redPackageDBLConfigDTO.getFailed());
                }
            }
            List<UserRewardRecordDTO> dtoList = queryUserRecordList(now, rewardUserId, null);
            if (!CollectionUtils.isEmpty(dtoList)) {
                if (dtoList.size() >= 3) {
                    vo.setRedPackageId(redPackageDBLConfigDTO.getFailed());
                }
            }

        } else {
            //已助力
            vo.setHelp(true);
            vo.setRedPackageId(redPackageDBLConfigDTO.getOngoing());
        }
        List<UserRewardRecordVO> voList = query(orderSn);
        vo.setRecordVOList(voList);
        vo.setShareImg(redPackageDBLConfigDTO.getImage());
        vo.setShareTitle(redPackageDBLConfigDTO.getTitle());
        return vo;
    }

    public OrderInfoDTO queryOrderInfo(String orderSn, String userId) {
        OrderQueryInfoRequest request = new OrderQueryInfoRequest();
        request.setOrderSn(orderSn);
        request.setUserId(userId);
        TSingleResult<OrderInfoDTO> orderInfoResult = orderInfoService.queryByOrderSn(request);
        return orderInfoResult.getValue();
    }

    public List<UserRewardRecordDTO> queryUserRecordList(Date now, String rewardUserId,
                                                         String userId) {

        String dayBefore = DateUtils.format(now, DateUtils.webFormat);
        try {
            Date startDate = DateUtils.parseNewFormat(dayBefore + " 00:00:00");
            Date endDate = DateUtils.parseNewFormat(dayBefore + " 23:59:59");
            UserRewardRecordRequest recordRequest = new UserRewardRecordRequest();
            recordRequest.setHelpUserId(rewardUserId);
            if (StringUtil.isNotEmpty(userId)) {
                recordRequest.setUserId(userId);
            }
            recordRequest.setStartCreateTime(startDate);
            recordRequest.setStopCreateTime(endDate);
            return queryReward(recordRequest);
        } catch (Exception e) {
            logger.error("queryUserRecord", e);
        }
        return null;

    }

    public void send(OrderInfoDTO info, boolean isSuccess, Double help, Double helpSurplus) {

        if (info == null) {
            return;
        }
        try {
            String userId = info.getCustomParameters();
            logger.info("推送模板消息开始,userId:{}", userId);
            Map<String, String> propertyMap = getStringStringMap(info, isSuccess, help,
                    helpSurplus);
            String content = toJSONString(propertyMap);
            //查询有效的formId
            TMultiResult<UserFormRecordDTO> result = userFormService
                    .query(info.getCustomParameters(), SwitchEnum.ENABLE.getCode());
            ServiceResultUtil.checkResult(result);
            List<UserFormRecordDTO> list = result.getValues();
            if (!CollectionUtils.isEmpty(list)) {
                UserFormRecordDTO formRecord = list.get(0);
                AppSendMessageRequest request = new AppSendMessageRequest();
                request.setContent(content);
                request.setUserId(userId);
                request.setFormId(formRecord.getFormId());
                request.setPage("pages/rewardBoost/rewardBoost?orderSn=" + info.getOrderSn()
                        + "&uid=" + userId);
                if (isSuccess) {
                    request.setType(MessageChannelEnum.HELPSUCCESS.getCode());
                } else {
                    request.setType(MessageChannelEnum.HELPIN.getCode());
                }
                BaseResult result1 = appSendMessageService.sendMiniMessage(request);
                if (result1.getErrcode() != BaseResult.SUCCESS) {
                    logger.info("助力,发送模板消息失败,该用户userId:{}", info.getCustomParameters());
                }
            } else {
                logger.info("助力,发送模板消息未查询到可使用的formId,该用户userId:{}", info.getCustomParameters());
            }
        } catch (Exception e) {
            logger.error("调用模板消息:", e);
        }
    }

    private Map<String, String> getStringStringMap(OrderInfoDTO info, boolean isSuccess,
                                                   Double help, Double helpSurplus) {
        Date gmtCreate = info.getGmtCreate();
        String date = DateUtils.formatNewFormat(gmtCreate);
        long promotionAmount = (info.getOrderCommissionSnapshot() * info.getPromotionAmount()) / 100
                * 2;
        Money money = new Money();
        money.setCent(promotionAmount);
        Map<String, String> propertyMap = Maps.newHashMap();
        propertyMap.put("keyword1", "订单奖励翻倍助力活动");
        propertyMap.put("keyword2", date);
        propertyMap.put("keyword3", "轻松奖励翻倍，翻倍后总奖励为：" + money.getAmount().toString() + "元");
        if (isSuccess) {
            propertyMap.put("keyword4", "恭喜助力达到100%！成功翻倍！");
        } else {
            propertyMap.put("keyword4", "已达成" + help + "%，当前还差" + helpSurplus + "%即可翻倍");
        }
        return propertyMap;
    }

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
}
