package com.fulihui.duoduoke.demo.producer.manager;


import com.fulihui.duoduoke.demo.producer.manager.enums.SendDataDefinitionEnum;
import com.fulihui.duoduoke.demo.producer.model.SendUserModel;


/**
 * @author: JY
 * @date: 2018/8/16 9:40
 */
public interface TemplateSendTaskManager {

    /**
     * 检查数据是否存在
     */
    void checkData();

    /**
     * 添加发送的任务消息
     *
     * @param sendDataDefinitionEnum
     * @param userModel
     */
    void putSend(SendDataDefinitionEnum sendDataDefinitionEnum, SendUserModel userModel);


    /**
     * 清空消息队列
     *
     * @param id
     * @return
     */
    void clearTaskQueue(Integer id);
}
