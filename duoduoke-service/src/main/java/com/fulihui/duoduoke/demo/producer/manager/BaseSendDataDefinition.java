package com.fulihui.duoduoke.demo.producer.manager;


import com.fulihui.duoduoke.demo.api.dto.TemplateSendTaskDTO;
import com.fulihui.duoduoke.demo.producer.model.SendUserModel;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/10/18 16:53
 */
public interface BaseSendDataDefinition {

    /**
     * 发送模板消息的用户
     *
     * @return
     */
    List<SendUserModel> list(TemplateSendTaskDTO sendTaskDTO) throws Exception;
}
