package com.fulihui.duoduoke.demo.producer.job.schedule;

import java.util.Date;

import com.fulihui.duoduoke.demo.api.api.OrderInfoService;
import com.fulihui.duoduoke.demo.api.api.UserFormService;
import com.fulihui.duoduoke.demo.api.api.sign.SignAwardService;
import com.fulihui.duoduoke.demo.api.dto.sign.SignAwardDTO;
import com.fulihui.duoduoke.demo.api.enums.SignPrizeStatusEnum;
import com.fulihui.duoduoke.demo.api.enums.SwitchEnum;
import com.fulihui.duoduoke.demo.api.request.OrderInfoUpdateRequest;
import com.fulihui.duoduoke.demo.api.request.UserFormInvalidRequest;
import com.fulihui.duoduoke.demo.api.request.sign.SignAwardRequest;
import org.near.servicesupport.result.TPageResult;
import org.near.servicesupport.util.ServiceResultUtil;
import org.near.toolkit.common.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import com.google.common.collect.Lists;

/**
 * @author lizhi
 * @date 2018-7-13
 */
public class UserFormIdJob implements SimpleJob {

    private static final Logger LOGGER  = LoggerFactory.getLogger(UserFormIdJob.class);

    @org.apache.dubbo.config.annotation.Reference
    UserFormService userFormService;

    @org.apache.dubbo.config.annotation.Reference
    OrderInfoService orderInfoService;

    @org.apache.dubbo.config.annotation.Reference
    SignAwardService signAwardService;

    private volatile boolean    running = false;

    @Override
    public void execute(ShardingContext shardingContext) {

        LOGGER.info("running:{}", running);
        if (running) {
            LOGGER.warn("running值没改掉");
            return;
        }
        running = true;

        try {
            UserFormInvalidRequest request = new UserFormInvalidRequest();
            request.setDay(7);
            request.setFormStatus(SwitchEnum.DISABLE.getCode());
            request.setDesc("7天自动过期");
            userFormService.updateInvalid(request);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        try {
            orderInfoService.update(new OrderInfoUpdateRequest());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        try {
            SignAwardRequest request = new SignAwardRequest();
            request.setPrizeStatus(Lists.newArrayList(SignPrizeStatusEnum.UNUSED.getCode()));
            TPageResult<SignAwardDTO> result = signAwardService.queryPage(request);
            ServiceResultUtil.checkResult(result);
            if (!CollectionUtils.isEmpty(result.getValues())) {
                for (int i = 1; i <= result.getTotalPage(); i++) {
                    request.setPage(i);
                    TPageResult<SignAwardDTO> queryPage = signAwardService.queryPage(request);
                    if (!CollectionUtils.isEmpty(queryPage.getValues())) {
                        for (SignAwardDTO value : queryPage.getValues()) {

                            Date now = new Date();
                            Date gmtCreate = value.getGmtCreate();
                            gmtCreate.setHours(23);
                            gmtCreate.setMinutes(59);
                            gmtCreate.setSeconds(59);
                            Date days = DateUtils.addDays(value.getGmtCreate(),
                                value.getUsefulDay());
                            if (now.after(days)) {
                                //已过期
                                SignAwardRequest newRequest = new SignAwardRequest();
                                newRequest.setId(value.getId());
                                newRequest.setPrizeStatus(
                                    Lists.newArrayList(SignPrizeStatusEnum.EXPIRED.getCode()));
                                signAwardService.update(newRequest);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        running = false;
        LOGGER.info("running改值成功");
    }
}
