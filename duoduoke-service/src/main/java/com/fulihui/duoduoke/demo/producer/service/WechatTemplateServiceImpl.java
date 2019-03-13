package com.fulihui.duoduoke.demo.producer.service;


import com.fulihui.duoduoke.demo.api.api.TemplateSendTaskService;
import com.fulihui.duoduoke.demo.api.api.UserFormService;
import com.fulihui.duoduoke.demo.api.api.WechatTemplateService;
import com.fulihui.duoduoke.demo.api.api.WechatTokenService;
import com.fulihui.duoduoke.demo.api.dto.WxTemplateDTO;
import com.fulihui.duoduoke.demo.api.dto.WxTemplateSendDTO;
import com.fulihui.duoduoke.demo.api.enums.TemplateSendTaskStateEnum;
import com.fulihui.duoduoke.demo.api.request.WechatTokenQueryRequest;
import com.fulihui.duoduoke.demo.producer.manager.MiniProgramManager;
import com.fulihui.duoduoke.demo.producer.manager.PassiveTaskDefinition;
import com.fulihui.duoduoke.demo.producer.model.WxTemplateModel;
import com.fulihui.duoduoke.demo.producer.model.WxTemplateSendModel;
import com.fulihui.duoduoke.demo.common.config.DuoDuoKeConfig;
import com.fulihui.duoduoke.demo.common.util.BeanConvUtil;
import org.apache.dubbo.config.annotation.Service;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TSingleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: JY
 * @date: 2018/8/13 15:49
 */
@Service(version = "${demo.service.version}")
public class WechatTemplateServiceImpl implements WechatTemplateService {

    private static final Logger logger = LoggerFactory.getLogger(WechatTemplateServiceImpl.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(WechatTemplateServiceImpl.class);
    @Autowired
    MiniProgramManager miniProgramManager;
    @Autowired
    WechatTokenService wechatTokenService;
    @Autowired
    UserFormService userFormService;
    @Autowired
    TemplateSendTaskService templateSendTaskService;
    @Autowired
    PassiveTaskDefinition passiveTaskDefinition;
    @Autowired
    DuoDuoKeConfig config;

    /**
     * 模板列表
     *
     * @return
     */
    @Override
    public List<WxTemplateDTO> list() {
        List<WxTemplateModel> templateModels = miniProgramManager.queryWxTemplate(getToken());

        if (templateModels != null) {
            return BeanConvUtil.copy(templateModels, WxTemplateDTO.class);
        }

        return null;
    }

    /**
     * 发送模板消息
     *
     * @return
     */
    @Override
    public TSingleResult<Boolean> sendTemplateMsg(WxTemplateSendDTO templateSendDTO) {
        boolean success = false;
        try {
            WxTemplateSendModel sendModel = BeanConvUtil.copy(templateSendDTO,
                    WxTemplateSendModel.class);

            Set<Map.Entry<String, String>> entries = templateSendDTO.getKeywords().entrySet();

            //设置keyword -> value
            int index = 0;
            for (Map.Entry<String, String> item : entries) {
                sendModel.addDataItem("keyword" + (++index), item.getValue());
            }
            //执行发送
            success = miniProgramManager.sendTemplateMsg(sendModel, getToken());

            logger.info("推送模板消息：{} \n推送内容:{}", success, sendModel);

            //修改FormId
            this.updateSendState(success, templateSendDTO);
        } catch (Exception ex) {
            LOGGER.error("发送模板消息失败：{},{}", ex.getMessage(), ex);
        }

        return ResultBuilder.succTSingle(success);
    }

    /**
     * 修改发送状态
     */
    private void updateSendState(boolean success, WxTemplateSendDTO templateSendDTO) {

        if (success) {
            //修改状态
            List<String> formIds = new ArrayList<>();
            formIds.add(templateSendDTO.getFormId());
            userFormService.setFormIdUsed(formIds, "发送任务消息");

            List<String> userIds = new ArrayList<>();
            userIds.add(templateSendDTO.getUserId());
            //标记发送用户
            passiveTaskDefinition.markerToadyCount(userIds, templateSendDTO.getTaskId());
        }

        //修改发送次数
        if (templateSendDTO.getTaskId() != null) {
            //修改记录数
            templateSendTaskService.setCountRecord(templateSendDTO.getTaskId(), 1,
                    success ? TemplateSendTaskService.TEMPLATE_SEND_SUCCESS
                            : TemplateSendTaskService.TEMPLATE_SEND_FAIL);
            //修改已发送
            templateSendTaskService.setState(templateSendDTO.getTaskId(),
                    TemplateSendTaskStateEnum.HAS_SEND);
        }
    }

    /**
     * 获取Token
     *
     * @return
     */
    private String getToken() {
        WechatTokenQueryRequest tokenQueryRequest = new WechatTokenQueryRequest();
        tokenQueryRequest.setAppid(config.getMiniAppid());
        TSingleResult<String> tokenResult = wechatTokenService.takeAccessToken(tokenQueryRequest);
        return tokenResult.getValue();
    }
}
