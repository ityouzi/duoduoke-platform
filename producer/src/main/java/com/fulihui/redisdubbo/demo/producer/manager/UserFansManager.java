package com.fulihui.redisdubbo.demo.producer.manager;

import java.util.Date;

/**
 * The interface User fans manager.
 *
 * @author lizhi
 * @date 2018 -8-2
 */
public interface UserFansManager {


    /**
     * Save fans num.
     *
     * @param date        the date
     * @param userReferee the user referee
     */
    void saveFansNum(Date date, String userReferee);


    /**
     * Save amount order num.
     *
     * @param date          the date
     * @param orderNum      the order num
     * @param subsidyAmount the subsidy amount
     * @param userReferee   the user referee
     */
    void saveAmountOrderNum(Date date, Integer orderNum, Integer subsidyAmount, String userReferee);


}
