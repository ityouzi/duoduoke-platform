package com.fulihui.redisdubbo.demo.producer.manager.impl;

import com.fulihui.redisdubbo.demo.api.dto.sign.SignUserCountDTO;
import com.fulihui.redisdubbo.demo.producer.manager.SignUserCountCountManager;
import com.fulihui.redisdubbo.demo.producer.repository.SignUserCountRepository;
import org.near.toolkit.common.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.util.Date;


/**
 * @author lz
 */
@Component
public class SignUserCountCountManagerImpl implements SignUserCountCountManager {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SignUserCountCountManagerImpl.class);
    private static final Integer MAX_THRESHOLD = 1000000;
    @Autowired
    SignUserCountRepository signUserCountRepository;

    @Override
    public boolean calculateSign(String userId, Date signDate, Date cycleTime) {
        Assert.notNull(userId, "userId is not null");
        /**
         * signDate 时间格式  yyyy-MM-dd HH:mm:ss
         */
        LOGGER.info("签到时间：{},签到周期:{}", DateUtils.formatNewFormat(signDate),
                DateUtils.formatWebFormat(cycleTime));
        /**
         * last 时间格式  yyyy-MM-dd
         */
        Date last = parseWebFormat(signDate);
        SignUserCountDTO dto = signUserCountRepository.query(userId, cycleTime);
        boolean bl;
        //数据存在
        if (null != dto) {
            //update
            SignUserCountDTO update = new SignUserCountDTO();
            update.setId(dto.getId());
            //总次数
            update.setTotalCount(dto.getTotalCount() + 1);
            update.setLastTime(last);
            update.setSignTime(signDate);
            //已经连续签到次数>= 阈值
            if (dto.getContinuousCount() >= MAX_THRESHOLD) {
                //连续签到次数清零
                update.setContinuousCount(0);
            } else {
                /* 判断是否连续 */
                boolean b = last.getTime() == DateUtils.addDays(dto.getLastTime(), 1).getTime();
                //连续
                if (b) {
                    //连续签到次数加1
                    Integer continuousCount = dto.getContinuousCount() + 1;
                    update.setContinuousCount(continuousCount);
                } else {
                    //连续签到次数清零
                    update.setContinuousCount(1);
                }
            }
            bl = signUserCountRepository.update(update) > 0;
        } else {
            SignUserCountDTO newDTO = new SignUserCountDTO();
            newDTO.setUserId(userId);
            newDTO.setLastTime(last);
            newDTO.setSignTime(signDate);
            newDTO.setContinuousCount(1);
            newDTO.setTotalCount(1);
            newDTO.setCycleTime(cycleTime);
            bl = signUserCountRepository.save(newDTO) > 0;
        }
        return bl;
    }

    /**
     * @param date
     * @return date
     */
    private Date parseWebFormat(Date date) {
        String webFormat = DateUtils.formatWebFormat(date);
        try {
            return DateUtils.parseWebFormat(webFormat);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
        }
        return date;

    }

}
