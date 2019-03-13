package com.fulihui.redisdubbo.demo.producer.manager;


import com.fulihui.redisdubbo.demo.producer.model.WxTemplateModel;
import com.fulihui.redisdubbo.demo.producer.model.WxTemplateSendModel;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/8/13 10:40
 */
public interface MiniProgramManager {

    /**
     * 查询模板列表
     *
     * @param token
     * @return
     */
    List<WxTemplateModel> queryWxTemplate(String token);

    /**
     * 发送模板消息
     *
     * @param templateSendModel
     * @param token
     * @return
     */
    boolean sendTemplateMsg(WxTemplateSendModel templateSendModel, String token);

}
