package com.fulihui.duoduoke.demo.web.factory;


import com.fulihui.duoduoke.demo.api.api.AppConfigService;
import com.fulihui.duoduoke.demo.api.api.GoodsInfoService;
import com.fulihui.duoduoke.demo.api.dto.AppConfigDTO;
import com.fulihui.duoduoke.demo.api.enums.AppConfigEnum;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.near.servicesupport.result.TSingleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


import static com.fulihui.duoduoke.demo.api.enums.AppConfigEnum.AMOUNT_CHECK;
import static com.fulihui.duoduoke.demo.api.enums.AppConfigEnum.SHARE_PERCENTAGE;
import static org.near.servicesupport.util.ServiceResultUtil.checkResult;

/**
 * @author lizhi
 * @date 2018-7-19
 */

@Component
public class AppConfigFactory {

    private static final Logger      LOGGER         = LoggerFactory
        .getLogger(AppConfigFactory.class);

    @org.apache.dubbo.config.annotation.Reference
    GoodsInfoService goodsInfoService;

    @org.apache.dubbo.config.annotation.Reference
    AppConfigService appConfigService;

    /**
     * 返利佣金配置百分比
     */
    private Long                     commission;

    /**
     * 分享配置百分比
     */
    private Long                     shareProportion;

    /**
     * 提现金额配置余额限制
     */

    private Long                     amountCheck    = 100L;

    @Autowired
    ThreadPoolTaskExecutor           threadPoolTaskExecutor;
    /**
     * 翻牌活动总开关
     */

    private Boolean                  isFlopOpen;

    private String                   withdrawalType = "3";

    private ScheduledExecutorService executorService;

    @PostConstruct
    void commission() {
        executorService = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder()
            .namingPattern("AppConfigFactory-schedule-pool-%d").daemon(true).build());
        executorService.scheduleAtFixedRate(() -> {
            try {
                TSingleResult<Long> result = goodsInfoService.queryCommisionConfig();
                checkResult(result);
                commission = result.getValue() != null ? result.getValue() : 37L;
                LOGGER.debug("返佣比例:{}", commission);
                String configVal = appConfigService.getModel(AMOUNT_CHECK).getValue()
                    .getConfigVal();
                amountCheck = Long.valueOf(configVal);
                LOGGER.debug("提现限制金额,单位分:{}", amountCheck);
                TSingleResult<AppConfigDTO> singleResult = appConfigService
                    .getModel(SHARE_PERCENTAGE);
                AppConfigDTO model = singleResult.getValue();
                shareProportion = Long
                    .valueOf(model.getConfigVal() != null ? model.getConfigVal() : "30");
                LOGGER.debug("分享比例:{}", shareProportion);

                TSingleResult<AppConfigDTO> serviceModel = appConfigService
                    .getModel(AppConfigEnum.FLOP_ACTIVITY_USING);
                String configVal1 = serviceModel.getValue().getConfigVal();
                isFlopOpen = Boolean.parseBoolean(configVal1);
                AppConfigDTO withdrawalConfig = appConfigService
                    .getModel(AppConfigEnum.WITHDRAWAL_CONFIG).getValue();
                withdrawalType = withdrawalConfig.getConfigVal();

            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }, 0, 60, TimeUnit.SECONDS);

    }

    @PreDestroy
    void destroy() {
        if (null != executorService) {
            executorService.shutdown();
        }
    }

    public Long getAmountCheck() {
        return amountCheck;
    }

    public Long getCommission() {
        return commission;
    }

    public Long getShareProportion() {
        return shareProportion;
    }

    public void setCommission(Long commission) {
        this.commission = commission;
    }

    public void setShareProportion(Long shareProportion) {
        this.shareProportion = shareProportion;
    }

    public void setAmountCheck(Long amountCheck) {
        this.amountCheck = amountCheck;
    }

    public Boolean getFlopOpen() {
        return isFlopOpen;
    }

    public void setFlopOpen(Boolean flopOpen) {
        isFlopOpen = flopOpen;
    }

    /**
     * Getter method for property <tt>withdrawalType</tt>
     *
     * @return property value of withdrawalType
     */
    public String getWithdrawalType() {
        return withdrawalType;
    }

    /**
     * Setter method for property <tt>withdrawalType</tt>.
     *
     * @param withdrawalType value to be assigned to property withdrawalType
     */
    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }
}
