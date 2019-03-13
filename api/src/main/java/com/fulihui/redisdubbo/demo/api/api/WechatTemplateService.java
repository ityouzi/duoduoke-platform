package com.fulihui.redisdubbo.demo.api.api;

import com.fulihui.redisdubbo.demo.api.dto.WxTemplateDTO;
import com.fulihui.redisdubbo.demo.api.dto.WxTemplateSendDTO;
import org.near.servicesupport.result.TSingleResult;

import java.util.List;

/**
 * @author: JY
 * @date: 2018/8/13 15:48
 */
public interface WechatTemplateService {

    /**
     * 模板列表
     *
     * @return
     */
    List<WxTemplateDTO> list();


    TSingleResult<Boolean> sendTemplateMsg(WxTemplateSendDTO templateSendDTO);

}
