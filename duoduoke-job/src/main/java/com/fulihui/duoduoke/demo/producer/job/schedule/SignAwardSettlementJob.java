package com.fulihui.duoduoke.demo.producer.job.schedule;

import static com.alibaba.fastjson.JSONArray.parseArray;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;
import static org.near.toolkit.common.DateUtils.formatNewFormat;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fulihui.duoduoke.demo.api.api.ActivityConfigService;
import com.fulihui.duoduoke.demo.api.api.sign.SignAwardService;
import com.fulihui.duoduoke.demo.api.api.sign.SignUserRecordService;
import com.fulihui.duoduoke.demo.api.dto.ActivityConfigDTO;
import com.fulihui.duoduoke.demo.api.dto.ActivitySignPrizeDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.dto.sign.SignUserRecordDTO;
import com.fulihui.duoduoke.demo.api.enums.SignStatusEnum;
import com.fulihui.duoduoke.demo.api.request.ActivityConfigRequest;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import com.fulihui.duoduoke.demo.api.request.sign.SignUserRecordRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;

/**
 *
 * @author lizhi
 * @date 2018-10-15
 */

public class SignAwardSettlementJob implements SimpleJob {

    private static final Logger LOGGER  = LoggerFactory.getLogger(UserFormIdJob.class);

    private volatile boolean    running = false;

         @org.apache.dubbo.config.annotation.Reference

    SignUserRecordService signUserRecordService;

    @org.apache.dubbo.config.annotation.Reference

    SignAwardService signAwardService;

    @org.apache.dubbo.config.annotation.Reference

    ActivityConfigService activityConfigService;

    @Override
    public void execute(ShardingContext shardingContext) {
        Date date = new Date();
        LOGGER.info("用户签到周期结算:{}", formatNewFormat(date));
        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }
        running = true;
        try {
            SignUserRecordRequest request = new SignUserRecordRequest();
            request.setSignStatus(Lists.newArrayList(SignStatusEnum.Y.getCode(),SignStatusEnum.S.getCode()));
            request.setCycleTime(DateUtils.addDays(date, -7));
            TPageResult<SignUserRecordDTO> result = signUserRecordService.queryPage(request);
            checkResult(result);
            List<SignUserRecordDTO> values = result.getValues();
            if (CollectionUtils.isEmpty(values)) {
                running = false;
                return;
            }
            List<SignUserRecordDTO> all = Lists.newArrayList();
            int totalPage = result.getTotalPage();
            for (int i = 1; i <= totalPage; i++) {
                request.setPage(i);
                TPageResult<SignUserRecordDTO> pageResult = signUserRecordService
                    .queryPage(request);
                checkResult(pageResult);
                all.addAll(pageResult.getValues());
            }

            ImmutableListMultimap multimap = Multimaps.index(all, input -> {
                assert input != null;
                return input.getUserId();
            });
            Map<String, Collection<SignUserRecordDTO>> immutableMap = multimap.asMap();
            immutableMap.forEach(this::accept);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        LOGGER.info("用户签到周期结算结束:{}", formatNewFormat(new Date()));
        running = false;
        LOGGER.info("running改值成功");

    }

    private void accept(String userId, Collection<SignUserRecordDTO> v) {
        if (CollectionUtils.isEmpty(v)) {
            return;
        }
        SignUserRecordDTO dto = v.stream().findFirst().get();
        //快照奖品信息
        List<ActivitySignPrizeDTO> parseArray = parseArray(dto.getSignInPrize(),
            ActivitySignPrizeDTO.class);
        //找最大的签到次数
        parseArray.sort((o1, o2) -> o2.getSignCount() - o1.getSignCount());
        for (ActivitySignPrizeDTO prizeDTO : parseArray) {
            //过滤签到的奖励金额
            if (v.size() >= prizeDTO.getSignCount()) {
                SignAwardRequest award = new SignAwardRequest();
                TPageResult<ActivityConfigDTO> list = activityConfigService
                    .list(new ActivityConfigRequest(prizeDTO.getActivityId()));
                ServiceResultUtil.checkResult(list);
                if (!CollectionUtils.isEmpty(list.getValues())) {
                    award.setActivityType(list.getValues().get(0).getType().toString());
                }
                SignAwardRequest queryRequest = new SignAwardRequest();
                queryRequest.setUserId(userId);
                queryRequest.setActivityType(list.getValues().get(0).getType().toString());
                queryRequest.setCycleTime(dto.getCycleTime());

                TPageResult<SignAwardDTO> awardResult = signAwardService.queryPage(queryRequest);
                ServiceResultUtil.checkResult(awardResult);
                if (CollectionUtils.isEmpty(awardResult.getValues())) {
                    award.setUserId(userId);
                    award.setSignCount(prizeDTO.getSignCount());
                    award.setPrizeType(prizeDTO.getPrizeType().toString());
                    award.setPrizePercent(prizeDTO.getPrizePercent());
                    award.setPrizeMoney(prizeDTO.getPrizeMoney());
                    award.setOverOrderMoney(prizeDTO.getOverOrderMoney());
                    award.setUsefulDay(prizeDTO.getUsefulDay());
                    award.setCycleTime(dto.getCycleTime());
                    signAwardService.insert(award);
                }
                break;
            }
        }
    }
}
