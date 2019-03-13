package com.fulihui.redisdubbo.demo.producer.manager;

import com.fulihui.redisdubbo.demo.producer.model.UserModel;

import java.util.List;


/**
 * @author: JY
 * @date: 2018/10/19 9:54
 */
public interface PassiveTaskDefinition extends BaseSendDataDefinition {

    void markerToadyCount(List<String> userIds, Integer taskId);

    /**
     * 添加待发送的用户
     *
     * @param userModel
     */
    void putUser(UserModel userModel);

}
