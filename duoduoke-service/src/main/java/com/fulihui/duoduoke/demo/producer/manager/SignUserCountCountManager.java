package com.fulihui.duoduoke.demo.producer.manager;

import java.util.Date;

/**
 * The interface User punch count manager.
 *
 * @author lizhi
 */
public interface SignUserCountCountManager {
    /**
     * 计算用户连续签到信息
     *
     * @param userId    the user id
     * @param signDate  the sign date
     * @param cycleTime the cycle time
     * @return the boolean
     */
    boolean calculateSign(String userId, Date signDate,
                          /**
                           *
                           *
                           * sign_user_count.cycle_time
                           * 签到周期
                           *
                           * @mbg.generated 2018-10-19 15:59:12
                           */
                          Date cycleTime);
}
