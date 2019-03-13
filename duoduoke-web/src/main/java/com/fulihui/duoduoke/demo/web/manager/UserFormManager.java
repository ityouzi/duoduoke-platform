package com.fulihui.duoduoke.demo.web.manager;

/**
 * @author lizhi
 * @date 2018-7-13
 */

public interface UserFormManager {
    /**
     * add openId  userId formId
     *
     * @param openId
     * @param userId
     * @param fromId
     */
    void add(String openId, String userId, String fromId);
}
