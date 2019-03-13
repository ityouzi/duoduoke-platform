package com.fulihui.redisdubbo.demo.api.api;


import com.fulihui.redisdubbo.demo.api.request.AppSendMessageRequest;
import org.near.servicesupport.result.BaseResult;
import org.near.servicesupport.result.TSingleResult;

/**
 * The interface App send message service.
 *
 * @author lizhi
 * @date 2018 -8-28
 */
public interface AppSendMessageService {

    /**
     * Send message t single result.
     *
     * @param request the request
     * @return the t single result
     */
    TSingleResult<Boolean> sendMessage(AppSendMessageRequest request);


    /**
     * Send.
     *
     * @param userId  the user id
     * @param balance the balance
     * @param text    the text
     */
    BaseResult userWithdrawSend(String userId, int balance, String text);


    BaseResult sendMiniMessage(AppSendMessageRequest request);


}
