package com.fulihui.duoduoke.demo.producer.job.schedule;

import static com.alibaba.fastjson.JSON.toJSONString;
import static org.near.toolkit.common.DateUtils.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fulihui.duoduoke.demo.api.api.AppSendMessageService;
import com.fulihui.duoduoke.demo.api.api.OrderInfoService;
import com.fulihui.duoduoke.demo.api.api.UserFormService;
import com.fulihui.duoduoke.demo.api.api.UserRewardRecordService;
import com.fulihui.duoduoke.demo.api.dto.OrderInfoDTO;
import com.fulihui.duoduoke.demo.api.dto.UserFormRecordDTO;
import com.fulihui.duoduoke.demo.api.enums.MessageChannelEnum;
import com.fulihui.duoduoke.demo.api.enums.RedPackageConfigStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.SwitchEnum;
import com.fulihui.duoduoke.demo.api.request.AppSendMessageRequest;
import com.fulihui.duoduoke.demo.api.request.OrderQueryInfoRequest;
import com.fulihui.duoduoke.demo.api.request.UserRewardRecordRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TMultiResult;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.result.TSingleResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.near.toolkit.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import com.fulihui.duoduoke.demo.producer.job.Consts;
import com.google.common.collect.Maps;

@Component
public class OrderSendJob implements SimpleJob {
    private static final Logger LOGGER             = LoggerFactory.getLogger(OrderSendJob.class);

    private static final Logger JOB_MONITOR_LOGGER = LoggerFactory
        .getLogger(Consts.LoggerName.JOB_MONITOR);

    @org.apache.dubbo.config.annotation.Reference
    OrderInfoService orderInfoService;

    @org.apache.dubbo.config.annotation.Reference
    UserFormService userFormService;

    @org.apache.dubbo.config.annotation.Reference
    AppSendMessageService appSendMessageService;

    @org.apache.dubbo.config.annotation.Reference
    UserRewardRecordService userRewardRecordService;

    private volatile boolean    running            = false;

    @Override
    public void execute(ShardingContext shardingContext) {

        LOGGER.info("订单模板拉取数据开始:{}", formatNewFormat(new Date()));

        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }
        running = true;
        try {
            fetchData();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        running = false;
        LOGGER.info("running改值成功");
        LOGGER.info("订单模板拉取数据结束:{}", formatNewFormat(new Date()));

    }

    void fetchData() {
        //当前时间
        Date now = new Date();

        long time = 23 * 60 * 60 + 1;
        Date start = addHours(now, -24);
        Date stop = addSeconds(now, -time);
        queryList(start, stop, MessageChannelEnum.HELPINEXPIRE.getCode());

        Date startOver = addHours(now, -25);
        long overtime = 24 * 60 * 60 + 1;
        Date stopOver = addSeconds(now, -overtime);

        queryList(startOver, stopOver, MessageChannelEnum.HELPEXPIRED.getCode());

    }

    public void queryList(Date start, Date stop, String type) {
        OrderQueryInfoRequest request = new OrderQueryInfoRequest();
        request.setStartGmtCreateTime(start);
        request.setEndGmtCreateTime(stop);
        request.setHelpStatus(RedPackageConfigStatusEnum.ON.getCode());
        TSingleResult<Long> result = orderInfoService.queryCount(request);
        ServiceResultUtil.checkResult(result);
        Long total = result.getValue();
        JOB_MONITOR_LOGGER.info("订单job推送模板消息:{}", total);
        long page = total % 100 == 0 ? total / 100 : total / 100 + 1;
        request.setRows(100);
        for (int i = 1; i <= page; i++) {
            request.setPage(i);
            TPageResult<OrderInfoDTO> orderResult = orderInfoService.queryPage(request);
            ServiceResultUtil.checkResult(orderResult);
            List<OrderInfoDTO> list = orderResult.getValues();
            if (!CollectionUtils.isEmpty(list)) {
                for (OrderInfoDTO dto : list) {
                    Double sumHelp = sumPercent(dto.getOrderSn(), dto.getCustomParameters());
                    if (sumHelp < 100) {
                        Double helpSurplus = new BigDecimal(100)
                            .subtract(new BigDecimal(Double.toString(sumHelp))).doubleValue();
                        send(dto, MessageChannelEnum.HELPEXPIRED.getCode(), sumHelp, helpSurplus);
                    }

                }
            }

        }
    }

    public void send(OrderInfoDTO info, String type, Double help, Double helpSurplus) {
        if (info == null) {
            return;
        }
        String userId = info.getCustomParameters();
        JOB_MONITOR_LOGGER.info("推送模板消息开始,userId:{}", userId);
        Map<String, String> propertyMap = getStringStringMap(info, type, help, helpSurplus);
        String content = toJSONString(propertyMap);
        //查询有效的formId
        TMultiResult<UserFormRecordDTO> result = userFormService.query(info.getCustomParameters(),
            SwitchEnum.ENABLE.getCode());
        ServiceResultUtil.checkResult(result);
        List<UserFormRecordDTO> list = result.getValues();
        if (!CollectionUtils.isEmpty(list)) {
            UserFormRecordDTO formRecord = list.get(0);
            AppSendMessageRequest request = new AppSendMessageRequest();
            request.setContent(content);
            request.setUserId(userId);
            request.setFormId(formRecord.getFormId());
            request.setType(type);
            request.setPage(
                "pages/rewardBoost/rewardBoost?orderSn=" + info.getOrderSn() + "&uid=" + userId);
            BaseResult result1 = appSendMessageService.sendMiniMessage(request);
            if (result1.getErrcode() != BaseResult.SUCCESS) {
                JOB_MONITOR_LOGGER.info("助力,发送模板消息失败,该用户userId:{}", info.getCustomParameters());
            }
        } else {
            JOB_MONITOR_LOGGER.info("助力,发送模板消息未查询到可使用的formId,该用户userId:{}",
                info.getCustomParameters());
        }
    }

    private Map<String, String> getStringStringMap(OrderInfoDTO info, String type, Double help,
                                                   Double helpSurplus) {
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
        if (type.equals(MessageChannelEnum.HELPEXPIRED.getCode())) {
            propertyMap.put("keyword4", "本次助力已到期，仅增加" + help + "%订单奖励");
        } else {
            propertyMap.put("keyword4", "还剩1小时结束本次助力，当前还差" + helpSurplus + "%即可翻倍");
        }
        return propertyMap;
    }

    public Double sumPercent(String orderSn, String userId) {
        UserRewardRecordRequest request = new UserRewardRecordRequest();
        request.setOrderSn(orderSn);
        request.setUserId(userId);
        TSingleResult<Double> result = userRewardRecordService.sumPercent(request);
        return result.getValue();
    }

}
